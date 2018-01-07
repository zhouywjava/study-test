package DesignModel.ObserverModel;

/**
 * Created by zhouyiwei on 2017/11/22.
 */
public interface IObserver<T> {

    void refresh(T data);
}
