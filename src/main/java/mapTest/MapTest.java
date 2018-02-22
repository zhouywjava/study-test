package mapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyiwei on 2018/2/22.
 */
public class MapTest {

    public static void main(String[] args) {
 /*       Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");

        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key:" + entry.getKey() + " ,value=" + entry.getValue());
        }

        map.forEach((k,v)-> System.out.println("key:" + k + " ,value=" + v));
*/
        Map<String,Integer> com = new HashMap<>();
        com.put("A",1000);
        System.out.println(com.merge("A",99,(X,Y)->X+Y));
        com.forEach((k,v)->System.out.println("key:" + k + " ,value=" + v));

    }
}
