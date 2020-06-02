import java.io.IOException;
import java.sql.SQLException;

public class BankManager implements Runnable {

	@Override
	public void run() {
		int x = (int) (Math.random() * 2) + 1;
		for (int i = 0; i < 200; i++) {
			int y = 0;
			try {
				y = (int) (Math.random() * (Bank.getInstance().getClients().size() - 1));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (x == 1) {
				try {
					Bank.getInstance().getClients().get(y).withdrawl((int) (Math.random() * 100000));
				} catch (BallanceExeption | IOException | SQLException e) {

					e.getMessage();
				}

			} else {
				try {
					Bank.getInstance().getClients().get(y).deposit((int) (Math.random() * 10000));
				} catch (IOException | SQLException e) {
					e.getMessage();
				}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.getMessage();
			}

		}
	}

}
