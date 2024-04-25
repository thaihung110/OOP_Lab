package hust.soict.globalict.aims.disc;

import hust.soict.globalict.aims.store.Media;

public class Disc extends Media{

	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public Disc(int id, String title, String category, String director, float cost) {
		super(id, title, category, cost);
		this.director = director;
		// TODO Auto-generated constructor stub
	}
	
	
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " - " + getLength() + " - " + getDirector();
	}
	
	
	

}
