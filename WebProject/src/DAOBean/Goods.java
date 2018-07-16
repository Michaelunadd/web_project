package DAOBean;

import java.sql.Blob;
import java.sql.Date;

public class Goods {
	private int num;
	private String name;
	private String group1;
	private String group2;
	private String group3;
	private int cost;
	private Date reg_date;
	private int qty;
	private int readcount;
	private Blob thumb;
	private Blob jpg;
	private String text;
	
	
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getGroup1() {return group1;}
	public void setGroup1(String group1) {this.group1 = group1;}
	
	public String getGroup2() {return group2;}
	public void setGroup2(String group2) {this.group2 = group2;}
	
	public String getGroup3() {return group3;}
	public void setGroup3(String group3) {this.group3 = group3;}
	
	public int getCost() {return cost;}
	public void setCost(int cost) {this.cost = cost;}
	
	public Date getReg_date() {return reg_date;}
	public void setReg_date(Date reg_date) {this.reg_date = reg_date;}
	
	public int getQty() {return qty;}
	public void setQty(int qty) {this.qty = qty;}
	
	public int getReadcount() {return readcount;}
	public void setReadcount(int readcount) {this.readcount = readcount;}
	
	public Blob getThumb() {return thumb;}
	public void setThumb(Blob thumb) {this.thumb = thumb;}
	
	public Blob getJpg() {return jpg;}
	public void setJpg(Blob jpg) {this.jpg = jpg;}
	
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
	
	
	
}