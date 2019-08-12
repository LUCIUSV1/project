package com.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class User {
	private Integer id; //id
	@NotEmpty(message = "用户编码不能为空")
	private String userCode; //用户编码
	@NotEmpty(message = "用户名称不能为空")
	private String userName; //用户名称
	@NotEmpty(message = "用户密码不能为空")
	@Length(min =  6,max = 12,message = "密码长度必须为6-12位")
	private String userPassword; //用户密码
	private Integer gender;  //性别
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date birthday;  //出生日期
	@Pattern(regexp = "/^1[1,3,4,5,6,7,8]\\d{9}$/",message = "手机号码格式不正确")
	private String phone;   //电话
	private String address; //地址
	private Integer userRole;    //用户角色ID
	private Integer createdBy;   //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy;     //更新者
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date modifyDate;   //更新时间

	private Integer age;//年龄
	private String userRoleName; //用户角色名称
	private String idPicPath;//用户证件照路径

	public String getIdPicPath() {
		return idPicPath;
	}

	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}

	//association
	private Role role; //用户角色

	//collection
	private List<Address> addressList;//用户地址列表

	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getAge() {

		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}

	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userCode='" + userCode + '\'' +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", gender=" + gender +
				", birthday=" + birthday +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", userRole=" + userRole +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				", age=" + age +
				", role=" + role +
				", addressList=" + addressList +
				'}';
	}
	public User(){}
	public User(Integer id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
}
