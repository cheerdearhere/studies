package ch09;

public class Desktop extends Computer{
	public void display() {
		System.out.println("Desktop display");
	}
	public void typing() {
		System.out.println("Desktop typing");
	}
	@Override
	public void turnOn() {
		System.out.println("Desktop turn on");
	}
	@Override
	public void turnOff() {
		System.out.println("Desktop turn off");
	}
	
}
