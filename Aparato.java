package placasSolares;

public class Aparato {
	private String descripcion;
	private short potencia;
	private boolean interruptor;
	
	
	//Metodos
	//Constructor
	Aparato(String descripcion,short potencia){
		this.descripcion = descripcion;
		this.potencia = potencia;
		interruptor = false;
	}
	
	//GETS
	public String getDescripcion() {
		return descripcion;
	}
	
	public short getPotencia() {
		return potencia;
	}
	
	public boolean getInterruptor() {
		return interruptor;
	}
	
	
	//SETS
	//Apagamos el interruptor del aparato
	public void setInterruptorOff() {
		interruptor = false;
				
	}
	
}
