package com.example.demo.controller;

import com.example.demo.api.TestBizApi;
import com.example.demo.api.TestServerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBizController implements TestBizApi {
    @Autowired
    TestServerApi testServerApi;

    @Override
    public String normal(Integer id) {
        return testServerApi.normal(id);
    }

    @Override
    public String timeOut(Integer id) {
        return testServerApi.timeOut(id);
    }
}
