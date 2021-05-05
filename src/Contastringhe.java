import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Contastringhe {
	 
	 
	 
	static int countOccurences(String str, String word)
	{
	    // split the string by spaces in a
	    String a[] = str.split(" ");
	 
	    // search for pattern in a
	    int count = 0;
	    for (int i = 0; i < a.length; i++)
	    {
	    // if match found increase count
	    if (word.equalsIgnoreCase(a[i]))
	        count++;
	    }
	 
	    return count;
	}
	 
	static ArrayList<String> trovanelfile(String filenome) throws FileNotFoundException {
		ArrayList<String> nomeProc = new ArrayList<String>();
//		String inizialpath="C:\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\T6\\DWHPACI_svi";
//		try (Scanner scannerInput = new Scanner(new File(inizialpath+filenome))) {
		try (Scanner scannerInput = new Scanner(new File(filenome))) {

		//	      String currentLine = "";
//	      int numero = 0  ;
//	      String result = "";
//	      int charCount = 0;
//	      while (input.hasNext()) {
//	        currentLine += input.nextLine() + " ";
////	        
//	       
//	      }  
//			 Scanner scannerInput = new Scanner(textDoc);
		        int count = 0;   

		        while (scannerInput.hasNext()) { //is there a next item?
		            String nextWord = scannerInput.next(); //reads next item

//		            System.out.println(nextWord);//just checking to see if I got in the loop
//		           CREATE OR REPLACE PROCEDURE
		            if (nextWord.equalsIgnoreCase("CREATE")){
		                String nextWord2 = scannerInput.next();
		                   if (nextWord2.equalsIgnoreCase("OR")) {
		                	 String nextWord3 = scannerInput.next();
		                	 if (nextWord3.equalsIgnoreCase("REPLACE")){
		                		 String nextWord4 = scannerInput.next();
		                		 if (nextWord4.equalsIgnoreCase("PROCEDURE") || nextWord4.equalsIgnoreCase("function")|| nextWord4.equalsIgnoreCase("PACKAGE")){
//		                			 count++;
		                			 String nome_procedura = scannerInput.next();
//		                			 System.out.println(  nome_procedura.toString().trim()   );
		                			 
		                			 nomeProc.add(nome_procedura.trim()) ;
		                		 }
		                	}
	  	              } 
		            }  
		            
		        } 

		      return nomeProc; 
	       
//	    System.out.println(currentLine.toString());
	       
//	      System.out.println(currentLine.indexOf("CREATE OR REPLACE PROCEDURE")); 
	      
//	 	 System.out.println(Contastringhe.countOccurences(currentLine.toString(), "CREATE"  )); 
	     
		}
	}
	

}
