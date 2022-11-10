import java.util.Scanner;

abstract public class TempConverter { //TempConverter - абстрактный родительский класс, имеет абстрактные подклассы FromCelsiusTo, FromKelvinTo и FromFahrenheitTo, а те в свою очередь имеют конкретные подклассы.
//В TempConverter находится метод main, к-й вызывает в свою очередь метод start через объект экземпляра конкретного подкласса, после чего метод start получает значения от пользователя и передает их соответствующим
// переменным, также main имеет метод convert, который уже определен и к-й только стоит вызвать любому конкретному подклассу.
//У каждого из абстрактных классов, дочерних от TempConverter,  есть по два конкретных подкласса, например, у класса FromCelsiusTo - это FromCelsiusToKelvin и FromCelsiusToFahrenheit.
//В каждом из дочерних классов у меня написаны только название класса, его модификаторы и фигурные скобки, можно ли так писать? У меня там даже методы не объявлены.
// По итогу программа у меня после принятия цифр в формате double не возвращает ничего, я не понимаю, почему, может проблема в том, что программа принимает не double, а, например, String?

	private double result;	//тут указаны все переменные, которые участвуют в программе, каждая из них инкапсулирована
	private double userValue;
	private String toSmth;
	private String fromSmth;
	private String aString;
	private double var1 = 1.8; // это константы, участвующие в формулах
	private double var2 = 32.0; // константа
	private double var3 = 273.15; // константа

	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}

	public double getUserValue() {
		return userValue;
	}
	public void setUserValue(double userValue) {
		this.userValue = userValue;
	}
	
	public double getVar1() {
		return var1;
	}
	public void setVar1(double var1) {
		this.var1 = var1;
	}

	public double getVar2() {
		return var2;
	}
	public void setVar2(double var2) {
		this.var2 = var2;
	}

	public double getVar3() {
		return var3;
	}
	public void setVar3(double var3) {
		this.var3 = var3;
	}

	public String getFromSmth() {
		return fromSmth;
	}
	public void setFromSmth(String fromSmth) {
		this.fromSmth = fromSmth;
	}

	public String getToSmth() {
		return toSmth;
	}
	public void setToSmth(String toSmth) {
		this.toSmth = toSmth;
	}

	public String getAstring() {
		return aString;
	}
	public void setAstring (String aString) {
		this.aString = aString;
	}






	public static void main(String[] args) {
		TempConverter b = new FromCelsiusToKelvin();
		b.start();
	}
	





	public void convert(String fromS, String toS, double uValue) {
		if ((fromS == "C") || (fromS == "С") || (fromS == "c") || (fromS == "с")) {
			if ((toS == "K") || (toS == "k") || (toS == "К") || (toS == "к")) {
				setResult(uValue + getVar3());
				setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);
			}
			else if ((toS == "F") || (toS == "f")) {
				setResult(uValue * getVar1() + getVar2());
				setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);	
			}
		}
		else if ((fromS == "K") || (fromS == "k") || (fromS == "К") || (fromS == "к")) {
			if ((toS == "C") || (toS == "С") || (toS == "c") || (toS == "с")) {
				setResult(uValue - getVar3());
				setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);
			}
			else if ((toS == "F") || (toS == "f")) {
				setResult((uValue - getVar3()) * getVar1() + getVar2());
				setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);
			}
		}
		else if ((fromS == "F") || (fromS == "f")) {
			if ((toS == "K") || (toS == "k") || (toS == "К") || (toS == "к")) {
				setResult((uValue + getVar2()) / getVar1() + getVar3());
				setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);
			}
			else if ((toS == "C") || (toS == "С") || (toS == "c") || (toS == "с")) {
				setResult((uValue - getVar2()) / getVar1());
				//setAstring(Double.toString(getResult())); 
				System.out.println("Получилось: " + getAstring() + toS);
			}
		}
	
	}






	public void start() {
		
		Scanner in = new Scanner(System.in);	
		System.out.println("Введите единицу измерения температуры, которую нужно конвертировать. Например: введите C, если это Цельсия, K, если Кельвины, если Фаренгейты ");
		String unit = in.nextLine();
		setFromSmth(unit);
	
		System.out.println("Введите, во что вы хотите конвертировать градусы по " + getFromSmth() + ". Например: введите F, если в Фаренгейты, или K, если в Кельвины, С, если в Цельсия: ");
		String str = in.nextLine();
		setToSmth(str);
	
		System.out.println("Хорошо, введите значение температуры, которое нужно конвертировать: ");
		double v = in.nextDouble();
		setUserValue(v);
		
		if (((getFromSmth() == "C") || (getFromSmth() == "С") || (getFromSmth() == "c") || (getFromSmth() == "с")) && ((getToSmth() == "K") || (getToSmth() == "k") || (getToSmth() == "К") || (getToSmth() == "к"))) {
			TempConverter a = new FromCelsiusToKelvin();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}
		else if (((getFromSmth() == "C") || (getFromSmth() == "С") || (getFromSmth() == "c") || (getFromSmth() == "с")) && ((getToSmth() == "F") || (getToSmth() == "f"))) {
			TempConverter a = new FromCelsiusToFahrenheit();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}
		
		else if	(((getFromSmth() == "K") || (getFromSmth() == "k") || (getFromSmth() == "К") || (getFromSmth() == "к")) && ((getToSmth() == "C") || (getToSmth() == "С") || (getToSmth() == "c") || (getToSmth() == "с"))) {
			TempConverter a = new FromKelvinToCelsius();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}
		else if (((getFromSmth() == "K") || (getFromSmth() == "k") || (getFromSmth() == "К") || (getFromSmth() == "к")) && ((getToSmth() == "F") || (getToSmth() == "f"))) {
			TempConverter a = new FromKelvinToFahrenheit();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}

		else if (((getFromSmth() == "F") || (getFromSmth() == "f")) && ((getToSmth() == "C") || (getToSmth() == "С") || (getToSmth() == "c") || (getToSmth() == "с"))) {
			TempConverter a = new FromFahrenheitToCelsius();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}
		else if (((getFromSmth() == "F") || (getFromSmth() == "f")) && ((getToSmth() == "K") || (getToSmth() == "k") || (getToSmth() == "К") || (getToSmth() == "к"))) {
			TempConverter a = new FromFahrenheitToKelvin();
			a.convert(getFromSmth(), getToSmth(), getUserValue());
		}
	




	}

}