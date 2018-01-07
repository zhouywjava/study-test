package DesignModel.ObserverModel;

/**
 * Created by zhouyiwei on 2017/11/22.
 */
public class Test {
    public static void main(String[] args) {
        IObserver<String> iObserver = new Observer<String>();
        Subject<String> subject = new Subject<String>();
        subject.setData("你好");
        subject.regist(iObserver);//属于推数据
        subject.notifyObservers();
    }
}
