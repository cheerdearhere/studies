package ch16.customerService;

public interface Scheduler {
	void sendCallToAgent();
	default void getNextCall() {
		System.out.println("상담전화를 순서대로 대기열에서 가져옵니다.");
	}  

}
