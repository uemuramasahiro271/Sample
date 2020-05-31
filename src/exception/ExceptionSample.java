package exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import common.ISample;

public class ExceptionSample implements ISample {

	public void execute() {
		exception1();
		exception2();
		exception3();
		exception4();
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

	private void exception4() {
	    try (InputStream inputStream = new FileInputStream("srcFile"); OutputStream outputStream = new FileOutputStream("destFile")) {
	        byte[] buf = new byte[100];
	        int n;
	        while ((n = inputStream.read(buf)) >= 0) {
	        	outputStream.write(buf, 0, n);
	        }
	    } catch(IOException e) {
	    	System.out.println("例外:IOException");
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
		throw new ErrorA("Error:ErrorA");
	}
}
