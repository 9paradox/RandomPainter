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

	ColorPanel colorPanel;
	PaintCanvas paintCanvas;
	CanvasControls canvasControls;
	BorderLayout layout;
	public PaintingWindow() {
		paintCanvas = new PaintCanvas();
		colorPanel = new ColorPanel();
		layout = new BorderLayout();
		canvasControls = new CanvasControls(this);
		setLayout(layout);
		
		add(colorPanel, BorderLayout.PAGE_START);
		add(paintCanvas, BorderLayout.CENTER);
		add(canvasControls,BorderLayout.PAGE_END);
		
		setTitle("Paint With Random Colors");
		pack();
		setSize(600, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void saveAsImg(String imgname) throws IOException{
		colorPanel.setVisible(false);
		canvasControls.setVisible(false);
		Container c = getContentPane();
		BufferedImage im = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
		c.paint(im.getGraphics());
		ImageIO.write(im, "PNG", new File(imgname));
		colorPanel.setVisible(true);
		canvasControls.setVisible(true);
	}
	
	public void resetGame(){
		
		paintCanvas.clearGame();
	}
}
