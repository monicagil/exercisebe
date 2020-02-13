package com.training.exercise.persistence.predicate;

import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.training.exercise.model.FilterCriteria;
import com.training.exercise.model.QUser;
import org.springframework.stereotype.Component;
import java.util.Set;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserPredicate {

    public static final String EQUALS_OPERATOR = ":";

    public BooleanExpression getPredicate(Set<FilterCriteria> filters) {
        List<BooleanExpression> predicates = new ArrayList<>();

        for (FilterCriteria filter : filters) {
            predicates.add(getPredicateByFilterKey(filter));
        }

        if (CollectionUtils.isEmpty(predicates)) {
            return Expressions.asBoolean(true).isTrue();
        }

        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }

    public BooleanExpression getPredicateByFilterKey(FilterCriteria filterCriteria){
        BooleanExpression booleanExpression = null;
        BooleanExpression booleanExpressionByKey = null;
        for (String filterKey : filterCriteria.getKey()) {
            switch (filterKey) {
                case "userName":
                    booleanExpressionByKey = getUserNamePredicate(filterCriteria);
                    break;
                case "name":
                    booleanExpressionByKey = getNamePredicate(filterCriteria);
                    break;
                case "age":
                    booleanExpressionByKey = getAgePredicate(filterCriteria);
                    break;
                case "gender":
                    booleanExpressionByKey = getGenderPredicate(filterCriteria);
                    break;
                case "email":
                    booleanExpressionByKey = getEmailPredicate(filterCriteria);
                    break;
            }
            booleanExpression = getOrExpression(booleanExpression, booleanExpressionByKey);
        }
        return booleanExpression;
    }

    private BooleanExpression getOrExpression(BooleanExpression booleanExpression,
                                              BooleanExpression booleanExpressionByKey) {
        if (booleanExpression == null) {
            booleanExpression = booleanExpressionByKey;
        } else {
            booleanExpression = booleanExpression.or(booleanExpressionByKey);
        }
        return booleanExpression;
    }
    
    private BooleanExpression getUserNamePredicate(FilterCriteria filterCriteria) {
        if (EQUALS_OPERATOR.equalsIgnoreCase(filterCriteria.getOperation())) {
            QUser qUser = QUser.user;
            return qUser.userName.likeIgnoreCase("%" + filterCriteria.getValue().get(0) + "%");
        }
        return null;
    }

    private BooleanExpression getNamePredicate(FilterCriteria filterCriteria) {
        if (EQUALS_OPERATOR.equalsIgnoreCase(filterCriteria.getOperation())) {
            QUser qUser = QUser.user;
            return qUser.name.likeIgnoreCase("%" + filterCriteria.getValue().get(0) + "%");
        }
        return null;
    }

    private BooleanExpression getGenderPredicate(FilterCriteria filterCriteria) {
        if (EQUALS_OPERATOR.equalsIgnoreCase(filterCriteria.getOperation())) {
            QUser qUser = QUser.user;
            return qUser.gender.stringValue().likeIgnoreCase("%" + filterCriteria.getValue().get(0) + "%");
        }
        return null;
    }

    private BooleanExpression getEmailPredicate(FilterCriteria filterCriteria) {
        if (EQUALS_OPERATOR.equalsIgnoreCase(filterCriteria.getOperation())) {
            QUser qUser = QUser.user;
            return qUser.email.likeIgnoreCase("%" + filterCriteria.getValue().get(0) + "%");
        }
        return null;
    }

    private BooleanExpression getAgePredicate(FilterCriteria filterCriteria) {
        if (EQUALS_OPERATOR.equalsIgnoreCase(filterCriteria.getOperation())
                && NumberUtils.isCreatable(filterCriteria.getValue().get(0))) {
            QUser qUser = QUser.user;
            List<Long> ages = filterCriteria.getValue().stream().map(Long::valueOf).collect(Collectors.toList());
            return qUser.age.in((CollectionExpression<?, ? extends Integer>) ages);
        }
        return null;
    }
}
