package pkh;
import javax.swing.*;
import java.awt.*;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class login extends JFrame implements ActionListener{
	
	Connection conn;
    Statement st;
    static String id;
    
    
	//初始化组件
	JLabel jl1,jl2;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb1,jb2,jb3;
	JPanel jp1,jp2,jp3;
	
	public login() {
		//创建组件
		jl1 = new JLabel("学号");
		jl2 = new JLabel("密    码");
		
		jtf = new JTextField(15);
		
		jpf = new JPasswordField(15);
		
		jb1 = new JButton("登录");
	
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//设置监听
		jb1.addActionListener(this);
		jb1.setActionCommand("login");
		
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jtf);
		
		jp2.add(jl2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		
		
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//设置窗体属性
		this.setTitle("疫情上报管理系统");
		this.setSize(500, 300);
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("login"))
		{
			if(jtf.getText().length()<1 || jpf.getText().length()<1)
			{
				JFrame newFrame = new JFrame();
				newFrame.setLocation(50,200);
				JOptionPane.showMessageDialog(newFrame.getContentPane(),
						"用户名或密码不能为空！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				id=jtf.getText();
				
					conn = connect.getConnection();
					String sql = "select * from dbo.Employee where Employee_id='"+jtf.getText()+"'";
					try {
						st = conn.createStatement();
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					ResultSet rs;
					try {
							rs = st.executeQuery(sql);
							st = conn.createStatement();
							if(rs.next())
							{
								if(jpf.getText().equals(rs.getString("Password")))
								{
									this.dispose();
								
					//				System.out.println("1");
									String rank=rs.getString("Position_rank");
									if(rank.equals("0")){
										admin a = new admin(jtf.getText());
									}
									else{
									    user uf = new user(jtf.getText());
									}
									
								}
								else
								{
									JFrame newFrame = new JFrame();
									newFrame.setLocation(50,200);
									JOptionPane.showMessageDialog(newFrame.getContentPane(),
											"用户名与密码不匹配！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							else
							{
								JFrame newFrame = new JFrame();
								newFrame.setLocation(50,200);
								JOptionPane.showMessageDialog(newFrame.getContentPane(),
										"用户不存在！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login log = new login();
	}
	
	
}
