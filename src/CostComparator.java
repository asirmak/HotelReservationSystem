import java.util.Comparator;

public class CostComparator implements Comparator<Services> {

	@Override
	public int compare(Services o1, Services o2) {
		return (int) (o2.getCost() - o1.getCost());
	}

}
