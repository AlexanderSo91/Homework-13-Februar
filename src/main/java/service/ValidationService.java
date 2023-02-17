package service;

import model.Ingredient;
import model.Recipe;

public interface ValidationService {

    public boolean validate(Recipe recipe);

    public boolean validate(Ingredient ingredient);
}
