import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import java.io.File;
import javax.swing.JFileChooser;
 
public class LineNumberReaderEx
{
   public static void main(String[] args)
   {
		
		JFileChooser chooser = new JFileChooser(); 
		int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
		
      readFromFile(chooser.getSelectedFile());
   }
 
   private static void readFromFile(File filename)
   {
      LineNumberReader lineNumberReader = null;
	  int c = 0;
	  
      try
      {
         //Construct the LineNumberReader object
         lineNumberReader = new LineNumberReader(new FileReader(filename));
          
         //Read all lines now;
         String line = null;
		 String[] words=null;
		 
		 Scanner in = new Scanner (System.in);
         System.out.print("Inserire parola da ricercare: ");	  
         String input= in.next();
		 
         while ((line = lineNumberReader.readLine()) != null)
         {
			 //words=line.split(" ");  //Split the word using space
			 
          //for (String word : words) 
          //{
                 if (line.contains(input))   //Search for the given word
                 {
					c++; 
                    System.out.println("Line " + lineNumberReader.getLineNumber() + " - " + "Numero ripetizione : " + c + line);
                 }
		      //}
          }
	  }
      catch (Exception ex)
      {
         ex.printStackTrace();
      } finally
      {
         //Close the LineNumberReader
         try {
            if (lineNumberReader != null){
               lineNumberReader.close();
            }
         } catch (IOException ex){
            ex.printStackTrace();
         }
      }
   }
}