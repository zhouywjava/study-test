package duotai;

/**
 * Created by zhouyiwei on 2018/2/16.
 */
public class B extends A {

    @Override
    public void functionb() {
        System.out.print(" override b");
        super.functionb();
    }

    public void functionc(){
        System.out.println("c");
    }
}
