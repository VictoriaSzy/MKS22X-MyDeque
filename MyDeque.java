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
  }
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
    if (size == 0) return 0 ;
    // otherwise we can find the difference
    return end - start + 1 ;
  }
  /* {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)
  */
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

  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("You can't add null to the beginning!") ;
    }
    if (size() == 0) {
      // data does not have any elements so that's good!
      data[0] = element ;
      size++ ;
      start = 0 ;
      end = 0 ;
    }
    else if (size < data.length && start == 0) {
      // we are adding to data which has space but already has an element at the start (0)
      size++ ;
      data[end + 1] = element ; // wrap the data around
      start = end + 1 ;
    }
    else if (size < data.length && start > 0 && end != start - 1) {
      // the data starts at the middle of the array but we can still add before the first element
      size++ ;
      start = start - 1 ;
      data[start] = element ;
    }
    else if (start != 0 && end == start - 1 || size == data.length) {
      // we have reached the capacity of data so we need to resize
      resizeAddFirst(element) ;
    }
  }

  @SuppressWarnings("unchecked")
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
      data = newdata ;
      start = 0 ;
      end = size - 1 ;
    }
  }
  private void resize() {

  }

  @SuppressWarnings("unchecked")
  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("You can't add null to the end!") ;
    }
    if (end == data.length - 1) {
      // we have our end at the end of data --> we have to make a new data
      resize() ;
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
