package  uk.co.placona.helloWorld;

public class Viaje {
	/* objetos de tipo Viaje 
	consisten en Colectivo, Horario y Monto del pasaje */
	 
	Colectivo colectivo;
	int 	  hora;
	double	  monto;
	
	public Viaje(Colectivo colectivo, int hora, double monto) {
		
		this.colectivo = colectivo;
		this.hora = hora;
		this.monto = monto;
	}
	
	public Colectivo getColectivo() {
		return colectivo;
	}
	
	public int getHora() {
		return hora;
	}
	
	public double getMonto() {
		return monto;
	}
	

	@Override
	public String toString() {
		return "Viaje [colectivo=" + colectivo + ", hora=" + hora + ", monto="
				+ monto + "]";
	}
	
	
}
