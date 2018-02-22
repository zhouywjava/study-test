package treetest;

import java.util.Objects;

/**
 * Created by zhouyiwei on 2018/2/21.
 */
public class Item implements Comparable<Item> {

    private String description;
    private int partNum;

    public Item(String description, int partNum) {
        this.description = description;
        this.partNum = partNum;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNum=" + partNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNum != item.partNum) return false;
        return description != null ? description.equals(item.description) : item.description == null;
    }

    @Override
    public int hashCode() {
       return Objects.hash(description,partNum);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNum,o.partNum);
        return diff != 0? diff:description.compareTo(o.getDescription());
    }
}
