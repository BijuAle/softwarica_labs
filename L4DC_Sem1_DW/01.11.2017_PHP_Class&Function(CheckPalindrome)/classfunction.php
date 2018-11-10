<?php
// PHP Class & method/function

public class PalindromeChecker{

	public function check($a){
		$reverse = array_reverse($a); //array_reverse() is library function

		if ($a===$reverse) {
			echo "Palindrome";
		}else{
			echo "Not Palindrome";
		}
	}

}


$palindromeChecker = new PalindromeChecker();
$palindromeChecker->check(array('R','A','C','E','C', 'A', 'R'));



/*
Java equivalent of above implementation:

public class PalindromeChecker{
	
	public void check(String a){
		String reverse = new StringBuilder(a).reverse().toString(); //StringBuilder is a library class with reverse function
		if(reverse.equals(a)){
			echo "Palindrome";
		}else{
			echo "Not Palindrome";
		}
		
	}

	public static void main(String args[]){
		palindromeChecker = new PalinfromeChecker();
		palindromeChecker.check("RACECAR");
	}

}

*/

?>