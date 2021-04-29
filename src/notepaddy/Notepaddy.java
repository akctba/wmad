package notepaddy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Notepaddy extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4069133822276892944L;

	public static Notepaddy app;

	private JMenuBar mnuMain;
	private JMenu mnuFile;
	private JMenu mnuEdit;
	private JMenu mnuView;

	public Notepaddy() {
		this.setSize(400, 400);
//		textBox = new JTextArea();
//		this.add(textBox);
//		textBox.setBounds(0, 0, this.getWidth(), this.getHeight());

		menuBuilder();

		addNewTab(null);

	}

	private void addNewTab(String file) {

		if (file == null) {
			
			JTextArea ta=new JTextArea(200,200);  
		    JPanel p1=new JPanel();  
		    p1.add(ta);
		    
		    JTabbedPane tp=new JTabbedPane();  
		    tp.setBounds(0,0,200,200);
		    tp.add("new text file",p1);  
			
			this.add(tp);

		} else {

		}

	}

	private void menuBuilder() {
		mnuMain = new JMenuBar();

		mnuFile = new JMenu("File");
		mnuMain.add(mnuFile);
		
		

		mnuEdit = new JMenu("Edit");
		mnuMain.add(mnuEdit);

		mnuView = new JMenu("View");
		mnuMain.add(mnuView);

		JMenuItem newFile = new FileNewTab(this, "New");
		mnuFile.add(newFile);
		
		JMenuItem open = new JMenuItem("Open");
		mnuFile.add(open);
		

		this.setJMenuBar(mnuMain);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create And Show the GUI
				app = new Notepaddy();
				app.setLayout(null);
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Set frame minimum size based on its components
				// app.pack();
				app.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}