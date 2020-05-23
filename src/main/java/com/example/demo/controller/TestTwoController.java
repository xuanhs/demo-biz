package com.example.demo.controller;

import com.example.demo.api.TestServiceFactoryApi;
import com.example.demo.api.TestTwoApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTwoController implements TestTwoApi {

    @Autowired
    TestServiceFactoryApi testServiceFactoryApi;

    @Override
    public String normal(@RequestBody  @Validated Integer id) {
        return testServiceFactoryApi.normal(id);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "5000")})
    @Override
    public String timeOut(@RequestBody @Validated Integer id) {
        return testServiceFactoryApi.timeOut(id);
    }

    @Override
    public String exception(@RequestBody @Validated Integer id) {
        return testServiceFactoryApi.exception(id);
    }
}
