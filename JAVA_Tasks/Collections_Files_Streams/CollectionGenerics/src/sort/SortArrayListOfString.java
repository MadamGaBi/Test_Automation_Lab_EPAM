package sort;

import java.io.*;
import java.util.*;

// ДЗ:
// Отсортировать массив строк:
// - по длине строки; use Comparator; в случае равных строк - по алфавиту
// - по количеству гласных

// всі масиви зчитувати з файлів сканером

/**
 * Created by GaBi on 20.04.2016.
 * class SortArrayListOfString using Comparator
 */
public class SortArrayListOfString {

    public static final String TEXT_FILE_NAME = "src/sort/inputString.txt";
    public static final String REG_EXP_COMA_AND_SPACE = "[.,\\s\\n]+";
    public static final String REG_EXP_CONSONANT = "[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]+";
    public static final String BEFORE_SORT = "Before sorting: ";
    public static final String AFTER_SORT_BY_ALPHABET = "After sorting by alphabet: ";
    public static final String AFTER_SORT_BY_LENGTH = "After sorting by length: ";
    public static final String AFTER_SORT_BY_VOWEL = "After sorting by quantity of vowels: ";


    /**
     * the method readFromFileArrayList reads String and adds it to list
     * if data in file are split up by coma(point), or space, or coma(point) with space
     * @param list
     * @return list with new data from file
     */
    public static List<String> readFromFileArrayList(List<String> list){
        list.clear();
        try (BufferedReader in = new BufferedReader(new FileReader(TEXT_FILE_NAME))){
            Scanner scanner = new Scanner(in);
            for (String inp : scanner.nextLine().trim().toLowerCase().split(REG_EXP_COMA_AND_SPACE)) {
                Collections.addAll(list, inp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * the method printAll prints object
     * @param forPrint
     */
    public static void printAll(Object forPrint){
        System.out.println(forPrint);
    }

    /**
     * the method sortArrayListWithStringByAlphabet
     * sorts ArrayList with String by alphabet
     * @param list
     * @return list
     */
    public static List<String> sortArrayListWithStringByAlphabet(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String  o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        return list;
    }

    /**
     * the method sortArrayListWithStringByLength
     * sorts ArrayList with String by length
     * @param list
     * @return list
     */
    public static List<String> sortArrayListWithStringByLength(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String  o1, String o2) {
                return (((Integer)o1.length()).compareTo(o2.length()));
            }
        });
        return list;
    }

    /**
     * the method deleteConsonant deletes all consonants in String
     * @param o
     * @return o without consonants
     */
    public static String deleteConsonant(String o) {
        return o.replaceAll(REG_EXP_CONSONANT,"");
    }

    /**
     * the method sortArrayListWithStringByVowels
     * sorts ArrayList with String by quantity of vowels
     * @param list
     * @return list
     */
    public static List<String> sortArrayListWithStringByVowels(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String  o1, String o2) {
                return (((Integer)deleteConsonant(o1).length()).compareTo(deleteConsonant(o2).length()));
            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        printAll(BEFORE_SORT);
        printAll(readFromFileArrayList(list));

        printAll(AFTER_SORT_BY_ALPHABET);
        printAll(sortArrayListWithStringByAlphabet(list));

        printAll(AFTER_SORT_BY_LENGTH);
        printAll(sortArrayListWithStringByLength(list));

        printAll(AFTER_SORT_BY_VOWEL);
        printAll(sortArrayListWithStringByVowels(list));
    }

}
