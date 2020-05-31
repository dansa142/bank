import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
	static Random random = new Random();

	private static Bank instance = null;
	private String name;
	private List<Client> clients;

	private Bank(String name) throws SQLException {
		this.name = name;
		List<Client> clients = new ArrayList<Client>();
		if (UserRepository.getAllUsers() == null) {
			for (int i = 0; i < 99; i++) {
				clients.add(clientMaker());
			}
		} else {
			clients = UserRepository.getAllUsers(); 
		}
		
		
		setClients(clients);
	}

	public static Bank getInstance() throws SQLException {
		if (instance == null) {
			synchronized (Bank.class) {
				if (instance == null) {
					instance = new Bank("Dan`s Bank");
				}
			}
		}

		return instance;
	}

	public static void setInstance(Bank instance) {
		Bank.instance = instance;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Client clientMaker() {
		int i = random.nextInt(3);
		switch (i) {
		case 0:
			return new RegulerClient();

		case 1:
			return new PrimumClient();

		case 2:
			return new PlatinumClient();

		default:
			break;
		}
		return null;

	}

	@Override
	public String toString() {
		return "Bank [name=" + name + "]";
	}

}
