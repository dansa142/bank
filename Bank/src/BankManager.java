import java.io.IOException;
import java.sql.SQLException;

public class BankManager implements Runnable {

	@Override
	public void run() {
		int x = (int) (Math.random() * 2) + 1;
		for (int i = 0; i < 200; i++) {
			int y = (int) (Math.random() * 99);
			if (x == 1) {
				try {
					Bank.getInstance().getClients().get(y).withdrawl((int) Math.random() * 10000);
				} catch (BallanceExeption | IOException | SQLException e) {

					e.printStackTrace();
				}

			} else {
				try {
					Bank.getInstance().getClients().get(y).deposit((int) Math.random() * 10000);
				} catch (IOException | SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
