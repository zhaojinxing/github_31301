package com.jx.modules.service;


import com.jx.modules.dao.GetDateTimeMapper;
import com.jx.modules.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GetDateTimeService {
    @Autowired
    private GetDateTimeMapper getDateTimeMapper;

    public String getDateTime(){
        Date getDbSqlNowDate = getDateTimeMapper.getDateTime();
        String DBSqlDateForStr = DateTimeUtil.getTimeNormalStringByFormat(getDbSqlNowDate, DateTimeUtil.TIME_FORMAT_CHINA);
        return DBSqlDateForStr;
    }
}

