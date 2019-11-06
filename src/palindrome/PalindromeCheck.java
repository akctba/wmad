package palindrome;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PalindromeCheck {

	private JFrame frmWmadPalindromeCheck;
	private JTextField textFieldSentence;
	private JLabel lblAnswer;
	private final Action randomPalindrome = new SwingActionRandom();
	private final Action clear = new SwingActionClear();
	private JTextField textRange;
	private JTextField textGenerated;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PalindromeCheck window = new PalindromeCheck();
					window.frmWmadPalindromeCheck.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PalindromeCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWmadPalindromeCheck = new JFrame();
		frmWmadPalindromeCheck.setTitle("WMAD Palindrome Check");
		frmWmadPalindromeCheck.setBounds(100, 100, 645, 300);
		frmWmadPalindromeCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWmadPalindromeCheck.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmWmadPalindromeCheck.getContentPane().add(tabbedPane);
		
		JPanel panelCheck = new JPanel();
		tabbedPane.addTab("Check", null, panelCheck, null);
		GridBagLayout gbl_panelCheck = new GridBagLayout();
		gbl_panelCheck.columnWidths = new int[]{272, 83, 76, 164, 0};
		gbl_panelCheck.rowHeights = new int[]{16, 26, 29, 0, 0};
		gbl_panelCheck.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCheck.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCheck.setLayout(gbl_panelCheck);
		
		JLabel lblTypeTheWord = new JLabel("Type the word or sentence to check if it's a Palindrome");
		GridBagConstraints gbc_lblTypeTheWord = new GridBagConstraints();
		gbc_lblTypeTheWord.anchor = GridBagConstraints.NORTH;
		gbc_lblTypeTheWord.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeTheWord.gridwidth = 4;
		gbc_lblTypeTheWord.gridx = 0;
		gbc_lblTypeTheWord.gridy = 0;
		panelCheck.add(lblTypeTheWord, gbc_lblTypeTheWord);
		
		textFieldSentence = new JTextField();
		GridBagConstraints gbc_textFieldSentence = new GridBagConstraints();
		gbc_textFieldSentence.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldSentence.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSentence.gridwidth = 4;
		gbc_textFieldSentence.gridx = 0;
		gbc_textFieldSentence.gridy = 1;
		panelCheck.add(textFieldSentence, gbc_textFieldSentence);
		textFieldSentence.setColumns(50);
		
		JButton btnRandom = new JButton("Random");
		GridBagConstraints gbc_btnRandom = new GridBagConstraints();
		gbc_btnRandom.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnRandom.insets = new Insets(0, 0, 0, 5);
		gbc_btnRandom.gridx = 0;
		gbc_btnRandom.gridy = 2;
		panelCheck.add(btnRandom, gbc_btnRandom);
		btnRandom.setAction(randomPalindrome);
		
		JButton btnCheck = new JButton("Check");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheck.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheck.gridx = 1;
		gbc_btnCheck.gridy = 2;
		panelCheck.add(btnCheck, gbc_btnCheck);
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldSentence.getText();
				//System.out.println("81\t" + text);
				text = text.replaceAll("\\s+", "");
				//System.out.println("83\t" + text);
				//only aphanumeric
				text = text.replaceAll("[^A-Za-z0-9]", "");
				//System.out.println("86\t" + text);
				
				StringBuilder sb = new StringBuilder(text);
				sb.reverse();
				String inverse = sb.toString();
				//System.out.println("91\t" + inverse);
				
				if (text.equalsIgnoreCase(inverse)) {
					lblAnswer.setText("It is a palindrome");
				} else {
					lblAnswer.setText("It is not a Palindrome");
				}
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 2;
		gbc_btnClear.gridy = 2;
		panelCheck.add(btnClear, gbc_btnClear);
		btnClear.setAction(clear);
		lblAnswer = new JLabel("answer");
		lblAnswer.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblAnswer = new GridBagConstraints();
		gbc_lblAnswer.gridwidth = 4;
		gbc_lblAnswer.gridx = 0;
		gbc_lblAnswer.gridy = 3;
		panelCheck.add(lblAnswer, gbc_lblAnswer);
		
		// ====== PANEL 2 ==========
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Generate", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {30, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblGivenARange = new JLabel("Given a range of letters and/or numbers or words, generate a palindrome");
		GridBagConstraints gbc_lblGivenARange = new GridBagConstraints();
		gbc_lblGivenARange.gridwidth = 3;
		gbc_lblGivenARange.insets = new Insets(0, 0, 5, 0);
		gbc_lblGivenARange.gridx = 1;
		gbc_lblGivenARange.gridy = 0;
		panel_2.add(lblGivenARange, gbc_lblGivenARange);
		
		JLabel lblRangeOfLetters = new JLabel("Range of letters and/or numbers:");
		GridBagConstraints gbc_lblRangeOfLetters = new GridBagConstraints();
		gbc_lblRangeOfLetters.insets = new Insets(0, 0, 5, 5);
		gbc_lblRangeOfLetters.anchor = GridBagConstraints.EAST;
		gbc_lblRangeOfLetters.gridx = 1;
		gbc_lblRangeOfLetters.gridy = 1;
		panel_2.add(lblRangeOfLetters, gbc_lblRangeOfLetters);
		
		textRange = new JTextField();
		textRange.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = textRange.getText();
				text += e.getKeyChar();
				StringBuilder sb = new StringBuilder(text);
				text += sb.reverse().toString();
				textGenerated.setText(text);
			}
		});
		GridBagConstraints gbc_textRange = new GridBagConstraints();
		gbc_textRange.insets = new Insets(0, 0, 5, 0);
		gbc_textRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRange.gridx = 2;
		gbc_textRange.gridy = 1;
		panel_2.add(textRange, gbc_textRange);
		textRange.setColumns(10);
		
		textGenerated = new JTextField();
		GridBagConstraints gbc_textGenerated = new GridBagConstraints();
		gbc_textGenerated.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGenerated.gridx = 2;
		gbc_textGenerated.gridy = 2;
		panel_2.add(textGenerated, gbc_textGenerated);
		textGenerated.setColumns(10);
		
		
		
		// ====== MENU =============
		
		
		JMenuBar menuBar = new JMenuBar();
		frmWmadPalindromeCheck.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmRandomExample = new JMenuItem("Random example");
		mntmRandomExample.setAction(randomPalindrome);
		mnFile.add(mntmRandomExample);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.setAction(clear);
		mnFile.add(mntmReset);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}

	private class SwingActionRandom extends AbstractAction {
		public SwingActionRandom() {
			putValue(NAME, "Random example");
			putValue(SHORT_DESCRIPTION, "It loads a random example of a valid palindrome");
		}
		public void actionPerformed(ActionEvent e) {
			String[] palindromes = {"A nut for a jar of tuna.",
					"Al lets Della call Ed “Stella.”",
					"Amore, Roma.",
					"Borrow or rob?",
					"Taco cat",
					"Was it a car or a cat I saw?",
					"Ed, I saw Harpo Marx ram Oprah W. aside.",
					"Madam, in Eden, I’m Adam.",
					"Oozy rat in a sanitary zoo.",
					"A base do teto desaba.",
					"Anotaram a data da maratona?",
					"Mega bobagem.",
					"Oto come mocoto.",
					"Socorram-me, subi no onibus em Marrocos."};
			
				Random random = new Random();
				int x = random.nextInt(palindromes.length-1);
				
				textFieldSentence.setText(palindromes[x]);
				lblAnswer.setText("");
				
			}
			
		}
	private class SwingActionClear extends AbstractAction {
		public SwingActionClear() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Clear the application fields");
		}
		public void actionPerformed(ActionEvent e) {
			textFieldSentence.setText("");
			lblAnswer.setText("");
		}
	}
	
	}
