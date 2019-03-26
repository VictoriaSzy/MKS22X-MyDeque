import java.util.* ;
import java.io.* ;

public class Calculator {

  public static void main(String[] args) {
    try {
      System.out.println("Welcome to calculator!") ;
      System.out.println("Here is the first String we are going to run:") ;
      String a = "1 1 +" ; // hopefully we can add so we should get 2
      System.out.println("Given: " + a) ;
      System.out.println("Output: " + eval(a)) ;
    } catch (NumberFormatException e) {
      System.out.println("The given String does not provide the appropriate info!") ;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("One or more of the arrays somehow got an index out of bounds!") ;
    } catch (Exception e) {
      System.out.println("There is an exception being thrown but it is not a usual error!") ;
    }
    System.out.println("In conclusion, there shouldn't be any errors.") ;
  }
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      Double ans = 0.0 ;
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
      String[] ops = new String[list.length - ((list.length / 2) + 1) + 1] ;
      //Double[] vals = new Double[list.length - (list.length / 2)] ;
      int i = 0 ;
      String operations = "+-/*" ;
      int numOfValues = 0 ;
      while (i < list.length && !operations.contains(list[i])) {
        // we are finding the values
        int val = Integer.parseInt(list[i]) ;
        //vals[i] = 1.0 * val ;
        System.out.println("The value being added is: " + val) ;
        a.addLast(1.0 * val) ;
        numOfValues++ ;
        i++ ;
      }
      while (i < list.length && operations.contains(list[i])) {
        // we are finding all of the operations
        Double b = a.getLast() ;
        Double aa = a.getLast() ;
        ans += operate(aa,b,list[i]) ;
        i++ ;
      }
      return ans ;
    }
    public static Double operate(Double a, Double b, String op) {
      // a is really the first value that we get when we read the given from left to right
      if (op.equals("+")) return a + b ;
      if (op.equals("-")) return a - b ;
      if (op.equals("*")) return a * b ;
      if (op.equals("/")) return a / b ;
      return 0.0 ;
      // might consider throwing an exception but not sure what kind yet
    }
}
