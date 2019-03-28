import java.util.* ;
import java.io.* ;

public class Calculator {

  public static void main(String[] args) {
    try {
      String t1 = "10 2.0 +" ;
      String t2 = "11 3 - 4 + 2.5 *" ;
      String t3 = "8 2 + 99 9 - * 2 + 9 -" ;
      String t4 = "1 2 3 4 5 + * - -" ;
      System.out.println(eval(t1)) ;
      System.out.println(eval(t2)) ;
      System.out.println(eval(t3)) ;
      System.out.println(eval(t4)) ;
      System.out.println("Welcome to calculator!") ;
      System.out.println("Here is the first String we are going to run:") ;
      String a = "1 1 +" ; // hopefully we can add so we should get 2
      System.out.println("Given: " + a) ;
      System.out.println("Output: " + eval(a)) ;
      String b = "1 1 -" ; // hopefully we can subtract --> 0
      System.out.println("Given: " + b) ;
      System.out.println("Output: " + eval(b)) ;
      String c = "1 6 *" ; // hopefully we can multiply a number by 1 --> 6
      System.out.println("Given: " + c) ;
      System.out.println("Output: " + eval(c)) ;
    } catch (NumberFormatException e) {
      System.out.println("The given String does not provide the appropriate info!") ;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("One or more of the arrays somehow got an index out of bounds!") ;
    } catch (Exception e) {
      System.out.println("There is an exception being thrown but it is not a usual error!") ;
    }
  }
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      Double ans = 0.0 ;
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
<<<<<<< HEAD
      String operations = "+-/*" ;
      for (int i = 0 ; i < list.length ; i++) {
        if (operations.contains(list[i])) {
          double aa = a.removeLast() ;
          double bb = a.removeLast() ;
          a.addLast(operate(bb, aa, list[i])) ;
        }
        else {
          int x = Integer.parseInt(list[i]) ;
          a.addLast((double) x) ;
        }
      }
      return a.getLast() ;
    }
    public static double operate(double a, double b, String op) {
=======
      //String[] ops = new String[list.length - ((list.length / 2) + 1) + 1] ;
      //Double[] vals = new Double[list.length - (list.length / 2)] ;
      int i = 0 ;
      String operations = "+-/*%" ;
      while (i < list.length && !operations.contains(list[i])) {
        // we are finding the values
        int val = Integer.parseInt(list[i]) ;
        //vals[i] = 1.0 * val ;
        //System.out.println("The value being added is: " + val) ;
        a.addLast(1.0 * val) ;
        i++ ;
      }
      while (i < list.length && operations.contains(list[i])) {
        // we are finding all of the operations
        Double b = a.removeLast() ;
        Double aa = a.removeLast() ;
        Double output = operate(aa,b,list[i]) ;
        a.addLast(output) ;
        i++ ;
      }
      return a.getFirst() ; // there should really only be one element left
    }
    public static Double operate(Double a, Double b, String op) {
      // a is really the first value that we get when we read the given from left to right
>>>>>>> c5a4daccec4ab4d28fa773f04e6afbabb8651a41
      if (op.equals("+")) return a + b ;
      if (op.equals("-")) return a - b ;
      if (op.equals("*")) return a * b ;
      if (op.equals("/")) return a / b ;
      if (op.equals("%")) return a % b ;
      return 0.0 ;
      //throw IllegalArgumentException("An IllegalArgumentException was thrown - this should not have happened!") ;
      // might consider throwing an exception but not sure what kind yet
    }
}
