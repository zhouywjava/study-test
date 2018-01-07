package DesignModel.qiaojiemodel;

/**
 * Created by zhouyiwei on 2017/11/26.
 */
public abstract class AbstractRead<T> {
    public abstract T read(String strPath) throws Exception;
}
