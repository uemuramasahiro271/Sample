package collection;

import java.util.Comparator;

public class ComparatorSample implements Comparator<Sample>{

	// o1 < o2 なら 1   入れ替える
	// o1 == o2 なら 0
	// o1 > o2 なら -1  入れ替えない

	@Override
	public int compare(Sample o1, Sample o2) {

		if(o1.getId() < o2.getId()) {
			return -1;
		}
		if(o2.getId() < o1.getId()) {
			return 1;
		}

		return 0;
	}

}
