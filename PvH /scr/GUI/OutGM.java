package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OutGM {

	private BufferedImage image;

	public OutGM() {
		try {
			image = ImageIO.read(new File("./pvhLogo.gif"));
		} catch (IOException ex) {

		}
	}

	public void draw(Graphics g) {

		g.drawImage(image, 50, 50, null);

	}

}
