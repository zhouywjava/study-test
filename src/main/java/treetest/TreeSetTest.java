package treetest;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by zhouyiwei on 2018/2/21.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("A",1234));
        parts.add(new Item("C",4562));
        parts.add(new Item("B",9921));
        System.out.println(parts);

        SortedSet sortByDescribe = new TreeSet(
               Comparator.comparing(Item::getDescription)
        );
        sortByDescribe.addAll(parts);
        System.out.println(sortByDescribe);
    }
}
