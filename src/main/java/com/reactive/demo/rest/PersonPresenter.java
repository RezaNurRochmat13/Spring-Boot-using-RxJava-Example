package com.reactive.demo.rest;

import com.reactive.demo.component.PersonDataObservables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class PersonPresenter {
    @Autowired
    private PersonDataObservables personDataObservables;

    @GetMapping("/persons")
    public Map<String, Object> getAllPersonObservables() {

    }
}
