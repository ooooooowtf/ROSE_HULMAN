package stage2;

import java.util.HashMap;
import java.util.Scanner;

public class BasketballMain {

	// DONE
	// You will want to add instance variables here to track
	// various objects created as commands are run
	public HashMap<String, Contest> contestMap;
	public HashMap<String, Player> playerMap;

	public static void main(String[] args) {
		BasketballMain simulator = new BasketballMain();
		System.out.println("Welcome to BasketBall.  Enter commands.  Type 'exit' to end.");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {

			String commandLine = scanner.nextLine();
			String result = simulator.handleCommand(commandLine);
			System.out.println(result);
		}

	}

	private String handleCommand(String command) {
		Scanner input = new Scanner(command);
		String commandType = input.next();
		String toReturn = null;

		if (commandType.equals("create-player")) {
			String name = input.next();
			double accuracy = input.nextDouble();
			handleCreatePlayer(name, accuracy);
			toReturn = "Log: player \"" + name + "\" created";
		} else if (commandType.equals("create-contest")) {
			String contestName = input.next();
			int shots = input.nextInt();
			handleCreateContest(contestName, shots);
			toReturn = "Log: contest \"" + contestName + "\" created";
		} else if (commandType.equals("add-player-to-contest")) {
			String playerName = input.next();
			String contestName = input.next();
			handleAddPlayerToContest(playerName, contestName);
			toReturn = "Log: player \"" + playerName + "\" added to contest \"" + contestName + "\"";
		}

		// NEW
		else if (commandType.equals("get-player-best-streak")) {
			String playerName = input.next();
			handleReportBestStreakForPlayer(playerName);
			toReturn = "Log: player \"" + playerName + "\" best streak reported.";
		}

		else if (commandType.equals("get-player-best-percentage")) {
			String playerName = input.next();
			handleReportBestPercentageForPlayer(playerName);
			toReturn = "Log: player \"" + playerName + "\" best percentage reported.";
		}
		//
		else if (commandType.equals("run-contest")) {
			String contestName = input.next();
			handleRunContest(contestName);
			toReturn = "Log: Contest \"" + contestName + "\" was run";
		} else if (commandType.equals("view-contest-report")) {
			String playerName = input.next();
			String contestName = input.next();
			handleViewContestReport(playerName, contestName);
			toReturn = "Log: Viewing report on " + playerName + " in contest: " + contestName;
		} else if (commandType.equals("exit")) {
			input.close();
			System.exit(0);
		} else {
			toReturn = "Unknown command " + commandType;
		}
		input.close();
		return toReturn;
	}

	public BasketballMain() {
		// DONE optionally use this to initialize instance variables
		this.contestMap = new HashMap<>();
		this.playerMap = new HashMap<>();
	}

	public void handleCreatePlayer(String name, double accuracy) {
		// DONE complete this method
		Player player1 = new Player(name, accuracy);
		this.playerMap.put(name, player1);
	}

	public void handleCreateContest(String contestName, int shots) {
		// DONE complete this method
		Contest con = new Contest(contestName, shots);
		this.contestMap.put(contestName, con);
	}

	public void handleAddPlayerToContest(String playerName, String contestName) {
		// DONE complete this method
		this.contestMap.get(contestName).addPlayer(this.playerMap.get(playerName));
	}

	public void handleRunContest(String contestName) {
		// DONE complete this method
		this.getContest(contestName).runContest();
	}

	public void handleViewContestReport(String playerName, String contestName) {
		System.out.println("Reporting Stats for Player: " + playerName + " in Contest: " + contestName);
		System.out.println("Raw Data:   " + handleGetRawData(playerName, contestName));
		System.out.println("Hit Streak: " + handleGetHitStreak(playerName, contestName));
		System.out.println("Percentage: " + handleGetPercentage(playerName, contestName) * 100 + "%");
	}

	public String handleGetRawData(String playerName, String contestName) {
		// DONE complete this method
		Contest con1 = this.getContest(contestName);
		Player pla1 = this.getPlayer(playerName);
		String output = pla1.getRawData(con1);
		if (output == null) {
			return "";
		}
		return output;

	}

	public int handleGetHitStreak(String playerName, String contestName) {
		// DONE complete this method
		Contest con1 = this.getContest(contestName);
		Player pla1 = this.getPlayer(playerName);
		int output = pla1.getHitStreak(con1);
		return output;
	}

	public double handleGetPercentage(String playerName, String contestName) {
		// DONE complete this method
		return this.getPlayer(playerName).getPercentage(this.getContest(contestName));
	}

	// NEW REQUIREMENTS BELOW

	public String handleGetBestStreakContestName(String playerName) {
		// DONE complete this method
		return this.getPlayer(playerName).returnBestStreakContestName();
	}

	public String handleGetBestPercentageContestName(String playerName) {
		// DONE complete this method
		return this.getPlayer(playerName).returnBestPercentageContestName();
	}

	////////////////////////////////////

	// Code that does not require changing
	public void handleReportBestStreakForPlayer(String playerName) {
		String bestGame = handleGetBestStreakContestName(playerName);
		String result = playerName + "'s best streak was in the game \"" + bestGame + "\"";
		result += "\n" + handleGetRawData(playerName, bestGame);
		result += "\nWith " + handleGetHitStreak(playerName, bestGame) + " shots made in a row!";
		System.out.println(result);
	}

	private void handleReportBestPercentageForPlayer(String playerName) {
		String bestGame = handleGetBestPercentageContestName(playerName);
		String result = playerName + "'s best percentage was in the game \"" + bestGame + "\"";
		result += "\n" + handleGetRawData(playerName, bestGame);
		result += "\nWith " + handleGetPercentage(playerName, bestGame) * 100 + "% of shots made!";
		System.out.println(result);
	}

	public Contest getContest(String contestName) {
		return this.contestMap.get(contestName);
	}

	public Player getPlayer(String playerName) {
		return this.playerMap.get(playerName);
	}

}
