 package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException,SQLException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice,option;
		
		Login login=new Login();
		LoginDAO logindao=new LoginDAO();
		Product product=new Product();
		ProductDAO productdao=new ProductDAO();
		
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("________________________");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1:
				System.out.println("________________________");
				System.out.println("Enter the Username");
				String username=br.readLine();
				System.out.println("Enter the password");
				String password=br.readLine();
				login.setUsername(username);
				login.setPassword(password);
				if(logindao.validate(login))
				{
					System.out.println("_____________________");
					System.out.println("Login successfull");
					do
					{
						System.out.println("________________________");
						System.out.println("1.Add");
						System.out.println("2.Display");
						System.out.println("3.logout");
						 option=Integer.parseInt(br.readLine());
						 switch(option)
						 {
						 case 1:
							 System.out.println("________________________");
							 System.out.println("Enter the productId");
							 int productId=Integer.parseInt(br.readLine());
							 System.out.println("Enter the productname");
							 String productname=br.readLine();
							 System.out.println("Enter the minSellQuantity");
							 int minSellQuantity=Integer.parseInt(br.readLine());
							 System.out.println("Enter the price");
							 int price=Integer.parseInt(br.readLine());
							 System.out.println("Enter the quantity");
							 int quantity=Integer.parseInt(br.readLine());
							 product.setProductId(productId);
							 product.setProductName(productname);
							 product.setMinSellQuantity(minSellQuantity);
							 product.setPrice(price);
							 product.setQuantity(quantity);
							 productdao.addProduct(product);
							 break;
						 
						 case 2:productdao.display();
						 break;
						 case 3:
							 break;
						 }
				    }while(option!=3);
				}
				    else
				    {
				    	System.out.println("Incorrect Username and password");
				    }
				break;
			case 2:
				System.out.println("Enter the username");
				String name=br.readLine();
				System.out.println("Enetr the password");
				String pass=br.readLine();
				login.setUsername(name);
				login.setPassword(pass);
				if(logindao.validate(login))
				{
					System.out.println("_____________________");
					System.out.println("Login successfull");
				    do
				    {
				    	System.out.println("1.Flow Inventory");
				
				    	System.out.println("2.Logout");
				    	option=Integer.parseInt(br.readLine());
				    	switch(option)
				    	{
				    	case 1:
				    		productdao.display();
				    		break;
				    	case 2:
				    		break;
				    	}
				    }while(option!=2);
				
				}
			}
		}while(choice!=3);
	}
}