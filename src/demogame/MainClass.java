package demogame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		GamePlay gamePlay = new GamePlay();
		
		JMenuBar menubar = new JMenuBar();
			
		JMenu game = new JMenu("Game");
		JMenuItem btnStart = new JMenuItem("Start");
		JMenuItem btnPause = new JMenuItem("Pause");
		JMenuItem btnExit = new JMenuItem("Exit");
		game.add(btnStart);
		game.add(btnPause);
		game.add(btnExit);
		JMenu debug = new JMenu("Debug");
		JMenuItem item4 = new JMenuItem("Change ball speed");
		debug.add(item4);
		menubar.add(game);
		menubar.add(debug);
		frame.setJMenuBar(menubar);
		
		frame.add(gamePlay);
		frame.setTitle("Game");
		frame.setSize(700,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

	
	}

}
