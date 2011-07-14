import java.sql.ResultSet;
import java.sql.SQLException;


public interface SqlIntegrator {
	
	/**
	 * Executes the given SQL statement that returns some result.
	 * @return
	 * the ResultSet of the result. 
	 **/
	ResultSet executeStatement(String stmt) throws SQLException;
	
	/**
	 * Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement 
	 * or an SQL statement that returns nothing.
	 * @return
	 * either the row count for SQL Data Manipulation Language (DML) statements 
	 * or 0 for SQL statements that return nothing 
	 **/
	int executeUpdate(String stmt)throws SQLException ;
}