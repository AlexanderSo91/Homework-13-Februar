package service;

import model.Ingredient;
import model.Recipe;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getName() != null
                && StringUtils.isEmpty(recipe.getName())
                && recipe.getSteps() != null
                && recipe.getIngredients() != null
                && recipe.getIngredients().isEmpty()
                && recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null;
                && !StringUtils.isEmpty(ingredient.getName());

    }
}
