package com.persistent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.persistent.bo.CustomerBO;

@Repository("oracleBean")
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	private DataSource ds;
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Override
	public int insert(CustomerBO bo) throws Exception {

		int count=0;
		try {
			con=ds.getConnection();
			if(con!=null)
			{
				pst=con.prepareStatement("insert into RealTimeDI_CUSTOMER values(CUST_NO_SEQ.NEXTVAL,?,?,?,?)");
			}
			
			if(pst!=null)
			{
				pst.setString(1,bo.getcName());
				pst.setString(2,bo.getcAddr());
				pst.setDouble(3,bo.getpAmt());
				pst.setDouble(4,bo.getIntrAmt());
				
				count=pst.executeUpdate();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		return count;
	}


	@Override
	public void select(CustomerBO bo) throws Exception {
		
		try {
			con=ds.getConnection();
			if(con!=null) {
				pst=con.prepareStatement("select * from RealTimeDI_CUSTOMER where cname=?");
			}
			
			if(pst!=null)
			{
				pst.setString(1,bo.getcName());
				rs=pst.executeQuery();
			}
			
			if(rs!=null)
			{
				boolean flag=false;
				while(rs.next())
				{
					flag=true;
					System.out.println(rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDouble(4)+"  "+rs.getDouble(5));
				}
				if(flag==false)
				{
					System.out.println("No Records Found !!");
				}
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int delete(CustomerBO bo) throws Exception {
		int count=0;
		try {
			con=ds.getConnection();
			
			if(con!=null)
			{
				pst=con.prepareStatement("delete from RealTimeDI_CUSTOMER where cname=?");
			}
			if(pst!=null)
			{
				pst.setString(1,bo.getcName());
				count=pst.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public int updateByName(CustomerBO bo) throws Exception {
		int count=0;
		try {
			con=ds.getConnection();
			
			if(con!=null)
			{
				pst=con.prepareStatement("update RealTimeDI_CUSTOMER set cname=? where cname=?");
			}
			
			if(pst!=null)
			{
				pst.setString(1,bo.getNewName());
				pst.setString(2,bo.getcName());
				count=pst.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}


	@Override
	public int updateByAddr(CustomerBO bo) throws Exception {
		int count=0;
		try {
			con=ds.getConnection();
			
			if(con!=null)
			{
				pst=con.prepareStatement("update RealTimeDI_CUSTOMER set caddr=? where caddr=?");
				
			}
			if(pst!=null)
			{
				pst.setString(1,bo.getNewAddr());
				pst.setString(2,bo.getcAddr());
				count=pst.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
