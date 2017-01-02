package gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {
	public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
            	BoardCR cb = new BoardCR();
            	JFrame f = new JFrame("Combate");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
	
	
}
