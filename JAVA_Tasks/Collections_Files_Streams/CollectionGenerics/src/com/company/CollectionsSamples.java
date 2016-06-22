package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

/**
 * Created by GaBi on 14.04.2016.
 * class CollectionsSamples demonstrates different operations with different types of collections
 */

public class CollectionsSamples<T> {

    public static final String TEXT_FILE_NAME_2 = "input.txt";
    public static final String COMMON_ELEMENTS = "Common elements in two sets: ";
    public static final String DIFFERENT_ELEMENTS = "Different elements in two sets: ";
    public static final String REG_EXP = "\\s+";
    public static final String REG_EXP_COMA_AND_SPACE = "[,\\s]+";

    T obj;

    public CollectionsSamples(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    // Вернуть obj
    T getobj() {
        return obj;
    }

    // Показать тип T
    void showTypeOfT() {
        printLn("Type of T: " + obj.getClass().getName());
    }

    public static void main(String[] args) {

        // ----------------------------------------- Start of lesson's coding ------------------------------------------

        String input = "one two three one two three one two three "
                + " one two three 55 5 6 7 45 45 45";
        String[] word = input.split(REG_EXP);
        printLn(Arrays.toString(word));

        List<String> list = new LinkedList<>(Arrays.asList(word));

        printLn(list);
        while (list.remove("45"));
        printLn(list);
        list.remove(3);
        printLn(list);
        printLine();
        printLn(list.indexOf("5"));
        // it's bad need ArrayList
        for (int i = 0; i<list.size(); i++){
            if ("5".equals(list.get(i))){
                printLn(i);
            }
        }
        printLine();

        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()){
            String val = it.next();
            i++;
            if ("5".equals(val)){
                printLn(i);
            }
        }
        printLine();
        i=0;
        for ( String val : list ) {
            i++;
            if ("5".equals(val)){
                printLn(i);
            }
        }
        printLine();
        printLine();

        String secondString = "one two three 55 new";
        Set<String> stringSet = new TreeSet<>( list );
        Set<String> secondSet = new TreeSet<>(Arrays.asList(secondString.split("\\s+")));
        printLn(stringSet);
        printLn(secondSet);

        printLine();
        printLine();

        // common elements in two sets
        printLn(COMMON_ELEMENTS);
        for (String s : stringSet ) {
            if (secondSet.contains(s)){
                System.out.print(s + " ");
            }
        }
        printLn("");
        printLine();
        printLine();

        // Map.Entry
        Map<String, Integer> map = new HashMap<>();

        for ( String s : list ) {
            Integer val;
            if ((val = map.get(s)) == null) {
                map.put(s, 1);
            } else {
                map.put(s, val + 1);
            }
        }
        printLn(list);
        printLn(map);
        printLine();
        printLine();

        // ------------------------------------------- End of lesson's codding -----------------------------------------

        // ---------------------------------------------- Start of homework --------------------------------------------

        /*
         * ДЗ: вивести різні елементи із двох сетів у третій
         */
        List<String> commonElementsList = new ArrayList<>();
        List<String> differentElementsList = new ArrayList<>();
        Set<String> unionOfTwoSets = Stream.concat(stringSet.stream(), secondSet.stream()).collect(Collectors.toSet());

        for (String s : stringSet ) {
            if (secondSet.contains(s)){
                commonElementsList.add(s);
            }
        }
        for (String s : unionOfTwoSets) {
            if (commonElementsList.contains(s)){
                // don't do anything
            } else {differentElementsList.add(s);}
        }
        printLn(DIFFERENT_ELEMENTS);
        printLn(differentElementsList); // print set with different elements of two sets
        printLine();
        printLine();

        /*
         * ДЗ: відсортувати масив int по кількості входів елемента, use map
         */
        List<Integer> listInt = new ArrayList<>();
        List listIntSortedByRepeating = new ArrayList<>();

        Map<Integer, Integer> sortMap = sortByValues(buildMapFromList(readFromFile(listInt)));

        printLn(readFromFile(listInt)); // list of data (print for easy debugging)
        printLn(buildMapFromList(readFromFile(listInt)));  // map of data (print for easy debugging)
        printLn(sortByValues(buildMapFromList(readFromFile(listInt)))); // sorted map by values (print for easy debugging)

        for ( Map.Entry sortMapElement : sortMap.entrySet() ) {
            for (int num = 0; num < (int)sortMapElement.getValue(); num++){
                listIntSortedByRepeating.add(sortMapElement.getKey());
            }
        }
        printLn(listIntSortedByRepeating); // sorted list by quantity of repeating
        }

    /**
     * method printLine() prints line to separate blocks of program
     */
    public static <T> void printLn(T objectT){
        System.out.println(objectT);
    }

    /**
     * method printLine() prints line to separate blocks of program
     */
    public static void printLine(){
        System.out.println("=========================================================================================");
    }

    /**
     * method sortByValues() sorts map by values
     * use HashMap to preserve the insertion order
     * @param map
     * @return sortedMap
     */
    private static Map<Integer, Integer> sortByValues(Map<Integer, Integer> map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     * method buildMapFromList() builds map from list
     * with keys - data from list, values - quantity of data's repeating in list
     * @param list
     * @return map
     */
    public static <T> Map<T, Integer> buildMapFromList(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for ( T s : list ) {
            Integer val;
            if ((val = map.get(s)) == null) {
                map.put(s, 1);
            } else {
                map.put(s, val + 1);
            }
        }
        return map;
    }

    /**
     * method readFromFile() reads integer and adds it to list
     * if data in file are split up by spaces (for example: 1 2 3 4 32 34 22 12 11)
     * @param listInt
     * @return list with new data from file
     */
    public static List<Integer> readFromFile(List<Integer> listInt){
        listInt.clear();
        try (InputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_NAME_2))){
            Scanner scanner = new Scanner(in);
            for (String inp : scanner.nextLine().trim().split(REG_EXP_COMA_AND_SPACE)) {
                listInt.add(Integer.valueOf(inp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listInt;
    }
    // --------------------------------------------- End of homework ---------------------------------------------------
}
