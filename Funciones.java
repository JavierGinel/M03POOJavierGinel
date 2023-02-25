package placasSolares;

import java.util.ArrayList;

public class Funciones {	
	
//---------------------------------------------------------------------
	//Funcion que devuelve la posicion de una casa en la listaCasas
	//Devuelve la posicion exacta de la casa.
	static short buscaCasa(String nif, ArrayList <Casa> listaCasas) {
		short res = -1;
		short i = 0;
		
		while(i<listaCasas.size() && res == -1){
			if (listaCasas.get(i).getNif().equalsIgnoreCase(nif)){
				//igualamos el conetido de res a la posicion i
				res = i;
				
			}
			i++;
		}
		
		
		return res;
	}
	
//---------------------------------------------------------------------
	//Funcion que comprueba si hay un nif con casa.
	//Devuelve true o false dependiendo si tiene o no.
	static boolean buscaNif(String nif, ArrayList <Casa> listaCasas) {
		
		//Primero creamos la lista de los nifs
		ArrayList <String> listaNifs = new ArrayList<>();
		
		for (short i=0;i<listaCasas.size();i++) {
			listaNifs.add(listaCasas.get(i).getNif());
		}
		
		//Comprobamos si el nif ests en la lista
		boolean res = listaNifs.contains(nif);
		
		return res;
	}
	
//---------------------------------------------------------------------
	
	
	
}
