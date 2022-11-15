package chex;

public class ArrayTest {
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,6};
		
		int max=intArr[0];
		int indexnum=0;
		
		for(int i=1 ; i<intArr.length ; i++) {
			if(intArr[i]>max) {
				max=intArr[i];		
				indexnum=i;
			}
		}
		
		System.out.println("최대값: "+max+"/ index: "+indexnum);
	}
}

