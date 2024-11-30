package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement intputData;
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "btn-sair")
	public WebElement buttonSair;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[6]/button[2]")	
	public WebElement excluirProduto1;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[6]/button[1]")
	public WebElement editarProduto1;
	
	//PRODUTOS
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]")
	public WebElement produto1;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[2]")
	public WebElement produto2;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
}
