package application.standardchartered;

import java.sql.SQLException;

public interface DbService {
	@SuppressWarnings("rawtypes")
	public Object loadFromDb(String connectionDetails, String sql, Class type) throws SQLException;

	public Object saveToDatabase(Object data, String connectionDetails) throws SQLException;

	public void delete(String id, @SuppressWarnings("rawtypes") Class type, String connectionDetails) throws SQLException;
}