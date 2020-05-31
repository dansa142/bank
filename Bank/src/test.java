import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

public class test {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		DataBase.initaiateDB();
		Bank bank = Bank.getInstance();

		PrintBankClients.printAll(bank);

		System.out.println("-----------------");

		new Thread(new BankManager()).start();

		new Thread(new QuarterlyIntrest()).run();

		Collections.sort(bank.getClients(), (cl1, cl2) -> ((cl1.getAcountNumber()) - (cl2.getAcountNumber())));

		System.out.println("-------------------");

		PrintBankClients.printAll(bank);

		System.out.println("-------------------");

		Collections.sort(bank.getClients(), (cl1, cl2) -> (int) ((cl1.getBallance()) - (cl2.getBallance())));

		for (int i = 0; i < UserRepository.getAllUsers().size(); i++) {
			System.out.println(UserRepository.getAllUsers().get(i));

		}

		PrintBankClients.printAll(bank);
	}

}
