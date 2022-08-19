package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Burger burger;

    Bun bun = new Bun("Crater bun", 1255);
    Ingredient sauce = new Ingredient(SAUCE, "Spase-X", 90);
    Ingredient filling = new Ingredient(FILLING, "Beef meteorite", 2000);
    Burger testBurger = new Burger();
    float expectedPrise = bun.price*2 + sauce.price + filling.price;

    @Before
    public void makeTestBurger() {
        testBurger.setBuns(bun);
        testBurger.addIngredient(sauce);
        testBurger.addIngredient(filling);
    }

    @Test
    public void shouldSetBunCraterBun() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(sauce);
        Mockito.verify(burger).addIngredient(sauce);
    }

    @Test
    public void shouldRemoveIngredient() {
        int i = testBurger.ingredients.indexOf(sauce);
        testBurger.removeIngredient(i);
        Assert.assertEquals(false, testBurger.ingredients.contains(sauce));
    }

    @Test
    public void shouldChangeIngredientPositionFrom0to1() {
        int i = testBurger.ingredients.indexOf(sauce);
        testBurger.moveIngredient(i, 1);
        Assert.assertEquals(1, testBurger.ingredients.indexOf(sauce));
    }

    @Test
    public void shouldChangeIngredientPositionFrom1to0() {
        int i = testBurger.ingredients.indexOf(filling);
        testBurger.moveIngredient(i, 0);
        Assert.assertEquals(0, testBurger.ingredients.indexOf(filling));
    }

    @Test
    public void shouldReturnBurgerPrice() {
        float actualPrise = testBurger.getPrice();
        Assert.assertEquals(expectedPrise, actualPrise, 0);
    }

    @Test
    public void receiptFormatMatchesLayout() {
        String actualReceipt = testBurger.getReceipt();

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : testBurger.ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", testBurger.getPrice()));
        String expectedReceipt = receipt.toString();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}