package ch16.customerService;

public class LeastJob implements Scheduler {

	@Override
	public void sendCallToAgent() {
		System.out.println("쉬고있거나 통화수가 가작 적은 상담원에게 배분합니다. ");
	}

}
