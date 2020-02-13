package com.training.exercise.model.dto;

import com.training.exercise.model.FilterCriteria;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class FilterCriteriaDTO {

    @NotNull
    private Set<FilterCriteria> filters = new HashSet<>();
}
