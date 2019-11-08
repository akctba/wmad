package anagram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnagramGenerator {

	private JFrame frmAnagramGenerator;
	private JTextField textInitial;
	private final Action action = new SearchAction();
	private JList<String> list;
	private JLabel lblfromx;
	private BigDecimal pos;
	private BigDecimal count = BigDecimal.ZERO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnagramGenerator window = new AnagramGenerator();
					window.frmAnagramGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnagramGenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnagramGenerator = new JFrame();
		frmAnagramGenerator.setTitle("Anagram Generator");
		frmAnagramGenerator.setBounds(100, 100, 450, 400);
		frmAnagramGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAnagramGenerator.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(22, 21, 411, 64);
		frmAnagramGenerator.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTypeTheSourceword = new JLabel("Type the initial word:");
		panel.add(lblTypeTheSourceword);

		JLabel lblPossibilities = new JLabel("X");
		textInitial = new JTextField();
		textInitial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pos = calculateCombinations(textInitial.getText());
				lblPossibilities.setText(pos.toString());
			}
		});
		panel.add(textInitial);
		textInitial.setColumns(20);

		DefaultListModel<String> modelList = new DefaultListModel<String>();
		list = new JList<String>(modelList);
		JLabel lblThisWordCould = new JLabel("Total number of possibilities:");
		panel.add(lblThisWordCould);

		panel.add(lblPossibilities);

		JButton btnSearch = new JButton("--- Search ---");
		btnSearch.setAction(action);
		panel.add(btnSearch);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 164, 411, 199);
		frmAnagramGenerator.getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_2.add(list, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 93, 411, 33);
		frmAnagramGenerator.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblfromx = new JLabel("1fromX");
		panel_1.add(lblfromx);
		lblfromx.setText("");
	}

	/**
	 * Calculate number of possible combinations
	 * 
	 * @param text word size
	 * @return number of combinations
	 */
	protected BigDecimal calculateCombinations(String text) {
		if (text == null || "".equals(text)) {
			return BigDecimal.ZERO;
		}
		int s = text.length();

		return factorial(new BigDecimal(s));
	}

	/**
	 * Calculate big factorials
	 * 
	 * @param a number in BigDecimal
	 * @return factorial of number
	 */
	public static BigDecimal factorial(BigDecimal n) {
		if (n.compareTo(BigDecimal.ONE) <= 0)
			return BigDecimal.ONE;
		else
			return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
	}

	private class SearchAction extends AbstractAction {

		private StringBuffer dictionary;

		public SearchAction() {
			putValue(NAME, "--- Search ---");
			putValue(SHORT_DESCRIPTION, "It searches anagrams for the typed word in the system dictionary.");
		}

		public void actionPerformed(ActionEvent e) {

			String word = textInitial.getText();

			Thread action = new Thread(new Runnable() {
				public void run() {
					// load the dictionary and search the word
					dictionary = loadDictionary();
					
					//clean list
					DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
					model.clear();
					lblfromx.setText("");

					searchAnagram(word.toCharArray(), 0);
				}
			});
			action.start();

		}

		private void searchAnagram(char[] word, int position) {
			int i;
			if (position == word.length - 1) {
				// busca no dicionario
				count.add(BigDecimal.ONE);
				showCount();
				String s = new String(word);
				Matcher m = Pattern.compile(s + " ").matcher(dictionary);
				if (m.find()) {
					// insere na lista
					DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
					model.addElement(s);

				}
				
			} else {
				searchAnagram(word, position + 1);
				i = position + 1;
				while (i < word.length) {
					changePosition(word, position, i);
					searchAnagram(word, position + 1);
					changePosition(word, position, i);
					i = i + 1;

				}
			}

		}

		private void showCount() {
			
			lblfromx.setText(count.toString() + " of " + pos.toString());
			
		}

		private void changePosition(char[] word, int a, int b) {
			char aux;
			aux = word[b];
			word[b] = word[a];
			word[a] = aux;
		}

		/**
		 * Loads the dictionary
		 * 
		 * @return StringBuffer
		 */
		private StringBuffer loadDictionary() {
			
			lblfromx.setText("Loading dictionary");

			StringBuffer sb = new StringBuffer();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("/Users/alexkayser/engDictionary.txt"));
				for (String line = br.readLine(); line != null; line = br.readLine()) {
					sb.append(line);
					sb.append(" ");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
				}
			}
			lblfromx.setText("Dictionary loaded");
			return sb;
		}
	}
}
