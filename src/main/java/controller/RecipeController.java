package controller;

import Opperation.Opperation;
import Tag.Tag;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Api рецепты", deskription = "CRUD рецепты")
public class RecipeController {

    private final RecipeService recipeService;
    private Recipe recipe;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        Recipe recipeRs = recipeService.save(recipe);
        return ResponseEntity.ok(recipeRs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe ingredient) {
        return ResponseEntity.ok(recipeService.update(id,recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Long, Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAll());
    }
}
