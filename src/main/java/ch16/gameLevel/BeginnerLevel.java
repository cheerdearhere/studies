package ch16.gameLevel;

public class BeginnerLevel implements GameLevel {

	@Override
	public void go(int i) {
		showLevelmessage();
		run();
		jump(i);
		turn();
	}

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump(int i) {
		System.out.println("jump 못하지롱");
	}

	@Override
	public void turn() {
		System.out.println("turn 못하지롱");
	}

	@Override
	public void showLevelmessage() {
		System.out.println("****** 초급자 레벨입니다 ******");
	}

}
