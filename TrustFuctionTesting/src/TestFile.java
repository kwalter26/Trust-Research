import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestFile {
	private int ROW = 200;
	private int COL = 1001;
	private String[] header = new String[14];
	private double[][] table = new double[ROW][COL];
	private PrintWriter outputStream = null;
	private Scanner inputStream = null;

	public void createFile(String fileName) {
		File dir = new File("TrustFunctionFiles");
		dir.mkdir();
		
		try {
			outputStream = new PrintWriter("TrustFunctionFiles/" + fileName);
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(null,
							"Error: File not created... \nTrust Function Test will now close.");
			System.exit(0);
		}
		createTestTable();
		for (int row = 0; row < ROW; row++) {
			for (int col = 0; col < COL; col++) {
				outputStream.print(table[row][col] + ",");
			}
			outputStream.println();
		}
		outputStream.close();
	}

	public void loadFile(String fileName) {

		try {
			inputStream = new Scanner(new File("TrustFunctionFiles/" + fileName));
			Print("Connected to " + fileName);
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(null,
							"Error: File Not Found... \nTrust Function Test will now close.");
			System.exit(0);
		}
		int row = 0;
		while (inputStream.hasNextLine()) {
				String temp = inputStream.nextLine();
				
				String[] values = temp.split("[,]");
				if(!values[0].equals("null")){
					for (int col = 0; col < values.length; col++) {
					table[row][col] = Double.parseDouble(values[col]);
				}
			}
			row++;
	}
		inputStream.close();
	}
	
	public void save(String fileName,double[][] t,String function){
		table = t;
		fileName = fileName.substring(0,fileName.length()-4) + "_calculated_" + function + ".csv";
		try{
			outputStream = new PrintWriter("TrustFunctionFiles/" + fileName);
		}catch(FileNotFoundException e){
			JOptionPane
			.showMessageDialog(null,
					"Error: File Not Found... \nTrust Function Test will now close.");
			System.exit(0);
		}
		for (int i = 0; i < header.length; i++) {
			outputStream.print(header[i]+",");
		}
		outputStream.println();
		for(int row = 0; row < ROW;row++){
			for(int col = 0; col< COL;col++){
				outputStream.print(table[row][col] + ",");
			}
			outputStream.println();
		}
		outputStream.close();
	}

	public void initialTrust() {
		table[1][0] = 0.0;
		for (int i = 3; i < ROW; i += 2) {
			double initialValue = Math.random();
			initialValue = (initialValue * 2) - 1;
			initialValue = round(initialValue);
			table[i][0] = initialValue;
		}

	}

	public void trustValue() {
		for (int row = 0; row < ROW; row += 2) {
			for (int col = 1; col < COL; col++) {
				double value = round(Math.random());
				if (value < .5)
					value = 0.0;
				else
					value = 1.0;
				table[row][col] = value;
			}
		}
	}

	public double round(double d) {
		d = d *1000;
		d = Math.round(d);
		d = d/1000;
		return d;
	}

	public void createTestTable() {
		initialTrust();
		trustValue();
	}

	public double[][] getTable() {
		return table;
	}

	public int getRow() {
		return ROW;
	}

	public int getCol() {
		return COL;
	}
	
	public void setHeader(String[] head){
		header = head;
	}

	public void printTable() {
		for (int row = 0; row < 10; row++) {
			System.out.print((row + 1) + "\t");
			for (int col = 0; col < 10; col++) {
				System.out.print(table[row][col] + ",");
			}
			System.out.println();
		}
	}

	public void Print(String sent) {
		System.out.println(sent);
	}

	public static void main(String[] args) {

	}

}
