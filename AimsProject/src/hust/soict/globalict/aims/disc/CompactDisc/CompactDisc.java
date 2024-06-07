package hust.soict.globalict.aims.disc.CompactDisc;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.Disc;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.disc.Track;

public class CompactDisc extends Disc implements Playable{

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	private String artist;
	public List<Track> tracks = new ArrayList<Track>();


	public List<String> getTrackName() {
		List<String> lst = new ArrayList<String>();
		for (int i = 0; i < tracks.size(); i++) {
			lst.add(tracks.get(i).getTitle());
		}
		return lst;
	}


	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String artist, List<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, float cost, String artist, List<Track> tracks) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			List<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	
	public CompactDisc(int id, String title, String category, String director, float cost, String artist
			, List<Track> tracks) {
		super(id, title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
		// TODO Auto-generated constructor stub
	}

	public void addTrack(Track track) {
		if (!this.tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Added track to the list.");
		}
		else {
			System.out.println("Track is already in the list.");
		}
	}
	
	public void removeTrack(Track track) {
		if (this.tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Removed track from the list.");
		}
		else {
			System.out.println("Track does not exist in the list.");
		}
	}
	
	@Override
	public int getLength() {
		int s = 0;
		for (int i = 0; i < this.tracks.size(); i++) {
			s += this.tracks.get(i).getLength();
		}
		return s;
	}
	
	@Override
	public void play() {
		for (int i = 0; i < this.tracks.size(); i++) {
			this.tracks.get(i).play();
		} 
	}

	@Override
	public String toString() {
		return "CD: " + super.toString() + " - " + getArtist() + " - " + getTrackName();
	}
	
	
	
}
