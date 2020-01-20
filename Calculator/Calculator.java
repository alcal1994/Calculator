import java.util.Locale;
import java.util.Stack;

public class Calculator{
	private static double runningTotal;
	private static Stack<Memento> result = new Stack <Memento>();
	
	//strings of language responses
			static String promptOne;
			static String promptTwo;
			static String promptThree;
			static String promptFour;
			static String promptFive;
			static String promptSix;
			static String promptSeven;
			static String promptEight;
			static String promptNine;
			static String promptTen;
			static String promptEleven;
			static String promptTwelve;
			static String promptThirteen;
			static String promptFourteen;
			static String promptFifteen;
			static String promptSixteen; 
	
	//used for checked locale outputs 
	//String locale = "zh_cn";
	//System.out.println("Locale: " + locale);
	public void setVariables(){
	 
	//Gets default locale and print it
		Locale locale = Locale.getDefault();
		
	//check user locale and set language variables 
	if(locale.equals("zh_cn")){
		promptOne = " 输入（清除，撤消，退出，表达式 ";
		promptTwo = " 所有计算均已清除 ";
		promptThree = " 您必须以以下示例形式输入输入值：4.4 + 5.5 ";
		promptFour = " 小计： ";
		promptFive = " 累计： ";
		promptSix = " 撤消不可用 ";
		promptSeven = " 您必须在实际文字输入之间使用以下操作数: (+,-,*,/)";
		promptNine = " 产品 ";
		promptTen = " 区别 ";
		promptEleven = " 除法小计 ";
		promptTwelve = " 产品 ";
		promptThirteen = "撤消";
		promptFourteen = "明确";
		promptFifteen = "退出";
		promptSixteen = " 无法除以0 ";
		
	}else if(locale.equals("ru_ru")){
		promptOne = " войти(Чисто,отменить,Выход,выражение) ";
		promptTwo = " Все расчеты были очищены ";
		promptThree = " Вы должны ввести входное значение в форме примера: 4.4 + 5.5 ";
		promptFour = " Сумма: ";
		promptFive = " Итого: ";
		promptSix = " Отмена недоступна ";
		promptSeven = " Вы должны использовать следующие операнды между вещественно-литеральными входами: (+,-,*,/)";
		promptNine = " продукт ";
		promptTen = " difference ";
		promptEleven = " разница ";
		promptTwelve = " продукт ";
		promptThirteen = "отменить";
		promptFourteen = "Чисто";
		promptFifteen = "Выход";
		promptSixteen = " Невозможно разделить на 0 ";
	}else{
		promptOne = " Enter (CLEAR,UNDO,EXIT,Expression) ";
		promptTwo = " All calculations have been cleared ";
		promptThree = " You must enter an input value in the example form of: 4.4+5.5 ";
		promptFour = " Sum: ";
		promptFive = " Running Total: ";
		promptSix = " undo is unavailable ";
		promptSeven = " You must use the following operands between real-literal inputs: (+,-,*,/) ";
		promptNine = " product ";
		promptTen = " difference ";
		promptEleven = " Quotient ";
		promptTwelve = " product ";
		promptThirteen = "undo";
		promptFourteen = "clear";
		promptFifteen = "exit";
		promptSixteen = " Cannot divide by 0 ";
		}
	}
	
	public void clear(){
		while (!result.empty()){
			result.pop();
			runningTotal = 0.0;   
			System.out.println(promptTwo + "\n");
		}
	}
	
	public void undo(){
		if(result.empty()){
			System.out.println(promptSix + "\n");
		}else{		
		runningTotal = runningTotal - (Double) result.peek().getTotal();
		result.pop();
		System.out.println(promptFive + runningTotal + "\n");
		}
	}
	
	public void exit(){
		System.out.println(promptFifteen + "\n");
		System.exit(0);	
	}
	
	public void add(double a, double b){
		Memento newMemento = new Memento();
		double total = (a + b);
		runningTotal += total;
		newMemento.setTotal(total);
		result.push(newMemento);
		System.out.print(promptFour + total + promptFive + runningTotal + "\n");
	}
	
	public void subtract(double a, double b){
		Memento newMemento = new Memento();
		double subTotal = (a + b);
		runningTotal += subTotal;
		newMemento.setTotal(subTotal);
		result.push(newMemento);
		System.out.print(promptTen + subTotal + promptFive + runningTotal + "\n");
	}
	
	public void multiply(double a, double b){
		Memento newMemento = new Memento();
		double mulTotal = (a * b);
		runningTotal += mulTotal;
		newMemento.setTotal(mulTotal);
		result.push(newMemento);
		
		System.out.print(promptTwelve + mulTotal + promptFive + runningTotal + "\n");
	}
	
	public void divide(double a, double b){
		if(a == 0 || b == 0){		
			System.out.println(promptSixteen + "\n");	
		}else{
			
		double divTotal = (a / b);
		runningTotal += divTotal;
		Memento newMemento = new Memento();
		newMemento.setTotal(divTotal);
		result.push(newMemento);
		System.out.println(promptEleven + divTotal +  promptFive + runningTotal + "\n");
		}
	}
		
}//end of class
