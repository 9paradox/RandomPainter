import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Pixel extends JLabel implements MouseListener{
	private int id;
	private Color color;
	private boolean colorApplied;
	public Pixel(int i) {
		this.id = i;
		addMouseListener(this);
		setEnabled(true);
		setOpaque(true);
		setDefault();
	}
	
	public void setDefault() {
		colorApplied = false;
		setBackground(Color.white);
	    setForeground(Color.WHITE);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		color = SelectedColor.color;
		setBackground(color);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(SelectedColor.mousedPressed==true){
			color = SelectedColor.color;
			setBackground(color);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		SelectedColor.mousedPressed =true;
		color = SelectedColor.color;
		setBackground(color);
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		setBackground(color);
		SelectedColor.mousedPressed =false;
		
	}
}
