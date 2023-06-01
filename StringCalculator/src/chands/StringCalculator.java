package chands;
import java.util.*;

/*
 * ITERATION 1 OF A STRING CALCULATOR, IMPLEMENTS BASIC CALCULATIONS USING A STRING INPUT BY THE USER
 * WILL ALSO INPUT MULTIPLE OPERATORS 
 */


public class StringCalculator {
	private static Stack<Double> strList = new Stack<Double>();
	private static String strValue;
	private static String operator;
	private static String strOne;
	private static double res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		
		strValue = "";
		operator="";
		System.out.println("Basic Calculator:");
		System.out.println("Available operators are: +, -, /, *");
		System.out.println("Only one operator is available at a time!");
		System.out.println("Avoid using spaces, input as 3+3, 5/5 etc:");
		
		System.out.println("------------------------------");
		
		System.out.println("Input values to calculate:");
		
		strOne = scan.next();
		
		//catches any alphabet strings added in the equation
		while(strOne.matches(".*[a-zA-Z].*") || strOne.startsWith(".*[\sa-zA-Z].*"))
		{
			System.out.println("Try Again!");
			strOne = scan.next();
		}
		
		
		//System.out.println(strOne);
		
		//checks if string contains operations and makes sure the equation is over a certain length
		if(strOne.contains("+") && strOne.length() > 2) { 
			operator = "+";
		}else if(strOne.contains("-") && strOne.length() > 2) { 
			operator = "-";
		}else if(strOne.contains("/") && strOne.length() > 2) { 
			operator = "/";
		}else if(strOne.contains("*") && strOne.length() > 2) { 
			operator = "*";
		}
		
		switch(operator) {
		case "+":
			
			//breaks down the string into stacks which can later be used apply the equations
			Calculator(operator);
			
			//gets the first element in the stack and adds it to the next element in the stack
			for(int i =1; i <= strList.size()-1 ; i++) res += strList.elementAt(i);
			
			break;
		case "-":
			Calculator(operator);
			
			//gets the first element in the stack and adds it to the next element in the stack
			for(int i =1; i <= strList.size()-1 ; i++) res -= strList.elementAt(i);
		
			break;
		case "/":
			Calculator(operator);
			
			//gets the first element in the stack and adds it to the next element in the stack
			for(int i =1; i <= strList.size()-1 ; i++) res /= strList.elementAt(i);
			
			break;
		case "*":
			Calculator(operator);
			
			//gets the first element in the stack and adds it to the next element in the stack
			for(int i =1; i <= strList.size()-1 ; i++) res *= strList.elementAt(i);
			
			break;
		default:
			System.out.println("INVALID STRING"); //if the string doesn't contain any of the following operators, output message
		}

		//output result
		System.out.println("OUTPUT: " +res);
	}

	private static void Calculator(String operator) {
		// TODO Auto-generated method stub
		for(int i=0, j=1; i < strOne.length(); i++)
		{
			char c = strOne.charAt(i);
			char d = strOne.charAt(j);
			
			//checks if first position is a number, if so, add to string variable
			if(Character.isDigit(c)) {
				strValue += c;
				
			}else if(Character.toString(c).equals(".")) //if it contains a decimal point, do the same
			{
				strValue += c;
			}

			
			try {
				
				if(Character.toString(c).equals("+") || Character.toString(c).equals("-") || Character.toString(c).equals("/") //if the string contains one of the following numerators
					|| Character.toString(c).equals("*") || i == strOne.length()-1)
				{
					
					//push to the stack
					
					strList.push(Double.parseDouble(strValue));
					strValue=""; //clear the string value
				}
			}catch(NumberFormatException e) {}//catches any string that try to be added to the stack
			
		}
		
		//gets the first elemnt in the array and store in the global variable, added here to avoid repeating code
		res = strList.elementAt(0);		

	}
	

}
