package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.ISample;

public class OutputCsvSample implements ISample {

	public void execute() {

		var fileName = getFileName();

		FileOutputStream stream = null;
		PrintWriter pw = null;
		try {

			stream = new FileOutputStream(new File(fileName), false);
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream, "utf-8")));

			writeHeader(pw);

			// 改行
			pw.println();

			writeContent(pw);


		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if(stream != null) {
				try {
					pw.close();
					stream.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

	}

	private void writeHeader(PrintWriter pw) {

		var dataArray = new String[] {"名前", "年齢", "職業"};
		outputCsv(pw, dataArray);
	}

	private void writeContent(PrintWriter pw) {

		var dataArray = new String[] {"太郎", "18歳", "エンジニア"};
		outputCsv(pw, dataArray);
	}

	private void outputCsv(PrintWriter pw, String[] dataArray) {

		for(int i = 0; i < dataArray.length; i++) {
			pw.print(dataArray[i]);
			if(i < dataArray.length - 1) {
				pw.print(",");
			}
		}
	}

	private String getFileName() {

		// プロジェクトのパスを取得する
		var path = System.getProperty("user.dir");

		var outputFolderPath = Paths.get(path, "Csv");

        var pattern = "yyyyMMddkmmss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        var date = format.format(new Date());

		var fileName = String.format("csv_sample%s.csv", date);

		return Paths.get(outputFolderPath.toString(), fileName).toString();
	}
}
