import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Kyle Walter
 * Project: TrustFuctionTesting
 * Data Created: Nov 21, 2014
 */
public class TrustGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String fileName;
	private int selection;

	public JLabel title;

	public JButton loadTestFile;
	public JButton createTestFile;
	public JTextField fileNameField;
	public JButton enterField;
	public JButton startButton;
	public JButton anotherFunctionButton;
	// Function 1
	public JButton function1Button;
	// Function 2
	public JButton function2Button;
	// Function 3
	public JButton function3Button;
	// Data Fields
	public JTextField functionAlphaField;
	public JTextField functionBetaField;
	public JTextField functionEpsilonField;
	public JTextField functionKappaField;
	public JTextField functionNuField;
	public JTextField functionThetaField;

	public TrustGui() {
		setSize(180, 180);
		setLocationRelativeTo(null);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		title = new JLabel("Trust Funciton Test");
		contentPane.add(title);

		startButton = new JButton("Start");
		startButton.addActionListener(this);
		contentPane.add(startButton);

		createTestFile = new JButton("Create Test File");
		createTestFile.addActionListener(this);
		contentPane.add(createTestFile);
		createTestFile.setVisible(false);

		loadTestFile = new JButton("Load Test File");
		loadTestFile.addActionListener(this);
		contentPane.add(loadTestFile);
		loadTestFile.setVisible(false);

		fileNameField = new JTextField(10);
		contentPane.add(fileNameField);
		fileNameField.setText("Enter File Name");
		fileNameField.setVisible(false);

		function1Button = new JButton("Function 1");
		function1Button.addActionListener(this);
		function1Button.setVisible(false);
		contentPane.add(function1Button);

		function2Button = new JButton("Function 2");
		function2Button.addActionListener(this);
		function2Button.setVisible(false);
		contentPane.add(function2Button);

		functionAlphaField = new JTextField(20);
		functionAlphaField.setText("Alpha");
		functionAlphaField.addActionListener(this);
		functionAlphaField.setVisible(false);
		contentPane.add(functionAlphaField);

		functionBetaField = new JTextField(20);
		functionBetaField.setText("Beta");
		functionBetaField.addActionListener(this);
		functionBetaField.setVisible(false);
		contentPane.add(functionBetaField);

		functionEpsilonField = new JTextField(20);
		functionEpsilonField.setText("Epsilon");
		functionEpsilonField.addActionListener(this);
		functionEpsilonField.setVisible(false);
		contentPane.add(functionEpsilonField);

		functionKappaField = new JTextField(20);
		functionKappaField.setText("Kappa");
		functionKappaField.addActionListener(this);
		functionKappaField.setVisible(false);
		contentPane.add(functionKappaField);

		functionNuField = new JTextField(20);
		functionNuField.setText("Nu");
		functionNuField.addActionListener(this);
		functionNuField.setVisible(false);
		contentPane.add(functionNuField);

		functionThetaField = new JTextField(20);
		functionThetaField.setText("Theta");
		functionThetaField.addActionListener(this);
		functionThetaField.setVisible(false);
		contentPane.add(functionThetaField);

		function3Button = new JButton("Function 3");
		function3Button.addActionListener(this);
		function3Button.setVisible(false);
		contentPane.add(function3Button);

		enterField = new JButton("Enter");
		enterField.addActionListener(this);
		contentPane.add(enterField);
		enterField.setVisible(false);

		anotherFunctionButton = new JButton("Enter Another Function");
		anotherFunctionButton.addActionListener(this);
		contentPane.add(anotherFunctionButton);
		anotherFunctionButton.setVisible(false);

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		TestFile testFile = new TestFile();

		if (src == startButton) {
			setSize(210, 300);
			title.setText("Select Option");
			startButton.setVisible(false);
			anotherFunctionButton.setVisible(false);
			createTestFile.setVisible(true);
			loadTestFile.setVisible(true);
		} else if (src == createTestFile) {
			title.setText("Create Trust File");
			createTestFile.setVisible(false);
			loadTestFile.setVisible(false);
			fileNameField.setVisible(true);
			enterField.setVisible(true);
			selection = 1;
			Print("Chose Create File: Selection = " + selection);
		} else if (src == loadTestFile) {
			title.setText("Load Trust File");
			createTestFile.setVisible(false);
			loadTestFile.setVisible(false);
			fileNameField.setVisible(true);
			enterField.setVisible(true);
			selection = 2;
			Print("Chose Load File: Selection = " + selection);
		} else if (src == enterField && selection == 1) {
			setSize(200, 300);
			title.setText("Select Trust Function");
			fileName = fileNameField.getText() + ".csv";
			testFile.createFile(fileName);
			fileNameField.setVisible(false);
			enterField.setVisible(false);
			function1Button.setVisible(true);
			function2Button.setVisible(true);
			function3Button.setVisible(true);
			Print("Function Choice Screen: Selection = " + selection);
		} else if ((src == enterField && selection == 2)||src == anotherFunctionButton) {
			setSize(200, 300);
			title.setText("Select Trust Function");
			fileName = fileNameField.getText() + ".csv";
			System.out.println("Load: " + fileName);
			fileNameField.setVisible(false);
			enterField.setVisible(false);
			function1Button.setVisible(true);
			function2Button.setVisible(true);
			function3Button.setVisible(true);
			startButton.setVisible(false);
			anotherFunctionButton.setVisible(false);
			Print("Function Choice Screen: Selection = " + selection);
		} else if (src == function1Button) { // Function 1 Construction
			setSize(300, 300);
			title.setText("Function 1");
			function1Button.setVisible(false);
			function2Button.setVisible(false);
			function3Button.setVisible(false);
			functionAlphaField.setVisible(true);
			functionBetaField.setVisible(true);
			enterField.setVisible(true);
			selection = 3;
			Print("Function One Screen: Selection = " + selection);
		} else if (src == function2Button) { // Function 2 Construction
			setSize(300, 300);
			title.setText("Test Function Two");
			function1Button.setVisible(false);
			function2Button.setVisible(false);
			function3Button.setVisible(false);
			functionAlphaField.setVisible(true);
			functionBetaField.setVisible(true);
			functionEpsilonField.setVisible(true);
			functionKappaField.setVisible(true);
			functionNuField.setVisible(true);
			functionThetaField.setVisible(true);
			enterField.setVisible(true);
			selection = 4;
			Print("Function Two Screen: Selection = " + selection);
		} else if (src == function3Button) { // Function 3 Construction
			setSize(300, 300);
			title.setText("Function Three");
			function1Button.setVisible(false);
			function2Button.setVisible(false);
			function3Button.setVisible(false);
			functionAlphaField.setVisible(true);
			functionBetaField.setVisible(true);
			functionEpsilonField.setVisible(true);
			functionKappaField.setVisible(true);
			functionNuField.setVisible(true);
			functionThetaField.setVisible(true);
			enterField.setVisible(true);
			selection = 5;
			Print("Function Three Screen: Selection = " + selection);
		} else if (src == enterField && selection == 3) { // RunningTrustFunctionOne
			setSize(220,300);
			String[] parametersOne = { functionAlphaField.getText(),
					functionBetaField.getText() };
			String[] head = { "Function One",
					"Alpha = " + functionAlphaField.getText(),
					"Beta = " + functionBetaField.getText() };
			testFile.setHeader(head);
			double[] p1 = new double[parametersOne.length];
			if (doubleChecker(parametersOne) == true) {
				for (int i = 0; i < parametersOne.length; i++) {
					p1[i] = Double.parseDouble(parametersOne[i]);
				}

				TrustFunctionOne testF1 = new TrustFunctionOne(
						testFile.getTable(), p1[0], p1[1]);
				testFile.loadFile(fileName);
				testF1.run();
				testFile.save(fileName, testF1.getTable(), "Function_One");
				functionAlphaField.setVisible(false);
				functionBetaField.setVisible(false);
				enterField.setVisible(false);
				title.setText("Calculation Complete");
				startButton.setText("Restart");
				startButton.setVisible(true);
				anotherFunctionButton.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null,
						"Error: Check that all entries are real numbers!");
				setSize(300,300);
			}
		} else if (src == enterField && selection == 4) { // RunningTrustFunctionTwo
			setSize(220,300);
			String[] parametersTwo = { functionAlphaField.getText(),
					functionBetaField.getText(),
					functionEpsilonField.getText(),
					functionKappaField.getText(), functionNuField.getText(),
					functionThetaField.getText() };
			String[] head = { "Function Two",
					"Alpha = " + functionAlphaField.getText(),
					"Beta = " + functionBetaField.getText(),
					"Epsilon = " + functionEpsilonField.getText(),
					"Kappa =" + functionKappaField.getText(),
					"Nu = " + functionNuField.getText(),
					"Theta = " + functionThetaField.getText() };
			testFile.setHeader(head);
			Print("First Value for Table = " + testFile.getTable()[0][0]);
			double[] p2 = new double[parametersTwo.length];
			if (doubleChecker(parametersTwo) == true) {
				for (int i = 0; i < parametersTwo.length; i++) {
					p2[i] = Double.parseDouble(parametersTwo[i]);
				}
				Print("Parameters to Double");
				TrustFunctionTwo testF2 = new TrustFunctionTwo(
						testFile.getTable(), p2[0], p2[1], p2[2], p2[3], p2[4],
						p2[5]);
				testFile.loadFile(fileName);
				testF2.run();
				testFile.save(fileName, testF2.getTable(), "Function_Two");
			} else{
				JOptionPane.showMessageDialog(null,
						"Error: Check that all entries are real numbers!");
				setSize(300,300);
			}
			functionAlphaField.setVisible(false);
			functionBetaField.setVisible(false);
			functionEpsilonField.setVisible(false);
			functionKappaField.setVisible(false);
			functionNuField.setVisible(false);
			functionThetaField.setVisible(false);
			enterField.setVisible(false);
			title.setText("Calculation complete!");
			startButton.setText("Restart");
			startButton.setVisible(true);
			anotherFunctionButton.setVisible(true);
		} else if (src == enterField && selection == 5) { // RunningTrustFunctionThree
			setSize(220,300);
			String[] parametersThree = { functionAlphaField.getText(),
					functionBetaField.getText(),
					functionEpsilonField.getText(),
					functionKappaField.getText(), functionNuField.getText(),
					functionThetaField.getText() };
			String[] head = { "Function Three",
					"Alpha = " + functionAlphaField.getText(),
					"Beta = " + functionBetaField.getText(),
					"Epsilon = " + functionEpsilonField.getText(),
					"Kappa =" + functionKappaField.getText(),
					"Nu = " + functionNuField.getText(),
					"Theta = " + functionThetaField.getText() };
			testFile.setHeader(head);
			Print("First Value for Table = " + testFile.getTable()[0][0]);
			double[] p3 = new double[parametersThree.length];
			if (doubleChecker(parametersThree) == true) {
				for (int i = 0; i < parametersThree.length; i++) {
					p3[i] = Double.parseDouble(parametersThree[i]);
				}
				Print("Parameters to Double");
				testFile.printTable();
				TrustFunctionThree testF3 = new TrustFunctionThree(
						testFile.getTable(), p3[0], p3[1], p3[2], p3[3], p3[4],
						p3[5]);
				testFile.loadFile(fileName);
				testF3.run();
				testFile.save(fileName, testF3.getTable(), "Function_Three");
			} else{
				JOptionPane.showMessageDialog(null,
						"Error: Check that all entries are real numbers!");
				setSize(300,300);
			}
			functionAlphaField.setVisible(false);
			functionBetaField.setVisible(false);
			functionEpsilonField.setVisible(false);
			functionKappaField.setVisible(false);
			functionNuField.setVisible(false);
			functionThetaField.setVisible(false);
			enterField.setVisible(false);
			title.setText("Calculation complete!");
			startButton.setText("Restart");
			startButton.setVisible(true);
			anotherFunctionButton.setVisible(true);

		}
	}

	public void Print(String sent) {
		System.out.println(sent);
	}

	public boolean doubleChecker(String[] strs2Check) {
		String regex = "[A-Za-z\\s]";

		Pattern checkRegex = Pattern.compile(regex);

		for (int i = 0; i < strs2Check.length; i++) {
			Matcher regexMatcher = checkRegex.matcher(strs2Check[i]);
			if (regexMatcher.find())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TrustGui gui = new TrustGui();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
