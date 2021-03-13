import java.io.*;

public class BackupFile {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please specify the file name!");
            System.exit(0);
        }
        File inputFile = new File(args[0]);
        File outputFile = new File(args[0] +".backup");
        try (FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile)) {
            int b = 0;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            System.out.println("Backup file is: "+args[0]+".backup!");
        } 
    }
}