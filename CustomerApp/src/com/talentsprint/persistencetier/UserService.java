package com.talentsprint.persistencetier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.talentsprint.utility.MySQLConnection;
@Component
public class UserService implements IUser{
	/*private DataSource dataSource=null;
	
	public UserService(){
		try {
			dataSource= (DataSource) ConnectionPool.getEnvironmentContext().lookup("jdbc/test");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}*/

	@Override
	public Boolean getUser(String username, String password) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sql="select * from users where username=? and password=?";
		try{
			//connection=dataSource.getConnection();
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}else{
				return false;
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
		
		return false;
	}

}
