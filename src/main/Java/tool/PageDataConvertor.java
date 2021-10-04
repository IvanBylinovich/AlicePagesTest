package tool;

import exception.NegativePageNumberException;

import java.util.List;

public class PageDataConvertor {

    //преобразование строки с номерами страниц в строкового списка номеров страниц
    public List<String> parsToStringList(String pagesString){
        return null;
    }

    //преобразует строкового списка номеров страниц в список целых чисел
    public List<Integer> parsToIntList(List<String> pagesList) throws NumberFormatException{
        return null;
    }

    //проверяет список целых чисел на положительное значение(страницы не могут быть меньше 1)
    public void positiveValueValidator(List<Integer> pages) throws NegativePageNumberException {

    }

    //сортирует номера страниц по возрастанию
    public List<Integer> sortPages(List<Integer> pages){
        return null;
    }

    //убирает дубликаты номеров страниц
    public List<Integer> removingDuplicates(List<Integer> pages){
        return null;
    }

    //преобразование отсортерованного списка номеров страниц в строку, сокращенного формата
    public String reducedPageNumbers(List<Integer> pageNumberList){
        return null;
    }

}
