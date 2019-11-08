package random;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;



public class RandomEval {

	private JFrame frmRandomEvaluation;
	private JTable tableReincidence;

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
		frmRandomEvaluation.setBounds(100, 100, 450, 400);
		frmRandomEvaluation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomEvaluation.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 121);
		frmRandomEvaluation.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblQuantity = new JLabel("Quantity");
		panel.add(lblQuantity);
		
		JSpinner SpnQuantity = new JSpinner();
		panel.add(SpnQuantity);
		
		JLabel lblFrom = new JLabel("From");
		panel.add(lblFrom);
		
		JSpinner SpnFrom = new JSpinner();
		panel.add(SpnFrom);
		
		JLabel lblTo = new JLabel("To:");
		panel.add(lblTo);
		
		JSpinner spnTo = new JSpinner();
		panel.add(spnTo);
		
		JLabel lblDuplicatesAreAllowed = new JLabel("Duplicates are allowed");
		panel.add(lblDuplicatesAreAllowed);
		
		JComboBox comboDuplicate = new JComboBox();
		comboDuplicate.setModel(new DefaultComboBoxModel(random.duplicate.values()));
		panel.add(comboDuplicate);
		
		JLabel lblGeneratedNumbers = new JLabel("Generated numbers");
		lblGeneratedNumbers.setBounds(6, 136, 138, 16);
		frmRandomEvaluation.getContentPane().add(lblGeneratedNumbers);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(6, 164, 172, 196);
		frmRandomEvaluation.getContentPane().add(list);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setBounds(190, 139, 61, 16);
		frmRandomEvaluation.getContentPane().add(lblStatistics);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(190, 164, 254, 33);
		frmRandomEvaluation.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblDup = new JLabel("Duplicates");
		panel_1.add(lblDup);
		
		JLabel lblDuplicates = new JLabel("duplicates");
		panel_1.add(lblDuplicates);
		
		JLabel lblPercduplicates = new JLabel("percDuplicates");
		panel_1.add(lblPercduplicates);
		
		tableReincidence = new JTable();
		tableReincidence.setBounds(190, 210, 254, 150);
		frmRandomEvaluation.getContentPane().add(tableReincidence);
	}
}

enum duplicate {
	Yes, No;
}
