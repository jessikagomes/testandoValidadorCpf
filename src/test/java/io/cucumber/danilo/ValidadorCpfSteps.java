package io.cucumber.danilo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ValidadorCpfSteps{
	
	public ValidadorCpfSteps() {
	    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	    browser = new ChromeDriver();
	}
	
	public WebDriver browser;

	@Quando("eu acesso o sistema de validacao de CPF")
	public void eu_acesso_o_sistema_de_validacao_de_CPF() {
	    browser.get("http://localhost:8080/");
	}
	
	@Quando("digito no campo nome {string}")
	public void digito_no_campo_nome(String string) {
	   WebElement input = browser.findElement( By.cssSelector("input[name='nome']") );
	   input.sendKeys(string);
	}
	
	@Quando("digito no campo cpf {string}")
	public void digito_no_campo_cpf(String string) {
		WebElement input = browser.findElement( By.cssSelector("input[name='cpf']") );
		input.sendKeys(string);
	}
	
	@Quando("clico no botao enviar")
	public void clico_no_botao_enviar() {
		WebElement input = browser.findElement(By.cssSelector("button"));
		input.click();
	}

	@Entao("eu devo ver a mensagem de sucesso {string}")
	public void eu_devo_ver_a_mensagem_de_sucesso(String string) {
		WebElement input = browser.findElement( By.cssSelector(".alert") );
		assertEquals(string, input.getText());
		browser.quit();
	}
	/*@Entao("eu devo ver a mensagem de sucesso \"Foi validado com sucesso“")
	public void eu_devo_ver_a_mensagem_de_sucesso_Foi_validado_com_sucesso() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

}