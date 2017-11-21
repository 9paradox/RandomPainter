import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ColorBox extends JLabel implements MouseListener{
	private int id;
	private Color color;
	public ColorBox(int i,Color c) {
		id = i;
		color = c;
		setBackground(color);
		setText(" ");
		setHorizontalAlignment(SwingConstants.CENTER);
	    setForeground(Color.WHITE);
		setFont(new Font(getFont().getName(), Font.BOLD, 23));
		addMouseListener(this);
		setEnabled(true);
		setOpaque(true);
		setDefault();
	}
	
	public void setDefault() {
		setText(" ");
		this.setBorder(BorderFactory.createLineBorder(color,5));
	}
	
	public void setSelected(){
		this.setBorder(BorderFactory.createLineBorder(color,5));
		ColorPanel.setSelectedColor(id);
		setText(" .. ");
	}
	
	public void setColor(Color c){
		color = c;
		setBackground(color);
		this.setBorder(BorderFactory.createLineBorder(color,5));
	}
	
	public Color getColor(){
		return color;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		SelectedColor.color = color;
		SelectedColor.selectedColorIndex = id;
		setSelected();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
