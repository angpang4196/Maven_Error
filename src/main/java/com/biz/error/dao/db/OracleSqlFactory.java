package com.biz.error.dao.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.error.dao.ErrorDao;

public class OracleSqlFactory {

	SqlSessionFactory sessionFactory;

	public SqlSessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public OracleSqlFactory() {
		Properties props = new Properties();

		props.put("DRIVER", DBContract.ORACLE_PRO.Driver);
		props.put("URL", DBContract.ORACLE_PRO.url);
		props.put("USER", DBContract.ORACLE_PRO.user);
		props.put("PASSWORD", DBContract.ORACLE_PRO.password);

		DataSourceFactory dataSourceFactory = new ErrorDataSourceFactory();

		dataSourceFactory.setProperties(props);

		DataSource dataSource = dataSourceFactory.getDataSource();

		TransactionFactory transactionFactory = new JdbcTransactionFactory();

		Environment environment = new Environment("ErrorENV", transactionFactory, dataSource);

		Configuration config = new Configuration(environment);

		config.addMapper(ErrorDao.class);

		this.sessionFactory = new SqlSessionFactoryBuilder().build(config);

	}

}
