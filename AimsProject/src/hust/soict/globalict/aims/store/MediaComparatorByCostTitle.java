package hust.soict.globalict.aims.store;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media m1, Media m2) {
		// First compare by cost in descending order
		int costCompare = Float.compare(m2.getCost(), m1.getCost());
		if (costCompare != 0) {
			return costCompare;
		}
		
		// If costs are equal, compare by title in alphabetical order
		return m1.getTitle().compareTo(m2.getTitle());
	}
}
