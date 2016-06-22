import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] array = {1, 6, 9, 2, 2, 12, 3, 0, -1, 999};
        List<Integer> list = Arrays.asList(array);
        System.out.println("Source array is " + list);
        findMinimums(list);
    }

    public static void findMinimums(List<Integer> list) {
        HashSet<Integer> set = new HashSet<Integer>(list);
        System.out.println("First minimum is " + findMinimum(set));
        System.out.println("Second minimum is " + findMinimum(set));
        System.out.println("Third minimum is " + findMinimum(set));
    }

    public static Integer findMinimum(HashSet<Integer> set) {
        if (set != null && !set.isEmpty()) {
            Integer min = Collections.min(set);
            set.remove(min);
            return min;
        }
        else {
            return null;
        }
    }
}
