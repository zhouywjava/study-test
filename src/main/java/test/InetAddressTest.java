package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhouyiwei on 2017/11/12.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.1.111");
            byte[] b = address.getAddress();
            for(byte octet : b){
                int unsigned = octet < 0? octet + 256 : octet;
                System.out.println(unsigned);
            }
          /*  String str = address.getHostAddress();
            System.out.println(str);*/
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
