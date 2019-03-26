public class Calculator {
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s) {
      MyDeque<Double> a = new MyDeque<Double>() ;
      String[] list = s.split(" ") ;
      String[] ops = new String[list.length - ((list.length / 2) + 1) + 1] ;
      int i = 0 ;
      String operations = "+-/*" ;
      while (i < list.length && !operations.contains(list[i])) {
        // we are finding the values
        int val = Integer.parseInt(list[i]) ;
        System.out.println("The value being added is: " + val) ;
        a.addLast(1.0 * val) ;
      }
      int x = 0 ;
      while (i < list.length && operations.contains(list[i])) {
        // we are finding all of the operations
        ops[x] = list[i] ;
      }
      for (String op : ops) {

      }
    }
    public static Double operate(Double a, Double b, String op) {
      if (op.equals("+")) return a + b ;
      if (op.equals("-")) return a - b ;
      if (op.equals("*")) return a * b ;
      if (op.equals("/")) return a / b ;
      return 0.0 ;
      // might consider throwing an exception but not sure what kind yet
    }
}
