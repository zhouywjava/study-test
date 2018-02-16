package test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: zyw
 * @Date: 2018/1/12
 */
public class ComputerTest {

    private List<Long> res = new LinkedList<Long>();
    public String getList(int n){
        long a = new Date().getTime();
        StringBuilder sb = new StringBuilder("");
        for(int i = 1;i <= n;i++){
            sb.append(function(i));
            sb.append(",");
        }
        long b = new Date().getTime();
        System.out.println(b-a);
        return sb.toString().substring(0,sb.length()-1);
    }

    public int function(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        if(n<1){ throw new ArrayIndexOutOfBoundsException();}
        return function(n-1)+function(n-2);

    }

    public String getListFor(int n){
        long a = new Date().getTime();
        StringBuilder sb = new StringBuilder("");
        if(n < 1)throw new ArrayIndexOutOfBoundsException();
        for(int i = 1;i <= n;i++){
            if(i == 1 || i == 2){
                res.add(1L);
            }else{
                int num = i - res.size();
                while(num>0){
                    res.add(res.get(res.size()-1) + res.get(res.size()-2));
                    num--;
                }
            }

        }
        for(Long str :res){
            sb.append(str);
            sb.append(",");
        }
        long b = new Date().getTime();
        System.out.println(b-a);
        return sb.toString().substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        ComputerTest test = new ComputerTest();
        //System.out.println(test.getList(50));
        System.out.println(test.getListFor(50));
    }
}
