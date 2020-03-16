package pkh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {
	
		Connection conn;
	    Statement st;

	    private static String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    private static String connStr = "jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统";
	    private static String dbusername = "sa";
	    private static String dbpassword = "mxd980302";
	    
	    public connect(){}
		
		/* 获取数据库连接的函数*/
		public static Connection getConnection() {
			Connection con = null;	//创建用于连接数据库的Connection对象
			try {
				Class.forName(driverStr);// 加载sql server数据驱动
			//	System.out.println("ok");
				con = DriverManager.getConnection(
						connStr,dbusername,dbpassword);// 创建数据连接
				
			} catch (Exception e) {
				System.out.println("数据库连接失败" + e.getMessage());
			}
			return con;	//返回所建立的数据库连接
		}
}