package paging;

import java.util.Date;

public class EMPModel {

	private int empno1;
	private String empname1;
	private String job;
	private Date hiredate1;
	private double salary;
	private double bound;
	
	public EMPModel(){
		
	}

	public int getEmpno1() {
		return empno1;
	}

	public void setEmpno1(int empno1) {
		this.empno1 = empno1;
	}

	public String getEmpname1() {
		return empname1;
	}

	public void setEmpname1(String empname1) {
		this.empname1 = empname1;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate1() {
		return hiredate1;
	}

	public void setHiredate1(Date hiredate1) {
		this.hiredate1 = hiredate1;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBound() {
		return bound;
	}

	public void setBound(double bound) {
		this.bound = bound;
	}
	
}
