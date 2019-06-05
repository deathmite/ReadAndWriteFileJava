import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class hello {

    public static void main(String[] args) {
        System.out.println("Taking inputs from the text file...");
        

        String fileInputName = "input.txt"; // The name of the file to read.
        String fileOutputName = "output.txt"; // The name of the file to write.
        String line = null; // This will reference one line at a time

        int a = 0; // Line counter, Track number of lines read in the input file
        String[] b = new String[100]; // Store a line of content in String array size of 100


        ////////////////////////////////////////////////// READ FILE /////////////////////////////////////////////////////////
        try {
            
            FileReader fileReader = new FileReader(fileInputName); // FileReader reads text files in the default encoding.
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Always wrap FileReader in BufferedReader.

            while((line = bufferedReader.readLine()) != null) { // Read all valid lines, print 
                System.out.println("bufferedReader.readLine() : " + line );
                b[a] = line ; // Store line in array
                a++; // increment line counter
            }   
            bufferedReader.close(); // Always close files.   
            
            System.out.println("Number of Lines : " + a );
        }

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileInputName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileInputName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }


        ///////////////////////////////////////////////////// WRITE FILE ////////////////////////////////////////////////////////

        
         try {
             
             FileWriter fileWriter = new FileWriter(fileOutputName); // Assume default encoding.
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Always wrap FileWriter in BufferedWriter.

             
 
             // Note that write() does not automatically append a newline character.
             while(a>1){
                a--; // decrease line counter
                bufferedWriter.write("" + b[a] ); // write line
                bufferedWriter.newLine(); // new line
                
             }
                // Write final line witthout new line
                a--; // decrease line counter
                bufferedWriter.write("" + b[a] ); // write line
 
             bufferedWriter.close(); // Always close files.
         }
         catch(IOException ex) {
             System.out.println("Error writing to file '" + fileOutputName + "'");
             // Or we could just do this:
             // ex.printStackTrace();
         }
    }
}