package reflection;

public class ReflectionSample {

	public void execute() {

		try {

			Class<?> dogClass = Class.forName("reflection.Dog");
			var dogObject = dogClass.getDeclaredConstructor().newInstance();

			// getDeclaredMethod()はサブクラスのメソッド一覧から検索する
			// var callMethod = dogObject.getClass().getDeclaredMethod("call");

			// getMethod()はベースクラスのメソッドを含む一覧から検索する
			var callMethod = dogObject.getClass().getMethod("call");
			callMethod.invoke(dogObject);

			var shoutMethod = dogObject.getClass().getDeclaredMethod("shout");
			shoutMethod.invoke(dogObject);

			Class<?> personClass = Class.forName("reflection.Person");
			var personObject = personClass.getDeclaredConstructor().newInstance();

			var personCallMethod = personObject.getClass().getMethod("callName", Animal.class);
			personCallMethod.invoke(personObject, dogObject);

		} catch(ReflectiveOperationException e) {

			System.out.print(e);
		}

	}
}
