package com.jx.modules.rest;


import com.jx.modules.service.GetDateTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/APPBizRest")
@Api(tags = "公共服务模块")
public class GetDateTimeController {
    @Autowired
    private GetDateTimeService getDateTimeService;

    @PostMapping("/getDbDateTime")
    @ApiOperation(value = "获取数据库当前时间", tags = "公共服务模块")
    public String getDbDateTime() {
        return getDateTimeService.getDateTime();
    }
}