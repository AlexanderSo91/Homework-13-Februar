package com.example.homework6februar.service.impl;

import com.example.homework6februar.exception.ValidationException;
import com.example.homework6februar.model.Ingredient;
import com.example.homework6februar.model.Recipe;
import com.example.homework6februar.service.FileService;
import com.example.homework6februar.service.IngredientService;
import com.example.homework6februar.service.ValidationService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static long idCounter = 1;
    private Map<Long, Ingredient> ingredients = new HashMap<>();
    private final ValidationService validationService;
    private Path ingredientPath;
    private FileService fileService ;
    private String ingredientsFilePath;
    private String ingredientsFileName;
    private Path recipesPath;


    public IngredientServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (validationService.validate(ingredient))
            throw new ValidationException(ingredient.toString());

        return ingredients.put(idCounter++, ingredient);

    }

    @Override
    public Optional<Ingredient> getById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredients.replace(id,ingredient);
    }

    @Override
    public Ingredient delete(Long id) {
        return ingredients.remove(id);
    }

    @Override
    public Map<Long, Ingredient> getAll() {
        return ingredients;
    }

    @Override
        public File readFile() {
            return ingredientPath.toFile();
        }

        @Override
        public void uploadFile(MultipartFile file) throws IOException {
            fileService.uploadFile(file, ingredientPath);
            ingredients = fileService.readMapFromFile(recipesPath,new TypeReference<HashMap<Long, Recipe>>() {});
        }

    @PostConstruct
    private void init(){
        ingredientPath = Path.of(ingredientsFilePath, ingredientsFileName);
        ingredients = fileService.readMapFromFile(ingredients, new TypeReference<HashMap<Long,ingredient>>(){});


    }
}
