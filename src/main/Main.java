package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QRCode.QRCodeSample;
import anonymous.AnonymousSample;
import collection.CollectionSample;
import date.DateSample;
import exception.ExceptionSample;
import reflection.ReflectionSample;

public class Main extends JFrame {

	public static void main(String[] args) {

		JFrame frame = new Main("Sample");
		frame.setVisible(true);

	}

	private Main(String title) {

		setTitle(title);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		Map<String, ActionListener> map = new HashMap<String, ActionListener>();
		map.put("リフレクション", reflectionListener());
		map.put("匿名クラス", anonymousListener());
		map.put("コレクション", collectionListener());
		map.put("QRコード", qrCodeListener());
		map.put("日付", dateListener());
		map.put("例外", exceptionListener());

		setupButton(panel, map);

	    Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);
	}

	private void setupButton(JPanel panel, Map<String, ActionListener> map) {
		for(var entry: map.entrySet()) {
			JButton button = createJButton(entry.getKey());
			setButtonClickAction(button, entry.getValue());
			panel.add(button);
		}
	}

	private JButton createJButton(String text) {

		JButton button = new JButton(text);

		return button;
	}

	private void setButtonClickAction(JButton b, ActionListener listener) {

	    // ボタンにアクションリスナーを追加
	    b.addActionListener(listener);
	}

	private ActionListener reflectionListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new ReflectionSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener anonymousListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new AnonymousSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener collectionListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new CollectionSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener qrCodeListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new QRCodeSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener dateListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new DateSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener exceptionListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  var sample = new ExceptionSample();
		    	  sample.execute();
		      }
		    };
	}

}

