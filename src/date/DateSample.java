package date;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import common.ISample;

public class DateSample implements ISample {

	public void execute() {

		// 現在日時取得
		Date date = new Date();
		System.out.println(date);

        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        // フォーマット指定
        var pattern = "yyyy年MM月dd日E曜日k時mm分ss秒";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        System.out.println(format.format(date));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(ldt1.format(formatter));

        // LocalDateTimeのparseは時刻を指定しないとエラーになる
        LocalDateTime ldt2 = LocalDateTime.parse("2018/05/07 10:00:00", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(ldt2);

        LocalDateTime ldt3 = LocalDateTime.of(2000, 5, 8, 10, 22);
        System.out.println(ldt3);
        System.out.println(ldt3.with(DayOfWeek.SATURDAY));
        System.out.println(ldt3.with(DayOfWeek.SATURDAY).isBefore(ldt3));
        System.out.println(ldt3.with(DayOfWeek.SATURDAY).isAfter(ldt3));
	}
}
