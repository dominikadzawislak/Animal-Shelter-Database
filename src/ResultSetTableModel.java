/**
 *
 * @author dominikadzawislak
 */
import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	static final String DB_URL = "jdbc:oracle:thin:@..";
	static final String USERNAME = "...";
	static final String PASSWORD = "...";

	private boolean connectedToDatabase = false;

	private void SetDatabaseURL() throws SQLException {
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException sex) {
			System.out.println(sex.getMessage());
		}
	}

	public ResultSetTableModel(String query) throws SQLException {

		SetDatabaseURL();
		connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		connectedToDatabase = true;

		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		resultSet = statement.executeQuery(query);
		metaData = resultSet.getMetaData();
		resultSet.last();
		numberOfRows = resultSet.getRow();

		fireTableStructureChanged();

	}

	@Override
	public Class getColumnClass(int column) throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			String className = metaData.getColumnClassName(column + 1);
			return Class.forName(className);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return Object.class;
	}

	@Override
	public int getColumnCount() throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			return metaData.getColumnCount();
		} catch (SQLException sex) {
			System.out.println(sex.getMessage());
		}

		return 0;
	}

	@Override
	public String getColumnName(int column) throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sex) {
			System.out.println(sex.getMessage());
		}

		return "";
	}

	@Override
	public int getRowCount() throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		return numberOfRows;
	}

	@Override
	public Object getValueAt(int row, int column) throws IllegalStateException {
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}

		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		} catch (SQLException sex) {
			System.out.println(sex.getMessage());
		}

		return "";
	}

	public void disconnectFromDatabase() {
		if (connectedToDatabase) {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sex) {
				System.out.println(sex.getMessage());
			} finally {
				connectedToDatabase = false;
			}
		}
	}
}
