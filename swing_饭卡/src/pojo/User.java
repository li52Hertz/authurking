package pojo;

import java.sql.Date;
import java.sql.ResultSet;

public class User {
		private int card_id;
		private int student_id;
		private String student_name;
		private String curr_money;
		private	Date Register_date;
		
		public User(ResultSet rs) {
			try {
				card_id = rs.getInt("card_id");
				student_id = rs.getInt("student_id");
				student_name = rs.getString("studen_name");
				curr_money = rs.getString("curr_money");
				Register_date = rs.getDate("Register_date");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public int getCard_id() {
			return card_id;
		}

		public void setCard_id(int card_id) {
			this.card_id = card_id;
		}

		public int getStudent_id() {
			return student_id;
		}

		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}

		public String getStudent_name() {
			return student_name;
		}

		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}

		public String getCurr_money() {
			return curr_money;
		}

		public void setCurr_money(String curr_money) {
			this.curr_money = curr_money;
		}

		public Date getRegister_date() {
			return Register_date;
		}

		public void setRegister_date(Date register_date) {
			Register_date = register_date;
		}

		public User(int student_id, String student_name, String curr_money) {
			super();
			this.student_id = student_id;
			this.student_name = student_name;
			this.curr_money = curr_money;
		}

		
		
		
		
}
