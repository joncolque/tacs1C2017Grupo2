package apiResult;

public class Review {
	
	private String author;
	private String content;
	
	public Review() {}
	
	public Review(String unNombre, String unaDesc) {
		author = unNombre;
		content = unaDesc;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
