package pkh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class admin extends JFrame{
	static Connection conn;
    static Statement st;
    
    String str;
    JTabbedPane jtp;//页面
    JPanel[] split=new JPanel[4];
    JPanel[] jp=new JPanel[5];//大面板
    JPanel[] jp0=new JPanel[3];//小面板
    JPanel[] jp1=new JPanel[3];
    JPanel[] jp2=new JPanel[3];
    JPanel[] jp3=new JPanel[3];
    JPanel[] jp4=new JPanel[3];
    JPanel[] jp5=new JPanel[3];
    JPanel[] jp6=new JPanel[3];
    JPanel[] jp7=new JPanel[3];
    //基本信息
    JLabel[] jl0=new JLabel[5];//条件
    static JTextField[] jtf0=new JTextField[5];//输入
    //公司部门
    JLabel[] jl1=new JLabel[3];//条件
    static JTextField[] jtf1=new JTextField[3];//输入
    //职位信息
    JLabel[] jl2=new JLabel[4];//条件
    static JTextField[] jtf2=new JTextField[4];//输入
    //培训信息
    JLabel[] jl3=new JLabel[4];//条件
    static JTextField[] jtf3=new JTextField[4];//输入
    //技能信息
    JLabel[] jl4=new JLabel[4];//条件
    static JTextField[] jtf4=new JTextField[4];//输入
    //工资信息
    JLabel[] jl5=new JLabel[5];//条件
    static JTextField[] jtf5=new JTextField[5];//输入
    //签到信息
    JLabel[] jl6=new JLabel[4];//签到表
    static JTextField[] jtf6=new JTextField[4];//输入
    JLabel jl7=new JLabel();//考勤表
    static JTextField jtf7=new JTextField();//输入
    
    static DefaultTableModel[] dtm=new DefaultTableModel[8];//默认的表格模式
    static JTable[] jt=new JTable[8];//表格
    static Vector[] title=new Vector[8];//表头和数据
    static Vector[] data=new Vector[8];
    JTableHeader[] header=new JTableHeader[8];//获取表头
    JScrollPane[] jsp=new JScrollPane[8];//滚动
    static JButton[] jb1=new JButton[8];//按钮查询
    static JButton[] jb2=new JButton[8];//按钮修改
    static JButton[] jb3=new JButton[8];//按钮添加
    static JButton sign=new JButton("签到");
    
	public admin(String str){
		this.str=str;
		
		jtp=new JTabbedPane();
		
//1.基本信息
		jp[0]=new JPanel();
		jp[0].setLayout(new BorderLayout());
		//输入
		jp0[0]=new JPanel();
		jl0[0]=new JLabel("学号");
		jtf0[0]=new JTextField(7);
		jl0[1]=new JLabel("姓名");
		jtf0[1]=new JTextField(7);
		jl0[2]=new JLabel("年级");
		jtf0[2]=new JTextField(7);
		jl0[3]=new JLabel("学院");
		jtf0[3]=new JTextField(7);
		jl0[4]=new JLabel("学历");
		jtf0[4]=new JTextField(7);
		jp0[0].add(jl0[0]);
		jp0[0].add(jtf0[0]);
		jp0[0].add(jl0[1]);
		jp0[0].add(jtf0[1]);
		jp0[0].add(jl0[2]);
		jp0[0].add(jtf0[2]);
		jp0[0].add(jl0[3]);
		jp0[0].add(jtf0[3]);
		jp0[0].add(jl0[4]);
		jp0[0].add(jtf0[4]);
		//输出
		jp0[1]=new JPanel();
		dtm[0]=new DefaultTableModel();
		jt[0]=new JTable(dtm[0]);
		title[0] = new Vector();
		data[0] = new Vector();
		header[0] = jt[0].getTableHeader();
		jsp[0] = new JScrollPane(jt[0]);
		header[0].setBounds(50, 50, 700, 800);
		jt[0].setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jp0[1].setPreferredSize(new Dimension(800,800));
		jp0[1].add(header[0]);
		jp0[1].add(jsp[0]);
		//操作
		jp0[2]=new JPanel();
		jb1[0] = new JButton("查询");
		jb1[0].addActionListener(new admin_listener());
		jb2[0] = new JButton("修改");
		jb2[0].addActionListener(new admin_listener());
		jb3[0] = new JButton("添加");
		jb3[0].addActionListener(new admin_listener());
		jp0[2].add(jb1[0]);
		jp0[2].add(jb2[0]);
		jp0[2].add(jb3[0]);
		//添加
		jp[0].add(jp0[0],BorderLayout.NORTH);
		jp[0].add(jp0[1],BorderLayout.CENTER);
		jp[0].add(jp0[2],BorderLayout.SOUTH);
		
//2.地址信息
		jp[1]=new JPanel();
		jp[1].setLayout(new GridLayout(0,2));
	//地区
		split[0]=new JPanel();
		split[0].setLayout(new BorderLayout());
		//输入
		jp1[0]=new JPanel();
		jl1[0]=new JLabel("当前所在省");
		jtf1[0]=new JTextField(7);
		jl1[1]=new JLabel("当前所在市区");
		jtf1[1]=new JTextField(7);
		jl1[2]=new JLabel("学号");
		jtf1[2]=new JTextField(7);
		jp1[0].add(jl1[0]);
		jp1[0].add(jtf1[0]);
		jp1[0].add(jl1[1]);
		jp1[0].add(jtf1[1]);
		jp1[0].add(jl1[2]);
		jp1[0].add(jtf1[2]);
		//输出
		jp1[1]=new JPanel();
		dtm[1]=new DefaultTableModel();
		jt[1]=new JTable(dtm[1]);
		title[1] = new Vector();
		data[1] = new Vector();
		header[1] = jt[1].getTableHeader();
		jsp[1] = new JScrollPane(jt[1]);
		jp1[1].add(header[1]);
		jp1[1].add(jsp[1]);
		//操作
		jp1[2]=new JPanel();
		jb1[1] = new JButton("查询");
		jb1[1].addActionListener(new admin_listener());
		jb2[1] = new JButton("修改");
		jb2[1].addActionListener(new admin_listener());
		jb3[1] = new JButton("添加");
		jb3[1].addActionListener(new admin_listener());
		jp1[2].add(jb1[1]);
		jp1[2].add(jb2[1]);
		jp1[2].add(jb3[1]);
		//添加
		split[0].add(jp1[0],BorderLayout.NORTH);
		split[0].add(jp1[1],BorderLayout.CENTER);
		split[0].add(jp1[2],BorderLayout.SOUTH);	
		jp[1].add(split[0]);
	//职位信息
		split[1]=new JPanel();
		split[1].setLayout(new BorderLayout());
		//输入
		jp2[0]=new JPanel();
		jl2[0]=new JLabel("学校主管序号");
		jtf2[0]=new JTextField(4);
		jl2[1]=new JLabel("主管等级");
		jtf2[1]=new JTextField(4);
		jl2[2]=new JLabel("主管名");
		jtf2[2]=new JTextField(4);
		jp2[0].add(jl2[0]);
		jp2[0].add(jtf2[0]);
		jp2[0].add(jl2[1]);
		jp2[0].add(jtf2[1]);
		jp2[0].add(jl2[2]);
		jp2[0].add(jtf2[2]);
		//输出
		jp2[1]=new JPanel();
		dtm[2]=new DefaultTableModel();
		jt[2]=new JTable(dtm[2]);
		title[2] = new Vector();
		data[2] = new Vector();
		header[2] = jt[2].getTableHeader();
		jsp[2] = new JScrollPane(jt[2]);
		jp2[1].add(header[2]);
		jp2[1].add(jsp[2]);
		//操作
		jp2[2]=new JPanel();
		jb1[2] = new JButton("查询");
		jb1[2].addActionListener(new admin_listener());
		jb2[2] = new JButton("修改");
		jb2[2].addActionListener(new admin_listener());
		jb3[2] = new JButton("添加");
		jb3[2].addActionListener(new admin_listener());
		jp2[2].add(jb1[2]);
		jp2[2].add(jb2[2]);
		jp2[2].add(jb3[2]);
		//添加
		split[1].add(jp2[0],BorderLayout.NORTH);
		split[1].add(jp2[1],BorderLayout.CENTER);
		split[1].add(jp2[2],BorderLayout.SOUTH);	
		jp[1].add(split[1]);
/**		
//3.员工管理		
		jp[2]=new JPanel();
		jp[2].setLayout(new GridLayout(0,2));
	//请假
		split[2]=new JPanel();
		split[2].setLayout(new BorderLayout());
		//输入
		jp3[0]=new JPanel();
		jl3[0]=new JLabel("请假编号");
		jtf3[0]=new JTextField(4);
		jl3[1]=new JLabel("员工工号");
		jtf3[1]=new JTextField(4);
		jl3[2]=new JLabel("请假时间");
		jtf3[2]=new JTextField(4);
		jl3[3]=new JLabel("请假天数");
		jtf3[3]=new JTextField(4);
		jp3[0].add(jl3[0]);
		jp3[0].add(jtf3[0]);
		jp3[0].add(jl3[1]);
		jp3[0].add(jtf3[1]);
		jp3[0].add(jl3[2]);
		jp3[0].add(jtf3[2]);
		jp3[0].add(jl3[3]);
		jp3[0].add(jtf3[3]);
		//输出
		jp3[1]=new JPanel();
		dtm[3]=new DefaultTableModel();
		jt[3]=new JTable(dtm[3]);
		title[3] = new Vector();
		data[3] = new Vector();
		header[3] = jt[3].getTableHeader();
		jsp[3] = new JScrollPane(jt[3]);
		jp3[1].add(header[3]);
		jp3[1].add(jsp[3]);
		//操作
		jp3[2]=new JPanel();
		jb1[3] = new JButton("查询");
		jb1[3].addActionListener(new admin_listener());
		jb2[3] = new JButton("修改");
		jb2[3].addActionListener(new admin_listener());
		jb3[3] = new JButton("添加");
		jb3[3].addActionListener(new admin_listener());
		jp3[2].add(jb1[3]);
		jp3[2].add(jb2[3]);
		jp3[2].add(jb3[3]);
		//添加
		split[2].add(jp3[0],BorderLayout.NORTH);
		split[2].add(jp3[1],BorderLayout.CENTER);
		split[2].add(jp3[2],BorderLayout.SOUTH);	
		jp[2].add(split[2]);
	//加班
		split[3]=new JPanel();
		split[3].setLayout(new BorderLayout());
		//输入
		jp4[0]=new JPanel();
		jl4[0]=new JLabel("加班编号");
		jtf4[0]=new JTextField(4);
		jl4[1]=new JLabel("员工号");
		jtf4[1]=new JTextField(4);
		jl4[2]=new JLabel("加班时间");
		jtf4[2]=new JTextField(4);
		jl4[3]=new JLabel("加班时长");
		jtf4[3]=new JTextField(4);
		jp4[0].add(jl4[0]);
		jp4[0].add(jtf4[0]);
		jp4[0].add(jl4[1]);
		jp4[0].add(jtf4[1]);
		jp4[0].add(jl4[2]);
		jp4[0].add(jtf4[2]);
		jp4[0].add(jl4[3]);
		jp4[0].add(jtf4[3]);
		//输出
		jp4[1]=new JPanel();
		dtm[4]=new DefaultTableModel();
		jt[4]=new JTable(dtm[4]);
		title[4] = new Vector();
		data[4] = new Vector();
		header[4] = jt[4].getTableHeader();
		jsp[4] = new JScrollPane(jt[4]);
		jp4[1].add(header[4]);
		jp4[1].add(jsp[4]);
		//操作
		jp4[2]=new JPanel();
		jb1[4] = new JButton("查询");
		jb1[4].addActionListener(new admin_listener());
		jb2[4] = new JButton("修改");
		jb2[4].addActionListener(new admin_listener());
		jb3[4] = new JButton("添加");
		jb3[4].addActionListener(new admin_listener());
		jp4[2].add(jb1[4]);
		jp4[2].add(jb2[4]);
		jp4[2].add(jb3[4]);
		//添加
		split[3].add(jp4[0],BorderLayout.NORTH);
		split[3].add(jp4[1],BorderLayout.CENTER);
		split[3].add(jp4[2],BorderLayout.SOUTH);	
		jp[2].add(split[3]);
*/		
//4.工资信息
		jp[3]=new JPanel();
		jp[3].setLayout(new BorderLayout());
		//输入
		jp5[0]=new JPanel();
		jl5[0]=new JLabel("学号");
		jtf5[0]=new JTextField(7);
		jl5[1]=new JLabel("学历");
		jtf5[1]=new JTextField(7);
		jl5[2]=new JLabel("签到次数");
		jtf5[2]=new JTextField(7);


		jp5[0].add(jl5[0]);
		jp5[0].add(jtf5[0]);
		jp5[0].add(jl5[1]);
		jp5[0].add(jtf5[1]);
		jp5[0].add(jl5[2]);
		jp5[0].add(jtf5[2]);


		//输出
		jp5[1]=new JPanel();
		dtm[5]=new DefaultTableModel();
		jt[5]=new JTable(dtm[5]);
		title[5] = new Vector();
		data[5] = new Vector();
		header[5] = jt[5].getTableHeader();
		jsp[5] = new JScrollPane(jt[5]);
		jp5[1].add(header[5]);
		jp5[1].add(jsp[5]);
		//操作
		jp5[2]=new JPanel();
		jb1[5] = new JButton("查询");
		jb1[5].addActionListener(new admin_listener());
		jb2[5] = new JButton("修改");
		jb2[5].addActionListener(new admin_listener());
		jb3[5] = new JButton("添加");
		jb3[5].addActionListener(new admin_listener());
		jp5[2].add(jb1[5]);
		jp5[2].add(jb2[5]);
		jp5[2].add(jb3[5]);
		//添加
		jp[3].add(jp5[0],BorderLayout.NORTH);
		jp[3].add(jp5[1],BorderLayout.CENTER);
		jp[3].add(jp5[2],BorderLayout.SOUTH);
		
//5.签到
		jp[4]=new JPanel();
		jp[4].setLayout(new GridLayout(0,2));
		JPanel[] split1=new JPanel[2];
	//签到表
		split1[0]=new JPanel();
		split1[0].setLayout(new BorderLayout());
		//输入
		jp6[0]=new JPanel();
		jl6[0]=new JLabel("学号");
		jtf6[0]=new JTextField(7);
		jl6[1]=new JLabel("年");
		jtf6[1]=new JTextField(7);
		jl6[2]=new JLabel("月");
		jtf6[2]=new JTextField(7);
		jl6[3]=new JLabel("日");
		jtf6[3]=new JTextField(7);
		jp6[0].add(jl6[0]);
		jp6[0].add(jtf6[0]);
		jp6[0].add(jl6[1]);
		jp6[0].add(jtf6[1]);
		jp6[0].add(jl6[2]);
		jp6[0].add(jtf6[2]);
		jp6[0].add(jl6[3]);
		jp6[0].add(jtf6[3]);
		//输出
		jp6[1]=new JPanel();
		dtm[6]=new DefaultTableModel();
		jt[6]=new JTable(dtm[6]);
		title[6] = new Vector();
		data[6] = new Vector();
		header[6] = jt[6].getTableHeader();
		jsp[6] = new JScrollPane(jt[6]);
		jp6[1].add(header[6]);
		jp6[1].add(jsp[6]);
		//查询
		jp6[2]=new JPanel();
		jb1[6] = new JButton("查询签到信息");
		jb1[6].addActionListener(new admin_listener());
		jp6[2].add(jb1[6]);
		sign.addActionListener(new admin_listener());
		jp6[2].add(sign);
		//添加
		split1[0].add(jp6[0],BorderLayout.NORTH);
		split1[0].add(jp6[1],BorderLayout.CENTER);
		split1[0].add(jp6[2],BorderLayout.SOUTH);
		jp[4].add(split1[0]);
	//考勤表
		split1[1]=new JPanel();
		split1[1].setLayout(new BorderLayout());
		//输入
		jp7[0]=new JPanel();
		jl7=new JLabel("学号");
		jtf7=new JTextField(7);
		jp7[0].add(jl7);
		jp7[0].add(jtf7);
		//输出
		jp7[1]=new JPanel();
		dtm[7]=new DefaultTableModel();
		jt[7]=new JTable(dtm[7]);
		title[7] = new Vector();
		data[7] = new Vector();
		header[7] = jt[7].getTableHeader();
		jsp[7] = new JScrollPane(jt[7]);
		jp7[1].add(header[7]);
		jp7[1].add(jsp[7]);
		//查询
		jp7[2]=new JPanel();
		jb1[7] = new JButton("查询签到情况");
		jb1[7].addActionListener(new admin_listener());
		jb2[7] = new JButton("修改");
		jb2[7].addActionListener(new admin_listener());
		jb3[7] = new JButton("添加签到信息");
		jb3[7].addActionListener(new admin_listener());
		jp7[2].add(jb1[7]);
		jp7[2].add(jb2[7]);
		jp7[2].add(jb3[7]);
		//添加
		split1[1].add(jp7[0],BorderLayout.NORTH);
		split1[1].add(jp7[1],BorderLayout.CENTER);
		split1[1].add(jp7[2],BorderLayout.SOUTH);
		jp[4].add(split1[1]);
		
		jtp.add("个人信息",jp[0]);
		jtp.add("地址信息",jp[1]);
		/**jtp.add("签到详细信息",jp[2]);*/
		jtp.add("健康状况",jp[3]);
		jtp.add("签到日期",jp[4]);
		this.add(jtp);
		
		this.setTitle("疫情上报管理系统");
		this.setSize(1000, 600);
		this.setLocation(400, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	

}