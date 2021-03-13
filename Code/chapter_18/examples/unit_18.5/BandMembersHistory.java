import java.util.*;

public class BandMembersHistory {
    public static void main(String args[]) {
        Deque<String> band = new LinkedList<>();
        //Deque<String> band = new ArrayDeque<>();
        band.push("Joey");
        band.offerFirst("Dee Dee");
        band.offer("Johnny");
        band.offerLast("Tommy");
        System.out.println("1974 Band Members: "+ band);
        band.pollLast();
        band.offerLast("Marky");
        System.out.println("1978 Band Members: "+ band);
        band.removeFirstOccurrence("Marky");
        band.offer("Richie");
        System.out.println("1984 Band Members: "+ band);
        band.removeLastOccurrence("Richie");
        band.add("Elvis");
        System.out.println("1987 Band Members: "+ band);
        band.removeLast();
        band.addLast("Marky");
        System.out.println("1988 Band Members: "+ band);
        band.poll();
        band.push("C.J.");
        System.out.println("1989 Band Members: "+ band);
    }
}