package sec01;

public class ThrowsExample {

    public static void division() throws ArithmeticException {
        int x = 1;
        int y = 1;
        int div = 0;

        div = x / y;
      }

      public static void main(String[] args) {
        try {
          division();
          throw new ArithmeticException();
        } catch(ArithmeticException e){
          System.out.println("0으로 나누면 안됩니다.");
        }
      }
    }