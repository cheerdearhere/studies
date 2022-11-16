package ch10;

public class AICar extends Car{

	@Override
	public void drive() {
		System.out.println("자율주행을 합니다.");
		System.out.println("자동차가 스스로 방향을 바꿉니다.");
	}

	@Override
	public void stop() {
		System.out.println("장애물 앞에서 스스로 멈춥니다.");
	}

	@Override
	public void wiper() {
		System.out.println("비를 감지해 와이퍼를 작동합니다. ");
	}
	
	@Override
	public void washingCar() {
		System.out.println("하차가 확인되면 자동세척기능을 수행합니다.");
	}

}
