import java.io.IOException;
import java.sql.SQLException;

public class QuarterlyIntrest extends Thread {

	public void run() {
		double temp;
		double amount;
		for (int i = 0; i < 4; i++) {
			for (Client client : Bank.getInstance().getClients()) {
				if (client.getBallance() < 0) {
					temp = client.getBallance() - Math.abs((client.getBallance() * client.getIntrestRate()) / 100);
					client.setBallance(temp);
					amount = Math.abs((client.getBallance() * client.getIntrestRate()) / 100);
					try {
						Loging.recored(client, 2, amount);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						UserRepository.updateUser(client);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
