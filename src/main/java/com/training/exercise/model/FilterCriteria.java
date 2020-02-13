package com.training.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterCriteria {
    @NotEmpty
    private List<String> key;

    @NotEmpty
    private String operation;

    @NotNull
    private List<String> value;
}
