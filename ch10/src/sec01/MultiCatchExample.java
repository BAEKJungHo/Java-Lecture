package sec01;

import java.util.Scanner;
public class MultiCatchExample {
    public static void main(String[] args) {
        int div = 0;
        Scanner scan = new Scanner(System.in);
        try{
          System.out.print("숫자 2개를 입력하세요 : ");
          int num1 = Integer.parseInt(scan.nextLine());
          int num2 = Integer.parseInt(scan.nextLine());

          if(num1 > num2) {
            div = num1 / num2;
          } else if(num2 > num1) {
            div = num2 / num1;
          }
      } catch(NumberFormatException | ArithmeticException e) {
        System.out.println("0으로 나눌 수 없습니다 / 숫자로 변환가능한 문자열을 입력하세요!");
      } catch(Exception e) {
    	  System.out.println("ERROR");
      }
     }
    }