package pkh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class user_listener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//1������Ϣ
		if (e.getSource() == user.jb1[0]){

			user.title[0].clear();
			user.data[0].clear();
			user.title[0].add("ѧ��");
			user.title[0].add("����");
			user.title[0].add("�Ա�");
			user.title[0].add("����");		
			user.title[0].add("�꼶");
			user.title[0].add("ѧԺ");
			user.title[0].add("ѧ��");
			user.title[0].add("����");
			user.title[0].add("�绰");
			user.title[0].add("��ѧʱ��");
		
			user.conn = connect.getConnection();
			String sql= "select * from dbo.Employee where "; 
			boolean flag=false;
			if(!(user.jtf0[0].getText().length()<1) ){
				sql+="Employee_id='"+user.jtf0[0].getText()+"'";
				flag=true;
			}

			
			sql+=";";
			if(flag==false){//ȫѡ
				sql="select * from dbo.Employee where Employee_id='00101';";
			}
			try {
				user.st = user.conn.createStatement();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			ResultSet rs;
			
				try {
					rs = user.st.executeQuery(sql);
					while(rs.next())
					{
						Vector v = new Vector();
						v.add(rs.getString("Employee_id"));
						v.add(rs.getString("Password"));
						v.add(rs.getString("Sex"));
						v.add(rs.getString("Name"));
						v.add(rs.getString("Position_rank"));
						v.add(rs.getString("Branch_id"));
						v.add(rs.getString("Position_id"));
						v.add(rs.getString("Email"));
						v.add(rs.getString("Phone"));
						v.add(rs.getString("Hiredate"));
						user.data[0].add(v);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					user.conn.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				user.dtm[0].setDataVector(user.data[0], user.title[0]);
		}
		if(e.getSource()==user.jb2[0]){//2��
			int row = user.jt[0].getSelectedRow();
			String[] change=new String[10];
			String[] in={"Employee_id","Password","Sex","Name","Position_rank","Branch_id",
					"Position_id","Email","Phone","Hiredate"};
			boolean[] input=new boolean[10];
			for(int i=0;i<change.length;i++){
				if(user.jt[0].getValueAt(row, i)!=null){
					input[i]=true;
					change[i]=user.jt[0].getValueAt(row, i)+"";
			//		System.out.println(change[i]);
				}
			}
			try
			{
				user.conn = connect.getConnection();
				String sql1 = "update dbo.Employee set Password='"+change[1]+"'";
				for(int i=2;i<change.length;i++){
					if(input[i]==true)
						sql1+=","+in[i]+"='"+change[i]+"'";
					
				}
				sql1+=" where Employee_id='"+change[0]+"';";
         //		System.out.println(sql1);
				PreparedStatement preparedStatement1 = user.conn.prepareStatement(sql1);
				preparedStatement1.executeUpdate();

				user.conn.close();
				
				} catch (SQLException e2) {

				e2.printStackTrace();

			} catch (Exception e3) {

				e3.printStackTrace();

			}
			JFrame newFrame = new JFrame();
			newFrame.setLocation(50,200);
			JOptionPane.showMessageDialog(newFrame.getContentPane(),
					"�޸���Ϣ�ɹ���", "����", JOptionPane.INFORMATION_MESSAGE);
		}

	//6������Ϣ
		if (e.getSource() == user.jb1[5]){

			user.title[5].clear();
			user.data[5].clear();
			user.title[5].add("ѧ��");
			user.title[5].add("����״��");
			user.title[5].add("��������");
			user.title[5].add("�Ƿ����");
			user.title[5].add("�Ƿ����ػ���");
			
			user.conn = connect.getConnection();
			String sql= "select * from dbo.Salary where "; 
			boolean flag=false;
			if(!(user.jtf5[0].getText().length()<1) ){
				sql+="Employee_id='"+user.jtf5[0].getText()+"'";
				flag=true;
			}
		
			sql+=";";
			if(flag==false){//ȫѡ
				sql="select * from dbo.Salary where Employee_id='00101';";
			}
			try {
				user.st = user.conn.createStatement();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			ResultSet rs;
			
				try {
					rs = user.st.executeQuery(sql);
					while(rs.next())
					{
						Vector v = new Vector();
						v.add(rs.getString("Employee_id"));
						v.add(rs.getString("Position_rank"));
						v.add(rs.getString("Base_Salary"));
						v.add(rs.getString("Bonus"));
						v.add(rs.getString("Salary"));
						user.data[5].add(v);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					user.conn.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				user.dtm[5].setDataVector(user.data[5], user.title[5]);
		}
		
		
	//7ǩ��
		//1��ѯǩ��
		if (e.getSource() == user.jb1[6]){

			user.title[6].clear();
			user.data[6].clear();
			user.title[6].add("ѧ��");
			user.title[6].add("��");
			user.title[6].add("��");
			user.title[6].add("��");
			user.title[6].add("ʱ��");
			user.title[6].add("�Ƿ�ǩ��");
			
			user.conn = connect.getConnection();
			String sql= "select * from dbo.sign where "; 
			boolean flag=false;
			if(!(user.jtf6[0].getText().length()<1) ){
				sql+="Employee_id='"+user.jtf6[0].getText()+"'";
				flag=true;
			}
			
			sql+=";";
			if(flag==false){//ȫѡ
				sql="select * from dbo.sign where Employee_id='00101';";
			}
			try {
				user.st = user.conn.createStatement();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			ResultSet rs;
			
				try {
					rs = user.st.executeQuery(sql);
					while(rs.next())
					{
						Vector v = new Vector();
						v.add(rs.getString("Employee_id"));
						v.add(rs.getString("year"));
						v.add(rs.getString("month"));
						v.add(rs.getString("day"));
						v.add(rs.getString("time"));
						v.add(rs.getString("late"));
						user.data[6].add(v);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					user.conn.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				user.dtm[6].setDataVector(user.data[6], user.title[6]);
		}
		
		//2���ǩ��
		if(e.getSource()==user.sign){
			try
			{
				user.conn = connect.getConnection();
				Calendar cal=Calendar.getInstance();
				int year=cal.get(Calendar.YEAR);
				int month=cal.get(Calendar.MONTH)+1;
				int day=cal.get(Calendar.DATE);
				String sql0="select * from dbo.sign where Employee_id='"+login.id+"' and year='"+
				year+"' and month='"+month+"' and day='"+day+"';";
				//System.out.println(sql0);
				try {
					user.st = user.conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs;
		
				rs = user.st.executeQuery(sql0);
					
				if(rs.next())
				{
					JFrame newFrame = new JFrame();
					newFrame.setLocation(50,200);
					JOptionPane.showMessageDialog(newFrame.getContentPane(),
							"������ǩ����", "����", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else{
			    	int hour = cal.get(Calendar.HOUR_OF_DAY); 
				    int minute = cal.get(Calendar.MINUTE); 
				    int second = cal.get(Calendar.SECOND); 
				    String late="";
				    if((hour>=8&&hour<=12)||(hour>=14&&hour<=18))
				    	late="��ǩ��";
				    String sql1 = "insert into dbo.sign values ('"+login.id+"','"+year+"','"+month+
				    		"','"+day+"','"+hour+":"+minute+":"+second+"','"+late+"');";
				    //System.out.println(sql1);
				    PreparedStatement preparedStatement1 = user.conn.prepareStatement(sql1);
				    preparedStatement1.executeUpdate();
				
				    JFrame newFrame = new JFrame();
				    newFrame.setLocation(50,200);
				    JOptionPane.showMessageDialog(newFrame.getContentPane(),
						"ǩ���ɹ���", "����", JOptionPane.INFORMATION_MESSAGE);
				    }
				user.conn.close();
				
			} catch (SQLException e2) {

				e2.printStackTrace();
			} catch (Exception e3) {

				e3.printStackTrace();

			}
			
		}
		//3��ѯ����
		if (e.getSource() == user.jb1[7]){//1��
			user.title[7].clear();
			user.data[7].clear();
			user.title[7].add("ѧ��");
			user.title[7].add("ǩ������");
			user.title[7].add("��ǩ������");
			user.title[7].add("ԭ��");
			
			user.conn = connect.getConnection();
			String sql= "select * from dbo.Attendance where "; 
			boolean flag=false;
			if(!(user.jtf7.getText().length()<1) ){
				sql+="Employee_id='"+user.jtf7.getText()+"'";
				flag=true;
			}
			sql+=";";
			if(flag==false){//ȫѡ
				sql="select * from dbo.Attendance where Employee_id='00101';";
			}
			try {
				user.st = user.conn.createStatement();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			ResultSet rs;
			
				try {
					rs = user.st.executeQuery(sql);
					while(rs.next())
					{
						Vector v = new Vector();
						v.add(rs.getString("Employee_id"));
						v.add(rs.getString("Late"));
						v.add(rs.getString("Absence"));
						v.add(rs.getString("Fine"));
						user.data[7].add(v);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					user.conn.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				user.dtm[7].setDataVector(user.data[7], user.title[7]);
		}
		
		
	//����
		//�޸��¼�Ա������
		if (e.getSource() == user.setBonus){
			try
			{
				user.conn = connect.getConnection();
				String sql0="select * from dbo.Employee where Employee_id='"+login.id+"';";
				//System.out.println(sql0);
				//System.out.println(login.id);
				try {
					user.st = user.conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs;
		
				rs = user.st.executeQuery(sql0);
					
				int row = user.jt[5].getSelectedRow();
				//System.out.println(row);
			if(rs.next()){
				int userRank=Integer.parseInt(rs.getString("Position_rank"));
				int changeRank=Integer.valueOf((String) user.jt[5].getValueAt(row, 1));
				if(userRank>=changeRank)
				{
					JFrame newFrame = new JFrame();
					newFrame.setLocation(50,200);
					JOptionPane.showMessageDialog(newFrame.getContentPane(),
							"û��Ȩ���޸�ѧ����Ϣ��", "����", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else{
					if(user.jt[5].getValueAt(row, 4)!=null){
					    String sql1 = "update dbo.Salary set Bonus='"+user.jt[5].getValueAt(row, 4)
							+"' where Employee_id='"+user.jt[5].getValueAt(row, 0)+"';";
				        //System.out.println(sql1);
				        PreparedStatement preparedStatement1 = user.conn.prepareStatement(sql1);
				        preparedStatement1.executeUpdate();
				
				        JFrame newFrame = new JFrame();
				        newFrame.setLocation(50,200);
				        JOptionPane.showMessageDialog(newFrame.getContentPane(),
						    "�޸ĳɹ���", "����", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				user.conn.close();
			}
			} catch (SQLException e2) {

				e2.printStackTrace();
			} catch (Exception e3) {

				e3.printStackTrace();

			}
		}
		
		
	}
}
