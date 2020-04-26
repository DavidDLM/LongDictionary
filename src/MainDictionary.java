import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Mario de Leon
 * @author Oscar de Leon
 *
 */
public class MainDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Aqui creo un splay tree y 2 paths para ambos txt.
		 */
		
		
		String path = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"Spanish.txt";
		String path2 = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"texto.txt";
		
		DictionaryFactory dict = new DictionaryFactory();
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    File archivo2 = null;
	    FileReader fr2 = null;
	    BufferedReader br2 = null;
	    
	    try {
    	
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (path);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         archivo2 = new File (path2);
	         fr2 = new FileReader (archivo2);
	         br2 = new BufferedReader(fr2);
	         
	         
	         
	         Date date = new Date();
	         DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	            
	            
	         System.out.println("Bienvenido a TraductorGT");
	         System.out.println("Hora y Fecha: " + hourFormat.format(date));
	         System.out.println("Seleccione el metodo a utilizar para su traduccion");
	         System.out.println("1.SplayTree o 2.HashMap");
	         @SuppressWarnings("resource")
			 Scanner entrada = new Scanner(System.in);  
	         String eleccion = entrada.nextLine();
	         
	         if(eleccion.equals("1")) {	  
	        	 /**
	        	 * Al usar Factory, como devuelve tanto HashMap como SplayTree 
	        	 * hay que asegurarlos que el objeto que crea es el que queremos
	        	 * y no generara errores en el futuro
	        	 * 
	        	 * Es mejor implementar directamente
	        	 * SplayBST<String, String> ss = new SplayBST<String, String>();
	        	 * 
	        	 */
	        	 
	        	 //SplayBST<String, String> ss = new SplayBST<String, String>();
	        	 
		        @SuppressWarnings("unchecked")
				SplayBST<String, String> ss = (SplayBST<String, String>) dict.getObject("SBST");
		        
		         /**
		     	 * Aqui crea strings para las lineas de ambos archivos
		     	 */ 
		         
		         String linea;
		         String linea2;
		         
		         /**
		          * Este while es del archivo del diccionario. Lee las lineas y separa en palabra - definicion (w,d) y los pone en el arbol Splay.
		          */
		         while((linea=br.readLine())!=null)
		         {
		        	 //System.out.println(linea);
		        	 
		        	 /**
		 	     	 * Si la oracion empieza con #, es un comentario. No hace nada.
		 	     	 * Si la oracion no empieza con # es una palabra con definicion valida.
		 	     	 */
		        	 
		        	if(String.valueOf(linea.charAt(0)).equals("#")){
		        		/**
		    	     	 * Este if solo identifica comentarios. No es necesario, pero ayuda a que el mapa no de FATAL_ERROR.
		    	     	 * Se puede reemplazar con if(!String.valueOf(linea.charAt(0)).equals("#")) para evitar el Else.
		    	     	 */
		        	}else {
		        		String[] partes = linea.split("\\s+",2);
			        	if(partes.length >= 2) {
			        		String w = partes[0];
			        		String d = partes[1];
			        		d = d.replaceAll(", ", "-");
			        		//System.out.println(d);
			        		//st.put(w, d);
			        		ss.put(w, d);
			        	}else {
			        		System.out.println("FATAL_ERROR");
			        	}
		        	}
		        	       	 
		         }/**
			     	 * Este while pertenece al txt de la oracion a traducir. Lee la oracion y ejecuta
			     	 * los procesos necesarios para traducir.
			     	 */
		         while ((linea2=br2.readLine())!=null) {
		        	 linea2 = linea2.toLowerCase();
		        	 linea2 = capitalizeFirstLetter(linea2);
		        	 System.out.println(linea2);
		        	 String delimeters = "[. ]";
		        	 String[] oracion = linea2.split(delimeters);	        	
		        	 
		        	 ArrayList<String> temp = new ArrayList<String>();
		        	 
		        	 for(int i = 0; i<oracion.length; i++) {
		        		 temp.add("*"+oracion[i]+"*");
		        		 if(ss.contains(oracion[i])){
		        			 //System.out.println(tree.get(oracion[i]));
		        			 temp.set(i, ss.get(oracion[i]));
		        			 
		        		 }
		        	 }
		        	 
		        	 //System.out.println(temp.toString());
		        	 String final_sentence = temp.toString().replaceFirst("\\[","");
		        	 final_sentence = final_sentence.substring(0,final_sentence.length()-1) + ".";
		        	 final_sentence = final_sentence.replace(',', ' ');
		        	 System.out.println(final_sentence);
		         }
		         	         
	         }else if(eleccion.equals("2")) {
	         
	        	 /**
		         * Al usar Factory, como devuelve tanto HashMap como SplayTree 
		       	 * hay que asegurarlos que el objeto que crea es el que queremos
		       	 * y no generara errores en el futuro
		       	 * 
		       	 * Es mejor implementar directamente
		       	 * HashMap<String, String> map = new HashMap<String, String>();
		       	 * 
		       	 */
	        	 
	        	 //HashMap<String, String> map = new HashMap<String, String>();
	        	 	        	 
	        	@SuppressWarnings("unchecked")
				HashMap<String, String> map = (HashMap<String, String>) dict.getObject("HashMap");
	        	 
	        	 /**
			     	 * Aqui crea strings para las lineas de ambos archivos
			     	 */ 
			         
			         String linea;
			         String linea2;
			         
			         /**
			          * Este while es del archivo del diccionario. Lee las lineas y separa en palabra - definicion (w,d) y los pone en el arbol Splay.
			          */
			         while((linea=br.readLine())!=null)
			         {
			        	 //System.out.println(linea);
			        	 
			        	 /**
			 	     	 * Si la oracion empieza con #, es un comentario. No hace nada.
			 	     	 * Si la oracion no empieza con # es una palabra con definicion valida.
			 	     	 */
			        	 
			        	if(String.valueOf(linea.charAt(0)).equals("#")){
			        		/**
			    	     	 * Este if solo identifica comentarios. No es necesario, pero ayuda a que el mapa no de FATAL_ERROR.
			    	     	 * Se puede reemplazar con if(!String.valueOf(linea.charAt(0)).equals("#")) para evitar el Else.
			    	     	 */
			        	}else {
			        		String[] partes = linea.split("\\s+",2);
				        	if(partes.length >= 2) {
				        		String w = partes[0];
				        		String d = partes[1];
				        		d = d.replaceAll(", ", "-");
				        		//System.out.println(d);
				        		map.put(w, d);	        		
				        	}else {
				        		System.out.println("FATAL_ERROR");
				        	}
			        	}
			        	       	 
			         }/**
				     	 * Este while pertenece al txt de la oracion a traducir. Lee la oracion y ejecuta
				     	 * los procesos necesarios para traducir.
				     	 */
			         while ((linea2=br2.readLine())!=null) {
			        	 linea2 = linea2.toLowerCase();
			        	 linea2 = capitalizeFirstLetter(linea2);
			        	 System.out.println(linea2);
			        	 String delimeters = "[. ]";
			        	 String[] oracion = linea2.split(delimeters);	        	
			        	 
			        	 ArrayList<String> temp = new ArrayList<String>();
			        	 
			        	 for(int i = 0; i<oracion.length; i++) {
			        		 temp.add("*"+oracion[i]+"*");
			        		 if(map.containsKey(oracion[i])){
			        			 //System.out.println(tree.get(oracion[i]));
			        			 temp.set(i, map.get(oracion[i]));
			        			 
			        		 }
			        	 }
			        	 
			        	 //System.out.println(temp.toString());
			        	 String final_sentence = temp.toString().replaceFirst("\\[","");
			        	 final_sentence = final_sentence.substring(0,final_sentence.length()-1) + ".";
			        	 final_sentence = final_sentence.replace(',', ' ');
			        	 System.out.println(final_sentence);
			         }	        	 	        	 
	         }else {
	        	 System.out.println("Opcion no valida.");
	         }
	         
	    }catch(Exception e){
	    	e.printStackTrace();
	        System.out.println("Archivo no existe");
	         
	         
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }		
				
	}
	
	public static String capitalizeFirstLetter(String string) {
	    if (string == null || string.length() == 0) {
	        return string;
	    }
	    return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

}
