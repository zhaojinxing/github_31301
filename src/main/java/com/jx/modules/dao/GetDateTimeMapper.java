package com.jx.modules.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface GetDateTimeMapper {
    /**
     * 获取系统数据库时间
     * @return
     */
    Date getDateTime();
}
