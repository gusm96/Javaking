package payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1621:xe";
		String user = "scott";
		String password = "tiger";

		return DriverManager.getConnection(jdbcUrl, user, password);
	}
}