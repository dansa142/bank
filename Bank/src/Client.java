import java.io.IOException;
import java.sql.SQLException;

public abstract class Client {

	private String name;
	private int accountNumber;
	private int id;
	static int idcounter = 1;
	static int nameCounter = 1;
	protected double ballance;
	protected int commition;
	protected int credit;
	protected double intrestRate;

	public abstract void deposit(int amount) throws IOException, SQLException;

	public abstract void withdrawl(int amount) throws BallanceExeption, IOException, SQLException;

	public Client() {
		this.name = ("cleint no` " + nameCounter);
		nameCounter++;
		this.accountNumber = (int) (Math.random() * 1000000);
		this.id = idcounter;
		idcounter++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBallance() {
		return ballance;
	}

	public void setBallance(double ballance) {
		this.ballance = ballance;
	}

	public int getCommition() {
		return commition;
	}

	public void setCommition(int commition) {
		this.commition = commition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAcountNumber() {
		return accountNumber;
	}

	public void setAcountNumber(int acountNumber) {
		this.accountNumber = acountNumber;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", acountNumber=" + accountNumber + "]";
	}

}
