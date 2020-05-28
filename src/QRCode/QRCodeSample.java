package QRCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeSample {

	public void execute() {

		String source = "https://www.youtube.com/";

		// QRコード生成時のエンコーディング
		String encoding = "UTF-8";
		// サイズ(ピクセル)
		int size = 300;
		// 画像ファイルの保存先
		String filePath = "qr_code.png";

		var hints = new ConcurrentHashMap();

		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

		hints.put(EncodeHintType.CHARACTER_SET, encoding);

		hints.put(EncodeHintType.MARGIN, 0);

		QRCodeWriter writer = new QRCodeWriter();

		try {
			BitMatrix bitMatrix = writer.encode(source, BarcodeFormat.QR_CODE, size, size, hints);
	        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

	        //ファイルへの保存処理
	        ImageIO.write(image, "png", new File(filePath));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
