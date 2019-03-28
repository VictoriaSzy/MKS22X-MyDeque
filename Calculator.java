public class Calculator {
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
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
      if (op.equals("+")) return a + b ;
      if (op.equals("-")) return a - b ;
      if (op.equals("*")) return a * b ;
      if (op.equals("/")) return a / b ;
      return 0.0 ;
      // might consider throwing an exception but not sure what kind yet
    }
}
