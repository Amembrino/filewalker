import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LukeFileWalker {
	private  static String  Iniziale="C:\\\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\\\T6\\";

 	 
//	String    percorso= "C:\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\T6\\DWHPACI_svi\\";
//	File oggetti= new File(percorso );
//	File[] filearray = oggetti.listFiles();
	// stampo tutte le sotto dir di primo liv nel percorso
//	for (File f: filearray) {
//	System.out.println(f);
//	
//		 	 	
//	}
	
	
	static	String  percorso="C:\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\T6\\DWHPACI_svi";
	//	static	String  percorso="C:\\sviluppoMetoda\\analisi fortify 2020\\PACI-DWH\\DWHPACI\\T6\\baseline";
	static List<String> trovapath() throws IOException{
//		
  		
		List<String> patto =new ArrayList<>();
//		 try ( Stream<Path> paths = Files.walk(Paths.get(Iniziale+percorso), 5)) {
		try ( Stream<Path> paths = Files.walk(Paths.get( percorso), 5)) {
//	         paths.map(path -> path.toString()).filter(f -> f.endsWith(".sql")||f.endsWith(".prc") )
	         paths.map(path -> path.toString()).filter(f ->  f.endsWith(".prc")||f.endsWith(".pkg")   )

	         .collect(Collectors.toCollection(() -> patto));
	        // .forEach(System.out::println);
	        // addToList(patto,paths);
	     }
		return  patto;
	 
	}
	
	static  List<String>  trovapath(String in ) throws IOException {
// il programma deve essere modificato per permettere di raggiungere le subdirectory
		List<String> patto =new ArrayList<>();
		 try ( Stream<Path> paths = Files.walk(Paths.get(percorso+File.separator+"\\*\\"+in), 5)) {
	         paths.map( path -> path.toString()) 
	           .collect(Collectors.toCollection(() -> patto));
	 	       
	        
	     }catch (Exception e) {
			 e.printStackTrace();
		}
		return  patto;
		
		 
		
		
		
	}
	   // metodo per aggiungere elementi da uno stream a una lista
    public static<T> void addToList(List<T> target, Stream<T> source) {
        source.collect(Collectors.toCollection(() -> target));
    }
	 
	 

}
