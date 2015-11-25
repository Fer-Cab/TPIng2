package  org;

public class TarjetaMedioBoleto extends Tarjeta {

	/*
	 * TarjetaMedioBoleto: Paga el boleto a 2.90 y el transbordo a 0,96
	 * 
	 * Las tarjetas de MedioBoleto solo son validas en horario escolar (de 6 a
	 * 24hs) en esta primera etapa del proyecto se asume que son validos todos
	 * los dias de la semana incluso Sabados y Domingos.
	 * 
	 * Cada vez que se usa una tarjeta para pagar un boleto se descuenta el
	 * monto del pasaje de dicho saldo. Si la tarjeta tenia saldo suficiente
	 * para pagar el boleto, el metodo PagarBoleto devuelve True, en caso
	 * contrario, devuelve False.
	 * 
	 * El boleto de tipo transbordo es valido siempre y cuando se tome en una
	 * linea distinta a la actual dentro del transcurso de una hora.
	 */

	public TarjetaMedioBoleto(int tarjetaId) {
		super(tarjetaId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean pagarBoleto(Colectivo colectivo,int horario) {

		
		if ( horario >=  600 && horario < 2400 ) {
			if (transbordo(colectivo, horario) && getSaldo() > 0.96) {
				setSaldo(getSaldo() - 0.96);
				addViaje(new Viaje(colectivo, horario, 0.96));
				return true;
			} else

			if (getSaldo() > 2.90) {
				setSaldo(getSaldo() - 2.90);
				addViaje(new Viaje(colectivo, horario, 2.90));
				return true;
			}
		}

		return false;
	}

}
