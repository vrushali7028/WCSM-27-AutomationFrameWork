package vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c = add(10000,20);
		System.out.println(c);
	}
	
	public static int add(int a, int b)  //generic
	{
		int sum = a+b;  //action
		return sum;
	}
}
