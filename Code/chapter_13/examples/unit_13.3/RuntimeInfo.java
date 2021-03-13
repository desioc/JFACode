public class RuntimeInfo {
    public static void main(String args[]) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("The system has "+ runtime.availableProcessors()+" processors");
        System.out.println("Total memory allocated in the JVM "+ runtime.totalMemory() +" bytes");
        System.out.println("Free memory that can be allocated in the JVM "+ runtime.freeMemory() +" bytes");
        System.out.println("Maximum memory that can be allocated in the JVM "+ runtime.maxMemory() +" bytes");
    }
}