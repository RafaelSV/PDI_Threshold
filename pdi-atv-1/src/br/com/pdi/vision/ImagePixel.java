package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePixel {

	BufferedImage image;
	int width, height;
		
	public void run() throws IOException {
		File input = new File("C:\\Faculdade\\2021.2\\PDI\\images\\image1.jfif");
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				System.out.println("["+i+"]["+j+"]  R:"+pixel.getRed()+" G:"+pixel.getGreen()+" B:"+pixel.getBlue());				
			}			
		}		
	}
	
	public static void main(String[] args) {
		try {
			new ImagePixel().run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
