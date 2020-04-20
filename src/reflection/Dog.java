package reflection;

public class Dog extends BaseAnimal{

	private int age;

	public Dog() {
		super("犬");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void shout() {
		System.out.print("BBB");
	}
}
