package placasSolares;

public class PlacaSolar {
	private short superficie;
	private short precio;
	private short potencia;
	
	//Metodos
	//Constructor
	PlacaSolar(short superficie, short precio, short potencia){
		this.superficie = superficie;
		this.precio = precio;
		this.potencia = potencia;
	}
	//GETS
	public short getSuperficie() {
		return superficie;
	}
	
	public short getPrecio() {
		return precio;
	}
	
	public short getPotencia() {
		return potencia;
	}
	
	
	
	
	
}
