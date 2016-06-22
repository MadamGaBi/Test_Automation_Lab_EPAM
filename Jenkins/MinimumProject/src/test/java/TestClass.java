import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class TestClass {

    @Test
    public void testNullCollection() {
        HashSet<Integer> list = null;
        Assert.assertEquals(Main.findMinimum(list), null);
    }

    @Test
    public void testEmptyCollection() {
        HashSet<Integer> list = new HashSet<Integer>();
        Assert.assertEquals(Main.findMinimum(list), null);
    }

    @Test
    public void testCollectionWithTheSameValues() {
        HashSet<Integer> list = new HashSet<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        Assert.assertEquals(Main.findMinimum(list), new Integer(1));
    }
}
