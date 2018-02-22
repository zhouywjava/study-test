package fanxingjicheng;

/**
 * Created by zhouyiwei on 2018/2/20.
 */
public class test implements Comparable{

    public static void sayHello(Employee employee){
        System.out.println("Hello");
    }

    public static void main(String[] args) {

        Employee admin = new Employee();
        Manager ceo = new Manager();
        Manager manager = new Manager();
        Son son = new Son();
        Staffer staffer = new Staffer();
        Pair<Manager> managerPair = new Pair<Manager>(ceo,manager);
        Pair<Employee> employeePair = new Pair<>(ceo,manager);
        Pair<? extends Employee> sonPair = managerPair;
        Pair<? super Manager> fatherPair = managerPair;
        fatherPair.setFirst(son);
        fatherPair.setFirst(ceo);
        Object one = fatherPair.getFirst();
        /*Employee e = fatherPair.getFirst();*/
       /* sonPair.setFirst(ceo);
        sonPair.setFirst(staffer);
        sonPair.setFirst(admin);*/
        sayHello(admin);
        sayHello(ceo);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
