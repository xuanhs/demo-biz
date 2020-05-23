package com.example.demo.controller;

import com.example.demo.api.TestBizApi;
import com.example.demo.api.TestNormalTimeoutApi;
import com.example.demo.api.TestServerApi;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBizController implements TestBizApi {
    @Autowired
    TestServerApi testServerApi;

    @Autowired
    TestNormalTimeoutApi testNormalTimeoutApi;
    @Override
    public String normal(@RequestBody @Validated Integer id) {
        return testServerApi.normal(id);
    }

    @Override
    public String timeOut(@RequestBody @Validated Integer id) {
        return testServerApi.timeOut(id);
    }

    @Override
    public String exception(@RequestBody @Validated Integer id) {
        return testServerApi.exception(id);
    }

    @Override
    public String exceptionNPL(@RequestBody @Validated Integer id) {
        return testServerApi.exceptionNPL(id);
    }

    @Override
    public String normalTimeout(@RequestBody @Validated Integer id) {
        return testNormalTimeoutApi.timeOut(id);
    }

    public String test(){
        return "fallback";
    }
}
