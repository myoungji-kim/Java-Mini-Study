package model.domain;

public class Board {
	private String title;
	private String text;
	
	public Board (){}
	public Board(String title, String text) {
		this.title = title;
		this.text = text;
	}
	
	// TITLE
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// TEXT
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return title + " " + text;
	}
	
}
