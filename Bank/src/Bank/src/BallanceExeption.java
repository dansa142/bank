
public class BallanceExeption extends Exception {

	public BallanceExeption(Client client) {
		super("Sorry, " + client.getName() + ", your ballance is : " + client.getBallance() + ".\n"
				+ "This withdrawl will exceed your credit balance of: " + Math.abs(client.getCredit()) + ".\n"
				+ "You can withdrawl an amount up to:"
				+ (client.getBallance() - (client.getCredit() + client.getCommition())));

	}

}
