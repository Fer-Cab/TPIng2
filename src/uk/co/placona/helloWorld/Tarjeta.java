package  uk.co.placona.helloWorld;

import java.util.ArrayList;

public abstract class Tarjeta {

	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	private int tarjetaId;
	private double saldo;
	private boolean hizoTransbordo;

	public Tarjeta(int tarjetaId) {

		this.tarjetaId = tarjetaId;
		viajes = new ArrayList<Viaje>();
		saldo = 0.0;
	}

	/*
	 * El boleto de tipo transbordo es valido siempre y cuando se tome en una
	 * linea distinta a la actual dentro del transcurso de una hora. Solo se
	 * acepta 1 transbordo por vez
	 */
	
	public boolean transbordo(Colectivo colectivo, int hora) {
		if (	getUltimoViaje() != null 
				&& !getUltimoViaje().getColectivo().getLinea().equals(
						colectivo.getLinea())
				 && (hora - getUltimoViaje().getHora() <= 100)
				&& getHizoTransbordo() == false) {
			setHizoTransbordo(true);
			return true;
		}
		return false;
	}

	public boolean getHizoTransbordo() {
		return hizoTransbordo;
	}

	public void setHizoTransbordo(boolean hizoTransbordo) {
		this.hizoTransbordo = hizoTransbordo;
	}

	public abstract boolean pagarBoleto(Colectivo colectivo,int hora);

	public void addViaje(Viaje viaje) {
		viajes.add(viaje);
	}

	/*
	 * Con respecto a las recargas, rige la siguiente tabla de valores: Usted
	 * Carga $ Monto Adicional Saldo Total Menos de 196 0 Mismo saldo 196 34 230
	 * 368 92 460
	 */
	public void recarga(int monto) {
		if (monto < 196) {
			saldo += monto;
		}
		if (monto == 196) {
			saldo += (monto + 34);
		}
		if (monto == 368) {
			saldo += (monto + 92);
		}
	}

	/*
	 * Cuando se le consulta por el saldo a una tarjeta la misma debe devolver
	 * el saldo en pesos que tiene disponible.
	 */
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/*
	 * Cuando se consulta por los ultimos viajes, la tarjeta debe devolver una
	 * lista de objetos de tipo Viaje
	 */
	public Viaje getUltimoViaje() {
		int index = viajes.size() - 1;
		if (index >= 0)
			return viajes.get(index);

		return null;
	}

	public ArrayList<Viaje> viajesRealizados() {
		return viajes;
	}

	@Override
	public String toString() {
		return "Tarjeta [viajes=" + viajes + ", tarjetaId=" + tarjetaId + ", saldo=" + saldo + "]";
	}

}
