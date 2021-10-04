package tool;

import exception.NegativePageNumberException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExecutorTest {

    Executor executor = new Executor();

    String testPages1_1 = "5,6,7,8,3,2,1,5,6,10";
    String expectedReducedPages1 = "1-3,5-8,10";
    String testPages2 = "5,6,b,8,3,2,1,5,6";
    String testPages3 = "5,6,-7,8,3,2,1,0,5,6";

    //общая проверка функции
    @Test
    void toFormat1() throws NegativePageNumberException {
        String actual = executor.toFormat(testPages1_1);
        Assert.assertEquals(expectedReducedPages1, actual);
    }

    //проверка на не числового значения
    @Test
    void toFormat2() throws NumberFormatException, NegativePageNumberException {
        Assertions.assertThrows(NumberFormatException.class, () -> executor.toFormat(testPages2));
    }

    //проверка на отрицательную страницу
    @Test
    void toFormat3() throws NegativePageNumberException {
        Assertions.assertThrows(NegativePageNumberException.class, () -> executor.toFormat(testPages3));
    }
}