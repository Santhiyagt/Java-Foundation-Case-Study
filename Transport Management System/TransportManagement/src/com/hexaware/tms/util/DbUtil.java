package com.hexaware.tms.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
 * @Authors: Priya, Santhiya
 * Date: 14-Apr-2025
 * desc: connecting with database
 */

public class DbUtil {

	public static Connection getDBConnection() throws SQLException {

		FileReader fr = null;
		Properties prop = null;
		try {
			fr = new FileReader("src/db.properties");

			prop = new Properties();

			prop.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = prop.getProperty("url");

		String username = prop.getProperty("username");

		String password = prop.getProperty("password");

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;

	}

}
