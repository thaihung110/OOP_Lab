package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.Track;
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
				
				for (int i = 0; i < store.getItemsInStore().size(); i++) {
					System.out.println(store.getItemsInStore().get(i).toString());
				}
				
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
										
										cart.print();
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
						for (int i = 0; i < store.getItemsInStore().size(); i++) {
							System.out.println(store.getItemsInStore().get(i).toString());
						}
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
						
						cart.print();
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
					
					else if (storeOption == 4) {
						cart.print();						
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
									for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
										if (cart.getItemsOrdered().get(i).getId() == id) {
											System.out.println(cart.getItemsOrdered().get(i).toString());
										}
									}
									if (flag4 == 0) System.out.println("The ID is not valid in the store");
								}
								
								else if (filterOption.toLowerCase().equals("title")) {
									System.out.println("Enter media's title:");
									String title = scanner.nextLine();
									
									int flag5 = 0;
									for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
										if (cart.getItemsOrdered().get(i).getTitle().equals(title)) {
											System.out.println(cart.getItemsOrdered().get(i).toString());
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
								
								cart.print();
								Cart.cartMenu();
							}
							
							else if (cartOption == 3) {
								
								System.out.println("Enter the media's title:");
								scanner.nextLine();
								String titlePlay = scanner.nextLine();
								int flag3 = 0;
								for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
									if (cart.getItemsOrdered().get(i).getTitle().equals(titlePlay)) {
										flag3 = 1;
										cart.removeMedia(cart.getItemsOrdered().get(i));
									}
								}
								if (flag3 == 0) System.out.println("The title is not valid in the cart");
								
								cart.print();
								Cart.cartMenu();
							}
							
							else if (cartOption == 4) {
								
								System.out.println("Enter the media's title:");
								scanner.nextLine();
								String titlePlay = scanner.nextLine();
								int flag3 = 0;
								for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
									if (cart.getItemsOrdered().get(i).getTitle().equals(titlePlay)) {
										flag3 = 1;
										if (cart.getItemsOrdered().get(i) instanceof DigitalVideoDisc) {
											DigitalVideoDisc dvd = (DigitalVideoDisc) cart.getItemsOrdered().get(i);
											dvd.play();
										}
										else if (cart.getItemsOrdered().get(i) instanceof CompactDisc) {
											CompactDisc cd = (CompactDisc) cart.getItemsOrdered().get(i);
											cd.play();
										}
									}
								}
								if (flag3 == 0) System.out.println("The title is not valid in the cart");
								
								
								
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
						
						Aims.showMenu();
					}
					
					
				}
				
			}
				
			else if (number == 2) {
				System.out.println("Enter update option: ");
				scanner.nextLine();
				String updateOption = scanner.nextLine();
				
				if (updateOption.toLowerCase().equals("add")) {
					System.out.println("Enter the type of media to add to the store: ");
					String type = scanner.nextLine();
					
					int id;
					String title;
					String category;
					float cost;
					
					System.out.println("Enter the id: ");
					id = scanner.nextInt();
					
					System.out.println("Enter the title: ");
					scanner.nextLine();
					title = scanner.nextLine();
					
					System.out.println("Enter the category: ");
					category = scanner.nextLine();
					
					System.out.println("Enter the cost: ");
					cost = scanner.nextFloat();
					
					if (type.toLowerCase().equals("book")) {
						List<String> authors = new ArrayList<String>();
						
						System.out.println("Enter the list of authors: ");
						String author;
						
						scanner.nextLine();
						author = scanner.nextLine();
						
						while (!author.equals("")) {
							authors.add(author);
							author = scanner.nextLine();
						}
						
						Book book = new Book(id, title, category, cost, authors);
						store.addMedia(book);
						
						Aims.showMenu();
					}
					
					else {
						
						String director;
						System.out.println("Enter the director: ");
						scanner.nextLine();
						director = scanner.nextLine();
						
						if (type.toLowerCase().equals("cd")) {
							String artist;
							List<Track> tracks = new ArrayList<Track>();
							
							System.out.println("Enter the artist: ");
							artist = scanner.nextLine();
							
							System.out.println("Enter the list of track: ");
							System.out.println("Enter the title of the track: ");
							String trackTitle = scanner.nextLine();
							
							while (!trackTitle.equals("")) {
								System.out.println("Enter the length of the track");
								int trackLength = scanner.nextInt();
								Track track =  new Track(trackTitle, trackLength);
								tracks.add(track);
								
								System.out.println("Enter the title of the track: ");
								scanner.nextLine();
								trackTitle = scanner.nextLine();
							}
							
							CompactDisc cd = new CompactDisc(id, title, category, director, 
									cost, artist, tracks);
							
							store.addMedia(cd);
							Aims.showMenu();
						}
						
						
						else if (type.toLowerCase().equals("dvd")) {
							int length;
							System.out.println("Enter the length: ");
							length = scanner.nextInt();
							
							DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,
									director, length, cost);
							
							store.addMedia(dvd);
							
							Aims.showMenu();
						}
					}
					
				}
				
				else if (updateOption.toLowerCase().equals("remove")) {
					System.out.println("Enter the media's title:");
					String titleStore = scanner.nextLine();
					int flag3 = 0;
					for (int i = 0; i < store.getItemsInStore().size(); i++) {
						if (store.getItemsInStore().get(i).getTitle().equals(titleStore)) {
							flag3 = 1;
							store.removeMedia(store.getItemsInStore().get(i));
						}
					}
					if (flag3 == 0) System.out.println("The title is not valid in the store");
					
					Aims.showMenu();
				}
			}
			
			
			else if (number == 3) {
				cart.print();
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
							for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
								if (cart.getItemsOrdered().get(i).getId() == id) {
									System.out.println(cart.getItemsOrdered().get(i).toString());
								}
							}
							if (flag4 == 0) System.out.println("The ID is not valid in the store");
						}
						
						else if (filterOption.toLowerCase().equals("title")) {
							System.out.println("Enter media's title:");
							String title = scanner.nextLine();
							
							int flag5 = 0;
							for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
								if (cart.getItemsOrdered().get(i).getTitle().equals(title)) {
									System.out.println(cart.getItemsOrdered().get(i).toString());
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
						
						cart.print();
						Cart.cartMenu();
					}
					
					else if (cartOption == 3) {
						
						System.out.println("Enter the media's title:");
						scanner.nextLine();
						String titlePlay = scanner.nextLine();
						int flag3 = 0;
						for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
							if (cart.getItemsOrdered().get(i).getTitle().equals(titlePlay)) {
								flag3 = 1;
								cart.removeMedia(cart.getItemsOrdered().get(i));
							}
						}
						if (flag3 == 0) System.out.println("The title is not valid in the cart");
						
						cart.print();
						Cart.cartMenu();
					}
					
					else if (cartOption == 4) {
						
						System.out.println("Enter the media's title:");
						scanner.nextLine();
						String titlePlay = scanner.nextLine();
						int flag3 = 0;
						for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
							if (cart.getItemsOrdered().get(i).getTitle().equals(titlePlay)) {
								flag3 = 1;
								if (cart.getItemsOrdered().get(i) instanceof DigitalVideoDisc) {
									DigitalVideoDisc dvd = (DigitalVideoDisc) cart.getItemsOrdered().get(i);
									dvd.play();
								}
								else if (cart.getItemsOrdered().get(i) instanceof CompactDisc) {
									CompactDisc cd = (CompactDisc) cart.getItemsOrdered().get(i);
									cd.play();
								}
							}
						}
						if (flag3 == 0) System.out.println("The title is not valid in the cart");
						
						
						
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
