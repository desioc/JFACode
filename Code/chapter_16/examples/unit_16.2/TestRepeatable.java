@TestTrigger(when="Every day, hour 18", how =TestTrigger.TestTool.JUNIT)
@TestTrigger(when="Every friday, hour 9", how =TestTrigger.TestTool.GUI)
public class TestRepeatable {
    public void method(String... args) {
        // . . .
    }
}