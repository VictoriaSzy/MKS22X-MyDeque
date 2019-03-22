import java.util.* ;
import java.io.* ;

@SuppressWarnings("unchecked")
public class MyDeque<E> {
  private E[] data ;
  private int size, start, end ;

  public static void main(String[] args) {
    System.out.println("************************************************************************************") ;
    MyDeque a = new MyDeque() ;
    System.out.println("Here is the toString method run on the new MyDeque a: ") ;
    System.out.println(a.toString()) ; // expecting only one null to be printed since it's from start to end
    System.out.println("Here is the entire array (including before/after start and end):\n" + a.toStringFull()) ;
    System.out.println("The size of a should be 1: " + a.size()) ;
    System.out.println("Start (should be 0): " + a.getStartIndex()) ;
    System.out.println("End (should be 0): " + a.getEndIndex()) ;
  }
  public MyDeque() {
    data = (E[])new Object[10] ;
    size = 0 ;
    start = 0 ;
    end = 0 ;
  }
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity] ;
    start = 0 ;
    end = 0 ;
  }
  public int size() {
    // returning capacity
    if (size == 0) return 0 ;
    // otherwise we can find the difference
    return end - start ;
  }
  /* {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)
  */
  public String toString() {
    String res = "{ " ;
    for (int i = 0 ; i < end + 1 ; i++) {
      res += data[i] + " " ;
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
  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("You can't add null to the beginning!") ;
    }
    if (size() == 0) {
      // data does not have any elements so that's good!
      data[0] = element ;
      size++ ;
      end++ ;

    }
    start = start - 1 ;
  }
  @SuppressWarnings("unchecked")
  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("You can't add null to the end!") ;
    }
    if (end == data.length - 1) {
      // we have our end at the end of data --> we have to make a new data
      E[] d = (E[])new Object[size() * 2] ;
      for (int i = 0 ; start < end + 1 && i < data.length ; i++) {
        d[i] = data[start] ;
        start++ ;
      }
      data = d ;
      start = 0 ;
    }
    else {
      end++ ;
      data[end] = element ;
    }
  }
  public E removeFirst() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot remove the first element if there aren't any elements!") ;
    }
    start++ ;
    return data[start - 1] ;
  }
  public E removeLast() {
    if (data.length == 0 || size() == 0) {
      throw new NoSuchElementException("You cannot remove the last element if there aren't any elements!") ;
    }
    end-- ;
    return data[end + 1] ;
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

}
