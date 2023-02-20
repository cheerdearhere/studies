package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Question10 {
	public static boolean isNumeric(String s) {
		return s.chars().allMatch(Character::isDigit);
	}
	public static void main(String[] args) {
		StudentList sl=StudentList.getStudentList();
		String response="";
		String name="";
		int score=0;
		int index=0;
		int a=0;
		int b=0;
		int i=0;
		String message="";
		
		Scanner sc = new Scanner(System.in);
		while(i<4) {
			System.out.println((i+1)+"번째 사람 이름: ");
			response=sc.next();
			if(response.trim()=="") {
				System.out.println("입력값이 없습니다.");
				System.exit(1000);
			}
			name=response;
			
			System.out.println(name+"이 받은 점수 입력: ");
			response=sc.next();
			if(!isNumeric(response)) {
				System.out.println("숫자를 입력해주세요");
				System.exit(1000);
			}
			score=Integer.parseInt(response);
			Student10 student = new Student10(name,score);
			sl.addList(student);
			i+=1;
		}
		ArrayList<Student10> studentList = sl.getList();
		for(Student10 s: studentList) {
			message+=(studentList.indexOf(s)+1)+"."+s.getName()+"\n";
		}
		System.out.println(message);
		System.out.println("5.종료");
		
		message="";
		System.out.println("누구와 누구를 대조하시겠습니까(번호)? \n 첫번째 사람 입력: ");
		response=sc.next();
		if(!isNumeric(response)) {
			System.out.println("숫자를 입력해주세요");
			System.exit(1000);
		}
		index=Integer.parseInt(response);
		if(index>5||index<=0) {
			System.out.println("1~5사이의 선택지를 입력해야합니다. ");
			index=sc.nextInt();
		}
		a=index; 
		
		System.out.println("두 번째 사람 입력: ");
		response=sc.next();
		if(!isNumeric(response)) {
			System.out.println("숫자를 입력해주세요");
			System.exit(1000);
		}
		index=Integer.parseInt(response);
		if(index>5||index<=0) {
			System.out.println(" 잘못된 입력입니다. 1~5사이의 선택지를 입력해야합니다. ");
			System.exit(0);
		}else if(index==5&&a==5) {
			System.out.println("5. 종료: 프로그램을 종료합니다.");
			System.exit(0);
		}else if(index==5&&a!=5) {
			System.out.println("잘못된 입력입니다.");
			System.exit(0);
		}
		b=index; 
		
		Student10 ss=new Student10();
		a=a-1;
		ss=sl.getObject(a);
		a=ss.getScore();
		String aName=ss.getName();
		
		b=b-1;
		ss=sl.getObject(b);
		b=ss.getScore();
		String bName=ss.getName();
		
		message="System: ";
		if(a>b) {
			message+=aName+"의 점수가 "+bName+"의 점수보다 더 큽니다!";
		}
		else if(b>a) {
			message+=bName+"의 점수가 "+aName+"의 점수보다 더 큽니다!";
		}
		else if(a==b) {
			message+=aName+"의 점수와 "+bName+"의 점수가 같습니다!";
		}
		System.out.println(message);
	}

}
class Student10 {
	private String name;
	private int score;
	StudentList sl;
	public Student10(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Student10() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public StudentList getStudentList() {
		return sl;
	}
}
class StudentList{
	private ArrayList<Student10> studentList= new ArrayList<Student10>();
	private static StudentList sl= new StudentList();
	private StudentList() {
	}
	public static StudentList getStudentList() {
		return sl;
	}
	public void addList(Student10 student) {
		studentList.add(student);
	}
	public ArrayList<Student10> getList() {
		return studentList;
	}
	public Student10 getObject(int index) {
		return studentList.get(index);
	}
}