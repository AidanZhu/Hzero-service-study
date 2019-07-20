package com.hzero.demo.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "himp_import_demo")
public class ImportDemo extends AuditDomain {

    public static final String FIELD_USERNAME = "username";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_SEX = "sex";
    public static final String FIELD_EMPLOYEE_NUMBER = "employeeNumber";
    public static final String FIELD_BORN_DATE = "bornDate";

    @ApiModelProperty("用户名")
    @Id
    @GeneratedValue
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    @NotBlank
    private String password;
   @ApiModelProperty(value = "性别")    
    private String sex;
   @ApiModelProperty(value = "工号")    
    private Long employeeNumber;
   @ApiModelProperty(value = "出生日期")    
    private Date bornDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

}
