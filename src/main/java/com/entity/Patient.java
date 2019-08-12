package com.entity;

import java.sql.Date;

public class Patient {
    private String name;
    private String sex;
    private Date birthday;
    private String age;
    private String patientId;
    private String InpatientCode;
    private String VisitNo;
    private String height;
    private String weight;
    private String Marry;
    private String dept;//申请科室
    private String address;
    private String phone;
    private Date date;
    private String doctor;
    private String dept_Code;//申请科室代码
    private String dept_Name;//申请科室名称
    private String barCode;
    private String examCode;
    private String item_Code;//医嘱（检查）项目代码
    private String item_Name;//医嘱项目名称
    private String price;
    private String exec_dept_Code;
    private String exec_dept_Name;
    private String diag;
    private String ChargeFlag;
    private String patientSource;
    private String bedNo;
    private String zone;
    private String orderStatus;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getInpatientCode() {
        return InpatientCode;
    }
    public void setInpatientCode(String inpatientCode) {
        InpatientCode = inpatientCode;
    }
    public String getVisitNo() {
        return VisitNo;
    }
    public void setVisitNo(String visitNo) {
        VisitNo = visitNo;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getMarry() {
        return Marry;
    }
    public void setMarry(String marry) {
        Marry = marry;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getDept_Code() {
        return dept_Code;
    }
    public void setDept_Code(String dept_Code) {
        this.dept_Code = dept_Code;
    }
    public String getDept_Name() {
        return dept_Name;
    }
    public void setDept_Name(String dept_Name) {
        this.dept_Name = dept_Name;
    }
    public String getBarCode() {
        return barCode;
    }
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public String getExamCode() {
        return examCode;
    }
    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }
    public String getItem_Code() {
        return item_Code;
    }
    public void setItem_Code(String item_Code) {
        this.item_Code = item_Code;
    }
    public String getItem_Name() {
        return item_Name;
    }
    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getExec_dept_Code() {
        return exec_dept_Code;
    }
    public void setExec_dept_Code(String exec_dept_Code) {
        this.exec_dept_Code = exec_dept_Code;
    }
    public String getExec_dept_Name() {
        return exec_dept_Name;
    }
    public void setExec_dept_Name(String exec_dept_Name) {
        this.exec_dept_Name = exec_dept_Name;
    }
    public String getDiag() {
        return diag;
    }
    public void setDiag(String diag) {
        this.diag = diag;
    }
    public String getChargeFlag() {
        return ChargeFlag;
    }
    public void setChargeFlag(String chargeFlag) {
        ChargeFlag = chargeFlag;
    }
    public String getPatientSource() {
        return patientSource;
    }
    public void setPatientSource(String patientSource) {
        this.patientSource = patientSource;
    }
    public String getBedNo() {
        return bedNo;
    }
    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }
    public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public String toString() {
        return "Patient [name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", age=" + age + ", patientId="
                + patientId + ", InpatientCode=" + InpatientCode + ", VisitNo=" + VisitNo + ", height=" + height
                + ", weight=" + weight + ", Marry=" + Marry + ", dept=" + dept + ", address=" + address + ", phone="
                + phone + ", date=" + date + ", doctor=" + doctor + ", dept_Code=" + dept_Code + ", dept_Name="
                + dept_Name + ", barCode=" + barCode + ", examCode=" + examCode + ", item_Code=" + item_Code
                + ", item_Name=" + item_Name + ", price=" + price + ", exec_dept_Code=" + exec_dept_Code
                + ", exec_dept_Name=" + exec_dept_Name + ", diag=" + diag + ", ChargeFlag=" + ChargeFlag
                + ", patientSource=" + patientSource + ", bedNo=" + bedNo + ", zone=" + zone + ", orderStatus="
                + orderStatus + "]";
    }

}
