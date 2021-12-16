package gamefiles;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class GameLauncher {
	public static JFrame gameFrame;
	public static GamePanel gamePanel;
	
	public static void main(String[] args) {
		gameFrame = new JFrame();
		JDialog dialogue = new JDialog();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Map<String,String> environMap= System.getenv();
		System.out.println(environMap.keySet());
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(dialogue.getGraphicsConfiguration());
		int taskBarHeight = scnMax.bottom;
		int taskBarWidth = scnMax.left + scnMax.right;
		gameFrame.setSize(screenSize.width - taskBarWidth, screenSize.height - taskBarHeight);
		Dimension d = new Dimension();
		d.width = screenSize.width - taskBarWidth;
		d.height = screenSize.height - taskBarHeight;
		gamePanel = new GamePanel(d);
		gameFrame.add(gamePanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}
}
