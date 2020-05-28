package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import QRCode.QRCodeSample;
import anonymous.AnonymousSample;
import collection.CollectionSample;
import date.DateSample;
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

		JButton button1 = createJButton("リフレクション");
		setButtonClickAction(button1, reflectionListener());
		panel.add(button1);

		JButton button2 = createJButton("匿名クラス");
		setButtonClickAction(button2, anonymousListener());
		panel.add(button2);

		JButton button3 = createJButton("コレクション");
		setButtonClickAction(button3, collectionListener());
		panel.add(button3);

		JButton button4 = createJButton("QRコード");
		setButtonClickAction(button4, qrCodeListener());
		panel.add(button4);

		JButton button5 = createJButton("日付");
		setButtonClickAction(button5, dateListener());
		panel.add(button5);

	    Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);
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

}

