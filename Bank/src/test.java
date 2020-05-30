import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

public class test {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		DataBase.initaiateDB();
		Bank bank = Bank.getInstance();
		Client c1 = new RegulerClient(1000.00);
		Client c2 = new PrimumClient(15000.23);
		bank.getClients().add(c1);
		bank.getClients().add(c2);
		Bank.getInstance().getClients().add(new PlatinumClient(-600000.53));
		Bank.getInstance().getClients().add(new RegulerClient(-400));
		bank.getClients().add(new PrimumClient(-45000));

		PrintBankClients.printAll(bank);

		System.out.println("-----------------");

		try {
			c1.withdrawl(10000);
		} catch (BallanceExeption e) {

			System.out.println(e.getMessage());
		}

		c1.deposit(1500);
		try {
			c1.withdrawl(1000);
		} catch (BallanceExeption | IOException e) {
			e.printStackTrace();
		}

		new Thread(new QuarterlyIntrest()).run();

		Collections.sort(bank.getClients(), (cl1, cl2) -> ((cl1.getAcountNumber()) - (cl2.getAcountNumber())));

		System.out.println("-------------------");

		PrintBankClients.printAll(bank);

		System.out.println("-------------------");

		Collections.sort(bank.getClients(), (cl1, cl2) -> (int) ((cl1.getBallance()) - (cl2.getBallance())));

		PrintBankClients.printAll(bank);

		System.out.println("-------------------");

		PrintBankClients.printMinusClients(bank);

	}

}
