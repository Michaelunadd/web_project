package DAOBean;

import java.sql.Date;

public class SC {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private int readcount;
	private int ref;
	private String passwd;
	private Date reg_date;
	
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	
	public String getWriter() {return writer;}
	public void setWriter(String writer) {this.writer = writer;}
	
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public int getReadcount() {return readcount;}
	public void setReadcount(int readcount) {this.readcount = readcount;}
	
	public String getPasswd() {return passwd;}
	public void setPasswd(String passwd) {this.passwd = passwd;}
	
	public Date getReg_date() {return reg_date;}
	public void setReg_date(Date reg_date) {this.reg_date = reg_date;}
	
	public int getRef() {return ref;}
	public void setRef(int ref) {this.ref = ref;}
	
	
	
	

}