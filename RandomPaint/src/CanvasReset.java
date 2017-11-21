import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CanvasReset extends JPanel{
	public static JLabel resetText,randomColorText;
	private PaintingWindow game;
	public CanvasReset(PaintingWindow g) {
		game = g;
		setBackground(Color.BLACK);
		resetText = new JLabel("Reset Canvas",JLabel.CENTER);
		resetText.setEnabled(true);
		resetText.setOpaque(true);
		resetText.setFont(new Font(getFont().getName(), Font.BOLD, 23));
		resetText.setForeground(Color.white);
		resetText.setBackground(Color.black);
		resetText.setSize(400, 100);
		resetText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				resetText.setForeground(Color.cyan);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetText.setForeground(Color.white);
				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					game.resetGame();
				Debuger.Log("Canvas Resetting");
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				resetText.setForeground(Color.DARK_GRAY);
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		add(resetText);
		
		randomColorText = new JLabel("Random Colors",JLabel.CENTER);
		randomColorText.setEnabled(true);
		randomColorText.setOpaque(true);
		randomColorText.setFont(new Font(getFont().getName(), Font.BOLD, 23));
		randomColorText.setForeground(Color.white);
		randomColorText.setBackground(Color.black);
		randomColorText.setSize(400, 100);
		randomColorText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				randomColorText.setForeground(Color.cyan);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				randomColorText.setForeground(Color.white);
				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ColorPanel.setRandomColors();
				Debuger.Log("Random Colors");
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				randomColorText.setForeground(Color.DARK_GRAY);
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		add(randomColorText);
		setLayout(new GridLayout(1,2));
	}
	
}
