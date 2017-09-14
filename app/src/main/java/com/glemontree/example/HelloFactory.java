package com.glemontree.example;

import com.example.Hello;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by Administrator on 2017/9/14.
 */

public class HelloFactory {
    private static HelloFactory mDisplayFactory;
    private Iterator<Hello> mIterator;

    private HelloFactory() {
        ServiceLoader<Hello> loader = ServiceLoader.load(Hello.class);
        mIterator = loader.iterator(); // 懒加载
    }

    public static HelloFactory newInstance() {
        if (null == mDisplayFactory) {
            synchronized (HelloFactory.class) {
                if (null == mDisplayFactory) {
                    mDisplayFactory = new HelloFactory();
                }
            }
        }
        return mDisplayFactory;
    }

    Hello getHello() {
        return mIterator.next();
    }

    boolean hasNextHello() {
        return mIterator.hasNext(); // 真正加载的地方
    }
}
