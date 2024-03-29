package ch16.gameLevel;

public class AdvancedLevel implements GameLevel {

	@Override
	public void go(int i) {
		run();
		jump(i);
		turn();
	}

	@Override
	public void run() {
		System.out.println("빨리 달립니다.");
	}

	@Override
	public void jump(int i) {
		for(int j=0 ; j<i ; j++) {
			System.out.println("높이 jump 합니다.");
		}
	}

	@Override
	public void turn() {
		System.out.println("turn 못하지롱");
	}

	@Override
	public void showLevelmessage() {
		System.out.println("****** 중급자 레벨입니다 ******");
	}

}
