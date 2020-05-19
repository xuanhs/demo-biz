package com.example.demo.api;

import com.example.demo.fallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "demo-biz")
public interface TestBizApi {

    /**
     * 实验管理界面，获取实验
     */
    @GetMapping("/bizNormal")
    String normal(Integer id);

    /**
     * 实验管理界面，获取实验
     */
    @GetMapping("/bitTimeOutTest")
    String timeOut(Integer id);
}
