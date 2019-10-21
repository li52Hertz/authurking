package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import pojo.User;
import util.DBUtil;

public class UserDao {
		public static User login(String username,String password) {
			User user = null;
			String sql = "select * from user where username=? and password=?";
			try {
				ResultSet rs = DBUtil.query(sql, username,password);
				if(rs.next()) {
					user = new User(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close();
			}
			return user;
		}
		
		public static boolean checkByUsername(String username) {
			try {
				String sql = "select * from user where username=?";
				ResultSet rs = DBUtil.query(sql, username);
				if(rs.next()) return true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close();
			}
			return false;
		}
		
//		public static boolean register(User user) {
//				String sql = "insert into user values(null,?,?)";
//				return DBUtil.update(sql, user.getUsername(),user.getPassword());
//		}
		
		public static List checkAll() {
			List<Vector> arr_date = new Vector<>();
			try {
				String sql = "select * from t_card";
				ResultSet rs = DBUtil.query(sql);
				while(rs.next()) {
					Vector arr = new Vector();
					arr.add(rs.getInt("card_id"));
					arr.add(rs.getInt("student_id"));
					arr.add(rs.getString("student_name"));
					arr.add(rs.getString("curr_money"));
					arr.add(rs.getDate("Register_date"));
					arr_date.add(arr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close();
			}
			return arr_date;
		}
		
		public static boolean deleteById(int id) {
			String sql = "delete from user where id=?";
			return DBUtil.update(sql, id);
		}
		
		public static User checkById(int id) {
			User user = null;
				try {
					String sql = "select * from user where id=?";
					ResultSet rs = DBUtil.query(sql, id);
					if(rs.next()) 
						user = new User(rs);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBUtil.close();
				}
				return user;
		}
		
//		public static boolean update(User user) {
//			String sql = "update user set username=?,password=? where id=?";
//			return DBUtil.update(sql, user.getUsername(),user.,user.getId());
//		}
		
		public static boolean add(User user) {
			String sql = "insert into T_card(Student_id,Student_name,Curr_money) values(?,?,?)";
			return DBUtil.update(sql, user.getStudent_id(),user.getStudent_name(),user.getCurr_money());
		}
}
