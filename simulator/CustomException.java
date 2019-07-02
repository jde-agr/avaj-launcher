package simulator;

public class CustomException extends Exception {
   public CustomException(String errorMessage) {
       super(errorMessage);
       System.out.println(errorMessage);
   }
}