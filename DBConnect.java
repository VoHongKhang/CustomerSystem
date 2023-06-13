/**
 * @(#)DBConnect.java 01-00 2023/06/12
 *
 * 
 * Version 1.00.
 */
package fjs.cs.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBConnect
 * 
 * @version 1.00
 * @author Huy-ndq-ttv
 * 
 */
public class DBConnect {

	/**
	 * getConnection
	 * 
	 * @return Chuoi ket noi
	 * 
	 * @throws Exception
	 * 
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;

			if (instance == null || instance.trim().isEmpty()) {
				url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;
			}

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

	// Khai bao bien ket noi
	private final String serverName = "localhost";
	private final String dbName = "CustomerSystem";
	// private final String portNumber = "1433";
	private final String instance = "";
	private final String userName = "sa";
	private final String password = "Abc@12345";

}
