import java.io.IOException;
import java.sql.SQLException;

public class PrimumClient extends Client {

	private double ballance;
	private String rank;
	private static final int commition = 5;
	private static final int credit = -1000000;
	private static final double intrestRate = 5.0;

	public PrimumClient() {
		this.rank = "Primum Client";
		int x = (int) (Math.random() * 4) + 1;
		if (x <= 3) {
			this.ballance = Math.random() * 1000000;
		} else {
			this.ballance = Math.random() * -50000;
		}
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
		this.rank = "Primum Client";
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

	
	public PrimumClient(String name, int acountNumber, int id, String rank, double ballance) {
		super(name, acountNumber, id, rank, ballance);
		// TODO Auto-generated constructor stub
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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
