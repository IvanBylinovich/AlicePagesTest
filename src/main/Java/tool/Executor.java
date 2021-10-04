package tool;

import exception.NegativePageNumberException;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    private PageDataConvertor pageDataConvertor = new PageDataConvertor();
    private List<Integer> bufferList= new ArrayList<>();

    public String toFormat(String pagesList) throws NegativePageNumberException {

        bufferList = pageDataConvertor.parsToIntList(pageDataConvertor.parsToStringList(pagesList));
        pageDataConvertor.positiveValueValidator(bufferList);
        bufferList = pageDataConvertor.sortPages(bufferList);
        bufferList = pageDataConvertor.removingDuplicates(bufferList);
        return pageDataConvertor.reducedPageNumbers(bufferList);
    }

}
