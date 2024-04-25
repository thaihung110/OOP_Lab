package hust.soict.globalict.aims.disc.DigitalVideoDisc;

import hust.soict.globalict.aims.disc.Disc;
import hust.soict.globalict.aims.disc.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	
	public boolean equals(DigitalVideoDisc obj) {
		return this.getTitle() == obj.getTitle() && this.getCategory() == obj.getCategory()
		&& this.getDirector() == obj.getDirector() && this.getLength() == obj.getLength()
		&& this.getCost() == obj.getCost();
	}
	
	@Override
	public String toString() {
		return "DVD: " + super.toString();
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}

	
}
