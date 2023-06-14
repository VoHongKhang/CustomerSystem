package fjs.cs.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class T002Customer implements Serializable{

	// Declare user variables
	private int customerId;
	private String customerName;
	private String sex;
	private String birthday;
	private String email;
	private String address;
	private Date delete_ymd;
	private Date insert_ymd;
	private int insert_psn_cd;
	private Date update_ymd;
	private int update_psn_cd;
	


	public T002Customer() {
		super();
	}



	public T002Customer(int customerId, String customerName, String sex, String birthday, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDelete_ymd() {
		return delete_ymd;
	}

	public void setDelete_ymd(Date delete_ymd) {
		this.delete_ymd = delete_ymd;
	}

	public Date getInsert_ymd() {
		return insert_ymd;
	}

	public void setInsert_ymd(Date insert_ymd) {
		this.insert_ymd = insert_ymd;
	}

	public int getInsert_psn_cd() {
		return insert_psn_cd;
	}

	public void setInsert_psn_cd(int insert_psn_cd) {
		this.insert_psn_cd = insert_psn_cd;
	}

	public Date getUpdate_ymd() {
		return update_ymd;
	}

	public void setUpdate_ymd(Date update_ymd) {
		this.update_ymd = update_ymd;
	}

	public int getUpdate_psn_cd() {
		return update_psn_cd;
	}

	public void setUpdate_psn_cd(int update_psn_cd) {
		this.update_psn_cd = update_psn_cd;
	}
	
	
}