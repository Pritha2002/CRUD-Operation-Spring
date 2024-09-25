package com.persistent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.persistent.dto.CustomerDTO;
import com.persistent.service.ICustomerMgmtService;
import com.persistent.vo.CustomerVO;

@Controller("controller")
public class MainController {
	
	@Autowired
	private ICustomerMgmtService service;
	
	CustomerDTO dto=new CustomerDTO();
	String resultMsg=null;
	
	
	public String processCustomer(CustomerVO vo) throws Exception
	{
		dto.setcName(vo.getcName());
		dto.setcAddr(vo.getcAddr());
		dto.setpAmt(Double.parseDouble(vo.getpAmt()));
		dto.setRoi(Double.parseDouble(vo.getRoi()));
		dto.setTime(Double.parseDouble(vo.getTime()));
		
		
		//dto.setIntrAmt(Double.parseDouble(vo.getIntrAmt()));
		
		resultMsg=service.registerCustomer(dto);
		return resultMsg;
		
		
	}
	public void selectCustomer(CustomerVO vo) throws Exception
	{
		dto.setcName(vo.getcName());
		service.selectCust(dto);
	}
	
	public String deleteCustomer(CustomerVO vo) throws Exception
	{
		dto.setcName(vo.getcName());
		resultMsg=service.deleteCust(dto);
		return resultMsg;
	}
	
	public String updateCustomer1(CustomerVO vo) throws Exception 
	{
			dto.setcName(vo.getcName());
			dto.setNewName(vo.getNewName());
			resultMsg=service.updateCust(dto);
			return resultMsg;
	}
	
	public String updateCustomer2(CustomerVO vo) throws Exception
	{
		dto.setcAddr(vo.getcAddr());
		dto.setNewAddr(vo.getNewAddr());
		resultMsg=service.updateCust1(dto);
		return resultMsg;
	}
}
