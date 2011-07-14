import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MsSqlIntegrator implements SqlIntegrator {
	private String hostName;
	private String dbName;
	private Connection con;

	public MsSqlIntegrator(String serverHostName, String databaseName) {
		super();
		hostName = serverHostName;
		dbName = databaseName;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("MsSql jdbc driver not found. You should install it first.");
		}
	}

	@Override
	public ResultSet executeStatement(String stmt) throws SQLException {
		Statement statement = con.createStatement();
		return statement.executeQuery(stmt);
	}

	@Override
	public int executeUpdate(String stmt) throws SQLException {
		Statement statement = con.createStatement();
		return statement.executeUpdate(stmt);
	}


	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public boolean openConnection() {
		String connectionUrl = "jdbc:sqlserver://"+hostName+";database="+dbName+";integratedSecurity=true;";
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
