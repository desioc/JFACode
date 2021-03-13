public class RectangleTest {
    public static void main(String args[]) {
        Rectangle rectangle1 = new Rectangle(5,6);
        Rectangle rectangle2 = new Rectangle(8,9);
        System.out.println("Perimeter of rectangle 1 = "+ rectangle1.perimeter());
        System.out.println("Area of rectangle 1 = "+ rectangle1.area());
        System.out.println("Perimeter of rectangle 2 = "+ rectangle2.perimeter());
        System.out.println("Area of rectangle 2 = "+ rectangle2.area());
    }
}