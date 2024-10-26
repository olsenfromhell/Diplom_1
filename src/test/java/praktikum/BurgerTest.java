package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;

    @Mock
    private Ingredient ingredientMock;

    @Mock
    private Ingredient anotherIngredientMock;

    private Burger burger;  // реальный экземпляр Burger

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        burger = new Burger();

    }

    @Test
    public void getBurgerPriceTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        float expectedPrice = bunMock.getPrice() * 2 + ingredientMock.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock);

        assertEquals(1, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        // добавили два ингридиента
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);
        // удалили первый ингридиент в списке
        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);

        burger.moveIngredient(0, 1);

        assertEquals(anotherIngredientMock, burger.ingredients.get(0));
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(anotherIngredientMock);

        // настраиваем поведение моков
        when(bunMock.getName()).thenReturn("Булочька");
        when(bunMock.getPrice()).thenReturn(20.0f);

        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("Кепчук");
        when(ingredientMock.getPrice()).thenReturn(5.0f);

        when(anotherIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(anotherIngredientMock.getName()).thenReturn("Каклета");
        when(anotherIngredientMock.getPrice()).thenReturn(30.0f);

        String expectedReceipt = "(==== Булочька ====)\n" +
                "= sauce Кепчук =\n" +
                "= filling Каклета =\n" +
                "(==== Булочька ====)\n" +
                "\nPrice: 75,000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);

        // проверка моков
        verify(bunMock, times(2)).getName();
        verify(bunMock, times(1)).getPrice();
        verify(ingredientMock, times(1)).getType();
        verify(ingredientMock, times(1)).getName();
        verify(ingredientMock, times(1)).getPrice();
        verify(anotherIngredientMock, times(1)).getType();
        verify(anotherIngredientMock, times(1)).getName();
        verify(anotherIngredientMock, times(1)).getPrice();
    }

}
