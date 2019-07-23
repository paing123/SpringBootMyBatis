package com.paing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.paing.model.Admin;

@Mapper
public interface AdminMapper {
	public void save(@Param("admin") Admin admin);
	
	public List<Admin> findAdmin(@Param("admin") Admin admin);
	
	public void update(@Param("admin") Admin admin);
	
	public void delete(@Param("id") Integer id);
}
