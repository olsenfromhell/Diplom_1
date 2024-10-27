package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private static final String BUN_NAME = "Булка";
    private static final float BUN_PRICE = 2.5f;

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void testBunConstructor() {
        // проверяем, что имя и цена булочки заданы правильно
        assertEquals("Имя булочки должно совпадать с переданным в конструктор значением", BUN_NAME, bun.name);
        assertEquals("Цена булочки должна совпадать с переданным в конструктор значением", BUN_PRICE, bun.price, 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Метод getName должен возвращать правильное имя", BUN_NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Метод getPrice должен возвращать правильную цену", BUN_PRICE, bun.getPrice(), 0);
    }
}
