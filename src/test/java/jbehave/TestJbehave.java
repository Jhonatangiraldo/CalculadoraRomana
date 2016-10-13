package jbehave;

import org.gradle.Principal;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.*;

public class TestJbehave {
	String respuesta;
	String numero1;
	String numero2;
	
	//Este sera un metodo general
	@When("Yo oprimo el boton procesar")
	public void procesar(){
		Principal principal = new Principal(numero1, numero2);
		respuesta = principal.devuelta();
	}
	
	
	@Given("Ingreso numero XV y numero XI")	
	public void numeroXV_XI(){
		numero1 = "XI";
		numero2 = "XV";
	}
	
	@Then("Recibo el numero 26")
	public void recibo26(){
		assertEquals("XXVI", respuesta);
	}
	
	
	@Given("Ingreso numero I y numero I")	
	public void numeroI_I(){
		numero1 = "I";
		numero2 = "I";
	}
	
	@Then("Recibo el numero 2")
	public void recibo2(){
		assertEquals("II", respuesta);
	}
	
	
	@Given("Ingreso numero I y numero IV")	
	public void numeroI_IV(){
		numero1 = "I";
		numero2 = "IV";
	}
	
	@Then("Recibo el numero 5")
	public void recibo5(){
		assertEquals("V", respuesta);
	}
}
