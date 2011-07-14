import java.sql.*;


public class MsSqlWorkingExample {

	/**
	 * The example of using the MsSqlIntegrator class.
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SqlIntegrator sql = new MsSqlIntegrator("Oleg-PC\\SQLEXPRESS", "master");
		sql.openConnection();
		ResultSet rs = sql.executeStatement("SELECT name FROM a");
		while ( rs.next() ) {
            String lastName = rs.getString("name");
            System.out.println(lastName);
        }
		sql.closeConnection();
	}

}
