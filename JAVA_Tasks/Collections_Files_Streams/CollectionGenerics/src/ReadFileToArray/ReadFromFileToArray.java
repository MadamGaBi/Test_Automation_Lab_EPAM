package ReadFileToArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by GaBi on 15.04.2016.
 * class ReadFromFileToArray reads data from file to Array
 */

public class ReadFromFileToArray {

    public static final String TEXT_FILE_NAME = "array.txt";
    public static final String TEXT_FILE_NAME_2 = "input.txt";
//    public static final String REG_EXP_SPACE = "\\s+";
    public static final String REG_EXP_COMA_AND_SPACE = "[,\\s]+";

    /**
     * method readFromFile reads integer and adds it to list
     * if data in file are split up by spaces 1 2 3 4 32 34 22 12 11
     * @param list
     * @return list with new data from file
     */
    @SuppressWarnings("JavaDoc")
    public static List<Integer> readFromFile(List<Integer> list){
        list.clear();
        try (InputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_NAME))){
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    int temp = scanner.nextInt();
                    list.add(temp);
                }else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * method readFromFileString reads integer and adds it to list
     * if data in file are split up by coma, or space, or coma with space  1,4,5,33,43,345, 32,33,0,0,  7, 9
     * @param list
     * @return list with new data from file
     */
    @SuppressWarnings("JavaDoc")
    public static List<Integer> readFromFileString(List<Integer> list){
        list.clear();
        try (InputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_NAME_2))){
            Scanner scanner = new Scanner(in);
            for (String inp : scanner.nextLine().trim().split(REG_EXP_COMA_AND_SPACE)) {
                list.add(Integer.valueOf(inp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * method readFromFileString reads integer and adds it to list
     * if data in file are split up by coma, or space, or coma with space  1,4,5,33,43,345, 32,33,0,0,  7, 9
     * @return list with data from file
     */
    public static List<String> readFromFileString() {
        List<String> input = null;
        try (InputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_NAME_2))){
            Scanner scanner = new Scanner(in);
            input = Arrays.asList(scanner.nextLine().trim().split(REG_EXP_COMA_AND_SPACE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void printMes(List mes){
        System.out.println(mes);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        printMes(readFromFile(list));
        printMes(readFromFileString(list));
        printMes(readFromFileString());
    }
}
