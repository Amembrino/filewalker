import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PathandFile {

	
	public static void associaFILEaPATH() throws IOException {
		List<String> paths =new ArrayList<>();
    	List<String> nomeProc =new ArrayList<>();
    	paths = LukeFileWalker.trovaFile();
    	  for(String Filepath:paths) {
//     		  System.out.println(Filepath.toString());
    		  nomeProc= Contastringhe.trovanelfile(""+File.separator+Filepath );
    		  if (!(nomeProc.isEmpty())) {
    			  for (int i=0; i<nomeProc.size(); i++) {
            		  System.out.println(Filepath.toString().substring(59)+"	 	 				"+nomeProc.get(i).toString());

        		  }
  
    		  }
    		  //    		  if (nomeProc!=null) {
//        		  System.out.println(Filepath+"			       "+nomeProc);
//
//    		  }
    	  }
	}
	
	public static List<String>  leggiUnaRigaPerVolta() throws IOException {
 		String nextWord = null;
 		List<String> paths =new ArrayList<>();
		//leggo dal file con la lista dei nomi di fies
       	try (Scanner scannerInput = new Scanner(new File("pathCesstop"))) {

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
 		 nomePath = leggiUnaRigaPerVolta();
 		
 		 HashMap<String, String> mappadiconfronto;
 		mappadiconfronto = new HashMap<String, String>();
 		
		try (Scanner scannerInput = new Scanner(new File("cessTOP"))) {
				
 	        while (scannerInput.hasNext()) { //fino alla fine del file 
// 	        	leggo la prima parola
 	        	int i=0;
 	        	boolean trov=false;
	 	          nextWord = scannerInput.next();
	 	        	for ( i=0;  i<nomePath.size();  ) { //leggo l'array  ontenete i pat
		 	        		String patto=nomePath.get(i);   // estrai l'elemenro iesimo
		 	        	// confronta l'elemento iesimo con la parola letta
		 	        		//per ogni elemento nell'array si cerca la parola letta
		 	        		if (patto.toLowerCase().contains( nextWord.toLowerCase().trim())) { // se iesimo elemento contiene parolafissa
		 	        			 System.out.println( nextWord+ "                                 " +patto ); 
		 	        			 trov=true;
		 	        			i++;
//		 	        			if (scannerInput.hasNext()) {
//		 	        				nextWord = scannerInput.next();	
//		 	        			}
	  	 	                   			 
		 	        		} 
		 	        		else  {//la parola fissata in nextword non è contenuta in patto
//		 	        			mappadiconfronto.put(nextWord, "non trovata");
		 	        			i++;
		 	        			 if (  i==nomePath.size() && !trov) {
		 	        				 System.out.println(nextWord+"                        non trovata         ") ; 
		 	        			 
		 	        			 }
		 	        			 
		 	        		}
		 	        		
	 	        	}
	              
	        }
// 	        System.out.println(mappadiconfronto);
		}
}
	
}
