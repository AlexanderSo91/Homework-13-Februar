package controller;


import annotation.Operation;
import annotation.Tag;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Api рецепты", description = "CRUD рецепты")
public class RecipeController {

    private final RecipeService recipeService;
    private Recipe recipe;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @Operation(
            summary = "Сохранение рецепта"
    )

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        Recipe recipeRs = recipeService.save(recipe);
        return ResponseEntity.ok(recipeRs);
    }
    @Operation(
            summary = "Получение рецепта по id"
    )

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getById(id));
    }
    @Operation(
            summary = "Обновление рецепта"
    )

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe ingredient) {
        return ResponseEntity.ok(recipeService.update(id,recipe));
    }
    @Operation(
            summary = "Удаление рецепта"
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }
    @Operation(
            summary = "Получение рецепта"
    )

    @GetMapping("/{id}")
    public ResponseEntity<Map<Long, Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAll());
    }
}
