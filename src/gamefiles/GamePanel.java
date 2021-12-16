package gamefiles;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	final Dimension defaultDim;
	GameMap gm;
	private Timer t;
	
	public GamePanel(Dimension dim) {
		gm = new GameMap();
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		setUpKeyMappings();
		t = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();
				repaint();
				Toolkit.getDefaultToolkit().sync();
			}
		});
		t.start();
//		System.out.print(Toolkit.getDefaultToolkit().getScreenSize().getWidth() + ", " 
//		+ Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	}
	
	private void setUpKeyMappings() {
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "playerLeft");
		this.getActionMap().put("playerLeft", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GameMap.battle == null)
					GameMap.getCurrentMovablesList().get(0).turnLeft();
				if(GameMap.battle != null) {
					if(GameMap.battle.actionGrid.active() == true) {
						GameMap.battle.actionGrid.selectHorizontal();
					}
					if(GameMap.battle.movesGrid.active() == true) {
						GameMap.battle.movesGrid.selectHorizontal();
					}
				}
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "playerRight");
		this.getActionMap().put("playerRight", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(GameMap.battle == null)
					GameMap.getCurrentMovablesList().get(0).turnRight();
				if(GameMap.battle != null){
					if(GameMap.battle.actionGrid.active() == true) {
						GameMap.battle.actionGrid.selectHorizontal();
					}
					if(GameMap.battle.movesGrid.active() == true) {
						GameMap.battle.movesGrid.selectHorizontal();
					}
				}
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "playerBackward");
		this.getActionMap().put("playerBackward", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(GameMap.battle == null)
					GameMap.getCurrentMovablesList().get(0).turnBackward();
				if(GameMap.battle != null) {
					if(GameMap.battle.actionGrid.active() == true) {
						GameMap.battle.actionGrid.selectVertical();
					}
					if(GameMap.battle.movesGrid.active() == true) {
						GameMap.battle.movesGrid.selectVertical();
					}
				}
			}
		});

		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "playerForward");
		this.getActionMap().put("playerForward", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(GameMap.battle == null)
					GameMap.getCurrentMovablesList().get(0).turnForward();
				if(GameMap.battle != null) {
					if(GameMap.battle.actionGrid.active() == true) {
						GameMap.battle.actionGrid.selectVertical();
					}
					if(GameMap.battle.movesGrid.active() == true) {
						GameMap.battle.movesGrid.selectVertical();
					}
				}
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
		this.getActionMap().put("space", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GameMap.battle != null) {
					GameMap.battle.spaceKey();
				}
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
		this.getActionMap().put("escape", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GameMap.battle != null) {
					GameMap.battle.escapeKey();
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(195, 245, 180));
		gm.draw(g);
//		g.setColor(Color.GRAY);
//		for(int x = 0; x < 30; x++) {
//			g.drawLine(x*gm.squareWidth, 0, x*gm.squareWidth, gm.height);
//		}
//		for(int y = 0; y < 18; y++) {
//			g.drawLine(0, y*gm.squareHeight, gm.width, y*gm.squareHeight);
//		}
		
	}
}
