package com.example.homework6februar.service;

import com.example.homework6februar.model.Ingredient;
import com.example.homework6februar.model.Recipe;

public interface ValidationService {

    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
