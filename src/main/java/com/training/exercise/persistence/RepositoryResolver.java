package com.training.exercise.persistence;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositoryResolver {
    @Autowired
    private List<PagingAndSortingRepository> repositories;

    public <T extends PagingAndSortingRepository> T get(Class<T> clazz) {
        return (T) repositories.stream().filter(clazz::isInstance).findFirst().orElseThrow(
                () -> new NoSuchBeanDefinitionException("There is not repository for the class " + clazz.getName()));
    }
}
