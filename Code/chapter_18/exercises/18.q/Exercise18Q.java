import java.util.*;

public class Exercise18Q {

   public static void main(String args[]) {

      ClaudioLinkedList claudioLinkedList = new ClaudioLinkedList();
      /*INSERT CODE HERE*/
      claudioLinkedList.removeFirst();
      claudioLinkedList.addFirst("C");
      claudioLinkedList.set(2, "A");
      claudioLinkedList.removeLast();
      claudioLinkedList.addLast("O");
      System.out.println(claudioLinkedList);
   }
}