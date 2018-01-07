package DesignModel.ObserverModel;

/**
 * Created by zhouyiwei on 2017/11/22.
 */
public class Observer<T> implements IObserver<T> {
    @Override
    public void refresh(T data) {
        System.out.println("接受到通知刷新"+ data);
    }
}
