package tool;

import exception.NegativePageNumberException;

import java.util.*;

public class PageDataConvertor {

    //преобразование строки с номерами страниц в строковый список номеров страниц
    public List<String> parsToStringList(String pagesString){
        return Arrays.asList(pagesString.split(","));
    }

    //преобразует строковый списка номеров страниц в список целых чисел
    public List<Integer> parsToIntList(List<String> pagesList) throws NumberFormatException{
        List<Integer> pagesIntList = new ArrayList<>();

        for(String numS : pagesList) pagesIntList.add(Integer.parseInt(numS));

        return pagesIntList;
    }

    //проверяет список целых чисел на положительное значение(номера страниц не могут быть меньше 1)
    public void positiveValueValidator(List<Integer> pages) throws NegativePageNumberException {
        for(int i : pages){
           if (i<=0) throw new NegativePageNumberException();
        }
    }

    //сортирует номера страниц по возрастанию
    public List<Integer> sortPages(List<Integer> pages){
        Collections.sort(pages, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return pages;
    }

    //убирает дубликаты номеров страниц
    public List<Integer> removingDuplicates(List<Integer> pages){
        Set<Integer> pagesSet = new LinkedHashSet<>();
        pagesSet.addAll(pages);
        List<Integer> treatedPages = new ArrayList<>();
        treatedPages.addAll(pagesSet);
        return treatedPages;
    }

    //преобразование отсортерованного списка номеров страниц в строку, сокращенного формата
    public String reducedPageNumbers(List<Integer> pageNumberList){
        Queue<Integer> pagesQ = new ArrayDeque<>();
        int first = 0;
        Integer last = 0;
        Optional<Integer> integerOptional;
        Optional<Integer> integerOptional2;
        String pagesString = "";

        pagesQ.addAll(pageNumberList);

        while (true){
            integerOptional = Optional.ofNullable(pagesQ.poll());
            if(integerOptional.isEmpty()) break;

            first = integerOptional.get();
            integerOptional = Optional.ofNullable(pagesQ.peek());

            //обработка момента окончания списка страниц
            if(integerOptional.isEmpty()){
                pagesString = pagesString.concat(String.valueOf(first));
                System.out.println(first);
                break;
            }

            if(integerOptional.get() == first+1){
                //цикл обрабатывет номера строниц, идущих по порядку
                do{

                    integerOptional = Optional.ofNullable(pagesQ.poll());
                    last = integerOptional.get();
                    integerOptional2 = Optional.ofNullable(pagesQ.peek());

                    if(integerOptional.isEmpty() || integerOptional2.isEmpty()) break;

                }while(pagesQ.peek() == last + 1);

                if(integerOptional2.isEmpty()){
                    //вывод последнего диапазона
                    pagesString = pagesString.concat(String.valueOf(first));
                    pagesString = pagesString.concat("-");
                    pagesString = pagesString.concat(String.valueOf(last));

                    System.out.print(first + "-" + last);
                }else{
                    pagesString = pagesString.concat(String.valueOf(first));
                    pagesString = pagesString.concat("-");
                    pagesString = pagesString.concat(String.valueOf(last));
                    pagesString = pagesString.concat(",");

                    System.out.print(first + "-" + last + ",");
                }

                //обрабатывает одиночную страницу, не имеющую следующего по порядковому номеру
            }else{
                pagesString = pagesString.concat(String.valueOf(first ));
                pagesString = pagesString.concat(",");
                System.out.print( first + ",");
            }
        }
        System.out.println(pagesString);

        return pagesString;

    }

}
