/**
 *
 * @author dominikadzawislak
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Shelter {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@...";
	static final String USERNAME = "...";
	static final String PASSWORD = "...";
	static Connection connection = null;

	public static void main(String[] args) {
		Shelter shelter = new Shelter();
		LoginForm.init();

	}

	public void DBUtilities() throws SQLException {
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void ExecuteSQLStatement(String sql_stmt) {

		Connection connection = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			System.out.println("Creating statement...");
			stmt = connection.createStatement();
			stmt.executeUpdate(sql_stmt);
		} catch (SQLException se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(null, " " + se, "Invalid data", JOptionPane.ERROR_MESSAGE);
			String string = se.getMessage();
			String[] parts = string.split(":");
			String part2 = parts[1];
			JOptionPane.showMessageDialog(null, " " + part2, "Invalid data", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}

	}

}