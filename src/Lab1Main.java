/*********************************************************************************************
 * 
 * Student Name:Elena Soukhnov
 * Student Number 040871451 
 * Course:  18W CST8130 - Data Structures
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lab1Main {


	public static void main (String [] args) {

		// write the code here to implement the menu as specified in Lab 1

		Scanner input = new Scanner(System.in);
		boolean flag = false;
		Numbers number = null;

		while (true){
			System.out.println("Enter 1 to initialize a default array");
			System.out.println("Enter 2 to initialize an array of input size"); 
			System.out.println("Enter 3 to fill array with values"); 
			System.out.println("Enter 4 to display values in array"); 
			System.out.println("Enter 5 to display average of the values in the array"); 
			System.out.println("Enter 6 to to fill the array with values from a file"); 
			System.out.println("Enter 7 to quit");

			int choice ;
			// Enter input choice
			while (true){

				try {
					choice = Integer.parseInt(input.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.println("\n" + "Invalid entry. Enter numberic value");
				}
			}

			if(choice < 1 || choice > 7){
				System.out.println("\n" + "Invalid entry. Enter number from 1 to 7");
				choice = input.nextInt();
			}	

			switch(choice){
			case 1: 
				number = new Numbers();
				break;  

			case 2: 
				System.out.println("Enter new size of array: ");
				int num;
				while (true){

					try {
						num = Integer.parseInt(input.nextLine());
						break;
					} catch (NumberFormatException nfe) {
						System.out.println("\n" + "Invalid entry. Enter numberic value");
					}
				}

				if(num < 1){
					System.out.println("\n" + "Invalid entry. Enter positive number");
					num = input.nextInt();
				}
				//number = new Numbers(input.nextInt())
				number = new Numbers(num);
				break;  

			case 3: 

				if(number == null){
					number = new Numbers();
				}

				System.out.println("Enter the float numbers as values in the array: ");
				number.initValuesInArray();

				break;  

			case 4: 
				//&& numbers_f.numbers.length==0
				if(number != null ){
					System.out.println(number.toString());
				}
				else{
					System.out.println("Please initialise default (choice 1) "
							+ "or custom (choice 2) array and enter array elements "
							+ "values (choice 3)" + "\n");
				}
				break;

			case 5:
				if(number != null){
					System.out.println("The average is " + number.calcAverage());
				}
				else{
					System.out.println("Please initialise default (choice 1) "
							+ "or custom (choice 2) arrayenter array elements "
							+ "values (choice 3)");
				}
				break;

			case 6:

				System.out.println("Enter file name. The available files are:"
						+ "\n" + "Lab2.txt" + "\n" + "Lab2Bad1.txt" + "\n" + 
						"Lab2Bad3.txt" + "\n" + "Lab2Bad3.txt");
				
				File file = new File (input.nextLine());
				String output = "";
				Float[] arrFlt = null;
				
				try {
					if (file.exists() && file.isFile())
						input = new Scanner(file);	

//					StringBuilder resultString = new StringBuilder();

					while(input.hasNextLine()){
//					resultString.append(input.nextLine()+"\n");  
						output += input.nextLine() + "\n";							
					}

					//splitting the resulting string based on whitespace
					String[] arrStrings=output.split("\\s"); 
					
					int arrIndex = 0;
					//converting the array of strings to array of integers
					for(int i = 0;i < arrStrings.length;i++)
					{
						try
						{
							arrFlt[arrIndex] = Float.parseFloat(arrStrings[i]);
							arrIndex++;
						}
						catch (NumberFormatException nfe)
						{
							System.out.println("\n" + "Invalid data in file – did not process");
						}
					}					


					if(arrFlt[0] < 1){
						System.out.println("\n" + "Invalid data in file – did not process");

					}
					
					int arrSize = Math.round(arrFlt[0]);
					number = new Numbers(arrSize);

					if(((arrFlt.length)-1) == arrFlt[0]){
						for ( int i = 0; i < ((arrFlt.length)-1); i++ ) 
							System.out.println(arrFlt[0+i]);							
					}
					else if(((arrFlt.length)-1) < arrFlt[0]){
						System.out.println("Missing values in file – did not process file");
					}

					else if(((arrFlt.length)-1) > arrFlt[0]){
						System.out.println("\n" + arrFlt.length);

					}

					else
						output = file.getName() + " does not exist or is not a file";

				}

				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for ( int i = 0; i < ((arrFlt.length)-1); i++ ){
					Numbers.numbersFloat[i] = arrFlt[i+1];
				}


			case 7: 
				System.out.println("Quit the menu");
				flag = true;
				break;
				/*default:
				System.out.println("Invalid entry. Enter number from 1 to 6");
				choice = input.nextInt();*/
			}


			if(flag)			
				break;
		}
		input.close();
	}
}


