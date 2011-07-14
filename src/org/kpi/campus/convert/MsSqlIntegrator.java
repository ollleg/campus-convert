import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MsSqlIntegrator implements SqlIntegrator {
	private String hostName;
	private String dbName;

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
		String connectionUrl = "jdbc:sqlserver://"+hostName+";database="+dbName+";integratedSecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl);
		ResultSet rs;
		Statement statement = con.createStatement();
        rs = statement.executeQuery(stmt);
        con.close();
		return rs;
	}

	@Override
	public int executeUpdate(String stmt) throws SQLException {
		String connectionUrl = "jdbc:sqlserver://"+hostName+";database="+dbName+";integratedSecurity=true;";
		Connection con = DriverManager.getConnection(connectionUrl);
		int res;
		Statement statement = con.createStatement();
        res = statement.executeUpdate(stmt);
        con.close();
		return res;
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
}
