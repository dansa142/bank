import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	public static final String url = "jdbc:mysql://localhost:3306/Bank?createDatabaseIfNotExist=TRUE&useTimezone=TRUE&serverTimezone=UTC";
	public static final String username = "root";
	public static final String password = "ThisIsMe7142";

	public static void initaiateDB() throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

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
}
