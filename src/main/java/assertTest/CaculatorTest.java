package assertTest;

/**
 * Created by zhouyiwei on 2018/2/12.
 */
public class CaculatorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        CaculatorTest.class.getClassLoader().setDefaultAssertionStatus(true);
        new CaculatorTest().caculator(1,0);
    }

    public void caculator(int i,int j){
        assert j != 0 : "j == 0";
        System.out.println(i/j);
    }
}
