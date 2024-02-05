
public class BasketBallTeam {

	String name;
	double salaryInMillions;
	int numberOfWins;
	int numberOfLosses;
	int numberOfChampionships;
	boolean playoffTeam;
	
	public BasketBallTeam(String name, double salaryInMillions, int numberOfWins, int numberOfLosses, int numberOfChampionships,
			boolean playoffTeam) {
		this.name = name;
		this.salaryInMillions = salaryInMillions;
		this.numberOfWins = numberOfWins;
		this.numberOfLosses = numberOfLosses;
		this.numberOfChampionships = numberOfChampionships;
		this.playoffTeam = playoffTeam;
	}

	public double getSalaryInMillions() {
		return salaryInMillions;
	}

	public void setSalaryInMillions(double salaryInMillions) {
		this.salaryInMillions = salaryInMillions;
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	public void setNumberOfLosses(int numberOfLosses) {
		this.numberOfLosses = numberOfLosses;
	}

	public int getNumberOfChampionships() {
		return numberOfChampionships;
	}

	public void setNumberOfChampionships(int numberOfChampionships) {
		this.numberOfChampionships = numberOfChampionships;
	}

	public boolean isPlayoffTeam() {
		return playoffTeam;
	}

	public void setPlayoffTeam(boolean playoffTeam) {
		this.playoffTeam = playoffTeam;
	}

	public String toString(){
		return name;
	}
	
}
