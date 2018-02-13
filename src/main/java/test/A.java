package test;

/**
 * Created by zhouyiwei on 2018/1/16.
 */
public class A implements Cloneable{

    private int num;

    public A(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1);
        System.out.println(a.num);
        A aa = (A)a.clone();
        System.out.println(aa.num);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
