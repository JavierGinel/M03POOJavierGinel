package placasSolares;

public class PlacaSolar {
	private short superficie;
	private double precio;
	private short potencia;
	
	//Metodos
	//Constructor
	PlacaSolar(short superficie, double precio, short potencia){
		this.superficie = superficie;
		this.precio = precio;
		this.potencia = potencia;
	}
	//GETS
	public short getSuperficie() {
		return superficie;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public short getPotencia() {
		return potencia;
	}
	
	
	
	
	
}
