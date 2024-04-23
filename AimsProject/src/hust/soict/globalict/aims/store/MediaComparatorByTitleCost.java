package hust.soict.globalict.aims.store;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media m1, Media m2) {
		// First compare by title in alphabetical order
		int titleCompare = m1.getTitle().compareTo(m2.getTitle());
		if (titleCompare != 0) {
			return titleCompare;
		}
		
		// If titles are equal, compare by cost in descending order
		return Float.compare(m2.getCost(), m1.getCost());
	}
}
