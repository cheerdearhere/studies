package ch10;

public abstract class Car {
	public abstract void drive();
	public abstract void stop();
	public abstract void wiper();
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	public void turnOff() {
		System.out.println("시동을 끕니다. ");
	}
	public void washingCar() {
		
	}
	//차량/기계 작동시 순서는 중요하기에 final로 선언
	final public void run() {
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
		washingCar();
	}
}
