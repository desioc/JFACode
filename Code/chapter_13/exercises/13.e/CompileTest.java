import javax.tools.*;
import java.io.*;
public class CompileTest {
    public static void main(String args[]) throws Exception {
        JavaCompilerTool compiler = ToolProvider.defaultJavaCompiler();
        compiler.run(new FileInputStream("MyClass.java"),null, null);
    }
}