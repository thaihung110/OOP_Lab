package hust.soict.globalict.aims.store;
import java.util.ArrayList;
import java.util.Collections;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}


	public void addMedia(Media media) {
		if (!itemsInStore.contains(media)) {
			itemsInStore.add(media);
			System.out.println("Added media to the store.");
		}
		else {
			System.out.println("Media is already in the store.");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Removed media from the store.");
		}
		else {
			System.out.println("Media does not exist in the store.");
		}
	}
	
	public void sortItemsByCostTitle() {
	    Collections.sort(itemsInStore, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void sortItemsByTitleCost() {
	    Collections.sort(itemsInStore, Media.COMPARE_BY_TITLE_COST);
	}
	
	public static void storeMenu() {
		System.out.println("Store Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

		
}
