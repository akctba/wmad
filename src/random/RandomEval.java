package random;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RandomEval {

	private JFrame frmRandomEvaluation;

	// fields
	private JComboBox<Methods> comboMethod;
	private JSpinner spnQuantity;
	private JSpinner spnFrom;
	private JSpinner spnTo;
	private JComboBox<Duplicate> comboDuplicate;
	private JList<String> list;
	private JLabel lblDuplicates;
	private JLabel lblPercduplicates;
	private JTable tableReincidence;

	private final Action runButton = new RunAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomEval window = new RandomEval();
					window.frmRandomEvaluation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomEval() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRandomEvaluation = new JFrame();
		frmRandomEvaluation.setTitle("Random Evaluation");
		frmRandomEvaluation.setBounds(100, 100, 450, 413);
		frmRandomEvaluation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomEvaluation.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 139);
		frmRandomEvaluation.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblMethod = new JLabel("Method");
		panel.add(lblMethod);

		comboMethod = new JComboBox<Methods>();
		comboMethod.setName("comboMethod");
		comboMethod.setModel(new DefaultComboBoxModel<Methods>(random.Methods.values()));
		panel.add(comboMethod);

		JLabel lblQuantity = new JLabel("Quantity");
		panel.add(lblQuantity);

		spnQuantity = new JSpinner();
		panel.add(spnQuantity);
		spnQuantity.setValue(100);

		JLabel lblFrom = new JLabel("From");
		panel.add(lblFrom);

		spnFrom = new JSpinner();
		panel.add(spnFrom);

		JLabel lblTo = new JLabel("To");
		panel.add(lblTo);

		spnTo = new JSpinner();
		spnTo.setValue(1000);
		panel.add(spnTo);

		JLabel lblDuplicatesAreAllowed = new JLabel("Duplicates are allowed");
		panel.add(lblDuplicatesAreAllowed);

		comboDuplicate = new JComboBox<Duplicate>();
		comboDuplicate.setName("comboDuplicate");
		comboDuplicate.setModel(new DefaultComboBoxModel<Duplicate>(random.Duplicate.values()));
		panel.add(comboDuplicate);

		JLabel lblGeneratedNumbers = new JLabel("Generated numbers");
		lblGeneratedNumbers.setBounds(6, 157, 138, 16);
		frmRandomEvaluation.getContentPane().add(lblGeneratedNumbers);

		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(6, 185, 172, 196);
		frmRandomEvaluation.add(scrollPane);

		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setBounds(190, 157, 61, 16);
		frmRandomEvaluation.getContentPane().add(lblStatistics);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(190, 186, 254, 33);
		frmRandomEvaluation.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblDup = new JLabel("Duplicates");
		panel_1.add(lblDup);

		lblDuplicates = new JLabel("duplicates");
		lblDuplicates.setText("-");
		panel_1.add(lblDuplicates);

		lblPercduplicates = new JLabel("percDuplicates");
		lblPercduplicates.setText("-%");
		panel_1.add(lblPercduplicates);

		tableReincidence = new JTable();
		JScrollPane scrollTable = new JScrollPane(tableReincidence);
		scrollTable.setBounds(190, 231, 254, 150);
		frmRandomEvaluation.getContentPane().add(scrollTable);

		JButton btnRun = new JButton("Run");
		btnRun.setAction(runButton);
		btnRun.setBounds(327, 152, 117, 29);
		frmRandomEvaluation.getContentPane().add(btnRun);
	}

	private class RunAction extends AbstractAction {
		public RunAction() {
			putValue(NAME, "Run");
			putValue(SHORT_DESCRIPTION, "Verify random eficiency");
		}

		public void actionPerformed(ActionEvent e) {

			// get the values
			Methods method = (Methods) comboMethod.getSelectedItem();
			Duplicate dup = (Duplicate) comboDuplicate.getSelectedItem();
			int from = (int) spnFrom.getValue();
			int to = (int) spnTo.getValue();
			int quant = (int) spnQuantity.getValue();
			int repetitions = 0;
			DefaultListModel<String> results = new DefaultListModel<String>();
			list.setModel(results);

			Map<String, Integer> map = new HashMap<String, Integer>();

			// apply to the selected method
			switch (method) {
			case java_util_Random:
				Random random = new Random();

				for (int i = 0; i < quant; ++i) {
					IntStream ints = random.ints(from, (to + 1));
					OptionalInt findFirst = ints.findFirst();
					String rdm = String.valueOf(findFirst.getAsInt());

					if (results.contains(rdm)) {
						if (dup == Duplicate.No) {
							i--;
						} else {
							// Yes
							results.addElement(rdm);
						}
						++repetitions;
						// add on the table
						if (map.containsKey(rdm)) {
							Integer val = map.get(rdm);
							++val;
							map.put(rdm, val);
						} else {
							map.put(rdm, 1);
						}

					} else {
						results.addElement(rdm);
					}

				}

				break;
			case SECOND_METHOD:
				//TODO IMPLEMENT ANOTHER WAY OF RANDOM
				
				break;
			default:
				System.out.println("Please select one method.");
			}

			// shows the number of coincidences
			lblDuplicates.setText(repetitions + "");
			if (repetitions > 0) {
				float perc = ((float) repetitions / quant);
				DecimalFormat df = new DecimalFormat("0.00%");
				lblPercduplicates.setText(df.format(perc));
			} else {
				lblPercduplicates.setText("0%");
			}

			tableReincidence.setModel(toTableModel(map));

		}

		private TableModel toTableModel(Map<String, Integer> map) {
			DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Value" }, 0);
			for (Map.Entry<?, ?> entry : map.entrySet()) {
				model.addRow(new Object[] { entry.getKey(), entry.getValue() });
			}
			return model;
		}
	}
}

enum Duplicate {
	Yes, No;
}

enum Methods {
	java_util_Random("java.util.Random"), SECOND_METHOD("Second version");

	private String name;

	private Methods(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
}
