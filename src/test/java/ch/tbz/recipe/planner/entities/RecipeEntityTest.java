package ch.tbz.recipe.planner.entities;

import ch.tbz.recipe.planner.entities.RecipeEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RecipeEntityTest {

    @Test
    void testGetId() {
        RecipeEntity recipeEntity = new RecipeEntity();
        assertNull(recipeEntity.getId()); // Assuming id is initially null
    }

    @Test
    void testGetName() {
        RecipeEntity recipeEntity = new RecipeEntity();
        assertNull(recipeEntity.getName()); // Assuming name is initially null
    }

    // Similarly, create tests for getDescription, getImageUrl, getIngredients, etc

    @Test
    void testSetId() {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(UUID.randomUUID());
        assertNotNull(recipeEntity.getId()); // Assuming setId correctly sets the id
    }

    @Test
    void testSetName() {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName("TestName");
        assertEquals("TestName", recipeEntity.getName());
    }

    // Similarly, create tests for setDescription, setImageUrl, setIngredients, etc.

    @Test
    void testEquals() {
        RecipeEntity recipeEntity1 = new RecipeEntity();
        RecipeEntity recipeEntity2 = new RecipeEntity();
        assertEquals(recipeEntity1, recipeEntity2); // Assuming equals is implemented based on id or other relevant fields
    }

    // Similarly, create tests for canEqual, testHashCode, and testToString
}
