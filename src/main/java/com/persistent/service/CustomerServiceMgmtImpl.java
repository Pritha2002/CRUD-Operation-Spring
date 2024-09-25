package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.bo.CustomerBO;
import com.persistent.dao.ICustomerDAO;
import com.persistent.dto.CustomerDTO;

@Service("custService")
public class CustomerServiceMgmtImpl implements ICustomerMgmtService{

	@Autowired
	private ICustomerDAO dao;
	
	CustomerBO bo=new CustomerBO();
	
	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {	
		
		double intrAmt=dto.getpAmt()*dto.getRoi()*dto.getTime()/100.0;
		bo.setcName(dto.getcName());
		bo.setcAddr(dto.getcAddr());
		bo.setpAmt(dto.getpAmt());
		bo.setIntrAmt(intrAmt);
		
		int count=dao.insert(bo);
		if(count==0)
		{
			return "Customer Registration Failed ";
		}
		else
		{
			return "Customer Registration Success";
		}
		
	}

	@Override
	public void selectCust(CustomerDTO dto) throws Exception {
		
		bo.setcName(dto.getcName());
		dao.select(bo);
	}

	@Override
	public String deleteCust(CustomerDTO dto) throws Exception {
		bo.setcName(dto.getcName());
		int res=dao.delete(bo);
		
		if(res==0)
		{
			return "Customer Record Not Found : Failed";
		}
		else 
		{
			return "Customer Record Deleted   :Success";
		}
	}

	@Override
	public String updateCust(CustomerDTO dto) throws Exception {
		
		bo.setcName(dto.getcName());
		bo.setNewName(dto.getNewName());
		
		int res=dao.updateByName(bo);
		if(res==0)
		{
			return "Customer Record Not Updated : Failed";
		}
		else 
		{
			return "Customer Record Updated : Success";
		}
	}

	@Override
	public String updateCust1(CustomerDTO dto) throws Exception {
		bo.setcAddr(dto.getcAddr());
		bo.setNewAddr(dto.getNewAddr());
		
		int res=dao.updateByAddr(bo);
		if(res==0)
		{
			return "Customer Record Not Updated : Failed";
		}
		else
		{
			return "Customer Record Updated : Success";
		}
		
	}
	
	

}
