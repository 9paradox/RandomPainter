import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PaintingWindow extends JFrame{

	ColorPanel status;
	PaintCanvas paintCanvas;
	CanvasReset reset;
	BorderLayout layout;
	public PaintingWindow() {
		paintCanvas = new PaintCanvas();
		status = new ColorPanel();
		layout = new BorderLayout();
		reset = new CanvasReset(this);
		setLayout(layout);
		
		add(status, BorderLayout.PAGE_START);
		add(paintCanvas, BorderLayout.CENTER);
		add(reset,BorderLayout.PAGE_END);
		
		setTitle("Paint With Random Colors");
		pack();
		setSize(600, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void saveAsImg(String imgname) throws IOException{
		status.setVisible(false);
		reset.setVisible(false);
		Container c = getContentPane();
		BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
		c.paint(im.getGraphics());
		ImageIO.write(im, "PNG", new File(imgname));
		status.setVisible(true);
		reset.setVisible(true);
	}
	
	public void resetGame(){
		
		paintCanvas.clearGame();
	}
}
