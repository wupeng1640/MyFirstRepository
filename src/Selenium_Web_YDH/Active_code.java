package Selenium_Web_YDH;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * @author  ҿ�Ʋ�����
 * @time    2015��12��3��
 * @see     ʵ�ִ�200���Ի������ݿ��ȡ������ֻ�������ֻ�������֤��
 */  
   class DBread {
	public static final String url = "jdbc:mysql://192.168.1.200/platform";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "ydh20130815";
	String tel=null;
	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBread(String tel) {
		this.tel=tel;
		 String sql = "SELECT t.factiveCode FROM platform.t_active_code t "
				+ "WHERE fmobile = "
				+ "'"+tel+"'"              //��sql�����������ѯ
				+ " and  t.factiveStatus=0 ";;
		try {
			Class.forName(name);// ָ����������
			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
			pst = conn.prepareStatement(sql);// ׼��ִ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getActiveCode(String tel) {
		String code = null;
		DBread db1 = null;
		ResultSet ret = null;
		db1  = new DBread(tel);
		//System.out.println(this.sql);
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				code = ret.getString(1); // ��ȡ��һ������
			}// ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;

	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
