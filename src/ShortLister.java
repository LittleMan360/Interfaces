import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args)
    {
        //creates a file chooser
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String lines;

        //try block to catch exceptions
        try
        {
            //opens the file chooser
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                //gets the selected file
                selectedFile = chooser.getSelectedFile();
                //creates a path to the file
                Path file = selectedFile.toPath();
                //creates a buffered reader to read the file
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                //creates a buffered reader to read the file
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                //BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                while(reader.ready())
                {//reads each line of the text file
                    lines = reader.readLine();

                    //prints the text file before ShortWordFilter is applied
                    System.out.println("This is the text file before ShortWordFilter is applied");
                    System.out.println(lines);

                    //splits each word into an array at the space
                    String [] words = lines.split(" ");

                    //calls ShortWordFilter
                    ShortWordFilter shortWordFilter = new ShortWordFilter();
                    //prints the header
                    System.out.println();
                    System.out.println("Strings < 5"); //header

                    //iterates through the array of words
                    for ( int i =0 ; i< words.length ;i++ )
                    {
                        //if the word is less than 5 characters, it is printed
                        if( shortWordFilter.accept(words[i]) == true )
                        {
                            //prints the word
                            System.out.print(words[i] + ", ");
                        }
                    }
                }
                //closes the reader
                reader.close();
                //prints that the file has been read
                System.out.println("\n\nData file read!");
            }
        }
        //catches file not found exception
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        //catches any other exceptions
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}