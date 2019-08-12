package com.service.impl;

import com.dao.DoctorMapper;
import com.entity.Doctor;
import com.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

    @Resource(name = "doctorMapper")
    private DoctorMapper doctorMapper;
    public Doctor login(String userCode, String userPassword) {
        return doctorMapper.login(userCode,userPassword);
    }
}
