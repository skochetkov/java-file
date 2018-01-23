/*********************************************************************************************
 * 
 * Student Name:Elena Soukhanov
 * Student Number 040871451 
 * Course:  18W CST8130 - Data Structures
 * 
 * This class contains the dynamically allocated array and it's processing
 */
import java.util.*;

public class Numbers {
	Integer num;
	int arr_size;
	static public Float [] numbersFloat;

	public Numbers() {
		///  write code here to intialize a "default" array since this is the default constructor
		arr_size = 10;
		numbersFloat = new Float [arr_size];
		Arrays.fill(numbersFloat, 0.0f);
	}

	public Numbers (int size) {
		///  write code here to initialize an "initial" array given the parameter 
		//size as this is an initial constructor
		numbersFloat = new Float [size];
		arr_size = size;
		/*for ( int i=0; i<numbers_f.length; i++) {
			numbers_f[i]= 0.0f;
		}*/

		Arrays.fill(numbersFloat, 0.0f);
	}

	public Float[] getNumbersFloat() {
		return numbersFloat;
	}
	
	public void initValuesInArray() {
		/// write code here to intialize the values in the array
		Scanner input = new Scanner(System.in);

		for ( int i = 0; i < numbersFloat.length; i++ ) {
			System.out.print("Enter value: ");
			Float num_f;
			while (true){

				try {
					num_f = Float.parseFloat(input.nextLine());
					break;
				} catch (NumberFormatException nfe) {
					System.out.println("\n" + "Invalid entry. Enter numberic value");
				}
			}			
			numbersFloat[i] = num_f;
		}

	}



	@Override
	public String toString() {
		// write code to return the values in the array in a list format - one value per line
		String output = "";
		for(int i=0;i<numbersFloat.length;i++) 
			output += numbersFloat[i] + "\n";
		return  output;
	}

	public float calcAverage() {
		// write code to return the average of the values in the array
		Float sum = 0.0f;
		for(int i=0;i<numbersFloat.length;i++) 
			sum += numbersFloat[i];
		Float average = sum/numbersFloat.length;
		return average;
	}

	/*	public Integer checkUserInput(String str) {

		try { 
			num = Integer.parseInt(str); 
		} catch(NumberFormatException nfe) {
			System.out.println("\n" + "Invalid entry. Enter numberic value");

	 */

}
