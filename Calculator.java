public class Calculator {
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
      int i = 0 ;
      String operations = "+-/*" ;
      while (i < list.length && !operations.contains(list[i])) {
        int val = Integer.parseInt(list[i]) ;
        a.addFirst(1.0 * val) ;
      }
    }
}
