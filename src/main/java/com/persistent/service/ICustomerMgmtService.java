package com.persistent.service;

import com.persistent.dto.CustomerDTO;

public interface ICustomerMgmtService {
	public String registerCustomer(CustomerDTO dto) throws Exception;
	public void selectCust(CustomerDTO dto) throws Exception;
	public String deleteCust(CustomerDTO dto) throws Exception;
	public String updateCust(CustomerDTO dto) throws Exception;
	public String updateCust1(CustomerDTO dto) throws Exception;
}
