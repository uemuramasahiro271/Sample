package collection;

public class Sample implements Comparable<Sample>{

	private int id;
	private String name;

	public Sample(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Sample o) {
		return Integer.compare(id, o.getId());
	}
}
