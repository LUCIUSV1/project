package com.dao;

import com.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    //得到列表
    public List<Patient> getPatList(@Param("patientId")String patientId,@Param("begin")Integer begin, @Param("pageSize")Integer pageSize);
    //得到数量
    public int getPatientCount(@Param("patientId")String patientId);

}
