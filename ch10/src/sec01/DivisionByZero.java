package sec01;

public class DivisionByZero extends Exception {
    public DivisionByZero() { }
    public DivisionByZero(String message){
      super(message);
    }
  }