package com.persistent.dao;

import com.persistent.bo.CustomerBO;

public interface ICustomerDAO {
	public int insert(CustomerBO bo) throws Exception;
	public void select(CustomerBO bo) throws Exception;
	public int delete(CustomerBO bo) throws Exception;
	public int updateByName(CustomerBO bo) throws Exception;
	public int updateByAddr(CustomerBO bo) throws Exception;
}
