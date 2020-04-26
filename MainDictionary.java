import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

/**
 * @author Mario De Leon
 * @author OScar De Leon
 *
 */
public class MainDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
                // TODO Auto-generated method stub
		 Scanner entrada = new Scanner(System.in);
       
                System.out.println("Bienvenido a TraductorGT");
                System.out.println("Hora y Fecha: " + hourFormat.format(date));
                System.out.println("Seleccione el metodo a utilizar para su traduccion");
                System.out.println("1.SplayTree o 2.HashMap");
                String eleccion = entrada.nextLine();
		/**
		 * Aqui creo un splay tree y 2 paths para ambos txt.
		 */
		if(eleccion.equals("1")){
		SplayBST<String, String> st = new SplayBST<String, String>();
		String path = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"Spanish.txt";
		String path2 = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"texto.txt";
		
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
	 	     	 * Si la oraci�n no empieza con # es una palabra con definicion valida.
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
		        		st.put(w, d);	        		
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
	        		 if(st.contains(oracion[i])){
	        			 //System.out.println(tree.get(oracion[i]));
	        			 temp.set(i, st.get(oracion[i]));
	        			 
	        		 }
	        	 }
	        	 
	        	 //System.out.println(temp.toString());
	        	 String final_sentence = temp.toString().replaceFirst("\\[","");
	        	 final_sentence = final_sentence.substring(0,final_sentence.length()-1) + ".";
	        	 final_sentence = final_sentence.replace(',', ' ');
	        	 System.out.println(final_sentence);
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
        
        if(eleccion.equals("2")){
            HashMap<String, String> map = new HashMap<String, String>();
            String path = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"Spanish.txt";
            String path2 = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"texto.txt";
		
            File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    File archivo2 = null;
	    FileReader fr2 = null;
	    BufferedReader br2 = null;
            
            
            try{
                 archivo = new File (path);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         archivo2 = new File (path2);
	         fr2 = new FileReader (archivo2);
	         br2 = new BufferedReader(fr2);
                 
                 String linea3;
	         String linea4;
                 
                while((linea3=br.readLine())!=null){
                     if(String.valueOf(linea3.charAt(0)).equals("#")){
                         
                     }
                     else{
                     String[] parte = linea3.split("//s+:");
                     String key = parte[0];
                     String value = parte[1];
                     map.put(key, value);
                     //System.out.println(map);
                     }
                     
                 }
                 
                while((linea4 = br2.readLine()) != null) {
                    linea4 = linea4.toLowerCase();
	        	 linea4 = capitalizeFirstLetter(linea4);
	        	 System.out.println(linea4);
	        	 String delimeters2 = "[. ]";
	        	 String[] oracion2 = linea4.split(delimeters2);
                       
                        
                    ArrayList<String> temp2 = new ArrayList<String>();
                    for(int i = 0; i < oracion2.length; i++){
                      temp2.add(oracion2[i]);
                      if (map.containsKey(oracion2[i])){
                            temp2.set(i, map.get(oracion2[i]));
                        }
                    }
                    System.err.println(temp2);
                    String final_sentence2 = temp2.toString().replaceFirst("\\[","");
                    final_sentence2 = final_sentence2.substring(0,final_sentence2.length()-1) + ".";
                    final_sentence2 = final_sentence2.replace(',', ' ');
                    System.out.println(final_sentence2);
                    
                }
            }
            catch(Exception e){
                e.printStackTrace();
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