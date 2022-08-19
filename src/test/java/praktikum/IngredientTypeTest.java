package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;
    private final IngredientType expectedType;

    public IngredientTypeTest(String type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] checkIngredientType() {
        return new Object[][] {
                {"SAUCE", SAUCE},
                {"FILLING", FILLING}
        };
    }

    @Test
    public void typeShouldBeContainedInEnumIngredientType() {
        IngredientType actualType = IngredientType.valueOf(type);
        assertEquals(expectedType, actualType);
    }

}
