package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    IngredientType ingredientType = SAUCE;
    String name = "SpicyX";
    float price = 100;
    Ingredient ingredient = new Ingredient(ingredientType, name, price);

    @Test
    public void shouldReturnIngredientTypeSAUCETest() {
        IngredientType receivedIngredientType = ingredient.getType();
        Assert.assertEquals(ingredientType, receivedIngredientType);
    }

    @Test
    public void shouldReturnNameSpicyXTest() {
        String receivedName = ingredient.getName();
        Assert.assertEquals(name, receivedName);
    }

    @Test
    public void shouldReturnPrice100Test() {
        float receivedPrice = ingredient.getPrice();
        Assert.assertEquals(price, receivedPrice, 0);
    }
}
