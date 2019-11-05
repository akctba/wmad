package visualCalc;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Visual example of a diferent kind of calculator
 * 
 * @author alexkayser
 *
 */
public class VisualCalc {
	
	/** Decimal scale to results */
	private static final int DEF_SCALE = 5;

	private static void addComponentsToPane(Container frame) {

		// frame.setLayout(new GridLayout(6,4));
		// frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		frame.setBackground(Color.lightGray);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 20, 0, 20); // top left right padding

		JLabel header = new JLabel("TYPE NUMBERS AND CHOOSE THE OPERATION");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		frame.add(header, c);

		Result area = new Result("");
		area.setBackground(Color.white);

		// create a line border and title
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY);
		TitledBorder title = BorderFactory.createTitledBorder(border, "Historic");
		title.setTitleJustification(TitledBorder.RIGHT);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel panel = new JPanel();

		// TODO the scroll isn't working...
		panel.setLayout(new FlowLayout());

		// set the border of the result area
		panel.setBorder(title);
		panel.setSize(200, 100);
		panel.add(scroll);

		// alinhar a direita
		// area.setHorizontalAlignment(SwingConstants.RIGHT);

		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 150;
		c.gridwidth = 5;
		frame.add(panel, c);

		// ###### Last Result

		// create a line border and title
		Result result = new Result("");
		result.setBackground(Color.decode("#FFFFFF"));
		result.setAutoscrolls(true);

		Border lastBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY);
		TitledBorder resultBorder = BorderFactory.createTitledBorder(lastBorder, "Result");
		resultBorder.setTitleJustification(TitledBorder.RIGHT);
		result.setBorder(resultBorder);
		result.setHorizontalTextPosition(SwingConstants.RIGHT);

		// TODO: put a big font size

		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 20;
		c.gridwidth = 5;
		frame.add(result, c);

		// ###### next value

		JTextField number = new JTextField("000000");
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 0;
		c.gridwidth = 5;
		frame.add(number, c);

		// ###### Operations

		JButton add = new JButton("+");
		JButton sub = new JButton("-");
		JButton mul = new JButton("x");
		JButton div = new JButton("/");
		JButton clear = new JButton("AC");

		// ## Button AC
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				number.setText("0.0");
				result.setText("0.0");
				area.setText("");

			}
		});

		// ## Button Add
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (result.getText() == null || result.getText().equals("")) {
					// so joga o valor pro campo result
					result.setText(toNumber(number.getText()).toString());
					String tmp = area.getText();
					tmp = addLine(tmp, number.getText());

					area.setText(tmp);

				} else {

					// last result + next value
					BigDecimal prev = toNumber(result.getText());
					BigDecimal next = toNumber(number.getText());

					String tmp = area.getText();
					tmp = addLine(tmp, "+ " + number.getText());
					area.setText(tmp);

					BigDecimal res = prev.add(next);
					res.setScale(DEF_SCALE);
					result.setText(res.toString());
				}

			}
		});

		// ## Button Sub
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (result.getText() == null || result.getText().equals("")) {
					// so joga o valor pro campo result
					result.setText(toNumber(number.getText()).toString());
					String tmp = area.getText();
					tmp = addLine(tmp, number.getText());

					area.setText(tmp);

				} else {

					// last result + next value
					BigDecimal prev = toNumber(result.getText());
					BigDecimal next = toNumber(number.getText());

					String tmp = area.getText();
					tmp = addLine(tmp, "- " + number.getText());

					area.setText(tmp);

					result.setText(prev.subtract(next).toString());
				}

			}
		});

		// ## Button Mul
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (result.getText() == null || result.getText().equals("")) {
					// so joga o valor pro campo result
					result.setText(toNumber(number.getText()).toString());
					String tmp = area.getText();
					tmp = addLine(tmp, number.getText());

					area.setText(tmp);

				} else {

					// last result + next value
					BigDecimal prev = toNumber(result.getText());
					BigDecimal next = toNumber(number.getText());

					String tmp = area.getText();
					tmp = addLine(tmp, "* " + number.getText());

					area.setText(tmp);

					result.setText(prev.multiply(next).toString());
				}

			}
		});

		// ## Button Mul
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (result.getText() == null || result.getText().equals("")) {
					// so joga o valor pro campo result
					result.setText(toNumber(number.getText()).toString());
					String tmp = area.getText();
					tmp = addLine(tmp, number.getText());

					area.setText(tmp);

				} else {

					// last result + next value
					BigDecimal prev = toNumber(result.getText());
					BigDecimal next = toNumber(number.getText());

					String tmp = area.getText();
					tmp = addLine(tmp, "/ " + number.getText());

					area.setText(tmp);

					result.setText(prev.divide(next).toString());
				}

			}
		});

		c.insets = new Insets(20, 5, 20, 5); // top left right padding
		c.gridwidth = 1;
		c.gridy = 4;
		c.gridx = 0;
		frame.add(add, c);

		c.gridx = 1;
		frame.add(sub, c);

		c.gridx = 2;
		frame.add(mul, c);

		c.gridx = 3;
		frame.add(div, c);

		c.gridx = 4;
		frame.add(clear, c);

	}

	private static String addLine(String old, String text) {
		final String OPEN = "<html>";
		final String CLOSE = "</html>";
		final String BREAK = "<br/>";

		String tmp;

		if (old == null || "".equals(old)) {
			tmp = OPEN + text + CLOSE;
		} else {
			tmp = old.replaceAll(CLOSE, "");
			tmp = tmp + BREAK + text + CLOSE;
		}

		return tmp;
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Simple Calculator by Alex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Set frame minimum size based on its components
		frame.pack();
		// Display the window.
		frame.setVisible(true);
	}

	/**
	 * Convert String to BigDecimal and set the default scale.
	 * @param txt
	 * @return BigDecimal of the value or Zero in any case of exception
	 */
	private static BigDecimal toNumber(String txt) {

		BigDecimal n = new BigDecimal(0);

		try {
			n = new BigDecimal(txt);
			n = n.setScale(DEF_SCALE);
		} catch (Exception e) {
			// TODO log debug
		}

		return n;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

class Result extends JLabel {

	private static final long serialVersionUID = 4278269293761280827L;

	public Result(String text) {
		super(text, null, RIGHT);
	}

	@Override
	public boolean isOpaque() {
		return true;
	}
}