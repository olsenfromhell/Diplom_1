package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    @Parameterized.Parameter
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Before
    public void init() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100.0f},
                {IngredientType.SAUCE, "sour cream", 200.0f},
                {IngredientType.FILLING, "cutlet", 300.0f},
                {IngredientType.FILLING, "sausage", 150.0f}
        });
    }

    @Test
    public void testGetType() {
        assertEquals("Тип ингредиента некорректен", type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals("Название ингредиента некорректно", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Цена ингредиента некорректна", price, ingredient.getPrice(), 0.0f);
    }
}
