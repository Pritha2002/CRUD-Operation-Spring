package com.persistent.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.persistent.controller.MainController;
import com.persistent.vo.CustomerVO;

public class RealTimeDI {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String cName=null;
		String cAddr=null;
		String pAmt=null;
		String roi=null;
		String time=null;
		String newName=null;
		String newAddr=null;
		
		CustomerVO cvo=new CustomerVO();
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationConfig.xml");
		MainController controller=context.getBean("controller",MainController.class);
		int i=1;
		while(i==1)
		{
			System.out.println("<============== 1.ADD CUSTOMER ==============>");
			System.out.println("<============== 2.SELECT CUSTOMER ==============>");
			System.out.println("<============== 3.UPDATE CUSTOMER ==============>");
			System.out.println("<============== 4.DELETE CUSTOMER ==============>");
			System.out.println("<============== 5.EXIT ==============>\n\n");
			System.out.println("Enter Your Choice :: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the Name of Customer :: ");
				cName=sc.next();
				sc.nextLine();
				System.out.println("Enter the Address of Customer :: ");
				cAddr=sc.next();
				System.out.println("Enter the Principle Amount :: ");
				pAmt=sc.next();
				System.out.println("Enter the Rate of Interest :: ");
				roi=sc.next();
				System.out.println("Enter the Time :: ");
				time=sc.next();
				
				cvo.setcName(cName);
				cvo.setcAddr(cAddr);
				cvo.setpAmt(pAmt);
				cvo.setRoi(roi);
				cvo.setTime(time);
				
				try {
					String msg=controller.processCustomer(cvo);
					System.out.println("Result is :: "+msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter the Name of Customer :: ");
				cName=sc.next();
				
				cvo.setcName(cName);
				try {
					controller.selectCustomer(cvo);
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("1.UPDATE NAME");
				System.out.println("2.UPDATE ADDRESS");
				
				System.out.println("Enter Your Choice :: ");
				choice=sc.nextInt();
				
				if(choice==1)
				{
					System.out.println("Enter the Old Name of Customer :: ");
					cName=sc.next();
					System.out.println("Enter the New Name of Customer:: ");
					newName=sc.next();
					
					cvo.setcName(cName);
					cvo.setNewName(newName);
					
					try {
						String msg=controller.updateCustomer1(cvo);
						System.out.println(msg);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(choice==2)
				{
					System.out.println("Enter the Old Address :: ");
					cAddr=sc.next();
					System.out.println("Enter the New Address :: ");
					newAddr=sc.next();
					cvo.setcAddr(cAddr);
					cvo.setNewAddr(newAddr);
					
					try {
						String msg=controller.updateCustomer2(cvo);
						System.out.println(msg);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Wrong Choice ");
				}
				
				break;
			case 4:
				System.out.println("Enter the Name of Customer :: ");
				cName=sc.next();
				cvo.setcName(cName);
				
				try {
					String msg=controller.deleteCustomer(cvo);
					System.out.println(msg);
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Thank You....");
				i=0;
				break;
			default:
				System.out.println("Wrong Choice !!");
			}
		}

	}

}
