import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	private static final String url = "jdbc:mysql://localhost:3306/Bank?createDatabaseIfNotExist=TRUE&useTimezone=TRUE&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "ThisIsMe7142";

	public static void initaiateDB() throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());

			String sql = "CREATE TABLE Bank.clients" + "(ID INT PRIMARY KEY NOT NULL, " + "ClientRank VARCHAR(20) NOT NULL, "
					+ "NAME VARCHAR(20) NOT NULL, " + "AcountNumber INT NOT NULL, " + "Ballance DOUBLE NOT NULL)";

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}

	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
}
