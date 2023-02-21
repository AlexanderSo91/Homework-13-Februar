package com.example.homework6februar.service.impl;

import com.example.homework6februar.model.Ingredient;
import com.example.homework6februar.model.Recipe;
import com.example.homework6februar.service.ValidationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && !StringUtils.isEmpty(recipe.getName())
                && recipe.getSteps() != null
                && recipe.getIngredients() != null
                && recipe.getIngredients().isEmpty()
                && recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null
                && !StringUtils.isEmpty(ingredient.getName());
    }
}
