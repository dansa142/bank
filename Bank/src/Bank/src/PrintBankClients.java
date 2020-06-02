
public class PrintBankClients {

	public static void printAll(Bank bank) {
		for (Client client : bank.getClients()) {
			System.out.println(client);
		}
	}

	public static void printRegular(Bank bank) {
		for (Client client : bank.getClients()) {
			if (client instanceof RegulerClient) {
				System.out.println(client);
			}
		}
	}

	public static void printPrimum(Bank bank) {
		for (Client client : bank.getClients()) {
			if (client instanceof PrimumClient) {
				System.out.println(client);
			}
		}
	}

	public static void printPlatinum(Bank bank) {
		for (Client client : bank.getClients()) {
			if (client instanceof PlatinumClient) {
				System.out.println(client);
			}
		}
	}

	public static void printMinusClients(Bank bank) {
		for (Client client : bank.getClients()) {
			if (client.getBallance() < 0) {
				System.out.println(client);
			}
		}
	}
}
