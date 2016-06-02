package com.hb.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.hb.domain.User;
import com.hb.util.SqlHelper;

public class UserService {
	
	public User getUser(String username){
		
		String sqlString = "select * from users where name=?";
		String[] para = {username};
		
		ResultSet rs = SqlHelper.executeQuery(sqlString, para);
		ArrayList al = getUserList();
		
		User user = new User();
		
		user.setName(username);
		user.setGoalfilename(((User)(al.get(0))).getGoalfilename());
		user.setSourcefilename(((User)(al.get(0))).getSourcefilename());
		
		return user;
		
	}
	

	public  boolean saveRegisterUsers(User user){
		
		String sqlString = "insert into users values(?,?,?)";
		
		String[] para = {user.getName(),user.getGoalfilename(),user.getSourcefilename()};
		
		try {
			SqlHelper.executeUpdate(sqlString, para);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public ArrayList getUserList(){
		
		String sql = "select * from users";
		
		try {
			ArrayList aList = SqlHelper.convertList(SqlHelper.executeQuery(sql, null));
			ArrayList<User> aList2 = new ArrayList<User>();
			
			for(int i = 0;i<aList.size();i++){
				User user = new User();
				
				user.setName(((Map)(aList.get(i))).get("name").toString());
				user.setGoalfilename(((Map)(aList.get(i))).get("goalfilename").toString());
				user.setSourcefilename(((Map)(aList.get(i))).get("sourcefilename").toString());
				aList2.add(user);
				
			}
			return aList2;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}
