package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.store.Media;

public class Cart {

	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("Added media to the cart.");
		}
		else {
			System.out.println("Media is already in the cart.");
		}
	}

	// Thêm phương thức để xóa sạch giỏ hàng
	public void emptyCart() {
		itemsOrdered.clear();
		System.out.println("All items have been removed from the cart.");
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed media from the cart.");
		}
		else {
			System.out.println("Media does not exist in the cart.");
		}
	}
	
	public float totalCost() {
		float s = 0.0f;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			s += this.itemsOrdered.get(i).getCost();
		}
		return s;
	}
	
	
	public void print() {
		System.out.println("***********************CART***********************\n"
				+ "Ordered Items:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.printf("%d. ", i + 1);
			System.out.println(itemsOrdered.get(i).toString());
		}
		
		System.out.printf("Total cost: %.2f $\n", this.totalCost());
		System.out.println("***************************************************");
	}
	
	public void search(String title) {
		int flag = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(title)) {
				System.out.println(itemsOrdered.get(i).toString());
				flag = 1;
			}
		}
		if (flag == 0)System.out.println("No match is found");
	}
	
	public void sortItemsByCostTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void sortItemsByTitleCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public static void cartMenu() {
		System.out.println("Cart Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}


	
}
