package com.example.demo.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo-biz")
@Api(description = "TestTwoApi", tags = "TestTwoApi")
public interface TestTwoApi {

    @ApiOperation(value = "正常返回", response =String.class)
    @PostMapping("/biz/bizNormal2")
    String normal(@RequestBody @Validated Integer id);

    @ApiOperation(value = "超时返回", response =String.class)
    @PostMapping("/biz/bitTimeOutTest2")
    String timeOut(@RequestBody @Validated Integer id);

    @ApiOperation(value = "异常返回", response =String.class)
    @PostMapping("/biz/exception2")
    String exception(@RequestBody @Validated Integer id);
}

