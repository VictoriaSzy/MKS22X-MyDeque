import java.util.* ;
import java.io.* ;

public class Calculator {

  public static void main(String[] args) {
      String t1 = "10 2.0 +" ;
      String t2 = "11 3 - 4 + 2.5 *" ;
      String t3 = "8 2 + 99 9 - * 2 + 9 -" ;
      String t4 = "1 2 3 4 5 + * - -" ;
      System.out.println("12.0 ----> " + eval(t1)) ;
      System.out.println("30.0 ----> " + eval(t2)) ;
      System.out.println("893.0 ----> " + eval(t3)) ;
      System.out.println("26.0 ----> " + eval(t4)) ;
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
  }
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
      String operations = "+-/*%" ;
      for (int i = 0 ; i < list.length ; i++) {
        try {
          a.addLast(Double.parseDouble(list[i])) ;
        } catch (NumberFormatException e) {
          Double aa = a.removeLast() ;
          Double bb = a.removeLast() ;
          char o = list[i].charAt(0) ;
          if (o == '+') a.addLast(bb + aa) ;
          else if (o == '-') a.addLast(bb - aa) ;
          else if (o == '/') a.addLast(bb / aa) ;
          else if (o == '*') a.addLast(bb * aa) ;
          else if (o == '%') a.addLast(bb % aa) ;
        }
      }
      return a.getFirst() ;
    }
/*
    public static double operate(double a, double b, String op) {
      if (op.equals("+")) return a + b ;
      if (op.equals("-")) return a - b ;
      if (op.equals("*")) return a * b ;
      if (op.equals("/")) return a / b ;
      if (op.equals("%")) return a % b ;
      return 0.0 ;
      //throw IllegalArgumentException("An IllegalArgumentException was thrown - this should not have happened!") ;
      // might consider throwing an exception but not sure what kind yet
    }*/
}
