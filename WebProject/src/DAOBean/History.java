package DAOBean;

import java.sql.Date;

public class History {
	
	private int num;
	private int orderno;
	private String id;
	private int gno;
	private int qty;
	private Date reg_date;
	
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	
	public int getOrderno() {return orderno;}
	public void setOrderno(int orderno) {this.orderno = orderno;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public int getGno() {return gno;}
	public void setGno(int gno) {this.gno = gno;}
	
	public int getQty() {return qty;}
	public void setQty(int qty) {this.qty = qty;}
	
	public Date getReg_date() {return reg_date;}
	public void setReg_date(Date reg_date) {this.reg_date = reg_date;}
	
	
}