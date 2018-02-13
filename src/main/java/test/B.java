package test;

/**
 * Created by zhouyiwei on 2018/1/16.
 */
public class B extends A{

    public B(int num) {
        super(num);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1);
        System.out.println(a.getNum());
        A aa = (A)a.clone();
        System.out.println(aa.getNum());
    }
}
