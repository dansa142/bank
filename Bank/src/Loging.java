import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loging {

	public static void recored(Client client, int x, double amount) throws IOException {

		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/Y hh:mm a");

		File file = new File("C:\\Users\\97254\\Desktop\\java full stack corse\\JavaProjects\\bank folder\\"
				+ client.getAcountNumber() + ".txt");
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		switch (x) {
		case 0:
			bufferedWriter.write(
					dateFormat.format(today) + "- Withdrawl amount: " + amount + "Ballance: " + client.getBallance());
			bufferedWriter.newLine();
			bufferedWriter.close();
			break;

		case 1:
			bufferedWriter.write(
					dateFormat.format(today) + "- Deposite amount: " + amount + "Ballance: " + client.getBallance());
			bufferedWriter.newLine();
			bufferedWriter.close();
			break;

		case 2:
			bufferedWriter.write(dateFormat.format(today) + "- Quarterly Intrest fees for ballance minus: "
					+ String.format("%15.2f", amount) + " Updated ballance: " + client.getBallance());
			bufferedWriter.newLine();
			bufferedWriter.close();
			break;

		default:
			break;
		}
	}

	public static void exportBankClient(Client client) throws IOException {
		File file = new File(
				"C:\\Users\\97254\\Desktop\\java full stack corse\\JavaProjects\\bank folder\\Bank Client List.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		bufferedWriter.write(client.toString());
		bufferedWriter.newLine();
		bufferedWriter.close();
	}
}
