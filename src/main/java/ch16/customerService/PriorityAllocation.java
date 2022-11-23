package ch16.customerService;

public class PriorityAllocation implements Scheduler {


	@Override
	public void sendCallToAgent() {
		System.out.println("고객 등급에 따라 등급이 높은 고객의 상담을 업무능력이 높은 상담원에게 배분합니다. ");
	}

}
