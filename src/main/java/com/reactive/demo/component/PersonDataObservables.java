package com.reactive.demo.component;

import io.reactivex.Observable;
import org.springframework.stereotype.Component;

@Component
public class PersonDataObservables {
    public Observable<String> personNamesObservables(String personName) {
        Observable<String> observablePersonName = Observable.create(emitterData -> {
            try {
                emitterData.onNext(personName);
                emitterData.onComplete();
            } catch (Exception e) {
                emitterData.onError(e);
            }
        });
        return observablePersonName;
    }
}
