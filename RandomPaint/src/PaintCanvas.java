import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PaintCanvas extends JPanel{

	int totalPixels;
	Pixel[] pixels;
	
	public PaintCanvas() {
		totalPixels = 1024;
		pixels = new Pixel[totalPixels];
		
		for(int i = 0; i<totalPixels ; i++){
			pixels[i] = new Pixel(i);
			add(pixels[i]);
		}
		setLayout(new GridLayout(32,32));
	}
	
	public void clearGame(){
		
		for(int i = 0; i<totalPixels ; i++){
			pixels[i].setDefault();
		}
	}
}
