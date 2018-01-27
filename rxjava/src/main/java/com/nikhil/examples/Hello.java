package com.nikhil.examples;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.SyncOnSubscribe;

import java.util.Arrays;
import java.util.function.Consumer;

public class Hello {
    Logger logger = LoggerFactory.getLogger(Hello.class);

    public void hello(String... names) {
        Observable<String> observable = Observable.from(names);

        Subscription subscription = observable.subscribe(s -> {
            logger.info("Hello {}", s);
        });

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onStart() {
                request(2);
            }

            @Override
            public void onCompleted() {
                logger.info("Subscriber complete");
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error("Error ", throwable);
                unsubscribe();
            }

            @Override
            public void onNext(String s) {
                logger.info("Received {}", s);

                request(0);
            }
        });

        Observable<String> customObservable = Observable.create(new SyncOnSubscribe<String[], String>() {
            int index = 0;
            @Override
            protected String[] generateState() {
                String[] state = new String[]{"Nikhil", "Erica", "Aiden"};
                logger.info("Generating state {}", state.length);

                return state;
            }

            @Override
            protected String[] next(String[] o, Observer<? super String> observer) {
                logger.info("Next invoked for object state with length {}", o.length);

                observer.onNext(o[index++]);

                if (index == o.length) {
                    observer.onCompleted();
                }

                return o;
            }
        });

//        customObservable.subscribe(s -> {
//            logger.info("I've subscribed and got {}. Hello {}", s, s);
//        });
    }
}
