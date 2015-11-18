package helloWorld;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;


import uk.co.placona.helloWorld.Colectivo;
import uk.co.placona.helloWorld.TarjetaComun;
import uk.co.placona.helloWorld.TarjetaMedioBoleto;

public class TPTest {

	/*
	 * @Before public void initialize() {
	 */

	TarjetaComun t1 = new TarjetaComun(1);
	Colectivo c1 = new Colectivo("Semtur", 01, "123");
	Colectivo c2 = new Colectivo("Semtur", 101, "122");
	Colectivo c3 = new Colectivo("Semtur", 201, "120");

	TarjetaMedioBoleto t2 = new TarjetaMedioBoleto(1);

	@Test
	public void recargaTarjetaTest() {
		t1.recarga(368);
		assertEquals(460, t1.getSaldo(), 0);
	}

	@Test
	public void transbordoFalseTest() {
		t1.recarga(20);
		assertTrue(t1.pagarBoleto(c1, 1000));
		assertTrue(t1.pagarBoleto(c3, 1020));
		assertFalse(t1.transbordo(c2, 1000));
	}

	@Test
	public void transbordoTrueTest() {
		t1.recarga(12);
		assertTrue(t1.pagarBoleto(c1, 1000));
		assertTrue(t1.transbordo(c2, 1040));
	}

	@Test
	public void pagarBoletoTarjetaComunTest() {

		t1.recarga(6);
		assertTrue(t1.pagarBoleto(c1, 1000));
	}

	@Test
	public void pagarBoletoMedioBoletoTest() {
		t2.recarga(20);
		assertTrue(t2.pagarBoleto(c1, 1500));
	}

	@Test
	public void dosViajesMismaTarjetaTest() {
		t1.recarga(12);
		assertTrue(t1.pagarBoleto(c1, 1000));
		assertTrue(t1.pagarBoleto(c1, 1002));
		assertEquals(0.5, t1.getSaldo(), 0);
	}

	@Test
	public void pagarBoletoTarjetaComunSinSaldoTest() {
		assertFalse(t1.pagarBoleto(c1, 1000));
	}

	@Test
	public void pagarBoletoMedioBoletoSinSaldoTest() {
		assertFalse(t2.pagarBoleto(c1, 1500));

	}

	@Test
	public void pagarBoletoMedioBoletoFueraHorarioTest() {
		t2.recarga(12);
		assertFalse(t2.pagarBoleto(c1, 500));
	}

}
