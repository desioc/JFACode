public class SquareTest {
    public static void main(String args[]) {
        Square square = new Square(5);
//        square.side = 5;
        int perimeter = square.perimeter();
        System.out.println(perimeter);
        int area = square.area();
        System.out.println(area);
    }
}