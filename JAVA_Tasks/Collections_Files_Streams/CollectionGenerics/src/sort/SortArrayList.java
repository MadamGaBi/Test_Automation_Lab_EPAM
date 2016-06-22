package sort;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by GaBi on 20.04.2016.
 * class SortArrayList using Comparator
 */

// ДЗ: Отсортировать ArrayList из double по возрастанию дробной части
// use comparator, который учитывет только дробную часть

public class SortArrayList {

    public static final String TEXT_FILE_NAME = "src/sort/inputDouble.txt";
    public static final String REG_EXP_COMA_AND_SPACE = "[,\\s]+";
    public static final String BEFORE_SORT = "Before sorting: ";
    public static final String AFTER_SORT = "After sorting: ";

    /**
     * the method readFromFileArrayList reads integer and adds it to list
     * if data in file are split up by coma, or space, or coma with space  1,4,5,33,43,345, 32,33,0,0,  7, 9
     * @param list
     * @return list with new data from file
     */
    @SuppressWarnings("JavaDoc")
    public static List<Double> readFromFileArrayList(List<Double> list){
        list.clear();
        try (InputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_NAME))){
            Scanner scanner = new Scanner(in);
            for (String inp : scanner.nextLine().trim().split(REG_EXP_COMA_AND_SPACE)) {
                list.add(Double.valueOf(inp));
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
     * the method separateFractionalPart separates fractional part of Double
     * @param o
     * @return fractional part of Double
     */
    public static Double separateFractionalPart(Double o){
        return o%1;
    }

    /**
     * the method sortArrayListWithDoubleByFractionalPart
     * sorts ArrayList with double by fractional part
     * @param list
     * @return list
     */
    public static List<Double> sortArrayListWithDoubleByFractionalPart(List<Double> list) {
        list.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (o1.compareTo(o2));
            }
        });
        list.sort((o1,o2) -> separateFractionalPart(o1).compareTo(separateFractionalPart(o2)));
        return list;
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();

        printAll(BEFORE_SORT);
        printAll(readFromFileArrayList(list));

        printAll(AFTER_SORT);
        printAll(sortArrayListWithDoubleByFractionalPart(list));

    }


    // Отсортировать массив строк:
    // - по длине строки; use Comparator
    // - по возрастанию строки (в случае равных строк - по алфавиту)
    // - по количеству гласных

    // всі масиви зчитувати з файлів сканером
}
