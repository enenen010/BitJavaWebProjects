package com.bit.sts09.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.cj.jdbc.Driver;

@Configuration
@MapperScan("com.bit.sts09.model")
public class RootConfig {

	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl("jdbc:mysql://192.168.99.103:3306/lecture");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(getDataSource());
//		Resource[] resources= {new ClassPathResource("/mapper/dept-mapper.xml")};
//		sqlSessionFactory.setConfigLocation(resource);
//		sqlSessionFactory.setMapperLocations(resources);
		return sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSession getSqlSession() throws Exception {
		return new SqlSessionTemplate(getSqlSessionFactory());
	}
	

}













