package DesignModel.ObserverModel;

/**
 * Created by zhouyiwei on 2017/11/22.
 */
public interface ISubject<T> {

    void regist(IObserver<T> iObserver);
    void unregist(IObserver<T> iObserver);
    void notifyObservers();
}
