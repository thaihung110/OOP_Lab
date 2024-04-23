package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Media;
import hust.soict.globalict.aims.store.Store;
public class Aims {
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void main(String[] args) {
		
		Aims.showMenu();
		Store store = new Store();
		Cart cart = new Cart();
		int countDVD = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int number = scanner.nextInt();
			if (number == 1) {
				
				Store.storeMenu();
				
				while(true) {
					
					int storeOption = scanner.nextInt();
					
					if (storeOption == 0) {
						Aims.showMenu();
						break;
					}
					
					else if(storeOption == 1) {
						System.out.println("Enter the media's title:");
						scanner.nextLine();
						String title = scanner.nextLine();
						int flag = 0;
						for (int i = 0; i < store.getItemsInStore().size(); i++) {
							if (store.getItemsInStore().get(i).getTitle().equals(title)) {
								flag = 1;
								System.out.println(store.getItemsInStore().get(i).toString());
								
								Media.mediaDetailsMenu();
								
								while (true) {
									int mediaOption = scanner.nextInt();
									if (mediaOption == 1) {
										cart.addMedia(store.getItemsInStore().get(i));
										
										Media.mediaDetailsMenu();
										
									}
									else if (mediaOption == 2) {
										
										if (store.getItemsInStore().get(i) instanceof DigitalVideoDisc) {
											DigitalVideoDisc dvd = (DigitalVideoDisc) store.getItemsInStore().get(i);
											dvd.play();
										}
										else if (store.getItemsInStore().get(i) instanceof CompactDisc) {
											CompactDisc cd = (CompactDisc) store.getItemsInStore().get(i);
											cd.play();
										}
										
										Media.mediaDetailsMenu();
										
									}
										
									else if (mediaOption == 0) {
										Store.storeMenu();
										break;
									}
									
								}
								
							}
						}
						if (flag == 0) System.out.println("The title is not valid in the store");
						
						Store.storeMenu();
					}
					
					
					
					else if (storeOption == 2) {
						System.out.println("Enter the media's title:");
						scanner.nextLine();
						String titleAddToCart = scanner.nextLine();
						int flag2 = 0;
						for (int i = 0; i < store.getItemsInStore().size(); i++) {
							if (store.getItemsInStore().get(i).getTitle().equals(titleAddToCart)) {
								flag2 = 1;
								cart.addMedia(store.getItemsInStore().get(i));
								if (store.getItemsInStore().get(i) instanceof DigitalVideoDisc) {
									countDVD++;
									System.out.printf("Number of DVD currently in the cart: %d\n", countDVD);
								}
							}
						}
						if (flag2 == 0) System.out.println("The title is not valid in the store");
						
						Store.storeMenu();
					}
					
					
					else if (storeOption == 3) {
						System.out.println("Enter the media's title:");
						scanner.nextLine();
						String titlePlay = scanner.nextLine();
						int flag3 = 0;
						for (int i = 0; i < store.getItemsInStore().size(); i++) {
							if (store.getItemsInStore().get(i).getTitle().equals(titlePlay)) {
								flag3 = 1;
								if (store.getItemsInStore().get(i) instanceof DigitalVideoDisc) {
									DigitalVideoDisc dvd = (DigitalVideoDisc) store.getItemsInStore().get(i);
									dvd.play();
								}
								else if (store.getItemsInStore().get(i) instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc) store.getItemsInStore().get(i);
									cd.play();
								}
							}
						}
						if (flag3 == 0) System.out.println("The title is not valid in the store");
						
						Store.storeMenu();
					}
					
					
				}
				
			}
				
			else if (number == 2) {
				DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger", 87, 19.95f);
				DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Lucas", 87, 24.95f);
				DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
				
				store.addMedia(dvd1);
				store.addMedia(dvd2);
				store.addMedia(dvd3);
				
				Aims.showMenu();
			}
			
			else if (number == 3) {
				Cart.cartMenu();
				
				while (true) {
					int cartOption = scanner.nextInt();
					
					if (cartOption == 0) {
						Aims.showMenu();
						break;
					}
					
					else if (cartOption == 1) {
						System.out.println("Enter filtering option:");
						scanner.nextLine();
						String filterOption = scanner.nextLine();
						if (filterOption.toLowerCase().equals("id")) {
							System.out.println("Enter media's ID:");
							int id = scanner.nextInt();
							
							int flag4 = 0;
							for (int i = 0; i < store.getItemsInStore().size(); i++) {
								if (store.getItemsInStore().get(i).getId() == id) {
									System.out.println(store.getItemsInStore().get(i).toString());
								}
							}
							if (flag4 == 0) System.out.println("The ID is not valid in the store");
						}
						
						else if (filterOption.toLowerCase().equals("title")) {
							System.out.println("Enter media's title:");
							scanner.nextLine();
							String title = scanner.nextLine();
							
							int flag5 = 0;
							for (int i = 0; i < store.getItemsInStore().size(); i++) {
								if (store.getItemsInStore().get(i).getTitle().equals(title)) {
									System.out.println(store.getItemsInStore().get(i).toString());
								}
							}
							if (flag5 == 0) System.out.println("The ID is not valid in the store");
						}
						
						Cart.cartMenu();
					}
					
					else if (cartOption == 2) {
						System.out.println("Enter sorting option:");
						scanner.nextLine();
						String sortOption = scanner.nextLine();
						
						if (sortOption.toLowerCase().equals("title")) {
							cart.sortItemsByTitleCost();
						}
						
						else if (sortOption.toLowerCase().equals("cost")) {
							cart.sortItemsByCostTitle();
						}
						
						Cart.cartMenu();
					}
					
					else if (cartOption == 3) {
						
						Cart.cartMenu();
					}
					
					else if (cartOption == 4) {
						
						Cart.cartMenu();
					}
					
					
					else if (cartOption == 5) {
						System.out.println("An order is created");
						ArrayList<Media> empty_list = new ArrayList<Media>();
						cart.setItemsOrdered(empty_list);
						System.out.printf("Size of the cart: %d\n", cart.getItemsOrdered().size());
						
						Cart.cartMenu();
					}
				}
				
			}
			
			else if (number == 0) {
				System.out.println("Exit the application");
				break;
			}
			
		}
		
		
		scanner.close();
	}

}
