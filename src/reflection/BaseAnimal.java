package reflection;

public abstract class BaseAnimal implements Animal {

	private String name;

	public BaseAnimal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void call() {
		System.out.print("XXXXX");
	}

	public void shout() {
		System.out.print("AAA");
	}
}
