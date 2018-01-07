package DesignModel.ObserverModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhouyiwei on 2017/11/22.
 */
public class Subject<T> implements ISubject<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private List<IObserver<T>> observers = new LinkedList<IObserver<T>>();

    @Override
    public void regist(IObserver<T> iObserver) {
        observers.add(iObserver);
    }

    @Override
    public void unregist(IObserver<T> iObserver) {
        if(observers.contains(iObserver)){
            observers.remove(iObserver);
        }
    }

    @Override
    public void notifyObservers() {
        for(IObserver<T> iObserver : observers){
            iObserver.refresh(data);
        }
    }
}
