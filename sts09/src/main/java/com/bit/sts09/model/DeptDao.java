package com.bit.sts09.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bit.sts09.model.entity.DeptVo;

@Mapper
public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> findAll();
	
	
	DeptVo findOne(int key);
	
	@Insert("insert into dept values (#{deptno},#{dname},#{loc})")
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int key);
}
