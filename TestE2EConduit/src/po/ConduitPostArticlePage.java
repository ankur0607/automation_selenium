package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConduitPostArticlePage {
	
	WebDriver driver;
	
	public ConduitPostArticlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By postArticleHeader = By.tagName("h1");
	By postArticleAuthorLink = By.xpath("//a[@class='author']");
	By postArticleEditLink = By.xpath("//a[contains(@class, 'secondary')]");
	By postArticleDeleteButton = By.xpath("//button[contains(@class, 'danger')]");
	By postArticleArticleText = By.xpath("//div[@class='container page']//p");
	By postArticleCommentTextArea = By.tagName("textarea");
	By postArticlePostCommentButton = By.xpath("//button[contains(@class,'primary')]");
	By postArticlePostedComment = By.xpath("//p[@class=\"card-text\"]");
	
	public WebElement getPostArticleHeader() {
		return driver.findElement(postArticleHeader);
	}
	
	public WebElement getPostArticleAuthorLink() {
		return driver.findElement(postArticleAuthorLink);
	}
	
	public WebElement getPostArticleEditLink() {
		return driver.findElement(postArticleEditLink);
	}
	
	public WebElement getPostArtileDeleteButton() {
		return driver.findElement(postArticleDeleteButton);
	}
	
	public WebElement getPostArticleText() {
		return driver.findElement(postArticleArticleText);
	}
	
	public WebElement getPostArticleTextArea() {
		return driver.findElement(postArticleCommentTextArea);
	}
	
	public WebElement getPostArticlePostCommentButton() {
		return driver.findElement(postArticlePostCommentButton);
	}

}
