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
    JTabbedPane jtp;//ҳ��
    JPanel[] split=new JPanel[4];
    JPanel[] jp=new JPanel[5];//�����
    JPanel[] jp0=new JPanel[3];//С���
    JPanel[] jp1=new JPanel[3];
    JPanel[] jp2=new JPanel[3];
    JPanel[] jp3=new JPanel[3];
    JPanel[] jp4=new JPanel[3];
    JPanel[] jp5=new JPanel[3];
    JPanel[] jp6=new JPanel[3];
    JPanel[] jp7=new JPanel[3];
    //������Ϣ
    JLabel[] jl0=new JLabel[5];//����
    static JTextField[] jtf0=new JTextField[5];//����
    //��˾����
    JLabel[] jl1=new JLabel[3];//����
    static JTextField[] jtf1=new JTextField[3];//����
    //ְλ��Ϣ
    JLabel[] jl2=new JLabel[4];//����
    static JTextField[] jtf2=new JTextField[4];//����
    //��ѵ��Ϣ
    JLabel[] jl3=new JLabel[4];//����
    static JTextField[] jtf3=new JTextField[4];//����
    //������Ϣ
    JLabel[] jl4=new JLabel[4];//����
    static JTextField[] jtf4=new JTextField[4];//����
    //������Ϣ
    JLabel[] jl5=new JLabel[5];//����
    static JTextField[] jtf5=new JTextField[5];//����
    //ǩ����Ϣ
    JLabel[] jl6=new JLabel[4];//ǩ����
    static JTextField[] jtf6=new JTextField[4];//����
    JLabel jl7=new JLabel();//���ڱ�
    static JTextField jtf7=new JTextField();//����
    
    static DefaultTableModel[] dtm=new DefaultTableModel[8];//Ĭ�ϵı��ģʽ
    static JTable[] jt=new JTable[8];//���
    static Vector[] title=new Vector[8];//��ͷ������
    static Vector[] data=new Vector[8];
    JTableHeader[] header=new JTableHeader[8];//��ȡ��ͷ
    JScrollPane[] jsp=new JScrollPane[8];//����
    static JButton[] jb1=new JButton[8];//��ť��ѯ
    static JButton[] jb2=new JButton[8];//��ť�޸�
    static JButton[] jb3=new JButton[8];//��ť���
    static JButton sign=new JButton("ǩ��");
    
	public admin(String str){
		this.str=str;
		
		jtp=new JTabbedPane();
		
//1.������Ϣ
		jp[0]=new JPanel();
		jp[0].setLayout(new BorderLayout());
		//����
		jp0[0]=new JPanel();
		jl0[0]=new JLabel("ѧ��");
		jtf0[0]=new JTextField(7);
		jl0[1]=new JLabel("����");
		jtf0[1]=new JTextField(7);
		jl0[2]=new JLabel("�꼶");
		jtf0[2]=new JTextField(7);
		jl0[3]=new JLabel("ѧԺ");
		jtf0[3]=new JTextField(7);
		jl0[4]=new JLabel("ѧ��");
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
		//���
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
		//����
		jp0[2]=new JPanel();
		jb1[0] = new JButton("��ѯ");
		jb1[0].addActionListener(new admin_listener());
		jb2[0] = new JButton("�޸�");
		jb2[0].addActionListener(new admin_listener());
		jb3[0] = new JButton("���");
		jb3[0].addActionListener(new admin_listener());
		jp0[2].add(jb1[0]);
		jp0[2].add(jb2[0]);
		jp0[2].add(jb3[0]);
		//���
		jp[0].add(jp0[0],BorderLayout.NORTH);
		jp[0].add(jp0[1],BorderLayout.CENTER);
		jp[0].add(jp0[2],BorderLayout.SOUTH);
		
//2.��ַ��Ϣ
		jp[1]=new JPanel();
		jp[1].setLayout(new GridLayout(0,2));
	//����
		split[0]=new JPanel();
		split[0].setLayout(new BorderLayout());
		//����
		jp1[0]=new JPanel();
		jl1[0]=new JLabel("��ǰ����ʡ");
		jtf1[0]=new JTextField(7);
		jl1[1]=new JLabel("��ǰ��������");
		jtf1[1]=new JTextField(7);
		jl1[2]=new JLabel("ѧ��");
		jtf1[2]=new JTextField(7);
		jp1[0].add(jl1[0]);
		jp1[0].add(jtf1[0]);
		jp1[0].add(jl1[1]);
		jp1[0].add(jtf1[1]);
		jp1[0].add(jl1[2]);
		jp1[0].add(jtf1[2]);
		//���
		jp1[1]=new JPanel();
		dtm[1]=new DefaultTableModel();
		jt[1]=new JTable(dtm[1]);
		title[1] = new Vector();
		data[1] = new Vector();
		header[1] = jt[1].getTableHeader();
		jsp[1] = new JScrollPane(jt[1]);
		jp1[1].add(header[1]);
		jp1[1].add(jsp[1]);
		//����
		jp1[2]=new JPanel();
		jb1[1] = new JButton("��ѯ");
		jb1[1].addActionListener(new admin_listener());
		jb2[1] = new JButton("�޸�");
		jb2[1].addActionListener(new admin_listener());
		jb3[1] = new JButton("���");
		jb3[1].addActionListener(new admin_listener());
		jp1[2].add(jb1[1]);
		jp1[2].add(jb2[1]);
		jp1[2].add(jb3[1]);
		//���
		split[0].add(jp1[0],BorderLayout.NORTH);
		split[0].add(jp1[1],BorderLayout.CENTER);
		split[0].add(jp1[2],BorderLayout.SOUTH);	
		jp[1].add(split[0]);
	//ְλ��Ϣ
		split[1]=new JPanel();
		split[1].setLayout(new BorderLayout());
		//����
		jp2[0]=new JPanel();
		jl2[0]=new JLabel("ѧУ�������");
		jtf2[0]=new JTextField(4);
		jl2[1]=new JLabel("���ܵȼ�");
		jtf2[1]=new JTextField(4);
		jl2[2]=new JLabel("������");
		jtf2[2]=new JTextField(4);
		jp2[0].add(jl2[0]);
		jp2[0].add(jtf2[0]);
		jp2[0].add(jl2[1]);
		jp2[0].add(jtf2[1]);
		jp2[0].add(jl2[2]);
		jp2[0].add(jtf2[2]);
		//���
		jp2[1]=new JPanel();
		dtm[2]=new DefaultTableModel();
		jt[2]=new JTable(dtm[2]);
		title[2] = new Vector();
		data[2] = new Vector();
		header[2] = jt[2].getTableHeader();
		jsp[2] = new JScrollPane(jt[2]);
		jp2[1].add(header[2]);
		jp2[1].add(jsp[2]);
		//����
		jp2[2]=new JPanel();
		jb1[2] = new JButton("��ѯ");
		jb1[2].addActionListener(new admin_listener());
		jb2[2] = new JButton("�޸�");
		jb2[2].addActionListener(new admin_listener());
		jb3[2] = new JButton("���");
		jb3[2].addActionListener(new admin_listener());
		jp2[2].add(jb1[2]);
		jp2[2].add(jb2[2]);
		jp2[2].add(jb3[2]);
		//���
		split[1].add(jp2[0],BorderLayout.NORTH);
		split[1].add(jp2[1],BorderLayout.CENTER);
		split[1].add(jp2[2],BorderLayout.SOUTH);	
		jp[1].add(split[1]);
/**		
//3.Ա������		
		jp[2]=new JPanel();
		jp[2].setLayout(new GridLayout(0,2));
	//���
		split[2]=new JPanel();
		split[2].setLayout(new BorderLayout());
		//����
		jp3[0]=new JPanel();
		jl3[0]=new JLabel("��ٱ��");
		jtf3[0]=new JTextField(4);
		jl3[1]=new JLabel("Ա������");
		jtf3[1]=new JTextField(4);
		jl3[2]=new JLabel("���ʱ��");
		jtf3[2]=new JTextField(4);
		jl3[3]=new JLabel("�������");
		jtf3[3]=new JTextField(4);
		jp3[0].add(jl3[0]);
		jp3[0].add(jtf3[0]);
		jp3[0].add(jl3[1]);
		jp3[0].add(jtf3[1]);
		jp3[0].add(jl3[2]);
		jp3[0].add(jtf3[2]);
		jp3[0].add(jl3[3]);
		jp3[0].add(jtf3[3]);
		//���
		jp3[1]=new JPanel();
		dtm[3]=new DefaultTableModel();
		jt[3]=new JTable(dtm[3]);
		title[3] = new Vector();
		data[3] = new Vector();
		header[3] = jt[3].getTableHeader();
		jsp[3] = new JScrollPane(jt[3]);
		jp3[1].add(header[3]);
		jp3[1].add(jsp[3]);
		//����
		jp3[2]=new JPanel();
		jb1[3] = new JButton("��ѯ");
		jb1[3].addActionListener(new admin_listener());
		jb2[3] = new JButton("�޸�");
		jb2[3].addActionListener(new admin_listener());
		jb3[3] = new JButton("���");
		jb3[3].addActionListener(new admin_listener());
		jp3[2].add(jb1[3]);
		jp3[2].add(jb2[3]);
		jp3[2].add(jb3[3]);
		//���
		split[2].add(jp3[0],BorderLayout.NORTH);
		split[2].add(jp3[1],BorderLayout.CENTER);
		split[2].add(jp3[2],BorderLayout.SOUTH);	
		jp[2].add(split[2]);
	//�Ӱ�
		split[3]=new JPanel();
		split[3].setLayout(new BorderLayout());
		//����
		jp4[0]=new JPanel();
		jl4[0]=new JLabel("�Ӱ���");
		jtf4[0]=new JTextField(4);
		jl4[1]=new JLabel("Ա����");
		jtf4[1]=new JTextField(4);
		jl4[2]=new JLabel("�Ӱ�ʱ��");
		jtf4[2]=new JTextField(4);
		jl4[3]=new JLabel("�Ӱ�ʱ��");
		jtf4[3]=new JTextField(4);
		jp4[0].add(jl4[0]);
		jp4[0].add(jtf4[0]);
		jp4[0].add(jl4[1]);
		jp4[0].add(jtf4[1]);
		jp4[0].add(jl4[2]);
		jp4[0].add(jtf4[2]);
		jp4[0].add(jl4[3]);
		jp4[0].add(jtf4[3]);
		//���
		jp4[1]=new JPanel();
		dtm[4]=new DefaultTableModel();
		jt[4]=new JTable(dtm[4]);
		title[4] = new Vector();
		data[4] = new Vector();
		header[4] = jt[4].getTableHeader();
		jsp[4] = new JScrollPane(jt[4]);
		jp4[1].add(header[4]);
		jp4[1].add(jsp[4]);
		//����
		jp4[2]=new JPanel();
		jb1[4] = new JButton("��ѯ");
		jb1[4].addActionListener(new admin_listener());
		jb2[4] = new JButton("�޸�");
		jb2[4].addActionListener(new admin_listener());
		jb3[4] = new JButton("���");
		jb3[4].addActionListener(new admin_listener());
		jp4[2].add(jb1[4]);
		jp4[2].add(jb2[4]);
		jp4[2].add(jb3[4]);
		//���
		split[3].add(jp4[0],BorderLayout.NORTH);
		split[3].add(jp4[1],BorderLayout.CENTER);
		split[3].add(jp4[2],BorderLayout.SOUTH);	
		jp[2].add(split[3]);
*/		
//4.������Ϣ
		jp[3]=new JPanel();
		jp[3].setLayout(new BorderLayout());
		//����
		jp5[0]=new JPanel();
		jl5[0]=new JLabel("ѧ��");
		jtf5[0]=new JTextField(7);
		jl5[1]=new JLabel("ѧ��");
		jtf5[1]=new JTextField(7);
		jl5[2]=new JLabel("ǩ������");
		jtf5[2]=new JTextField(7);


		jp5[0].add(jl5[0]);
		jp5[0].add(jtf5[0]);
		jp5[0].add(jl5[1]);
		jp5[0].add(jtf5[1]);
		jp5[0].add(jl5[2]);
		jp5[0].add(jtf5[2]);


		//���
		jp5[1]=new JPanel();
		dtm[5]=new DefaultTableModel();
		jt[5]=new JTable(dtm[5]);
		title[5] = new Vector();
		data[5] = new Vector();
		header[5] = jt[5].getTableHeader();
		jsp[5] = new JScrollPane(jt[5]);
		jp5[1].add(header[5]);
		jp5[1].add(jsp[5]);
		//����
		jp5[2]=new JPanel();
		jb1[5] = new JButton("��ѯ");
		jb1[5].addActionListener(new admin_listener());
		jb2[5] = new JButton("�޸�");
		jb2[5].addActionListener(new admin_listener());
		jb3[5] = new JButton("���");
		jb3[5].addActionListener(new admin_listener());
		jp5[2].add(jb1[5]);
		jp5[2].add(jb2[5]);
		jp5[2].add(jb3[5]);
		//���
		jp[3].add(jp5[0],BorderLayout.NORTH);
		jp[3].add(jp5[1],BorderLayout.CENTER);
		jp[3].add(jp5[2],BorderLayout.SOUTH);
		
//5.ǩ��
		jp[4]=new JPanel();
		jp[4].setLayout(new GridLayout(0,2));
		JPanel[] split1=new JPanel[2];
	//ǩ����
		split1[0]=new JPanel();
		split1[0].setLayout(new BorderLayout());
		//����
		jp6[0]=new JPanel();
		jl6[0]=new JLabel("ѧ��");
		jtf6[0]=new JTextField(7);
		jl6[1]=new JLabel("��");
		jtf6[1]=new JTextField(7);
		jl6[2]=new JLabel("��");
		jtf6[2]=new JTextField(7);
		jl6[3]=new JLabel("��");
		jtf6[3]=new JTextField(7);
		jp6[0].add(jl6[0]);
		jp6[0].add(jtf6[0]);
		jp6[0].add(jl6[1]);
		jp6[0].add(jtf6[1]);
		jp6[0].add(jl6[2]);
		jp6[0].add(jtf6[2]);
		jp6[0].add(jl6[3]);
		jp6[0].add(jtf6[3]);
		//���
		jp6[1]=new JPanel();
		dtm[6]=new DefaultTableModel();
		jt[6]=new JTable(dtm[6]);
		title[6] = new Vector();
		data[6] = new Vector();
		header[6] = jt[6].getTableHeader();
		jsp[6] = new JScrollPane(jt[6]);
		jp6[1].add(header[6]);
		jp6[1].add(jsp[6]);
		//��ѯ
		jp6[2]=new JPanel();
		jb1[6] = new JButton("��ѯǩ����Ϣ");
		jb1[6].addActionListener(new admin_listener());
		jp6[2].add(jb1[6]);
		sign.addActionListener(new admin_listener());
		jp6[2].add(sign);
		//���
		split1[0].add(jp6[0],BorderLayout.NORTH);
		split1[0].add(jp6[1],BorderLayout.CENTER);
		split1[0].add(jp6[2],BorderLayout.SOUTH);
		jp[4].add(split1[0]);
	//���ڱ�
		split1[1]=new JPanel();
		split1[1].setLayout(new BorderLayout());
		//����
		jp7[0]=new JPanel();
		jl7=new JLabel("ѧ��");
		jtf7=new JTextField(7);
		jp7[0].add(jl7);
		jp7[0].add(jtf7);
		//���
		jp7[1]=new JPanel();
		dtm[7]=new DefaultTableModel();
		jt[7]=new JTable(dtm[7]);
		title[7] = new Vector();
		data[7] = new Vector();
		header[7] = jt[7].getTableHeader();
		jsp[7] = new JScrollPane(jt[7]);
		jp7[1].add(header[7]);
		jp7[1].add(jsp[7]);
		//��ѯ
		jp7[2]=new JPanel();
		jb1[7] = new JButton("��ѯǩ�����");
		jb1[7].addActionListener(new admin_listener());
		jb2[7] = new JButton("�޸�");
		jb2[7].addActionListener(new admin_listener());
		jb3[7] = new JButton("���ǩ����Ϣ");
		jb3[7].addActionListener(new admin_listener());
		jp7[2].add(jb1[7]);
		jp7[2].add(jb2[7]);
		jp7[2].add(jb3[7]);
		//���
		split1[1].add(jp7[0],BorderLayout.NORTH);
		split1[1].add(jp7[1],BorderLayout.CENTER);
		split1[1].add(jp7[2],BorderLayout.SOUTH);
		jp[4].add(split1[1]);
		
		jtp.add("������Ϣ",jp[0]);
		jtp.add("��ַ��Ϣ",jp[1]);
		/**jtp.add("ǩ����ϸ��Ϣ",jp[2]);*/
		jtp.add("����״��",jp[3]);
		jtp.add("ǩ������",jp[4]);
		this.add(jtp);
		
		this.setTitle("�����ϱ�����ϵͳ");
		this.setSize(1000, 600);
		this.setLocation(400, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	

}