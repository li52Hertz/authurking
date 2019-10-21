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
	
	Font font = new Font("����",Font.BOLD,30);
	
	public All() {
		
		Vector date = (Vector)UserDao.checkAll();
		Vector<String> columnNames = new Vector<>();
		columnNames.add("�������");
		columnNames.add("ѧ��ѧ��");
		columnNames.add("ѧ������");
		columnNames.add("��ǰ���");
		columnNames.add("�Ǽ�����");
		//ʵ�������
		l_title = new JLabel("�����б�");
		l_add = new JLabel("�������");
		l_student_id = new JLabel("ѧ��ѧ�ţ�");
		l_student_name = new JLabel("ѧ��������");
		l_curr_money = new JLabel("��ֵ��");
		jt_student_id = new JTextField();
		jt_student_name = new JTextField();
		jt_curr_money = new JTextField();
		model = new DefaultTableModel(date, columnNames);
		jt = new JTable(model);
		pane = new JScrollPane(jt);
		jb_add = new JButton("��ӷ�����Ϣ");
		
		//�������λ�ü���С
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
		//������������С
		l_title.setFont(font);
		l_add.setFont(font);
		l_student_id.setFont(font);
		l_student_name.setFont(font);
		l_curr_money.setFont(font);
		jb_add.setFont(font);
		//�����Ӧ�¼�
		jb_add.addActionListener(this);
		//�������ӵ������
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
		//���ò���ģʽ(���������λ�ü���С)
		setLayout(null);
		//���ñ���
		setTitle("ʳ�÷�������ϵͳ");
		//���ÿ��
		setSize(700, 700);
		//���þ��ж���
		setLocationRelativeTo(null);
		//���ùرհ�ť����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//���ÿɼ� -- ���ڹ��캯�����һ��
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb_add) {
			add();
		}
	}
	
	public void add() {
		//��ȡ����
		String student_id = jt_student_id.getText();
		String student_name = jt_student_name.getText();
		String curr_money = jt_curr_money.getText();
		User users = new User(Integer.parseInt(student_id),student_name,curr_money);
		boolean b = UserDao.add(users);
		if(b) {
			//�رյ�ǰ����
			this.dispose();
			new All();
			JOptionPane.showMessageDialog(this, "��ӳɹ�");
			jt_student_id.setText("");
			jt_student_name.setText("");
			jt_curr_money.setText("");
		}else {
			//��ʾ
			JOptionPane.showMessageDialog(this, "��Ϣ����");
			jt_student_id.setText("");
			jt_student_name.setText("");
			jt_curr_money.setText("");
		}
	}
}
