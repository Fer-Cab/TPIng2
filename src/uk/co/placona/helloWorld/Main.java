package  uk.co.placona.helloWorld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Colectivo c1 = new Colectivo("Semtur", 01, "123");
		Colectivo c2 = new Colectivo("Semtur", 11, "122");
		Colectivo c3 = new Colectivo("Semtur", 21, "120");

		TarjetaMedioBoleto t2 = new TarjetaMedioBoleto(1);
		
		t2.recarga(12);
		t2.pagarBoleto(c1, 1500);
		t2.pagarBoleto(c2, 1520);
		
		System.out.println(t2.viajesRealizados());
	}

}
