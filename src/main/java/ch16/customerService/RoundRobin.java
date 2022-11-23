package ch16.customerService;

public class RoundRobin implements Scheduler {


	@Override
	public void sendCallToAgent() {
		System.out.println("다음 순서의 상담원에게 배분합니다. ");
	}

}
