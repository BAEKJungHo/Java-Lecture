package sec01;

public class GetMessageExample {

    public static void division() throws ArithmeticException {
        int x = 1;
        int y = 0;
        int div = 0;

        div = x / y;
      }

      public static void main(String[] args) {
        try {
          division();
        } catch(ArithmeticException e){
          String message = e.getMessage();
          System.out.println(message);
          System.out.println();
          e.printStackTrace();
        }
      }
    }