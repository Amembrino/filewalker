import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PathandFile {

	
	public static String associaFILEaPATH() throws IOException {
		List<String> paths =new ArrayList<>();
    	List<String> nomeProc =new ArrayList<>();
    	String nomeProceduraTrovata = null;
    	//riempie l'araraylist con i vari paths
    	paths = LukeFileWalker.trovapath();
    	
    	for(String Filepath:paths) {
//     		  System.out.println(Filepath.toString());
    		  nomeProc= Contastringhe.trovanelfile(""+File.separator+Filepath );
    		  if (!(nomeProc.isEmpty())) {
    			  for (int i=0; i<nomeProc.size(); i++) {
    				  if (!(nomeProc.get(i).equalsIgnoreCase("BODY"))) {
    					  nomeProceduraTrovata=nomeProc.get(i).toString();
//    					  System.out.println(Filepath.toString().substring(59)+"	 	 				"+nomeProc.get(i).toString());
  
    				  }
            		  
        		  }
  
    		  }
    		  //    		  if (nomeProc!=null) {
//        		  System.out.println(Filepath+"			       "+nomeProc);
//
//    		  }
    	  }
		return  nomeProceduraTrovata;
	}
	
	public static List<String>  leggiUnaRigaPerVolta(String nomefile) throws IOException {
 		String nextWord = null;
 		List<String> paths =new ArrayList<>();
		//leggo dal file con la lista dei nomi di fies
       	try (Scanner scannerInput = new Scanner(new File( nomefile))) {

	 	        while (scannerInput.hasNext() ) {
	 	        	 
         	     nextWord = scannerInput.next();
	 	         
		         //reads next item
		          paths.add(nextWord);
		        }
	}
        return   paths ;
 }
	
	
	public static void  paragon() throws IOException {
 		String nextWord = null;
 		List<String> nomePath =new ArrayList<>();
 		 nomePath = leggiUnaRigaPerVolta("pathres");
 		
 		 
 		
		try (Scanner scannerInput = new Scanner(new File("dres"))) {
				
 	        while (scannerInput.hasNext()) { //fino alla fine del file 
// 	        	leggo la prima parola
 	        	int i=0;
 	        	boolean trov=false;
	 	          nextWord = scannerInput.next();
	 	        	for ( i=0;  i<nomePath.size();  ) { //leggo l'array  ontenete i pat
		 	        		String patto=nomePath.get(i);   // estrai l'elemenro iesimo
		 	        	// confronta l'elemento iesimo con la parola letta
		 	        		//per ogni elemento nell'array si cerca la parola letta
		 	        		if (patto.toLowerCase().contains( nextWord.substring(0, nextWord.indexOf('.') ).toLowerCase().trim())) { // se iesimo elemento contiene parolafissa
		 	        		 
 		 	        			System.out.println( nextWord+ "                                 " +patto ); 
		 	        			 trov=true;
		 	        			i++;
//		 	        			if (scannerInput.hasNext()) {
//		 	        				nextWord = scannerInput.next();	
//		 	        			}
	  	 	                   			 
		 	        		} 
		 	        		else  {//la parola fissata in nextword non è contenuta in patto
		 	        			i++;
		 	        			 if (  i==nomePath.size() && !trov) {
		 	        				 System.out.println(nextWord+"                                 no riscontro         ") ; 
		 	        			 
		 	        			 }
		 	        			 
		 	        		}
		 	        		
	 	        	}
	              
	        }
		}
}
	
}
