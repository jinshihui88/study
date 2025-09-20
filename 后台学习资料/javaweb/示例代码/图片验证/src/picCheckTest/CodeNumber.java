package picCheckTest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

public class CodeNumber {

	private static BufferedImage image = new BufferedImage(50, 20, 1);

	private static CodeNumber instance = new CodeNumber();

	public static final Random RANDOM = new Random();

	private CodeNumber() {
	}

	public static CodeNumber getInstance() {
		return instance;
	}
	
	
	public synchronized String writeRandNumber(int bits, int to, HttpServletRequest request) throws IOException {
		String rand = getRandNumber(bits, to);
		setSession(request, rand);
		return rand;
	}

	public synchronized Image codeNumber(int bits, int to, HttpServletRequest request) {
		String rand = getRandNumber(bits, to);
		Graphics g = image.getGraphics();
		refreshBgColor(g);
		g.setColor(getRandColor(20, 130));
		g.drawString(rand, 6, 16);
		g.dispose();
		setSession(request, rand);
		return image;
	}

	private String getRandNumber(int bits, int to) {
		StringBuffer randBuffer = new StringBuffer();
		for (int i = 1; i <= bits; i++)
			randBuffer.append(RANDOM.nextInt(to));

		return randBuffer.toString();
	}

	private void setSession(HttpServletRequest request, String rand) {
		request.getSession().removeAttribute("codeNum");
		request.getSession().setAttribute("codeNum", rand);
	}

	private void refreshBgColor(Graphics g) {
		g.fillRect(0, 0, 50, 20);
		g.setFont(new Font("Times New Roman", 0, 18));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 100; i++) {
			int x = RANDOM.nextInt(50);
			int y = RANDOM.nextInt(20);
			int xl = RANDOM.nextInt(12);
			int yl = RANDOM.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

	}

	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + RANDOM.nextInt(bc - fc);
		int g = fc + RANDOM.nextInt(bc - fc);
		int b = fc + RANDOM.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
