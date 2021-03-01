package com.hiep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoHelper {
    private static final String jdbcURL;
    private static final String jdbcUsername;
    private static final String jdbcPassword;
    protected Connection connec;

    static {
        jdbcURL = "jdbc:mysql://localhost:3306/casestudy_hoahauvietnam?useEncoding=true&characterEncoding=UTF-8";
        jdbcUsername = "root";
        jdbcPassword = "123456";
    }

    protected void connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connec = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void disconnection() throws SQLException {
        if (connec != null && !connec.isClosed()){
            connec.close();
        }
    }

}
