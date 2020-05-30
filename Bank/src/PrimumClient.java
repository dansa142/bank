import java.io.IOException;
import java.sql.SQLException;

public class PrimumClient extends Client {

	private double ballance;
	private static final int commition = 5;
	private static final int credit = -100000;
	private static final double intrestRate = 5.0;

	public PrimumClient() {
		this.ballance = Math.random() * 1000000;
		try {
			Loging.exportBankClient(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			UserRepository.insertUser(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public PrimumClient(double ballance) {
		this.ballance = ballance;
		try {
			Loging.exportBankClient(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			UserRepository.insertUser(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCommition() {
		return commition;
	}

	public double getBallance() {
		return ballance;
	}

	public void setBallance(double ballance) {
		this.ballance = ballance;
	}

	public int getCredit() {
		return credit;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	public void withdrawl(int amount) throws BallanceExeption, IOException, SQLException {
		double check = 0;
		check = (getBallance() - (amount + commition));
		if (check >= credit) {
			setBallance(check);
			Loging.recored(this, 0, amount);
			UserRepository.updateUser(this);
		} else {
			throw new BallanceExeption(this);
		}

	}

	public void deposit(int amount) throws IOException, SQLException {
		setBallance(ballance + (amount - commition));
		Loging.recored(this, 1, amount);
		UserRepository.updateUser(this);
	}

	@Override
	public String toString() {
		return "Primum Client   / Name: " + String.format("%14s", getName()) + "; Acount number: "
				+ String.format("%08d", getAcountNumber()) + "; Ballance: " + String.format("%12.2f", ballance);
	}

}
