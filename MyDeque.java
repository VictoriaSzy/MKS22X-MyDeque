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
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    size = initialCapacity ;
    data = (E[])new Object[size] ;
    start = 0 ;
    end = size - 1 ;
  }
  public int size() {
    // returning capacity
    return end - start + 1 ;
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
  public void addFirst(E element) {
    start = start - 1 ;
  }
  @SuppressWarnings("unchecked")
  public void addLast(E element) {
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
    start++ ;
    return data[start + 1] ;
  }
  public E removeLast() {
    end-- ;
    return data[end + 1] ;
  }
  // accessor methods
  public E getFirst() {
    return data[start] ;
  }
  public E getLast() {
    return data[end] ;
  }

}
