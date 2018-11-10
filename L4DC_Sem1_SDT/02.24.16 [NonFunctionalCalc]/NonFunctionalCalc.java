//Non functional calculator

public class NonnFunctionalCalc{
	public static void main(String[]args){

		int one=551359;
		int two=59;
		int add= one+two;
		int sub=one-two;
		int prod=one*two;
		int div=one/two;
		int remainder=one%two;
		int increment=one++;
		int decrement=one--;
		
		System.out.println("The sum is " +add);
		System.out.println("The difference is " +sub);
		System.out.println("The product is " +prod);
		System.out.println("The divison is " +div);	
		System.out.println("The remainder is " +remainder);	
		System.out.println("The increment is " +increment);	
		System.out.println("The decrement is " +decrement);	
		System.out.println("The increment is "+ ++one);		
}
};