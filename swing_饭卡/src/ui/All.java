package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.UserDao;
import pojo.User;

public class All extends JFrame implements ActionListener{

	JTable jt;
	DefaultTableModel model;
	JTextField jt_student_id,jt_student_name,jt_curr_money;
	JButton jb_add;
	JScrollPane pane;
	JLabel l_title,l_add,l_student_id,l_student_name,l_curr_money;
	
	Font font = new Font("宋体",Font.BOLD,30);
	
	public All() {
		
		Vector date = (Vector)UserDao.checkAll();
		Vector<String> columnNames = new Vector<>();
		columnNames.add("饭卡编号");
		columnNames.add("学生学号");
		columnNames.add("学生姓名");
		columnNames.add("当前余额");
		columnNames.add("登记日期");
		//实例化组件
		l_title = new JLabel("饭卡列表");
		l_add = new JLabel("饭卡添加");
		l_student_id = new JLabel("学生学号：");
		l_student_name = new JLabel("学生姓名：");
		l_curr_money = new JLabel("充值金额：");
		jt_student_id = new JTextField();
		jt_student_name = new JTextField();
		jt_curr_money = new JTextField();
		model = new DefaultTableModel(date, columnNames);
		jt = new JTable(model);
		pane = new JScrollPane(jt);
		jb_add = new JButton("添加饭卡信息");
		
		//设置组件位置及大小
		l_title.setBounds(250, 60, 250, 60);
		l_add.setBounds(250, 300, 250, 60);
		pane.setBounds(100, 110, 500, 200);
		l_student_id.setBounds(100, 400, 250, 60);
		l_student_name.setBounds(100, 450, 250, 60);
		l_curr_money.setBounds(100, 500, 250, 60);
		jt_student_id.setBounds(280, 410, 250, 40);
		jt_student_name.setBounds(280, 460, 250, 40);
		jt_curr_money.setBounds(280, 510, 250, 40);
		jb_add.setBounds(230, 590, 250, 40);
		//设置组件字体大小
		l_title.setFont(font);
		l_add.setFont(font);
		l_student_id.setFont(font);
		l_student_name.setFont(font);
		l_curr_money.setFont(font);
		jb_add.setFont(font);
		//添加响应事件
		jb_add.addActionListener(this);
		//将组件添加到面板中
		add(l_title);
		add(l_add);
		add(pane);
		add(l_student_id);
		add(l_student_name);
		add(l_curr_money);
		add(jt_student_id);
		add(jt_student_name);
		add(jt_curr_money);
		add(jb_add);
		init();
	}
	
	
	private void init() {
		//设置布局模式(组件必须有位置及大小)
		setLayout(null);
		//设置标题
		setTitle("食堂饭卡管理系统");
		//设置宽高
		setSize(700, 700);
		//设置居中对齐
		setLocationRelativeTo(null);
		//设置关闭按钮操作
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//设置可见 -- 放在构造函数最后一行
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb_add) {
			add();
		}
	}
	
	public void add() {
		//获取数据
		String student_id = jt_student_id.getText();
		String student_name = jt_student_name.getText();
		String curr_money = jt_curr_money.getText();
		User users = new User(Integer.parseInt(student_id),student_name,curr_money);
		boolean b = UserDao.add(users);
		if(b) {
			//关闭当前窗体
			this.dispose();
			new All();
			JOptionPane.showMessageDialog(this, "添加成功");
			jt_student_id.setText("");
			jt_student_name.setText("");
			jt_curr_money.setText("");
		}else {
			//提示
			JOptionPane.showMessageDialog(this, "信息错误");
			jt_student_id.setText("");
			jt_student_name.setText("");
			jt_curr_money.setText("");
		}
	}
}
