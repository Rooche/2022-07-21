package com.company.mvc.emp;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpReqVO {
	private String employeeId;
	private String jobId;
	private String[] depts;
	private Date sdt;
	private Date edt;
}
