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
  }
  public MyDeque(int initialCapacity) {
    size = initialCapacity ;
    data = (E[])new Object[size] ;
  }
  public int size() {
    return size ;
  }
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
  public E getFirst() {

  }
  public E getLast() {

  }

}
