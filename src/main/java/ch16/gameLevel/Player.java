package ch16.gameLevel;

public class Player {
	GameLevel playerLevel = new BeginnerLevel();
	
	public void play(int i) {
		playerLevel.go(i);
	}
	public void upgradeLevel(AdvancedLevel level) {
		playerLevel = new AdvancedLevel();
		playerLevel.showLevelmessage();
	}
	public void upgradeLevel(SuperLevel level) {
		playerLevel = new SuperLevel();
		playerLevel.showLevelmessage();
	}
}
