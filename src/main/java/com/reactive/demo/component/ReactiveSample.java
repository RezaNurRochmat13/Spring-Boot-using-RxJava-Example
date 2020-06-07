package com.reactive.demo.component;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReactiveSample {

    public Observable<Object> simpleCreateObservables() {
            Observable<Object> sourceObserver = Observable.create(emitterEvent -> {
                try {
                    emitterEvent.onNext("First submit");
                    emitterEvent.onNext("Second submit");
                    emitterEvent.onNext("Third submit");
                    emitterEvent.onComplete();
                } catch (Exception e) {
                    emitterEvent.onError(e);
                }
            });
            return sourceObserver;
    }

    @Bean
    public void simpleCreateObserver() {
        Observable<Object> sourcesObservables = simpleCreateObservables();
        Observer<Object> observer = new Observer<Object>() {

            @Override
            public void onSubscribe(Disposable disposable) { }

            @Override
            public void onNext(Object o) {
                System.out.println("Data observes : " + o);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error an occured : " + throwable.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Emit data submitted ..");
            }
        };
        sourcesObservables.subscribe(observer);
    }
}
