package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import common.ISample;

public class CollectionSample implements ISample {

	public void execute() {

		List<Sample> list1 = new ArrayList<Sample>(
				Arrays.asList(new Sample[] { new Sample(2, "b"),  new Sample(3, "c"), new Sample(1, "a")}));

		list1.sort(new ComparatorSample());

		list1.forEach(sample -> System.out.println(sample.getName()));

		List<Sample> list2 = new ArrayList<Sample>(
				Arrays.asList(new Sample[] { new Sample(3, "c"),  new Sample(2, "b"), new Sample(1, "a")}));

		Collections.sort(list2);

		list2.forEach(sample -> System.out.println(sample.getName()));
	}
}
