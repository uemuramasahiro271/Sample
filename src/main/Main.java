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
import common.ISample;
import date.DateSample;
import exception.ExceptionSample;
import reflection.ReflectionSample;
import test1.Test1;

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

		Map<String, ISample> map = new HashMap<String, ISample>();
		map.put("リフレクション", new ReflectionSample());
		map.put("匿名クラス", new AnonymousSample());
		map.put("コレクション", new CollectionSample());
		map.put("QRコード", new QRCodeSample());
		map.put("日付", new DateSample());
		map.put("例外", new ExceptionSample());

		setupButton(panel, map);

	    Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);

	    // モジュールシステム テスト
	    Test1 test1 = new Test1();
	    test1.test();
	}

	private void setupButton(JPanel panel, Map<String, ISample> map) {
		for(var entry: map.entrySet()) {
			JButton button = createJButton(entry.getKey());
			setButtonClickAction(button, createActionListener(entry.getValue()));
			panel.add(button);
		}
	}

	private JButton createJButton(String text) {

		JButton button = new JButton(text);

		return button;
	}

	private ActionListener createActionListener(ISample sample) {
		return new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  sample.execute();
		      }
		    };
	}

	private void setButtonClickAction(JButton b, ActionListener listener) {

	    // ボタンにアクションリスナーを追加
	    b.addActionListener(listener);
	}
}

