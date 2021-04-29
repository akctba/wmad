package typingTutor;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TypingTutor {

	private JFrame frmWordTypingTutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypingTutor window = new TypingTutor();
					window.frmWordTypingTutor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TypingTutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWordTypingTutor = new JFrame();
		frmWordTypingTutor.setTitle("Word Typing Tutor");
		frmWordTypingTutor.setBounds(100, 100, 600, 389);
		frmWordTypingTutor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
