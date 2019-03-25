package sec01;

public class TryCatchExample {
    public static void division(int num1, int num2) throws DivisionByZero {
        int x = num1;
        int y = num2;
        int div = 0;

        if((num1 == 0) || (num2 == 0))
          throw new DivisionByZero("0으로 나누면안됨");
        else
          div = x / y;
      }

      public static void main(String[] args) {
        try {
          division(10, 0);
        } catch(Exception e){
          String message = e.getMessage();
          System.out.println(message);
          System.out.println();
          e.printStackTrace();
        }
      }
    }
