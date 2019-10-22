package com.dzkj.pojo;

public class User {
		private String u_name;
		private String password;
		public String getU_name() {
			return u_name;
		}
		public void setU_name(String u_name) {
			this.u_name = u_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public User(String u_name, String password) {
			super();
			this.u_name = u_name;
			this.password = password;
		}
		
}
