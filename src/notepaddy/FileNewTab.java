package notepaddy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class FileNewTab extends JMenuItem implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3329144253044969317L;
	
	

	public FileNewTab(Notepaddy paddy, String string) {
		super(string);
		
		JTextArea ta=new JTextArea(200,200);  
	    JPanel p1=new JPanel();  
	    p1.add(ta);
	    
	    JTabbedPane tp=new JTabbedPane();  
	    tp.setBounds(0,0,200,200);
	    tp.add("new text file",p1);  
		
	    paddy.add(tp);
	    //TODO here
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
