import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BankCSVReader {
	
	public static void main(String[] args) {
		
		String fileName = "hw1data.csv";
		File file = new File(fileName);
		double married = 0;
		int marriedCounter = 0;
		double single = 0;
		int singleCounter = 0;

		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {				
				String data = input.next();
				String values[] = data.split(",");
				double bankBalance = Double.parseDouble(values[3]);
				if(values[2].equals("Married")) {
					married = married + bankBalance;
					marriedCounter++;
				}
				if(values[2].equals("Single")) {
					single = single + bankBalance;
					singleCounter++;
				}
			}
			
			input.close();
			DecimalFormat df = new DecimalFormat("#.##");

			System.out.println("Married Average Bank Balance: " + df.format(married / marriedCounter));
			System.out.println("Single Average Bank Balance: " + df.format(single / singleCounter));

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}








