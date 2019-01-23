/*In big data environments, analysts are constantly writing ad hoc database queries
to obtain general table statistics for purposes of validation, trend analysis, and to simply gain a deeper
understanding of their data. Suppose we had a .CSV text file listing bank customers. Each line includes
the customer’s account number, name, marital status and account balance. The bank manager would
like to know if customers with different marital status have, on average, significantly different account
balances. In a programming language of your choice (or pseudocode), write or describe step-by-step a
function that processes the .CSV file and outputs the average account balance for customers in each
marital status category. */

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








