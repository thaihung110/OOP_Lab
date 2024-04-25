package hust.soict.globalict.aims.book;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.store.Media;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Added " + authorName + " to the list.");
		}
		else {
			System.out.println(authorName + " is already in the list.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Removed " + authorName + " from the list.");
		}
		else {
			System.out.println(authorName + " does not exist in the list.");
		}
	}

	@Override
	public String toString() {
		return "Book: " + super.toString() + " - " + getAuthors();
	}
	

}
