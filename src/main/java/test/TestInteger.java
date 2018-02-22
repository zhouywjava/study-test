package test;

/**
 * Created by zhouyiwei on 2018/2/21.
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        int c = 128;
        int d = 128;

        System.out.println(a.intValue() == b.intValue());
        System.out.println(a.equals(b));
        System.out.println(c == d);
    }
}
