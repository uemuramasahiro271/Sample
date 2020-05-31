package exception;

public class ExceptionSample {

	public void execute() {
		exception1();
		exception2();
		exception3();
	}

	private void exception1() {
		try {
			testA();
		} catch (ExceptionA | ExceptionB e) {

			System.out.println(e.getMessage());
		}
	}

	private void exception2() {
		try {
			testB();
		} catch (ExceptionB e) {

			System.out.println(e.getMessage());
		}
	}

	private void exception3() {
		try {
			testC();
		} catch (ErrorA e) {

			System.out.println(e.getMessage());
		}
	}

	private void testA() throws ExceptionA {
		throw new ExceptionA("例外:ExceptionA");
	}

	private void testB() {
		// ExceptionBは非検査例外のためthrows不要
		throw new ExceptionB("例外:ExceptionB");
	}

	private void testC() {
		throw new ErrorA();
	}
}
