import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class Main extends Calculator{
		
		private static double a = 0d;
		private static double b = 0d;
		
		public static void main(String[] args){		
			//call instance of the calculator class
			Calculator calculator = new Calculator(); 
			
			//call method to set string variables
			calculator.setVariables();
			
			//prompt user for input
			System.out.println(promptOne);
			
			//Checks if variable A has been set 
			boolean first = false;
			
			//initialize scanner 
			Scanner scan = new Scanner(System.in);
			
			//continuously checks for user input and loops
			while(scan.hasNextLine()){
		        //stores user input in string
				String userInput = scan.nextLine();
				//scans string for specific pattern
				Pattern regex = Pattern.compile("(-?\\d+(?:\\.\\d+))");
				Matcher matcher = regex.matcher(userInput);
				
				//if/else statements that determines if the user entered a function
	            if(userInput.contains(promptFourteen)){
	            	    calculator.clear();       			   		
	            	
				}else if(userInput.contains(promptThirteen)){				        
					calculator.undo();
					
				}else if(userInput.contains(promptFifteen)){
					calculator.exit();	
					
				}else{
				
				//checks if string has decimal format match and assigns variables			
				if(matcher.find() == true && first == false){
					a = Double.valueOf(matcher.group(1));
					first = true;
				}
				if(matcher.find() == true && first == true){
					b = Double.valueOf(matcher.group(1));
					first = false;
				}else{
					System.out.println(promptThree + "\n");
					a = 0.0;
					b = 0.0;
				}//end of matches validation
					
				   //call calculator methods 
					if(userInput.contains("+")){
						calculator.add(a,b);					
						
					}else if(userInput.contains("-")){
						calculator.subtract(a,b);
						
					}else if(userInput.contains("*")){
						calculator.multiply(a,b);
						
					}else if(userInput.contains("/")){
						calculator.divide(a,b);						
						
					}else{
						System.out.println(promptSeven + "\n");
					}
				}//end of else expression 
	            //Prompt for next user input
	            System.out.println(promptOne + "\n");
			}//end of scanner while loop		
		}//end of main method
	}//end of class
