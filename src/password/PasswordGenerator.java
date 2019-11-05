package password;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * GUI Based Password Generator
 * @author alexkayser
 *
 */
public class PasswordGenerator {

	private JFrame frmWmadPasswordGenerator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordGenerator window = new PasswordGenerator();
					window.frmWmadPasswordGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordGenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWmadPasswordGenerator = new JFrame();
		frmWmadPasswordGenerator.setTitle("WMAD Password Generator");
		frmWmadPasswordGenerator.setBounds(100, 100, 450, 327);
		frmWmadPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWmadPasswordGenerator.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Type of characters");
		panel.setBounds(22, 27, 157, 109);
		frmWmadPasswordGenerator.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox chckbxUseLowerCase = new JCheckBox("Use lower case");
		panel.add(chckbxUseLowerCase);
		
		JCheckBox chckbxUseUpperCase = new JCheckBox("Use upper case");
		panel.add(chckbxUseUpperCase);
		
		JCheckBox chckbxUseNumbers = new JCheckBox("Use numbers");
		panel.add(chckbxUseNumbers);
		
		JCheckBox chckbxUseSymbols = new JCheckBox("Use !?@#$*");
		panel.add(chckbxUseSymbols);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 148, 157, 52);
		frmWmadPasswordGenerator.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{78, 78, 0};
		gbl_panel_1.rowHeights = new int[]{26, 26, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblMinLength = new JLabel("Min length");
		GridBagConstraints gbc_lblMinLength = new GridBagConstraints();
		gbc_lblMinLength.fill = GridBagConstraints.BOTH;
		gbc_lblMinLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinLength.gridx = 0;
		gbc_lblMinLength.gridy = 0;
		panel_1.add(lblMinLength, gbc_lblMinLength);
		
		JSpinner spinnerMinLength = new JSpinner();
		GridBagConstraints gbc_minLength = new GridBagConstraints();
		gbc_minLength.fill = GridBagConstraints.BOTH;
		gbc_minLength.insets = new Insets(0, 0, 5, 0);
		gbc_minLength.gridx = 1;
		gbc_minLength.gridy = 0;
		panel_1.add(spinnerMinLength, gbc_minLength);
		
		JLabel lblMaxLength = new JLabel("Max length");
		GridBagConstraints gbc_lblMaxLength = new GridBagConstraints();
		gbc_lblMaxLength.fill = GridBagConstraints.BOTH;
		gbc_lblMaxLength.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaxLength.gridx = 0;
		gbc_lblMaxLength.gridy = 1;
		panel_1.add(lblMaxLength, gbc_lblMaxLength);
		
		JSpinner spinnerMaxLength = new JSpinner();
		GridBagConstraints gbc_maxLength = new GridBagConstraints();
		gbc_maxLength.fill = GridBagConstraints.BOTH;
		gbc_maxLength.gridx = 1;
		gbc_maxLength.gridy = 1;
		panel_1.add(spinnerMaxLength, gbc_maxLength);
		
		JList<String> pwdList = new JList<String>();
		
		DefaultListModel<String> passwords = new DefaultListModel<String>();
		pwdList.setModel(passwords);
		pwdList.setBounds(191, 27, 233, 142);
		frmWmadPasswordGenerator.getContentPane().add(pwdList);
		
		JLabel lblNumberOfPasswords = new JLabel("Number of passwords");
		lblNumberOfPasswords.setBounds(69, 216, 143, 16);
		frmWmadPasswordGenerator.getContentPane().add(lblNumberOfPasswords);
		
		JSlider sliderPassword = new JSlider();
		sliderPassword.setValue(3);
		sliderPassword.setMinorTickSpacing(1);
		sliderPassword.setMaximum(5);
		sliderPassword.setMinimum(1);
		sliderPassword.setPaintTicks(true);
		sliderPassword.setBounds(214, 212, 190, 29);
		frmWmadPasswordGenerator.getContentPane().add(sliderPassword);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = pwdList.getSelectedValue();
				if (s!=null && !"".equals(s)) {
					//put s to clipboard
					Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
					Clipboard clipboard = defaultToolkit.getSystemClipboard();

			        clipboard.setContents(new StringSelection(s), null);
					System.out.println("Password copied to the clipboard");
				} else {
					System.out.println("No selected password to copy.");
				}
				
			}
		});
		btnCopy.setEnabled(false);
		btnCopy.setBounds(250, 171, 117, 29);
		frmWmadPasswordGenerator.getContentPane().add(btnCopy);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset the components to initial values
				//lower
				chckbxUseLowerCase.setSelected(true);
				//upper
				chckbxUseUpperCase.setSelected(false);
				//number
				chckbxUseNumbers.setSelected(true);
				//symbol
				chckbxUseSymbols.setSelected(false);
				//quantity
				sliderPassword.setValue(3);
				//min
				spinnerMinLength.setValue(4);
				//max
				spinnerMaxLength.setValue(8);
				//list 
				passwords.clear();
				btnCopy.setEnabled(false);
				
			}
		});
		//btnClear.setAction(clearAction);
		btnClear.setBounds(79, 244, 117, 29);
		frmWmadPasswordGenerator.getContentPane().add(btnClear);
		
		//enabling button copy
		pwdList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getFirstIndex() >= 0 || e.getLastIndex() >= 0) {
					btnCopy.setEnabled(true);
				} else {
					btnCopy.setEnabled(false);
				}
			}
		});
		
		JButton btnGeneratePasswords = new JButton("Generate Passwords");
		btnGeneratePasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnCopy.setEnabled(false);
				
				//clear previous passwords
				passwords.clear();
				
				if (!validateOptions()) return;
				
				PassGen generator = new PassGen();
				generator.resetRules();
				
				if(chckbxUseLowerCase.isSelected()) {
					generator.setLowercase();
				}
				if(chckbxUseNumbers.isSelected()) {
					generator.setNumbers();
				}
				if(chckbxUseSymbols.isSelected()) {
					generator.setSymbols();
				}
				if(chckbxUseUpperCase.isSelected()) {
					generator.setUppercase();
				}
				
				int z = sliderPassword.getValue();
				int minLength = (Integer) spinnerMinLength.getValue();
				int maxLength = (Integer) spinnerMaxLength.getValue();
				
				if(!validateSize(minLength, maxLength)) return;
				
				for(int i=0; i<z; i++) {
					String tmp = generator.randomPassword(minLength, maxLength);
					passwords.addElement(tmp);
				}
			}

			private boolean validateSize(int minLength, int maxLength) {
				boolean valid = false;
				if(minLength <= 0) {
					//TODO Message: min length must to be greater than one.
					System.out.println("min length must to be greater than one.");
					valid = false;
				} else {
					valid = true;
				}
				if (minLength > maxLength) {
					//TODO Message: Min length must be less than Max length
					System.out.println("Max length must be grater than Min length");
					valid = valid && false;
				}
				
				return valid;
			}

			private boolean validateOptions() {
				boolean valid = false;
				if(chckbxUseLowerCase.isSelected()
						|| chckbxUseNumbers.isSelected()
						|| chckbxUseSymbols.isSelected()
						|| chckbxUseUpperCase.isSelected())
					valid = true;
				if(!valid) {
					//TODO message: select at least one option of characters
					System.out.println("select at least one option of characters");
				}
				
				return valid;
			}
		});
		//btnGeneratePasswords.setAction(generateAction);
		btnGeneratePasswords.setBounds(224, 244, 157, 29);
		frmWmadPasswordGenerator.getContentPane().add(btnGeneratePasswords);
		
		JMenuBar menuBar = new JMenuBar();
		frmWmadPasswordGenerator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSavePaswords = new JMenuItem("Save paswords");
		mnFile.add(mntmSavePaswords);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}
//	private class ClearAction extends AbstractAction {
//		public ClearAction() {
//			putValue(NAME, "Clear");
//			putValue(SHORT_DESCRIPTION, "Reset the options to the initial values");
//		}
//		public void actionPerformed(ActionEvent e) {
//		}
//	}
//	private class GenerateAction extends AbstractAction {
//		public GenerateAction() {
//			putValue(NAME, "Generate passwords");
//			putValue(SHORT_DESCRIPTION, "Click to generate some passwords");
//		}
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("Line 232");
//			
//		}
//	}
}
