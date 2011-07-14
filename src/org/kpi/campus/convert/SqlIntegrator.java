package org.kpi.campus.convert;

import java.sql.ResultSet;
import java.sql.SQLException;



public interface SqlIntegrator {
	
	/**
	 * Executes the given SQL statement that returns some result.
	 * It should be called only after opening connection by openConnection method.
	 * @return
	 * the ResultSet of the result. 
	 **/
	ResultSet executeStatement(String stmt) throws SQLException;
	
	/**
	 * Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement 
	 * or an SQL statement that returns nothing.
	 * It should be called only after opening connection by openConnection method.
	 * @return
	 * either the row count for SQL Data Manipulation Language (DML) statements 
	 * or 0 for SQL statements that return nothing 
	 **/
	int executeUpdate(String stmt) throws SQLException ;
	
	/**
	 * Opens the connection with the database.
	 * @return
	 * if connection established then true else false
	 */
	boolean openConnection();
	
	/**
	 * Closes the connection with the database
	 * @return
	 * if connection closed then true else false
	 */
	boolean closeConnection();
}