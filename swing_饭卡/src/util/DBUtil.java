package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
		private static final String Driver = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
		private static final String username = "root";
		private static final String password = "";
		
		
		private static Connection conn = null;
		private static PreparedStatement ps = null;
		private static ResultSet rs = null;
		static {
			try {
				Class.forName(Driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void getConn() {
			try {
				conn = DriverManager.getConnection(URL, username, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void close() {
			try {
				if(conn!=null) conn.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static boolean update(String sql,Object...args) {
			try {
				getConn();
				ps = conn.prepareStatement(sql);
				for(int i=0;i<args.length;i++) {
					ps.setObject((i+1), args[i]);
				}
				int count = ps.executeUpdate();
				if(count>0) return true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return false;
		}
		
		public static ResultSet query(String sql,Object... args) {
			try {
				getConn();
				ps= conn.prepareStatement(sql);
				for(int i=0;i<args.length;i++) {
					ps.setObject((i+1), args[i]);
				}
				rs = ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rs;
		}
}
