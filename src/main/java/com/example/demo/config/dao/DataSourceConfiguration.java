package com.example.demo.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接配置
 *
 */
@Configuration
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration {
	@Value("${jdbc.driver}")
private String driverClass;
	@Value("${jdbc.url}")
private String jdbcUrl;
	@Value("${jdbc.username}")
private String user;
	@Value("${jdbc.password}")
private String password;

@Bean(name="dataSource")
public ComboPooledDataSource CreateDataSource() throws PropertyVetoException{
	ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
	comboPooledDataSource.setDriverClass(driverClass);
	comboPooledDataSource.setJdbcUrl(jdbcUrl);
	comboPooledDataSource.setUser(user);
	comboPooledDataSource.setPassword(password);
	//连接池关闭时不自动提交
	comboPooledDataSource.setAutoCommitOnClose(false);
	return comboPooledDataSource;
}
}
