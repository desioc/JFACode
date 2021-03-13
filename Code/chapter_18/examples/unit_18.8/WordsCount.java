import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class WordsCount {
    public static void main(String[] args) throws IOException {
        String wordToSearch = getWordToSearch();
        List<String> words = getWordsList();

        long startTime1 = System.currentTimeMillis();
        long count = 0;
        for (String word : words) {
            if (word.equals(wordToSearch)) {
                count++;
            }
        }
        System.out.printf("Time for foreach loop  = \t%s  milliseconds \tcount = %s \n", (System.currentTimeMillis() - startTime1), count);

        count = 0;
        long startTime2 = System.currentTimeMillis();
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(wordToSearch)) {
                count++;
            }
        }
        System.out.printf("Time for iterator object = \t%s milliseconds \t\tcount = %s \n", (System.currentTimeMillis() - startTime2), count);
        
        long startTime3 = System.currentTimeMillis();
        int []countArray = {0};
        words.forEach( word ->{ if (word.equals(wordToSearch)) countArray[0]++; });
        System.out.printf("Time for  forEach() method = \t%s milliseconds \t\tcount = %s \n", (System.currentTimeMillis() - startTime3), count);
        
        long startTime4 = System.currentTimeMillis();
        count = words.stream().filter(word -> word.equals(wordToSearch)).count();
        System.out.printf("Time for ordinary stream = \t%s milliseconds \t\tcount = %s \n", (System.currentTimeMillis() - startTime4), count);

        long startTime5 = System.currentTimeMillis();
        count = words.parallelStream().filter(word -> word.equals(wordToSearch)).count();
        System.out.printf("Time for  parallel stream = \t%s milliseconds \tcount = %s \n", (System.currentTimeMillis() - startTime5), count);
    }

    public static String getWordToSearch(){
        System.out.println("Edit the word to search: ");
        Scanner scanner = new Scanner(System.in);
        String wordToSearch = scanner.nextLine();
        return wordToSearch;
    }
    
    public static List<String> getWordsList() throws IOException{
            String contents = new String(Files.readAllBytes(
        Paths.get("./la-divina-commedia.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split(" "));
        return words;
    }
}