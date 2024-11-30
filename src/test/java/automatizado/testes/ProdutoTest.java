package automatizado.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.ProdutoPO;

public class ProdutoTest extends BaseTest {

	private static ProdutoPO ProdutoPage;
	
	@BeforeClass
	public static void prepararTeste() {
		ProdutoPage = new ProdutoPO(driver);
	}
	private void abrirModal() {
		ProdutoPage.buttonAdicionar.click();
		ProdutoPage.buttonAdicionar.click();
	}
	
	@Test
	public void TC006_cadastrarProdutoComTodosOsCamposPreenchidos() {
		this.abrirModal();
		ProdutoPage.inputCodigo.sendKeys("2");
		ProdutoPage.inputNome.sendKeys("Refrigerente");
		ProdutoPage.inputQuantidade.sendKeys("10");
		ProdutoPage.inputValor.sendKeys("10.00");
		ProdutoPage.intputData.sendKeys("10/09/2021");
		ProdutoPage.buttonSalvar.click();		
		//Verifica se o produto foi inserido na tabela		
		assertEquals(ProdutoPage.produto1.isDisplayed(), true);
	}
	
	@Test
	public void TC007_adicionarProdutosIguais() {
		//ADICIONA 2x PRODUTOS IGUAIS
		for (int i = 1; i <=2; i++) {
			this.abrirModal();
			ProdutoPage.inputCodigo.sendKeys("2");
			ProdutoPage.inputNome.sendKeys("Refrigerente");
			ProdutoPage.inputQuantidade.sendKeys("10");
			ProdutoPage.inputValor.sendKeys("10.00");
			ProdutoPage.intputData.sendKeys("10/09/2021");
			ProdutoPage.buttonSalvar.click();
			ProdutoPage.buttonSair.click();			
		}			
		//Verifica se o produto com o mesmo codigo foi inserido na tabela na segunda linha	
		assertEquals(ProdutoPage.produto2.isDisplayed(), false);
	}
	
	@Test
	public void TC008_removerProduto() {
		this.abrirModal();
		ProdutoPage.inputCodigo.sendKeys("2");
		ProdutoPage.inputNome.sendKeys("Refrigerente");
		ProdutoPage.inputQuantidade.sendKeys("10");
		ProdutoPage.inputValor.sendKeys("10.00");
		ProdutoPage.intputData.sendKeys("10/09/2021");
		ProdutoPage.buttonSalvar.click();		
		ProdutoPage.excluirProduto1.click();
		//Verifica se o produto da linha 1 não existe mais.
		assertEquals(ProdutoPage.produto1.isDisplayed(), false);		
	}
	
	@Test
	public void TC009_editarProduto() {
		this.abrirModal();
		ProdutoPage.inputCodigo.sendKeys("2");
		ProdutoPage.inputNome.sendKeys("Refrigerente");
		ProdutoPage.inputQuantidade.sendKeys("10");
		ProdutoPage.inputValor.sendKeys("10.00");
		ProdutoPage.intputData.sendKeys("10/09/2021");
		ProdutoPage.buttonSalvar.click();				
		assertEquals(ProdutoPage.editarProduto1.isEnabled(), true);
		
	}
	
	@Test
	public void TC010_salvarProdutoCampoVazio() {
		this.abrirModal();
		ProdutoPage.inputCodigo.sendKeys("2");
		ProdutoPage.inputNome.sendKeys("Refrigerente");		
		ProdutoPage.inputValor.sendKeys("10.00");
		ProdutoPage.intputData.sendKeys("10/09/2021");
		ProdutoPage.buttonSalvar.click();				
		String mensage = ProdutoPage.spanMensagem.getText();
		//Verifica se a mensagem de erro é exibida.
		assertEquals(mensage, "Todos os campos são obrigatórios para o cadastro!");
		
	}
}
