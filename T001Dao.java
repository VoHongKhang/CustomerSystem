/**
 * @(#)T001Dao.java 01-00 2021/07/16
 *
 * Copyright(C) 2021 by FUJINET CO., LTD.
 *
 * Last_Update 2021/07/16
 * Version 1.00.
 */
package fjs.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fjs.cs.common.DBConnect;
import fjs.cs.dto.UserDto;

/**
 * T001Dao
 * 
 * @version 1.00
 * @since 1.00
 * @author Long-PH,Huy-ndq-ttv
 * 
 */
public class T001Dao {

	// Khai bao bien ket noi
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * Ham kiem tra user co ton tai trong he thong
	 * 
	 * @param userId, password de kiem tra user co ton tai trong he thong
	 * @return User neu user do ton tai , neu khong return null
	 */
	public UserDto checkLogin(String userId, String password) {
		try {
			String query = "Select * from MSTUSER where DELETE_YMD IS null and USERID =? and PASSWORD= ? ";
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserDto user = new UserDto();
				user.setPSN_CD(rs.getInt("PSN_CD"));
				user.setUSERID(rs.getString(1));
				user.setPASSWORD(rs.getString(2));
				user.setUSERNAME(rs.getString("USERNAME"));
				return user;
			}
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return null;

	}
}
