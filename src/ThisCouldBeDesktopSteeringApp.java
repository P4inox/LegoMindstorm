import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ThisCouldBeDesktopSteeringApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThisCouldBeDesktopSteeringApp window = new ThisCouldBeDesktopSteeringApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThisCouldBeDesktopSteeringApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 252, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisIsText = new JLabel("Dis is Text go away!");
		lblDisIsText.setBounds(69, 72, 97, 14);
		frame.getContentPane().add(lblDisIsText);
	}

}
