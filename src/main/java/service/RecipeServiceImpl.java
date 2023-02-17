package service;

import exception.ValidationException;
import model.Ingredient;
import model.Recipe;
import org.springframework.asm.TypeReference;
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
public class RecipeServiceImpl implements RecipeService {

    private static long idCounter = 1;
    private Map<Long, Recipe> recipes = new HashMap<>();
    private final ValidationService validationService;
    private Path recipesPath;

    public RecipeServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Recipe save(Recipe recipe) {
        if (validationService.validate(recipe))
            throw new ValidationException(recipe.toString());

        return recipes.put(idCounter++, recipe);
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        if (!validationService.validate(recipe))
            throw new ValidationException(recipe.toString());

        return recipes.replace(id, recipe);
    }

    @Override
    public Recipe delete(Long id) {
        return recipes.remove(id);
    }

    @Override
    public Map<Long, Recipe> getAll() {
        return recipes;
    }

    @Override
    public File readFile() {
        return recipesPath.toFile();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        fileService.uploadFile(file, recipesPath);
        recipes = fileService.readMapFromFile(recipesPath, new TypeReference<HashMap<Long, Recipe>>() {});
    }

    @PostConstruct
    private void init() {
        recipesPath = Path.of(recipesFilePath, recipesFileName);
        recipes = fileService.readMapFromFile(recipesPath, new TypeReference<HashMap<Long, Recipe>>() {});
    }
}
