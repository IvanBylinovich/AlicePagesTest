package tool;

import exception.NegativePageNumberException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageDataConvertorTest {

    PageDataConvertor pageDataConvertor = new PageDataConvertor();

    String testStringPages = "5,6,7,8,3,2,1,0,5,6";
    List<String> expectedParsToStringListResult = Arrays.asList("5","6","7","8","3","2","1","0","5","6");
    List<String> testNoNumberList = Arrays.asList("5","b","7");
    List<Integer> expectedParsToIntListResult = Arrays.asList(5,6,7,8,3,2,1,0,5,6);
    List<Integer> expectedSortPagesResult = Arrays.asList(0,1,2,3,5,5,6,6,7,8);
    List<Integer> testNotPositiveNumberList = Arrays.asList(-2,0,2,3,-60,5,6,6,7,-80);
    List<Integer> testListForReducedPageNumbers1 = Arrays.asList(2,3,4,6,8,9,10);
    String expectedReducedPageNumbers1 = "2-4,6,8-10";
    List<Integer> testListForReducedPageNumbers2 = Arrays.asList(2,3,4,6,8,10);
    String expectedReducedPageNumbers2 = "2-4,6,8,10";


    @Test
    void parsToStringList() {
        List<String> actualResult = pageDataConvertor.parsToStringList(testStringPages);
        Assert.assertEquals(expectedParsToStringListResult, actualResult);
    }

    @Test
    void parsToIntList() {
        List<Integer> actualResult =  pageDataConvertor.parsToIntList(expectedParsToStringListResult);
        Assert.assertEquals(expectedParsToIntListResult, actualResult);
    }

    @Test
    void parsToIntListEx() throws NumberFormatException{
        try {
            pageDataConvertor.parsToIntList(testNoNumberList);
        }catch (NumberFormatException e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }


    @Test
    void positiveValueValidator() throws NegativePageNumberException {
        try {
            pageDataConvertor.positiveValueValidator(testNotPositiveNumberList);
        }catch (Exception e){
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    void sortPages() {
        List<Integer> actualResult = pageDataConvertor.sortPages(expectedParsToIntListResult);
        Assert.assertEquals(expectedSortPagesResult, actualResult);
    }

    @Test
    void removingDuplicates() {
        List<Integer> actualResult = pageDataConvertor.removingDuplicates(expectedParsToIntListResult);
        Assert.assertEquals(expectedSortPagesResult, actualResult);
    }

    @Test
    void reducedPageNumbers1() {
        String actual1 = pageDataConvertor.reducedPageNumbers(testListForReducedPageNumbers1);
        Assert.assertEquals(expectedReducedPageNumbers1, actual1);
    }

    @Test
    void reducedPageNumbers2() {
        String actual2 = pageDataConvertor.reducedPageNumbers(testListForReducedPageNumbers2);
        Assert.assertEquals(expectedReducedPageNumbers2, actual2);

    }


}