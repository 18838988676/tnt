package cn.com.test.getField;

import static org.junit.Assert.*;

import org.apache.solr.client.solrj.beans.Field;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

	public static void main3(String[] args) {
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			if (tableName.endsWith("registertype")) {
				List<String> aa = getColumnNames(tableName);
				List<String> dd = getColumnTypes(tableName);
				for (String string : dd) {
					System.out.println(string);
				}
				System.out.println(" <entity name=\"" + tableName
						+ "\" query=\"select * from " + tableName
						+ " where id='${}'\">");
				for (String string : aa) {
					System.out.println(" <field name=\"" + string
							+ "\" column=\"" + string + "\"/>");

				}
				System.out.println(" </entity>");

			}
		}
	}

	//
	public static void main1(String[] args) {
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			List<String> ifdes = getColumnTypes(tableName);

			if (tableName.endsWith("registertype")) {
				List<String> aa = getColumnNames(tableName);
				for (int i = 0; i < aa.size(); i++) {
					if (ifdes.get(i).endsWith("INT")) {
						System.out
								.println("  <field name=\""
										+ aa.get(i)
										+ "\" type=\"amyint\" indexed=\"true\" stored=\"true\"/>");
					} else if (ifdes.get(i).endsWith("DATE")) {
						System.out
								.println("  <field name=\""
										+ aa.get(i)
										+ "\" type=\"amydate\" indexed=\"true\" stored=\"true\"/>");
					} else if (ifdes.get(i).endsWith("VARCHAR")) {
						System.out
								.println("  <field name=\""
										+ aa.get(i)
										+ "\" type=\"amyString\" indexed=\"true\" stored=\"true\"/>");
					} else if (ifdes.get(i).endsWith("DECIMAL")) {
						System.out
								.println("  <field name=\""
										+ aa.get(i)
										+ "\" type=\"amydouble\" indexed=\"true\" stored=\"true\"/>");
					} else if (ifdes.get(i).endsWith("DATETIME")) {
						System.out
								.println("  <field name=\""
										+ aa.get(i)
										+ "\" type=\"amydate\" indexed=\"true\" stored=\"true\"/>");
					} else {
						System.out.println("no:" + aa.get(i) + ifdes.get(i));
					}

				}

			}
		}
	}

	// 得到字段 @Field
	public static void main(String[] args) {
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			List<String> ifdes = getColumnTypes(tableName);

			if (tableName.endsWith("registertype")) {
				System.out.println("tableName:" + tableName);
				List<String> aa = getColumnNames(tableName);
				for (int i = 0; i < aa.size(); i++) {

					if (ifdes.get(i).endsWith("INT")) {
						System.out.println("	@Field(\"" + aa.get(i) + "\")");
						System.out.println("	private  Integer " + aa.get(i)
								+ ";");
					} else if (ifdes.get(i).endsWith("VARCHAR")) {
						System.out.println("	@Field(\"" + aa.get(i) + "\")");
						System.out.println("	private  String " + aa.get(i)
								+ ";");
					} else if (ifdes.get(i).endsWith("DECIMAL")) {
						System.out.println("	@Field(\"" + aa.get(i) + "\")");
						System.out.println("	private  BigDecimal " + aa.get(i)
								+ ";");
					} else if (ifdes.get(i).endsWith("DATETIME")) {
						System.out.println("	@Field(\"" + aa.get(i) + "\")");
						System.out.println("	private  Date " + aa.get(i) + ";");

					}

				}

			}
		}
	}

	// 得到高亮设置字段

	// 得到字段 @Field
	@Test
	public void getHi() {
		List<String> tableNames = getTableNames();
		for (String tableName : tableNames) {
			if (tableName.endsWith("registertype")) {
				System.out.println("tableName:" + tableName);
				List<String> fields = getColumnNames(tableName);
				for (int i = 0; i < fields.size(); i++) {
					System.out
							.println("                solrQuery.addHighlightField(\""									+ fields.get(i) + "\");");
				}

			}
		}
	}

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tnt";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static final String SQL = "SELECT * FROM ";// 数据库操作

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
		}
	}

	/**
	 * 获取数据库连接
	 *
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	/**
	 * 获取数据库下的所有表名
	 */
	public static List<String> getTableNames() {
		List<String> tableNames = new ArrayList<>();
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			// 获取数据库的元数据
			DatabaseMetaData db = conn.getMetaData();
			// 从元数据中获取到所有的表名
			rs = db.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				tableNames.add(rs.getString(3));
			}
		} catch (SQLException e) {
		} finally {
			try {
				rs.close();
				closeConnection(conn);
			} catch (SQLException e) {
			}
		}
		return tableNames;
	}

	/**
	 * 获取表中所有字段名称
	 * 
	 * @param tableName
	 *            表名
	 * @return
	 */
	public static List<String> getColumnNames(String tableName) {
		List<String> columnNames = new ArrayList<>();
		// 与数据库的连接
		Connection conn = getConnection();
		PreparedStatement pStemt = null;
		String tableSql = SQL + tableName;
		try {
			pStemt = conn.prepareStatement(tableSql);
			// 结果集元数据
			ResultSetMetaData rsmd = pStemt.getMetaData();
			// 表列数
			int size = rsmd.getColumnCount();
			for (int i = 0; i < size; i++) {
				columnNames.add(rsmd.getColumnName(i + 1));
			}
		} catch (SQLException e) {
		} finally {
			if (pStemt != null) {
				try {
					pStemt.close();
					closeConnection(conn);
				} catch (SQLException e) {
				}
			}
		}
		return columnNames;
	}

	/**
	 * 获取表中所有字段类型
	 * 
	 * @param tableName
	 * @return
	 */
	public static List<String> getColumnTypes(String tableName) {
		List<String> columnTypes = new ArrayList<>();
		// 与数据库的连接
		Connection conn = getConnection();
		PreparedStatement pStemt = null;
		String tableSql = SQL + tableName;
		try {
			pStemt = conn.prepareStatement(tableSql);
			// 结果集元数据
			ResultSetMetaData rsmd = pStemt.getMetaData();
			// 表列数
			int size = rsmd.getColumnCount();
			for (int i = 0; i < size; i++) {
				columnTypes.add(rsmd.getColumnTypeName(i + 1));
			}
		} catch (SQLException e) {
		} finally {
			if (pStemt != null) {
				try {
					pStemt.close();
					closeConnection(conn);
				} catch (SQLException e) {
				}
			}
		}
		return columnTypes;
	}

	/**
	 * 获取表中字段的所有注释
	 * 
	 * @param tableName
	 * @return
	 */
	public static List<String> getColumnComments(String tableName) {
		List<String> columnTypes = new ArrayList<>();
		// 与数据库的连接
		Connection conn = getConnection();
		PreparedStatement pStemt = null;
		String tableSql = SQL + tableName;
		List<String> columnComments = new ArrayList<>();// 列名注释集合
		ResultSet rs = null;
		try {
			pStemt = conn.prepareStatement(tableSql);
			rs = pStemt.executeQuery("show full columns from " + tableName);
			while (rs.next()) {
				columnComments.add(rs.getString("Comment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
					closeConnection(conn);
				} catch (SQLException e) {
				}
			}
		}
		return columnComments;
	}

}

// <field name="age" type="text_ik" indexed="true" stored="true"/>