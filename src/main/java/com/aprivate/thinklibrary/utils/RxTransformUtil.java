package com.aprivate.thinklibrary.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by NewNet on 2017/11/15.
 * 可以配合Retrofit和RxJava使用
 */

public class RxTransformUtil {

    public static <T> Observable.Transformer<T, T> composeHelper() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
