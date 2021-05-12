import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CercaFile   {
	
	
	 
	static ArrayList<String> cercaFileBynomeP(  ) throws IOException {
		 List<String> noeprocedure= new ArrayList<>();
		 List<String> paths= new ArrayList<>();
         String inizialpath="C:\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\T6\\DWHPACI_svi";
         String nome_procedura =null;
 		 ArrayList<String> nomeProc = new ArrayList<String>();
         
		 try {
//			noeprocedure=PathandFile.leggiUnaRigaPerVolta("224resnonAssociati");
			 noeprocedure=PathandFile.leggiUnaRigaPerVolta("224busnonAssociati"); 
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		 
//		ricerco i path presenti in  DWHPACI_svi
 		
			
		 	paths = LukeFileWalker.trovapath();
			 
		     for (String nomeP:noeprocedure) {
		    	 
		    	 for(String Filepath:paths) {
 	     		  if (  Filepath.toLowerCase().contains(nomeP.substring(0, nomeP.indexOf('.') ).toLowerCase().trim())  ) {
  	     			  
 	     			try (Scanner scannerInput = new Scanner(new File(Filepath))) {
 
 	     			  

 	     				        while (scannerInput.hasNext()) { 
 	     				            String nextWord = scannerInput.next(); 
 
 	     				            if (nextWord.equalsIgnoreCase("CREATE")){
 	     				                String nextWord2 = scannerInput.next();
 	     				                   if (nextWord2.equalsIgnoreCase("OR")) {
 	     				                	 String nextWord3 = scannerInput.next();
 	     				                	 if (nextWord3.equalsIgnoreCase("REPLACE")){
 	     				                		 String nextWord4 = scannerInput.next();
 	     				                		 if (nextWord4.equalsIgnoreCase("PROCEDURE") || nextWord4.equalsIgnoreCase("function")|| nextWord4.equalsIgnoreCase("PACKAGE")){
 	     				                			 	 
 	     				                			  
 	     				                			 	  nome_procedura = scannerInput.next();
  	     				                			 if (nome_procedura.toLowerCase().contains(nomeP.substring(0, nomeP.indexOf('.') ).toLowerCase().trim())) {
  	     				           	     			System.out.println(nomeP+"                "+Filepath+ "                "+nome_procedura );

  	     				                			 }
 	     				                			 nomeProc.add(nome_procedura.trim()) ;
 	     				                		 }
 	     				                	}
 	     			  	              } 
 	     				            }  
 	     				            
 	     				        } 
 	     				      
 	     				  
  
 	     			     
 	     				}
 	     			
 	     		  }
		    		 
		    	 
		    		
		    	}
		     }
		       

		 return nomeProc; 
	       
  
	}
	
}
