package ch11;

public class CalculatorTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		//상속한 Calculator가 Calc 타입을 내포하므로 상속받은 CompleteCalc도 적용
		Calc calc = new CompleteCalc();
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		System.out.println(calc.modulus(num1, num2));
	}

}
