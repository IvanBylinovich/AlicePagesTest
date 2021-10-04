package tool;

import exception.NegativePageNumberException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ExecutorTest {

    String testPages1 = "5,6,7,8,3,2,1,0,5,6,10";
    String expectedReducedPages1 = "1-3,5-8,10";
    String testPages2 = "5,6,b,8,3,2,1,0,5,6";
    String testPages3 = "5,6,-7,8,3,2,1,0,5,6";


    @Test
    void toFormat1() {
        String actual = Executor.toFormat(testPages1);
        Assert.assertEquals(expectedReducedPages1, actual);
    }

    @Test
    void toFormat2()throws NumberFormatException {
        try {
            Executor.toFormat(testPages2);
        }catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void toFormat3()throws NegativePageNumberException {
        try {
            Executor.toFormat(testPages3);
        }catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }
    @Test
    void toFormat4()throws NullPointerException{
        try {
            Executor.toFormat(testPages1);
        }catch (NumberFormatException e){
            Assert.assertEquals("", e.getMessage());
        }
    }
}