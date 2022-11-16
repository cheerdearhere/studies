package ch09;

public abstract class Computer {
	// Class having abstract method must be abstract class or Interface.  
	public abstract void display();
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
