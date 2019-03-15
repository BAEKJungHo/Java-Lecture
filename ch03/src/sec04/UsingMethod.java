package sec04;

public class UsingMethod {
    public static int add(int num1, int num2){
      return num1 + num2;
    }
    public static void main(String[] args){
      UsingMethod sum = new UsingMethod();
      System.out.println(sum.add(10, 10));
    }
  }