package tool;

import exception.NegativePageNumberException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class PageDataConvertorTest {

    PageDataConvertor pageDataConvertor = new PageDataConvertor();

    String testStringPages = "5,6,7,8,3,2,1,0,5,6";
    List<String> expectedParsToStringListResult = Arrays.asList("5","6","7","8","3","2","1","0","5","6");
    List<String> testNoNumberList = Arrays.asList("5","n","7");
    List<Integer> expectedParsToIntListResult = Arrays.asList(5,6,7,8,3,2,1,0,5,6);
    List<Integer> expectedTreatedPagesResult = Arrays.asList(5,6,7,8,3,2,1,0);
    List<Integer> expectedSortPagesResult = Arrays.asList(0,1,2,3,5,5,6,6,7,8);
    List<Integer> testNotPositiveNumberList = Arrays.asList(-2,0,2,3,-60,5,6,6,7,-80);
    List<Integer> testListForReducedPageNumbers1 = Arrays.asList(2,3,4,6,8,9,10);
    String expectedReducedPageNumbers1 = "2-4,6,8-10";
    List<Integer> testListForReducedPageNumbers2 = Arrays.asList(2,3,4,6,8,10);
    String expectedReducedPageNumbers2 = "2-4,6,8,10";


    @Test
    void parsToStringList() {
        List<String> actualResult = pageDataConvertor.parsToStringList(testStringPages);
        Assertions.assertEquals(expectedParsToStringListResult, actualResult);
    }

    @Test
    void parsToIntList() {
        List<Integer> actualResult =  pageDataConvertor.parsToIntList(expectedParsToStringListResult);
        Assertions.assertEquals(expectedParsToIntListResult, actualResult);
    }

    @Test
    void parsToIntListEx() throws NumberFormatException{
            Assertions.assertThrows(NumberFormatException.class, () -> pageDataConvertor.parsToIntList(testNoNumberList));
    }


    @Test
    void positiveValueValidator()  {
            Assertions.assertThrows(NegativePageNumberException.class, () -> pageDataConvertor.positiveValueValidator(testNotPositiveNumberList));
    }

    @Test
    void sortPages() {
        List<Integer> actualResult = pageDataConvertor.sortPages(expectedParsToIntListResult);
        Assertions.assertEquals(expectedSortPagesResult, actualResult);
    }

    @Test
    void removingDuplicates() {
        List<Integer> actualResult = pageDataConvertor.removingDuplicates(expectedParsToIntListResult);
        Assertions.assertEquals(expectedTreatedPagesResult, actualResult);
    }

    @Test
    void reducedPageNumbers1() {
        String actual1 = pageDataConvertor.reducedPageNumbers(testListForReducedPageNumbers1);
        Assertions.assertEquals(expectedReducedPageNumbers1, actual1);
    }

    @Test
    void reducedPageNumbers2() {
        String actual2 = pageDataConvertor.reducedPageNumbers(testListForReducedPageNumbers2);
        Assertions.assertEquals(expectedReducedPageNumbers2, actual2);

    }


}