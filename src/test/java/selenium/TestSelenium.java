package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class TestSelenium {

	@Test
	public void test1(){
		FirefoxDriver driver = new FirefoxDriver();
	      driver.get("http://localhost:8080/ProjectNormal/index.html");
	      WebElement numero1 = driver.findElement(By.id("numero1"));
	      numero1.sendKeys("X");
	      WebElement numero2 = driver.findElement(By.id("numero2"));
	      numero2.sendKeys("V");
	      WebElement boton = driver.findElement(By.id("boton"));
	      boton.click();
	      WebElement resultado = driver.findElement(By.id("resultado"));
	      
	      assertEquals("XV", resultado.getAttribute("value"));
	}
	
	@Test
	public void test2(){
		FirefoxDriver driver = new FirefoxDriver();
	      driver.get("http://localhost:8080/ProjectNormal/index.html");
	      WebElement numero1 = driver.findElement(By.id("numero1"));
	      numero1.sendKeys("I");
	      WebElement numero2 = driver.findElement(By.id("numero2"));
	      numero2.sendKeys("X");
	      WebElement boton = driver.findElement(By.id("boton"));
	      boton.click();
	      WebElement resultado = driver.findElement(By.id("resultado"));
	      
	      assertEquals("XI", resultado.getAttribute("value"));
	}
	
	@Test
	public void test3(){
		FirefoxDriver driver = new FirefoxDriver();
	      driver.get("http://localhost:8080/ProjectNormal/index.html");
	      WebElement numero1 = driver.findElement(By.id("numero1"));
	      numero1.sendKeys("L");
	      WebElement numero2 = driver.findElement(By.id("numero2"));
	      numero2.sendKeys("X");
	      WebElement boton = driver.findElement(By.id("boton"));
	      boton.click();
	      WebElement resultado = driver.findElement(By.id("resultado"));
	      
	      assertEquals("LX", resultado.getAttribute("value"));
	}
}
