package com.vsr.PredefinedFunctionalInterfaces;

public class EmployeeSupplier {
public EmployeeSupplier(int empNo, String empName, String empPosition) {
		super();
		EmpNo = empNo;
		EmpName = empName;
		EmpPosition = empPosition;
	}

private int EmpNo;
private String EmpName;
private String EmpPosition;
public int getEmpNo() {
	return EmpNo;
}
public void setEmpNo(int empNo) {
	EmpNo = empNo;
}
public String getEmpName() {
	return EmpName;
}
public void setEmpName(String empName) {
	EmpName = empName;
}
public String getEmpPosition() {
	return EmpPosition;
}
public void setEmpPosition(String empPosition) {
	EmpPosition = empPosition;
}

@Override
public String toString() {
	return "EmployeeSupplier [EmpNo=" + EmpNo + ", EmpName=" + EmpName + ", EmpPosition=" + EmpPosition + "]";
}
}
