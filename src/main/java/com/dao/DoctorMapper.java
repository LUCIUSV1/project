package com.dao;

import com.entity.Doctor;


import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    //登录方法
    public Doctor login(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
}
