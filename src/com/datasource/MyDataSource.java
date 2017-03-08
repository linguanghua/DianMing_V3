package com.datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by LinXu on 2017/3/1.
 */
public class MyDataSource extends BasicDataSource {
    @Override
    public synchronized void close() throws SQLException {
        DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306/hibernate"));
        super.close();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
