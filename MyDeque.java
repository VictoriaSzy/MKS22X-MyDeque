public class MyDeque<E> {
  private E[] data ;
  private int size, start, end ;

  public static void main(String[] args) {
    System.out.println() ;
  }

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10] ;
    size = 10 ;
    start = 0 ;
    end = 9 ;
  }
  public MyDeque(int initialCapacity) {
    size = initialCapacity ;
    data = (E[])new Object[size] ;
    start = 0 ;
    end = size - 1 ;
  }
  public int size() {
    return size ;
  }
  /* {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}  (space after each value)
  */
  public String toString() {
    String res = "" ;
    return res ;
  }
  public void addFirst(E element) {

  }
  public void addLast(E element) {

  }
  public E removeFirst() {

  }
  public E removeLast() {

  }
  // accessor methods
  public E getFirst() {
    return data[start] ;
  }
  public E getLast() {
    return data[end] ;
  }

}
