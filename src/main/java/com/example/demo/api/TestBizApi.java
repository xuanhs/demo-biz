package com.example.demo.api;

import com.example.demo.config.FeignHasHystrixConfigure;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo-biz")
@Api(description = "测试熔断", tags = "熔断测试接口")
public interface TestBizApi {

    @ApiOperation(value = "正常返回", response = String.class)
    @PostMapping("/biz/bizNormal")
    String normal(@RequestBody @Validated Integer id);

    @ApiOperation(value = "超时返回", response = String.class)
    @PostMapping("/biz/bitTimeOutTest")
    String timeOut(@RequestBody @Validated Integer id);

    @ApiOperation(value = "异常返回", response = String.class)
    @PostMapping("/biz/exception")
    String exception(@RequestBody @Validated Integer id);

    @ApiOperation(value = "空指针异常", response = String.class)
    @PostMapping("/biz/exceptionNPL")
    String exceptionNPL(@RequestBody @Validated Integer id);

    @ApiOperation(value = "feign超时", response = String.class)
    @PostMapping("/biz/normalTimeout")
    String normalTimeout(@RequestBody @Validated Integer id);

}
