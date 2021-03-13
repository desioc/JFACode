public class Square {
    public int side;

    public int perimeter() {
        int perimeter = side * 4;
        return perimeter;
    }

    public int area() {
        int area = side * side;
        return area;
    }
}