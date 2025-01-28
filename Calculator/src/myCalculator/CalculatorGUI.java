package myCalculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CalculatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input_Field;
	private JLabel input_Label;
	private JButton calculate_Btn;
	private JLabel result_Lbl;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorGUI() {
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input_Label = new JLabel("Math expression:");
		input_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		input_Label.setBounds(10, 44, 120, 14);
		contentPane.add(input_Label);
		
		input_Field = new JTextField();
		input_Field.setBounds(132, 42, 329, 17);
		contentPane.add(input_Field);
		input_Field.setColumns(10);
		
		calculate_Btn = new JButton("Calculate");
		calculate_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = input_Field.getText();
				double result = InputHandler.perform_Calculations(input);
				String output = "" + result;
				
				result_Lbl.setText(output);
			}
		});
		calculate_Btn.setBounds(10, 69, 112, 25);
		contentPane.add(calculate_Btn);
		
		result_Lbl = new JLabel("");
		result_Lbl.setBounds(132, 70, 329, 25);
		contentPane.add(result_Lbl);
	}
}
