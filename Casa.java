package placasSolares;

import java.util.ArrayList;

public class Casa {
	private String nif;
	private String nombre;
	private short superficie;
	private boolean interruptor;
	private ArrayList <PlacaSolar> listaPlacas = new ArrayList<>();
	private ArrayList <Aparato> listaAparatos = new ArrayList<>();	

	
	//Metodos
	//Constructor
	public Casa(String nif,String nombre,short superficie) {
		this.nif = nif;
		this.nombre = nombre;
		this.superficie = superficie;
		interruptor = true;
	}
	
//	GETS
	public String getNif() {
		return nif;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public short getsuperficie() {
		return superficie;
	}
	
	public boolean getInterruptor() {
		return interruptor;
	}
	
	public ArrayList<PlacaSolar> getPlacas() {
		return listaPlacas;
	}
	
	public ArrayList<Aparato> getAparatos() {
		return listaAparatos;
	}
	
	
	//SETS
	public void setPlaca(PlacaSolar nuevaplaca) {
		listaPlacas.add(nuevaplaca);
	}
	
	public void setAparato(Aparato nuevoAparato) {
		listaAparatos.add(nuevoAparato);
	}
	
	public void setInterruptorOn() {
		interruptor = true;
	}
	
	public void setInterruptorOff() {
		interruptor = false;
	}
	
	
	
	
	
	
	
	
	//Calcula el area restante que queda libre en cada casa
	//Envia un numero tipo short con el tamaño restante
	public short getAreaRestante() {		
		
		short sumaAreas = superficie;
		for (short i=0;i<listaPlacas.size();i++) {
			sumaAreas = (short) (sumaAreas - listaPlacas.get(i).getSuperficie());
		}
		
		
		return sumaAreas;
	}
	
	
	
	//Revisa si ya esta asignado un aparato con esta descripcion en la propia casa.
	//Envia True cuando si que existe y False cuando no existe.
	public boolean compruebaAparato(String descripcion) {
		
		//Inicializamos la variable en false
		boolean res = false;
		
		//Recorremos la lista de aparatos de la casa y comprobamos si existe el aparato
		for (short i = 0; i < listaAparatos.size(); i++) {
			if (listaAparatos.get(i).getDescripcion().equalsIgnoreCase(descripcion) ) {
				res = true;
			}
		}
		
		
		return res;
	}
	
	//Calcula la potencia que generan las placas de la casa
	//Devuelve un short con la potencia generada
	public short potenciaGenerada(){
		short potenciaTotal = 0;
		
		//Recorremos toda la lista de placas y sumamos a la potencia total el de cada una de las placas
		for(short i = 0; i < listaPlacas.size(); i++) {
			potenciaTotal +=listaPlacas.get(i).getPotencia();
		}
		
		return potenciaTotal;
	}
	
	//Calcula la potencia que gastan los aparatos de la casa
	//Devuelve un short con la potencia gastada
	public short potenciaGastada(){
		short potenciaTotal = 0;
		
		//Recorremos toda la lista de aparatos y sumamos a la potencia de los aparatos encendidos
		for(short i = 0; i < listaAparatos.size(); i++) {
			//Comprobamos si el interruptor del aparato esta encendido
			if(listaAparatos.get(i).getInterruptor()) {
				potenciaTotal +=listaAparatos.get(i).getPotencia();
			}
			
		}
		
		return potenciaTotal;
	}
	
	public double inversion() {
		double dinero = 0;
		
		//Recorremos la lista de placas y sumamos lo que cuesta
		for (short i = 0;i<listaPlacas.size();i++){
			//Sumamos al dinero el precio de la placa
			dinero += listaPlacas.get(i).getPrecio();
		
		}
		
		return dinero;
	}
	
	
	
}
