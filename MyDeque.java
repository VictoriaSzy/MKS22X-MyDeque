import java.util.* ;
import java.io.* ;

public class MyDeque<E> {
  private E[] data ;
  private int size, start, end ;

  public static void main(String[] args) {
    System.out.println("************************************************************************************") ;
    MyDeque<Integer> a = new MyDeque<Integer>() ;
    System.out.println("Here is the toString method run on the new MyDeque a: ") ;
    System.out.println(a.toString()) ; // expecting only one null to be printed since it's from start to end
    System.out.println("Here is the entire array (including before/after start and end):\n" + a.toStringFull()) ;
    System.out.println("The size of a should be 0: " + a.size()) ;
    System.out.println("Start (should be 0): " + a.getStartIndex()) ;
    System.out.println("End (should be 0): " + a.getEndIndex()) ;
    a.addFirst(5) ;
    System.out.println("Adding 5 to the beginning: \n" + a.toString()) ;
    a.addFirst(3) ;
    System.out.println("Adding 3 to the beginning: \n" + a.toString()) ;
    a.addLast(1) ;
    System.out.println("Adding 1 to the end: \n" + a.toString()) ;
    a.removeFirst() ;
    System.out.println("We removed the first element: \n" + a.toString()) ;
    a.removeLast() ;
    System.out.println("We removed the last element: \n" + a.toString()) ;
  }
  //// constructors
  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10] ;
    size = 0 ;
    start = 0 ;
    end = 0 ;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity] ;
    size = 0 ;
    start = 0 ;
    end = 0 ;
  }
  public int size() {
    // returning capacity
    //if (size == 0) return 0 ;
    // otherwise we can find the difference
    //return end - start + 1 ;
    return size ;
  }
  /// to String methods
  // {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)
  public String toString() {
    if (size == 0) return "{}" ;
    String res = "{ " ;
    if (start <= end) {
      for (int i = start ; i <= end ; i++) {
        res += data[i] + " " ;
      }
    }
    else {
      for (int i = start ; i < data.length ; i++) {
        res += data[i] + " " ;
      }
      for (int i = 0 ; i <= end ; i++) {
        res += data[i] + " " ;
      }
    }
    return res + "}" ;
  }
  // additional toString method to print out entire array - may include elements before and/or after start and end
  public String toStringFull() {
    String res = "{ " ;
    for (int i = 0 ; i < data.length ; i++) {
      res += data[i] + " " ;
    }
    return res + " }" ;
  }
  // add methods
  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("You can't add null to the beginning!") ;
    }
    if (size == data.length) resize() ;
    if (size == 0) {
      data[start] = element ;
      end = start ;
      size++ ;
      return ;
    }
    start = (start - 1 + data.length) % data.length ;
    data[start] = element ;
    size++ ;
  }
  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("You cannot add null, especially to the end!") ;
    }
    if (size == data.length) resize() ;
    if (size == 0) {
      data[start] = element ;
      end = start ;
      size++ ;
      return ;
    }
    end = (end + 1) % data.length ;
    data[end] = element ;
    size++ ;
  }
  /*@SuppressWarnings("unchecked")
  private void resizeAddFirst(E element) {
    E[] newdata = (E[])new Object[data.length * 2 + 1] ;
    if (start <= end) {
      // this is much more straightforward
      for (int i = 1 ; i < data.length ; i++) {
        // bring previous elements to new data
        newdata[i] = data[i - 1] ;
      }
      newdata[0] = element ;
      size = data.length + 1 ;
      data = newdata ;
      start = 0 ;
      end = size - 1 ;
    }
    else {
      int index = start ;
      for (int i = 1 ; index < data.length ; i++) {
        newdata[i] = data[index] ;
        index++ ;
      }
      index = 0 ;
      for (int i = data.length - start ; index <= end ; i++) {
        newdata[i] = data[index] ;
        index++ ;
      }
      newdata[0] = element ;
      size = data.length + 1 ;
      data = newdata ;
      start = 0 ;
      end = size - 1 ;
    }
  }*/
  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newdata = (E[])new Object[data.length * 2 + 1] ;
    for (int i = start ; i < start + size ; i++) {
      newdata[i - start] = data[i % data.length] ;
    }
    end = size - 1 ;
    start = 0 ;
    /*int index = start ;
    for (int i = 0 ; index < data.length; i++) {
      newdata[i] = data[index] ;
      index++ ;
    }
    index = 0 ;
    int e = 0 ;
    for (int i = data.length - start ; index <= end ; i++) {
      newdata[i] = data[index] ;
      index++ ;
      e = i ;
    }*/
    // final steps
    data = newdata ;
    //start = 0 ;
    //end = e ;
  }
  public E removeFirst() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot remove the first element if there aren't any elements!") ;
    }
    E val = data[start] ; // original value that we will return
    data[start] = null ;
    int dif = start + 1 ;
    start = dif % data.length ;
    size-- ;
    return val ;
  }
  public E removeLast() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot remove the last element if there aren't any elements!") ;
    }
    E val = data[end] ; // original value to be returned
    data[end] = null ;
    int dif = end - 1 + data.length ;
    end = dif % data.length ;
    size-- ;
    return val ;
  }
  // accessor methods
  public E getFirst() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot get the first element because it doesn't exist!") ;
    }
    return data[start] ;
  }
  public E getLast() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot get the last element because it doesn't exist!") ;
    }
    return data[end] ;
  }
  // for beginning of testing
  public int getStartIndex() {
    return start ;
  }
  public int getEndIndex() {
    return end ;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////

}
