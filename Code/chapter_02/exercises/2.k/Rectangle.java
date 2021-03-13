public class Rectangle {
    public final int NUMBER_OF_EQUAL_SIDES = 2;
    public int base;
    public int height;

    public Rectangle(int b, int h) {
        base = b;
        height = h;
    }

    public int  perimeter() {
        int perimeter = (base + height) * NUMBER_OF_EQUAL_SIDES;
        return perimeter;
    }

    public int area() {
        int area = base * height;
        return area;
    }
    
    public void printDetails(){
        System.out.println(getDetails());
    }
    
    public String getDetails(){
        return "This rectangle, has base = " + base + ", height = " + height + ", perimeter = " + perimeter()+ ", area = " + area();
    }
}