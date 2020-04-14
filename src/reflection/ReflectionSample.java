package reflection;

public class ReflectionSample {

	public void execute() {

		try {

			Class<?> dogClass = Class.forName("reflection.Dog");
			var dogObject = dogClass.getDeclaredConstructor().newInstance();

			// ベースクラスのメソッドは見つからない
//			var callMethod = dogObject.getClass().getDeclaredMethod("call");
//			System.out.print(callMethod.invoke(dogObject));

			var shoutMethod = dogObject.getClass().getDeclaredMethod("shout");
			System.out.print(shoutMethod.invoke(dogObject));

		} catch(ReflectiveOperationException e) {

			System.out.print(e);
		}

	}
}
