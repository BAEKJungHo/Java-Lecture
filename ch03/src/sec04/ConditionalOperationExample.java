package sec04;

import java.util.Scanner;
public class ConditionalOperationExample {
	public static void main(String[] args) {
	      int score;
	      Scanner sc = new Scanner(System.in);
	      score = sc.nextInt();
	      char grade = (score > 90) ? 'A' : 
	          ((score > 80) ? 'B' : 
	          (score > 70) ? 'C' : 
	          (score) > 60 ? 'D' : 'F') ;
	      System.out.println(score+"점은" + grade + "등급");

	      sc.close();
	    }
	  }