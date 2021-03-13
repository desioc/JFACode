import java.util.*;

public class OwnGenericMain {
  public static void main(String args[]) {
/* ArrayList al = new ArrayList();
    al.add("string");
    al.add(1);
    Iterator i = al.iterator();
    while (i.hasNext()) {
      Object o = i.next();
    } */

    new OwnGenericMain();
  }

  public OwnGenericMain () {
    OwnGeneric <Integer> own = new OwnGeneric <Integer>();
    for (int i = 0; i < 10; ++i) {
      own.add((i));
    }
    print(own);
  }

  /* public void print(OwnGeneric<? extends Number> o1) {
    System.out.println(o1);
  } */
  public <A extends Number> void print(OwnGeneric<A> o1) {
    System.out.println(o1);
  }

 /* public void print(ArrayList al) {
    Iterator i = al.iterator();
    while (i.hasNext()) {
      Object o = i.next();
    } 
  }*/

  public class OwnGeneric <E extends Number> {
    private List<E> list;

    public OwnGeneric () {
      list = new ArrayList<E>();
    }
    public void add(E e) {
      list.add(e);
    }

    public void remove(int i) {
      list.remove(i);
    }

    public E get(int i) {
      return list.get(i);
    }

    public int size( ) {
      return list.size( );
    }

    public boolean isEmpty( ) {
      return list.size( ) == 0;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < size(); i++) {
        sb.append(get(i) + (i!=size()-1?"-":""));
      }
      return sb.toString();
    }
  }
}