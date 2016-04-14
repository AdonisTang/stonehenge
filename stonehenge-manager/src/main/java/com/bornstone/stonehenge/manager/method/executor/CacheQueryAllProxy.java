package com.bornstone.stonehenge.manager.method.executor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by King.Tang on 14-7-28.
 */
public class CacheQueryAllProxy {
    private static Map<Class, List> cache = new ConcurrentHashMap<Class, List>();

//    private AfterQueryDoNothing afterQueryDoNothing;
//
//    public <T extends BaseEntity,D extends IQueryAll> List<T> query(D dao, Class clssName){
//        return query(dao, afterQueryDoNothing, clssName);
//    }
//
//    public <T extends BaseEntity> List<T> query(IQueryAll<T> dao,IQueryCallBackAble queryCallBackAble, Class className){
//        List<T> list = (List<T>) cache.get(className);
//        if(list==null){
//            list = dao.selectAll();
//            list = queryCallBackAble.afterQuery(list);
//            cache.put(className, list);
//        }
//        return list;
//    }
//
//    public void clearCache(Class className){
//        if(cache.containsKey(className)){
//            cache.remove(className);
//        }
//    }
//
//    public void setAfterQueryDoNothing(AfterQueryDoNothing afterQueryDoNothing) {
//        this.afterQueryDoNothing = afterQueryDoNothing;
//    }
}
