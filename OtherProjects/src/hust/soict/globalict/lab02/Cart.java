package hust.soict.globalict.lab02;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			this.itemsOrdered[this.qtyOrdered] = disc;
			this.qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int flag = 0;
		int idx = 0;
		for (int i = 0; i < this.qtyOrdered; i++) {
			if (disc.equals(itemsOrdered[i])) {
				flag = 1;
				idx = i;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Cannot remove");
		}
		else {
			for (int i = idx; i <= this.qtyOrdered - 2; i++) {
				this.itemsOrdered[i] = this.itemsOrdered[i + 1];
			}
			this.qtyOrdered--;
			System.out.println("Removed sucessfully");
		}
		
	}
	
	public float totalCost() {
		float s = 0.0f;
		for (int i = 0; i < this.qtyOrdered; i++) {
			s += this.itemsOrdered[i].getCost();
		}
		
		return s;
	}
}
