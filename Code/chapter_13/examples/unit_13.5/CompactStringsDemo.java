import java.util.*;

public class CompactStringsDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long initialMemoryDimension = runtime.totalMemory()- runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        long limit = 100_000;
        String s ="";
        for (int i = 0; i < limit; i++) {
            s += limit;
        }
        long totalTime = System.currentTimeMillis() - initialTime;
        System.out.println("Created "+ limit +" strings in "+ totalTime +" milliseconds");
        long finalMemoryDimension = runtime.totalMemory()- runtime.freeMemory();
        long usedMemory = finalMemoryDimension - initialMemoryDimension;
        System.out.println("Used Memory = "+ usedMemory +" bytes");
    }
}