package com.service.impl;

import com.dao.PatientMapper;
import com.entity.Patient;
import com.service.PatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Resource(name = "patientMapper")
    private PatientMapper patientMapper;
    public List<Patient> getPatList(@Param("patientId") String patientId, Integer begin, Integer pageSize) {
        begin = (begin-1)*pageSize;
        return patientMapper.getPatList(patientId,begin,pageSize);
    }

    public int getPatientCount(@Param("patientId")String patientId) {
        return patientMapper.getPatientCount(patientId);
    }
}
