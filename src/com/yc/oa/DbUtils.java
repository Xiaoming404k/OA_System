package com.yc.oa;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DbUtils {
    private static QueryRunner qr = new QueryRunner();

    public static Connection getConnection() {
        try {

            System.out.println('1');
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/oa", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int executeCUD(String sql) {
        int n = 0;
        Connection conn = getConnection();
        try {
            n = qr.update(conn, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n;
    }

    public static <T> List<T> executeR(String sql, Class<T> cls) {
        Connection conn = getConnection();
        try {
            return qr.query(conn, sql, new BeanListHandler<T>(cls));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(executeR("select * from employee", Employee.class));
    }

}
