import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	public static void insertUser(Client client) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DataBase.url, DataBase.username, DataBase.password);
			String sql = "INSERT INTO `Bank`.`clients` (ID, NAME , AcountNumber, Ballance) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, client.getId());
			statement.setString(2, client.getName());
			statement.setInt(3, client.getAcountNumber());
			statement.setDouble(4, client.getBallance());

			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			connection.close();
		}

	}

	public static void updateUser(Client client) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DataBase.url, DataBase.username, DataBase.password);
			String sql = "UPDATE `bank`.`clients` SET NAME=?, AcountNumber=?, Ballance=? WHERE ID=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, client.getName());
			statement.setInt(2, client.getAcountNumber());
			statement.setDouble(3, client.getBallance());
			statement.setInt(4, client.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}

	}

	public static void deleteUser(int id) throws SQLException {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(DataBase.url, DataBase.username, DataBase.password);

			String sql = "DELETE from bank.clients where id=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}

	}

	public static List<Client> getAllUsers() throws SQLException {

		List<Client> clientsTable = new ArrayList<Client>();
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(DataBase.url, DataBase.username, DataBase.password);

			String sql = "SELECT * from bank.clients";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int AcountNumber = resultSet.getInt(3);
				double ballance = resultSet.getDouble(4);
				clientsTable.add(Client(id, name, AcountNumber, ballance));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
		return clientsTable;

	}

	private static Client Client(int id, String name, int acountNumber, double ballance) {
		return null;
	}

}
