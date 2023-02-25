package placasSolares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Main {

	public static void main(String[] args) throws IOException {
		
		//Iniciamos las variables que permiten que funcione el menú
		boolean salir = false;
		BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
		
		//CREAMOS LAS LISTAS QUE VAN A GUARDAR DATOS
		ArrayList <Casa> listaCasas = new ArrayList<>();
		
		
		
		
		do {
			//Esto es lo que hace que el menú funcione. 
			//Espera hasta que se pone el comando por teclado y lo separa en la lista dades
			System.out.print(">");
			String comanda = terminal.readLine();
			String dades[] = comanda.split(" ");
			
			switch (dades[0]) {
				//Cuando el comando es quit. Cerramos el programa. ACABADO
				case "quit": 
					System.out.print("------------------------------------------------------------------------\r\n"
							+ "BUILD SUCCESS\r\n"
							+ "------------------------------------------------------------------------");
					salir = true;
					break;
					
					
					
					
				//Cuando el comando es addCasa. 
					//addCasa [nif] [nom] [superfície]
				case "addCasa":
					
					//Primero verifiamos que se hayan añadido 4 parametros
					if (dades.length == 4) {
						//Pasamos la superficie a short
						short intSuperficie = (short) Integer.parseInt(dades[3]);
						//Verificamos que el NIF no tenga ya una casa asignada. 
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);				
						
						//Si el nif no esta en la lista
						if (!nifExiste) {
							//Verificamos que la superficie es mayor que 10.
							if (intSuperficie > 10) {
								
								//Instanciamos la clase y añadimos casa a la lista
								Casa nuevaCasa = new Casa(dades[1], dades[2], intSuperficie);
								listaCasas.add(nuevaCasa);
																
								System.out.println("OK: Casa registrada.");
							}else {
								System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10.");
							}
						}else {
							System.out.println("ERROR: Ja hi ha una casa registrada amb aquest nif");
						}
	
					//Si no se han añadido 4 parametros	
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.");
					}
					
					break;
				
					
					
					
				//Cuando el comando es addPlaca. 
					//addPlaca [nif] [superficie] [precio] [potencia]
				case "addPlaca":
					//Comprobamos que el numero de parametros sea correcto
					if (dades.length == 5) {
						//Pasamos las variables que necesitamos a short
						short numSuperficie = (short) Integer.parseInt(dades[2]);
						short numPrecio = (short) Integer.parseInt(dades[3]);
						short numPotencia = (short) Integer.parseInt(dades[4]);
						
						//Comprobar si el nif tiene una casa
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);
						if (nifExiste) {
							//Comprobamos si el precio es mas grande que 0
							if (numPrecio > 0) {
								//Verificamos si la placa cabe
								
								// Buscamos la posicion de la casa en la lista
								short posCasa = Funciones.buscaCasa(dades[1], listaCasas);
								
								//Sacamos el area restante de esta casa
								short areaRestante = listaCasas.get(posCasa).getAreaRestante();
								
								//Si la placa cabe
								if (areaRestante>=numSuperficie) {
									
								//Instanciamos la clase y añadimos PLACA a la lista de la casa
								PlacaSolar nuevaPlaca = new PlacaSolar(numSuperficie, numPrecio,numPotencia);
								
								listaCasas.get(posCasa).setPlaca(nuevaPlaca);
								
								System.out.println("OK: Placa afegida a la casa.");
									
								//Si la placa no cabe
								}else {
									System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
								}
					
							//El precio no es mayor que 0
							}else {
								System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
							}				
							
						//No hay ninguna casa con este nif
						}else {
							System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
						}
						
					//Si el numero de parametros no es correcto
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.");
						
						
					}
					break;	
					
					
					
					
				//Cuando el comando es addAparell. 
					//addAparell [nif] [descripcio] [potència]
					
				case "addAparell":
					//Comprobamos que el numero de parametros sea correcto
					if (dades.length == 4) {
						//Pasamos las variables que necesitamos a short
						short numPotencia = (short) Integer.parseInt(dades[3]);
						
						
						//Comprobamos que el nif tenga casa
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);
						
						if (nifExiste) {
							// Buscamos la posicion de la casa en la lista
							short posCasa = Funciones.buscaCasa(dades[1], listaCasas);
							
							//Comprobamos que no haya ya un aparell igual en esta casa.
							
							short areaRestante = listaCasas.get(posCasa).getAreaRestante();
							boolean compruebaDescrip = listaCasas.get(posCasa).compruebaAparato(dades[2]);
							
							if (!compruebaDescrip) {
								//Instanciamos la clase y añadimos PLACA a la lista de la casa
								Aparato nuevoAparato = new Aparato(dades[2], numPotencia);
								
								listaCasas.get(posCasa).setAparato(nuevoAparato);
								
								
								System.out.println("OK: Aparell afegit a la casa.");
								
							//Ya existe un aparato con esta descripcion en esta casa.
							}else {
								System.out.println("ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.");
							}
							
							
						//El nif no tiene casa asignada
						}else {
							System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
						}

					//Si el numero de parametros no es correcto
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.\r\n"
								+ "Ús: addAparell [nif] [descripció] [potència]");
					}
	
					break;
				
					

					
				//Cuando el comando es onCasa. 	
					//onCasa [nif]
				case "onCasa":
					//Comprobamos que el numero de parametros sea correcto
					if (dades.length == 2) {
						
						//Comprobamos que el nif tenga casa
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);
						
						if (nifExiste) {
							// Buscamos la posicion de la casa en la lista
							short posCasa = Funciones.buscaCasa(dades[1], listaCasas);
							
							//comprobamos si el interruptor esta apagado
							if (!listaCasas.get(posCasa).getInterruptor() ){
								
								//encendemos el interruptor de la casa llamando al metodo set
								listaCasas.get(posCasa).setInterruptorOn();						
								System.out.println("OK: Interruptor general activat.");
								
								
							//El interruptor de la casa ya esta encendido
							}else {
								System.out.println("ERROR: La casa ja té l'interruptor encès.");
							}
								
						//El nif no tiene casa asignada
						}else {
							System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
						}
					//Si el numero de parametros no es correcto				
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.");
					}
									
					break;
					
					
					
					
				//Cuando el comando es onAparell. 	
					//onAparell [nif] [descripció aparell]
				case "onAparell":
					//Comprobamos que el numero de parametros sea correcto
					if (dades.length == 3) {
						//Comprobamos que el nif tenga casa
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);
						
						if (nifExiste) {
							// Buscamos la posicion de la casa en la lista
							short posCasa = Funciones.buscaCasa(dades[1], listaCasas);
							
							//comprobamos si el interruptor esta encendido
							if (listaCasas.get(posCasa).getInterruptor() ){
								
								//Comprobamos si la casa tiene este aparato
								boolean compruebaDescrip = listaCasas.get(posCasa).compruebaAparato(dades[2]);
								
								if (compruebaDescrip) {
									//Primero encendemos el aparato, despues comprobamos si supera de potencia
									//Buscamos la posicion del aparato en la lista de aparatos de la casa
									short posAparato = Funciones.buscaAparell(dades[2],listaCasas.get(posCasa).getAparatos() );
									
									Aparato aparato = (Aparato) listaCasas.get(posCasa).getAparatos().get(posAparato);
																		
									aparato.setInterruptorOn();
									

									
									//Obtenemos las potencias generadas y gastadas
									short potenciaGenerada = listaCasas.get(posCasa).potenciaGenerada();
									short potenciaGastada = listaCasas.get(posCasa).potenciaGastada() ;

									//Comparamos las potencias
									//Si la potencia generada es menor que la gastada
									if (potenciaGenerada < potenciaGastada ) {
										
										//Apagamos el interruptor general de la casa
										listaCasas.get(posCasa).setInterruptorOff();		
										
										
										//Apagamos todos los interruptores de los aparatos
										for (short i = 0; i < listaCasas.get(posCasa).getAparatos().size();i++) {
											Aparato aparell = (Aparato) listaCasas.get(posCasa).getAparatos().get(i);
											
											aparell.setInterruptorOff();
											}
																				
										System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
									
										
									//Si la potencia generada es mayor que la gastada
									}else {
										System.out.println("OK: Aparell encès.");
									}
									
								//Esta casa no tiene este aparato
								}else {
									System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
								}
							
							//El interruptor de la casa esta apagado
							}else {
								System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
							}
						

						//El nif no tiene casa asignada
						}else {
							System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
						}
						
					//Si el numero de parametros no es correcto
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.");
					}
					
					break;
				

					
					
					
					
				//Cuando el comando es offAparell. 	
					//offAparell [nif] [descripció aparell]
				case "offAparell":
					//Comprobamos que el numero de parametros sea correcto
					if (dades.length == 3) {
						//Comprobamos que el nif tenga casa
						boolean nifExiste = Funciones.buscaNif(dades[1],listaCasas);
						
						if (nifExiste) {
							// Buscamos la posicion de la casa en la lista
							short posCasa = Funciones.buscaCasa(dades[1], listaCasas);
							
							//Comprobamos si la casa tiene este aparato
							boolean compruebaDescrip = listaCasas.get(posCasa).compruebaAparato(dades[2]);
							if (compruebaDescrip) {
								//Buscamos la posicion del aparato en la lista de aparatos de la casa
								short posAparato = Funciones.buscaAparell(dades[2],listaCasas.get(posCasa).getAparatos() );
								
								//Comprobamos si este aparato ya esta apagado
								Aparato aparato = (Aparato) listaCasas.get(posCasa).getAparatos().get(posAparato);
								
								
								//Detecta si esta encendido o apagado el aparato. Queda apagar el aparato si esta encendido
								if (aparato.getInterruptor()) {
									aparato.setInterruptorOff();
									System.out.println("OK: Aparell apagat.");
									
								}else {
									System.out.println("ERROR: L'aparell ja està apagat.");
								}
								
								
								
								
								
							//Esta casa no tiene este aparato
							}else {
								System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
							}
												
						//El nif no tiene casa asignada
						}else {
							System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
						}

					//Si el numero de parametros no es correcto
					}else {
						System.out.println("ERROR: Número de paràmetres incorrecte.");
					}
					
					
					
					
					
					
					break;
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				//Cuando el comando es list. 	
				case "list":
					System.out.println("lista");
					break;
				
				//Cuando el comando es info. 	
				case "info":
					System.out.println("info");
					break;
					
					
				//Si no es ninguno de los casos el comando es incorrecto
				default:
					System.out.println("ERROR: Comanda incorrecta.");
			
			}
			
			
			
			
		}while(salir != true);
		

	}

}
