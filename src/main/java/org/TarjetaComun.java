package  org;

public class TarjetaComun extends Tarjeta {
	/* TarjetaComun: Paga el boleto a 5.75 y el transbordo a 1.90
	  
	  Cada vez que se usa una tarjeta para pagar un boleto se descuenta el
	  monto del pasaje de dicho saldo. Si la tarjeta tenia saldo suficiente
	  para pagar el boleto, el metodo PagarBoleto devuelve True, en caso
	  contrario, devuelve False.
	  
	  El boleto de tipo transbordo es valido siempre y cuando se tome en una
	  linea distinta a la actual dentro del transcurso de una hora.
	  
	  usar java.Time	 */

	public TarjetaComun(int tarjetaId) {
		super(tarjetaId);
	}

	@Override
	public boolean pagarBoleto(Colectivo colectivo,int horario) {
		
		
		if (transbordo(colectivo, horario) && getSaldo() > 1.90) {
			setSaldo(getSaldo() - 1.90);
			addViaje(new Viaje(colectivo, horario, 1.90));

			return true;
		} else

		if (getSaldo() > 5.75) {
			setSaldo(getSaldo() - 5.75);
			addViaje(new Viaje(colectivo, horario, 5.75));
			return true;
		}

		return false;
	}

}
