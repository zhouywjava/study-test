package inter;

/**
 * Created by zhouyiwei on 2018/2/21.
 */
public interface TestInter {
     void sayHello();
     static int num = 1;
     static void sayHi(){
         System.out.println("hi");
     }
}
class Test implements TestInter{

    private String id;
    private String name;

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        /*Test t = new Test();
        t.sayHello();
        TestInter.sayHi();*/
        String first = "abc";
        String second = "bac";
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        return id != null ? id.equals(test.id) : test.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}