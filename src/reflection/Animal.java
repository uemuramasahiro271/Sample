package reflection;

public abstract class Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String call() {
		return "XXXXX";
	}

	public String shout() {
		return "AAA";
	}
}
