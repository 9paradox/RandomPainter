import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

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
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void saveAsImage() throws IOException{
		final JFileChooser fc = new JFileChooser();
	    int retrival = fc.showSaveDialog(null);
		if(fc.getSelectedFile()!=null){
			String ext = ".png";
			Debuger.Log("Saving File to : "+fc.getSelectedFile().getPath()+""+ext);
			saveAsImg(fc.getSelectedFile().getPath()+""+ext);
		}
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
	
	public void saveFile() {
	    String sb = "TEST CONTENT";
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("F://"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".png");
	            fw.write(sb.toString());
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public void resetGame(){
		
		paintCanvas.clearGame();
	}
}
