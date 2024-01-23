package ch.tbz.recipe.planner.service;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeEntityMapper mapper;

    @Mock
    private RecipeRepository repository;

    // Initialize mocks before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetRecipes() {
        // Arrange
        List<RecipeEntity> recipeEntities = Collections.singletonList(new RecipeEntity());
        when(repository.findAll()).thenReturn(recipeEntities);
        when(mapper.entityToDomain(any())).thenReturn(new Recipe());

        // Act
        List<Recipe> recipes = recipeService.getRecipes();

        // Assert
        assertEquals(1, recipes.size());
        // Add more assertions as needed
    }

    @Test
    void testGetRecipeById() {
        // Arrange
        UUID recipeId = UUID.randomUUID();
        RecipeEntity recipeEntity = new RecipeEntity();
        when(repository.findById(recipeId)).thenReturn(Optional.of(recipeEntity));
        when(mapper.entityToDomain(any())).thenReturn(new Recipe());

        // Act
        Recipe recipe = recipeService.getRecipeById(recipeId);

        // Assert
        assertNotNull(recipe);
        // Add more assertions as needed
    }

    @Test
    void testAddRecipe() {
        // Arrange
        Recipe recipe = new Recipe();
        RecipeEntity recipeEntity = new RecipeEntity();
        when(mapper.domainToEntity(recipe)).thenReturn(recipeEntity);
        when(repository.save(recipeEntity)).thenReturn(recipeEntity);
        when(mapper.entityToDomain(recipeEntity)).thenReturn(recipe);

        // Act
        Recipe addedRecipe = recipeService.addRecipe(recipe);

        // Assert
        assertNotNull(addedRecipe);
        // Add more assertions as needed
    }
}
