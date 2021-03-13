public class BaseClass {
    public void method() throws java.io.IOException {
    }
}
class CorrectSubclass1 extends BaseClass {
    @Override
    public void method() throws java.io.IOException {
    }
}
class CorrectSubclass2 extends BaseClass {
    @Override
    public void method() throws java.io.FileNotFoundException {
    }
}
class CorrectSubclass3 extends BaseClass {
    @Override
    public void method() {
    }
}
//This class cannot be compiled
/*class NotCorrectSubclass extends BaseClass {
    @Override
    public void method() throws java.sql.SQLException {
    }
}*/

class CorrectSubclass4 extends BaseClass {
     @Override
     public void method () throws java.lang.NullPointerException {}
}
