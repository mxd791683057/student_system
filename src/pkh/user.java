package pkh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class user extends JFrame {
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
    static JButton[] jb1=new JButton[8];//按钮1
    static JButton[] jb2=new JButton[8];//按钮修改
    static JButton sign=new JButton("签到");
    static JButton setBonus=new JButton("修改时间");
    
	public user(String str){
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

		jp0[0].add(jl0[0]);
		jp0[0].add(jtf0[0]);
		jp0[0].add(jl0[1]);
		jp0[0].add(jtf0[1]);

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
		//查询
		jp0[2]=new JPanel();
		jb1[0] = new JButton("查询");
		jb1[0].addActionListener(new user_listener());
		jb2[0] = new JButton("修改");
		jb2[0].addActionListener(new user_listener());
		jp0[2].add(jb1[0]);
		jp0[2].add(jb2[0]);
		//添加
		jp[0].add(jp0[0],BorderLayout.NORTH);
		jp[0].add(jp0[1],BorderLayout.CENTER);
		jp[0].add(jp0[2],BorderLayout.SOUTH);
		

//4.工资信息
		jp[3]=new JPanel();
		jp[3].setLayout(new BorderLayout());
		//输入
		jp5[0]=new JPanel();
		jl5[0]=new JLabel("学号");
		jtf5[0]=new JTextField(7);

		jp5[0].add(jl5[0]);
		jp5[0].add(jtf5[0]);

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
		//查询
		jp5[2]=new JPanel();
		jb1[5] = new JButton("查询");
		jb1[5].addActionListener(new user_listener());
		jp5[2].add(jb1[5]);
		setBonus.addActionListener(new user_listener()); 
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
		jp6[0].add(jl6[0]);
		jp6[0].add(jtf6[0]);
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
		jb1[6].addActionListener(new user_listener());
		jp6[2].add(jb1[6]);
		sign.addActionListener(new user_listener());
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
		jb1[7].addActionListener(new user_listener());
		jp7[2].add(jb1[7]);
		//添加
		split1[1].add(jp7[0],BorderLayout.NORTH);
		split1[1].add(jp7[1],BorderLayout.CENTER);
		split1[1].add(jp7[2],BorderLayout.SOUTH);
		jp[4].add(split1[1]);
	
		
		jtp.add("基本信息",jp[0]);
		jtp.add("打卡信息",jp[3]);
		jtp.add("签到信息",jp[4]);
		
		this.add(jtp);
		
		this.setTitle("疫情上报系统  学生"+str);
		this.setSize(1000, 600);
		this.setLocation(400, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}



}
