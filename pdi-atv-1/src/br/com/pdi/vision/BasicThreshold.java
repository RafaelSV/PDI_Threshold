package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicThreshold {

	BufferedImage image;
	int width, height, red, green, blue, gray;
	int auxRed, auxBlue, auxGreen;
	int threshold = 100;
		
	public void run() throws IOException {
		File input = new File("C:\\Faculdade\\PDI\\imagens\\image1.jfif");
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();
				
				auxRed = red;
				auxGreen = green;
				auxBlue = blue;
				
				red -= (auxBlue*0.4 + auxGreen*0.4);
				green -= (auxBlue + auxRed*1.5);
				blue -= (auxRed*1.5 + auxGreen);
				
				if (red < 0){
					red = 0;
				}
				if (green < 0){
					green = 0;
				}
				if (blue < 0){
					blue = 0;
				}
				gray = (red + green + blue);
				
				if (gray < 0){
					gray = 0;
				} else if (gray > 255) {
					gray = 255;
				}
				
				if(gray > threshold) {
					image.setRGB(j, i, Color.BLACK.getRGB());
				}else {
					image.setRGB(j, i, Color.WHITE.getRGB());
				}
								
			}			
		}
		
		File output = new File("C:\\Faculdade\\PDI\\imagens\\image1_bw10.jpg");
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
		
	}
	
	public static void main(String[] args) {
		try {
			new BasicThreshold().run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
