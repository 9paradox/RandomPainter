import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {
	
	private static int totalColors = 16;
	private static ColorBox[] colors;
	
	public ColorPanel() {
		
		colors = new ColorBox[totalColors];
		

		colors[0] = new ColorBox(0, new Color(255,255,255));
		colors[1] = new ColorBox(0, new Color(0,0,0));
		add(colors[0]);
		add(colors[1]);
		for(int i=2;i<totalColors;i++){
			colors[i] = new ColorBox(i, new Color(getRandom(),getRandom(),getRandom()));
			add(colors[i]);
		}
		
		
		
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(1,5));
	}
	
	public static void setRandomColors(){
		for(int i=2;i<totalColors;i++){
			colors[i].setColor(new Color(getRandom(),getRandom(),getRandom()));
		}

		SelectedColor.color = colors[SelectedColor.selectedColorIndex].getColor();
	}
	
	public static void setSelectedColor(int n){
		for(int i=0;i<totalColors;i++){
			if(i!=n)
			colors[i].setDefault();
		}
	}
	
	
	public static int getRandom(){
		return  (int)(Math.random()*((255-1)+1))+1;
	}
}
