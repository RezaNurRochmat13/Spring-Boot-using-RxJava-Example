package com.reactive.demo.rest;

import com.reactive.demo.component.PersonDataObservables;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class PersonPresenter {
    @Autowired
    private PersonDataObservables personDataObservables;

    @GetMapping("/persons")
    public void getAllPersonObservables() {
        Map<String, Object> map = new HashMap<>();
        Observable<String> observablesPerson = personDataObservables.personNamesObservables("Andre");

        try {
            observablesPerson.subscribe(res -> {
                String messages = "";
                messages = res;
                System.out.println("Subscribe messages : " + messages);
            });
        } catch (Exception e) {
            System.out.println("Error has reached : " + e.getLocalizedMessage());
        }

    }
}
