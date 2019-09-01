package com.talentsprint.persistencetier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.talentsprint.businesstier.dto.Customer;
import com.talentsprint.utility.ConnectionPool;
import com.talentsprint.utility.MySQLConnection;

@Component
public class CustomerService implements ICustomer{
	/*DataSource dataSource=null;
	
	public CustomerService(){
		try {
			dataSource= (DataSource) ConnectionPool.getEnvironmentContext().lookup("jdbc/test");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}*/
	
	
	@Override
	public Customer getCustomer(int id) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sql="select * from customer where id=?";
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				Customer customer=new Customer();
				customer.setCustomerId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setBalance(resultSet.getDouble("balance"));
				return customer;
			}else{
				throw new Exception("Invalid Customer Id");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

	/*@Override
	public String newCustomer(Customer customer) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;		
		String sql="insert into customer(firstname,lastname,balance) values(?,?,?)";
		
		try{
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setDouble(3, customer.getBalance());
			int num=preparedStatement.executeUpdate();
			if(num>0){
				return "SUCCESS";
			}else{
				return "FAILED";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "FAILED";
	}*/

	@Override
	public List<Customer> getAllCustomers() {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String sql="select * from customer";
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			List<Customer> customerList=new ArrayList<>();
			
			while(resultSet.next()){
				Customer customer =new Customer();
				
				customer.setCustomerId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setBalance(resultSet.getDouble("balance"));
				
				customerList.add(customer);
			}
			return customerList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public String updateCustomer(Customer customer) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;		
		String sql="update customer set firstname=?,lastname=?,balance=? where id=?";
		
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setDouble(3, customer.getBalance());
			preparedStatement.setInt(4, customer.getCustomerId());
			int num=preparedStatement.executeUpdate();
			if(num>0){
				return "SUCCESS";
			}else{
				return "FAIL";
			}
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		catch(Exception e){
				e.printStackTrace();
		}
		finally{
				try {
					connection.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public String newCustomer(Customer customer) {
		Connection connection=null;
		CallableStatement callableStatement=null;
		String sql="{call newCustomer(?,?,?)}";
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			callableStatement=connection.prepareCall(sql);
			callableStatement.setString(1, customer.getFirstName());
			callableStatement.setString(2, customer.getLastName());
			callableStatement.setDouble(3, customer.getBalance());
			Boolean flag=callableStatement.execute();			
			System.out.println(flag);
			return "New Customer Record Saved";
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {					
				e.printStackTrace();
			}
		}
		return "FAIL";
		
	}


	@Override
	public String deleteCustomer(int id) {
		Connection connection=null;
		CallableStatement callableStatement=null;
		String sql="{call deleteCustomer(?)}";
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			callableStatement=connection.prepareCall(sql);
			callableStatement.setInt(1, id);
			callableStatement.execute();
			return "One Customer Record Deleted";
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "FAIL";
	}

}
