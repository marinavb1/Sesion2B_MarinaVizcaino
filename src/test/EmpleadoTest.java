package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	private TipoEmpleado tipoE, tipoV;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
		tipoV=TipoEmpleado.Vendedor;
		tipoE=TipoEmpleado.Encargado;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
		
	}

	@Test
	void testCalculaNominaBrutaEncargado() {
		double expected=2500;
		double actual=Empleado.CalculaNominaBruta(tipoE,0,0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaBrutaVendedor() {
		double expected=2000;
		double actual=Empleado.CalculaNominaBruta(tipoV,0,0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesNegativa() {
		double expected=-1;
		double actual=Empleado.CalculaNominaBruta(tipoV,-8,0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesMenor1000() {
		double expected=2000;
		double actual=Empleado.CalculaNominaBruta(tipoV,50,0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaBrutaVentasMesEntre1000y1500() {
		double expected=2600;
		double actual=Empleado.CalculaNominaBruta(tipoE,1050,0);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculaNominaBrutaVentasMesMayor1500() {
		double expected=2700;
		double actual=Empleado.CalculaNominaBruta(tipoE,1600,0);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculaNominaBrutaHorasExtrasPositivas() {
		double expected=2650;
		double actual=Empleado.CalculaNominaBruta(tipoE,0,5);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculaNominaBrutaHorasExtrasNegativas() {
		double expected=-1;
		double actual=Empleado.CalculaNominaBruta(tipoE,0,-10);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNeta2100() {
		double expected=Empleado.CalculaNominaBruta(tipoV,0,0);
		double actual=Empleado.calculoNominaNeta(Empleado.CalculaNominaBruta(tipoV,0,0));
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		double expected=Empleado.CalculaNominaBruta(tipoV,2000,0)-Empleado.CalculaNominaBruta(tipoV,2000,0)*0.15;
		double actual=Empleado.calculoNominaNeta(Empleado.CalculaNominaBruta(tipoV,2000,0));
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaNetaMayor2500() {
		double expected=Empleado.CalculaNominaBruta(tipoE,1500,50)-Empleado.CalculaNominaBruta(tipoE,1500,50)*0.18;
		double actual=Empleado.calculoNominaNeta(Empleado.CalculaNominaBruta(tipoE,1500,50));
		assertEquals(expected, actual);
	}

}
