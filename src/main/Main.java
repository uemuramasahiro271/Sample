package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import anonymous.AnonymousSample;
import collection.CollectionSample;
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
		    	  ReflectionSample sample = new ReflectionSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener anonymousListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  AnonymousSample sample = new AnonymousSample();
		    	  sample.execute();
		      }
		    };
	}

	private ActionListener collectionListener() {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  CollectionSample sample = new CollectionSample();
		    	  sample.execute();
		      }
		    };
	}

}

