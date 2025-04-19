package com.hexaware.tms.main;
import com.hexaware.tms.util.DbUtil;
import java.sql.Connection;


public class TestDb {
    public static void main(String[] args) {
        try {
            Connection conn = DbUtil.getDBConnection();
            if (conn != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
