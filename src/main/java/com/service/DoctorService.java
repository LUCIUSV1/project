package com.service;

import com.entity.Doctor;


public interface DoctorService {
    Doctor login(String userCode, String userPassword);
}
