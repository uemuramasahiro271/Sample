package reflection;

public class Dog extends Animal{

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String shout() {
		return "BBB";
	}
}
