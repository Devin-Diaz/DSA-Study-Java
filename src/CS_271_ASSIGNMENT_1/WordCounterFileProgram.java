package CS_271_ASSIGNMENT_1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WordCounterFileProgram {
    public static void main(String[] args) throws IOException {
        //creating file instance to store my file's path for use later on
        File file = new File("C:/Users/diazd/OneDrive/Desktop/Framingham.txt");
        // Scanner object will read the byte data from file input stream and parse it's content
        Scanner document = new Scanner(new FileInputStream(file));
        // Array to keep track of length of words and amount via index and value
        int[] word_counter = new int[10]; //default size of 10
        // iterates through each word in file
        while(document.hasNext()) {
            String word = document.next(); //store word
            //Java regex to take out alphanumeric chars e.g ` * ,....
            word = word.replaceAll("[^a-zA-Z]", "");
            int length = word.length(); // store word length
            //resizing array if word length is greater than current max index of our array
            if(word.length() > word_counter.length - 1) {
                int newTop = word_counter.length * 2;
                word_counter = Arrays.copyOf(word_counter, newTop);
            }
            word_counter[length]++;
        }
        System.out.println("WORD-LENGTH   WORD-COUNTER");
        for(int i = 1; i < word_counter.length; i++) {
            System.out.printf("    %-13d %d\n", i, word_counter[i]);
        }
    }
}