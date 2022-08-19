package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    String expectedName = "Кратерная булка N-200i";
    float expectedPrice = 1255;

    @Test
    public void shouldReturnNameCraterBun() {
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldReturnPrice1255() {
        Bun bun = new Bun(expectedName, expectedPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

}
