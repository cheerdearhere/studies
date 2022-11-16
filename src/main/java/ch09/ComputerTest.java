package ch09;

public class ComputerTest {

	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		Computer computer = new Desktop();
		computer.display();
		desktop.turnOff();
	}

}
