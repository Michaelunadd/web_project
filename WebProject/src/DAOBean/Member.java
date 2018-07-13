package DAOBean;

import java.sql.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private String gender;
	private int port;
	private String address1;
	private String address2;
	private String email;
	private String tel;
	private String grade;
	private Date reg_date;
	
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	public int getPort() {return port;}
	public void setPort(int port) {this.port = port;}
	
	public String getAddress1() {return address1;}	
	public void setAddress1(String address1) {this.address1 = address1;}
	
	public String getAddress2() {return address2;}
	public void setAddress2(String address2) {this.address2 = address2;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public String getTel() {return tel;}
	public void setTel(String tel) {this.tel = tel;}
	
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	
	public Date getReg_date() {return reg_date;}
	public void setReg_date(Date reg_date) {this.reg_date = reg_date;}
	
}