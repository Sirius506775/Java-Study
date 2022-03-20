# Exception Handling

---

**예외 처리**란 99%가 정상적으로 실행되더라도 1%의 오류가 발생할 수 있다면 이를 처리하는 작업을 의미한다.

프로그램에서 혹시라도 발생 가능한 예기치 않는 상황에 대한 대비이다.

<aside>
💡 **예외 처리(Exception Handling)**는 간단히 말해서 '프로그램을 위한 보험 처리'입니다. 잘못된 하나로 인해 전체 시스템이 무너지는 결과를 방지하기 위한 기술적인 처리입니다.

- `**예외가 주로 발생하는 원인**`
1. `사용자가 잘못된 데이터를 입력하는 경우`
2. `개발자가 로직이나 계산을 잘못 작성한 경우`
</aside>

---

### Error와 Exception을 구분하는 기준

- 메모리가 부족하거나, JVM 동작 이상이 발생하는 등의 개발자가 조치할 수 없는 상황을 **Error**
- JVM 은 정상적으로 동작하고 있지만, 다른 방식으로 처리하는 것.
    
    즉, 개발자가 조치할 수 있는 상황 **Exception**
    

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1d5234f8-42d1-4c4b-ba1b-024760165af8/Untitled.png)

컴파일러가 체크해주는 예외는 오히려 처리하기가 간단하다! 버튼 몇 번만 눌러주면 알아서 코드가 생성되기 때문이다.

하지만 초급자들에게는 컴파일러가 체크하지 않는 예외의 경우가 오히려 어렵다. 메시지를 해석해보는 습관을 가지도록 평상시에 훈련해보자.

---

### Exception의 두 가지 종류

- **Checked Exception**: 예외 처리를 하지 않으면 컴파일을 허락하지 않는 예외, 주로 외부 리소스와 통신하는 경우는 반드시 Checked Exception이라고 생각하시면 됩니다.
    - 네트워크 혹은 파일 시스템의 연동 시
    - 시스템의 보안 위반 행위
- **Unchecked Exception**: 컴파일 시에 체크되지 않고, 실행 시(Runtime)에 발생하는 Exception을 말합니다. 개발자들이 작성하는 로직에 의해서 처리해야 하는 예외입니다.
    - 사용자가 입력한 데이터를 검증하지 않아서 발생하는 경우가 가장 대표적인 상황

---

### 가장 빈번하게 겪는 예외들

- 실제 레퍼런스(리모컨)가 가리키는 객체가 없는 상태에서 강제로 동작을 시키는 **NullPointerException**
    
    ```java
    public class NullEx {
    	public static void main(String[] args) {
    		String str1 = "AAAAAAAA";
    		String str2 = null;
    		System.out.println(str1);
    		System.out.println(str2);
    		//객체를 동작시켜 본다.
    		System.out.println(str1.charAt(0));
    		System.out.println(str2.charAt(0));
    	}
    }
    --------------------------------
    AAAAAAAA
    null
    A
    Exception in thread "main" java.lang.NullPointerException
    at NullEx.main(NullEx.java:15)
    ```
    
    <aside>
    💡 **NullPointerException을 찾는 방법**
    NullPointerException은 변수 안의 리모컨이 실제 객체를 가리키지 않을 때 발생하므로 무조건 Exception이 발생한 곳의 '.'으로 호출한 코드(객체를 움직이게 하는 코드)만 찾으면 됩니다.
    
    </aside>
    

- 배열, 문자열, 자료구조와 같이 범위를 벗어난 인덱스 번호를 사용하는 **IndexOutOfBoundsException**
    - StringIndexOutOfBoundsException
        
        ```java
        public class OutofBoundsEx2 {
        	public static void main(String[] args) {
        	String str = "ABCDE";
        	String sub = str.substring(7);
        	}
        }
        -----------------------------------------------------------------
        Exception in thread "main" java.lang.StringIndexOutOfBoundsException:
        String index out of range: -2
        at java.lang.String.substring(String.java:1938)
        at java.lang.String.substring(String.java:1905)
        at OutofBoundsEx2.main(OutofBoundsEx2.java:8)
        ```
        
    - ArrayIndexOutOfBoundsException
        
        ```java
        public class OutofBoundsEx {
        	public static void main(String[] args) {
        		int[] arr = {1, 2, 3};
        		System.out.println("배열의 길이" +arr.length);
        		//인덱스번호는 0, 1, 2까지만 존재
        		System.out.println(arr[3]);
        	}
        }
        ------------------------------------------------
        배열의 길이 3
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        at OutofBoundsEx.main(OutofBoundsEx.java: 9)
        ```
        
- substring( ) 메소드

- 문자열이나 숫자/날짜 변환 시에 잘못된 데이터로 발생하는 **XXXFormatException.** `컴파일러가 체크하지 않는 Excepttion이므로 신경을 많이 써야한다!!`
    - NumberFormatException
        
        ```java
        import java.util.Scanner;
        
        public class NumberEx {
        		public static void main(String[] args) {
        					String str = "123A";
        					int i = Integer.parseInt(str);
        					System.out.println(i);
        		}
        }
        ----------------------------------------------------
        Exception in thread "main" java.lang.NumberFormatException:
        For input string: "123A"
        at java.lang.NumberFormatException.forInputString
        (NumberFormatException.java:48)
        at java.lang.Integer.parseInt(Integer.java:456)
        at java.lang.Integer.parseInt(Integer.java:497)
        at NumberEx.main(NumberEx.java:10)
        ```
        
    - InputMismatchException
    
    ```java
    import java.util.Scanner;
    
    public class NumberEx2 {
    		public static void main(String[] args) {
    					Scanner s = new Scanner([System.in](http://system.in/));
    					System.out.println("숫자를 입력하세요.");
    			//사용자가 고의로 숫자 변환이 불가능한 값을 입력하면 예외 발생
    					int input = s.nextInt();
    					System.out.println(input);
    		}
    }
    ---------------------------------------------------------
    숫자를 입력하세요.
    a
    Exception in thread "main" java.util.InputMismatchException
    at java.util.Scanner.throwFor(Scanner.java:840)
    at java.util.Scanner.next(Scanner.java:1461)
    at java.util.Scanner.nextInt(Scanner.java:2091)
    at java.util.Scanner.nextInt(Scanner.java:2050)
    at NumberEx2.main(NumberEx2.java:13)
    ```
    

---

### 우리가 예외 처리에서 하는 작업은 Exception을 어떻게 핸들링해서 프로그램을 안전하게 보호할 것인지를 처리해 주는 것입니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fbaee8f1-6700-45bf-918e-85812fea1f00/Untitled.png)

JAVA에서는 모든 예외가 발생하게 되면 Exception 객체를 발생시킨다.

Exception 또한 상속구조를 가지고 있기 때문에 우리는 java.lang.Exception 클래스 알고 있으면 된다.  많은 자식 클래스들을 가지고 있다.

---

### Exception 클래스에서 알아야 하는 메소드는?

Exception 클래스는 부모 클래스인 Throwable 클래스에서 모든 메소드를 물려받는다.

- **printStackTrace( );** 발생한 Exception의 출처를 메모리상에서 추적하면서 결과를 알려줍니다. **`즉 예외가 발생한 위치를 정확히 화면에 출력해주기 때문에 가장 많이 쓰이고`**, 이클립스가자동으로 완성시켜주는 코드도 이 메소드를 사용하고 있습니다. 다만, 리턴 타입이 void이기때문에 보이는 메시지를 다른 방식으로 응용할 수 없다는 불편함이 있습니다.
- **getMessage( );** printStackTrace( )가 상세한 내용이라면 getMessage( )는 **`한 줄로 요약된 요약 메시지를 String으로 반환`**해줄 수 있습니다. 주로 예외의 근본적인 발생 원인만을 어디선가 사용할 필요가 있을 때 많이 사용합니다.
- getStackTrace**( );** JDK1.4부터 지원하는 기능으로 printStackTrace( )의 단점을 보완하기 위해서 나온 개념입니다. StatTraceElement라는 객체들의 배열로 printStackTrace( )의 결과를 객체화시켜줍니다. 이것은 printStackTrace( )가 그냥 콘솔 창에 출력만 되기 때문에 별도로 문자열을 만들 때 getStactTrace( )를 이용해서 문자열로 변경해서 처리합니다.

<aside>
💡 **printStactTrace( )가 모든 원인을 추적하면서 알려준다는 것과, 간단하게 결과를 알고 싶을 때에는 getMessage( )를 사용한다는 것만 알고 있으면 됩니다.**

</aside>

---

### 예외 처리에서 알아야할 두 가지를 정리해본다면

- 예외는 **객체로 처리**되고 **모든 예외는 Exception이라는 클래스의 하위 클래스**이다. 따라서 우
리는 어떤 종류의 예외 객체가 발생하든지 간에 'Exception a = new XXXException( );'과 같
은 상속 구조를 이용하려면 Exception이라는 클래스만 정확히 알고 있으면 된다.
- Exception의 **메소드는 printStackTrace( )가 가장 많이 사용**된다. 이는 발생한 예외의 원인을
추적해서 보여준다. 또한, **getMessag( )는 예외의 원인 메시지를 문자열로 리턴**해준다.

---

## Try ~ catch : 예외를 직접 처리

**try ~ catch**를 이용해서 **로직 중에 예외가 발생할지도 모르는 부분에 보험처리**를 합니다. try { }안에는
위험한 로직을 catch{ }에서는 예외 발생 시에 대안 처리를 작성합니다.

```java
try{
			**예외가 발생할 가능성이 있는 코드**
}catch(Exception e) {
			**예외 발생 시 대안 처리**
}
```

예외 처리를 효과적으로 하려면 적절한 판단이 필요하다. **그렇다면 우리는 예외 처리를 어떻게 진행해야할까?**

- 예외 처리를 하고 싶은 코드의 부분을 찾는다.
    - `**중요한 점은 라인 단위로 예외처리를 하지 않는다!**` 주로 예외 처리는 **로직의 한 부분 전체를 예외의 대상으로 삼는다.** 로직 단위가 기준이다.
- try 블록 안에는 정상적으로 실행될 코드를 넣어준다.
    - try 블록 안에는 **`무조건 예외 사항을 고려하지 않고 성공하는 코드만 작성`**합니다.
    - 처리를 하겠다고 생각하는 곳의 시작 위치에 try라는 블록을 시작해주면 됩니다.
- try 블록 안에서 유일하게 주의해야할 사항 한 가지는 `**선언한 변수는 블록 바깥쪽에서 사용될 수 없다는 것**`이다.
    - 만일 변수가 외부에서 계속 사용되어야 하는 변수라면 변수의 선언은 바깥쪽으로 하고 변수의 초기화는 안쪽에서 하는 것이 일반적이다.

---

### try로 시작한 구문의 완성은 catch 블록으로 완성됩니다

catch 블록 안에는 예외가 발생했을 때 어떻게 할 것인지를 작성해 두면 됩니다.

주로 catch 블록 안의 내용은 다음과 같은 항목 중에서 하나를 만족하는 경우가 많습니다.

- **예외에 대한 정확한 메시지를 보여주는 선택**
    - 대표적으로 printStackTrace( )가 바로 이런 역할을 합니다. 예외가 발생했을 때 어느 부분
    에서 문제가 발생했는지 원인을 알아볼 수 있게 만드는 것이 목표라고 생각할 수 있습니다.
- **잘못된 결과를 대신해서 나머지 코드에 영향이 없게끔 대안 결과를 제시하는 경우**
    - 가끔 인덱스의 번호를 이용하는 곳에서 어떤 메소드를 호출한 결과가 -1이라는 값이 나오
    는 경우가 있습니다. 주로 이런 경우는 연산을 하다가 catch 블록으로 빠져 나와서 절대 나
    올 수 없거나 미리 약속된 오류 코드를 결괏값으로 처리하는 겁니다. 즉 배열이라면 인덱스
    번호가 0부터 시작하지만 -1이라는 값을 반환해버리는 겁니다.
- **잘못된 상황에서 다른 메소드를 호출하거나, 결과를 기록하는 경우**
    - 위의 경우와 유사하긴 합니다만, 엄밀하게 말해서 `if ~ else` 대신에 처리하는 방법이라고
    생각하시면 됩니다. 즉 정상적으로 실행될 때에는 A( )라는 메소드가 실행된다고 가정하면
    예외가 발생하면 B( )나 C( )를 호출하게 하는 방식입니다.
    
    ---
    

catch의 ( )는 메소드의 파라미터라고 생각하세요.

```java
try{
			System.out.println(x/y);
}catch(Exception e){
			e.printStackTrace();
}
```

---

### *try ~ catch 블록에서 반드시 알아야 하는 건너뛰기*

`**예외가 발생하면 try{ } 안의 다른 코드는 실행되지 못합니다.**`try 블록에서 시도하다가 삐끗하면 catch로 간다고 생각하시면 됩니다. 물론 가고 나면 아래쪽의
나머지 코드들은 실행될 수 없습니다.

```java
public class ExceptionFlow {
			public static void main(String[] args) {
						try{
								String str = "AAA";
								int a = Integer.parseInt(str);
									//예외가 발생하므로 catch로 이동해 버린다.
										System.out.println("1---------------");
								System.out.println("2---------------");
								System.out.println("3---------------");
						}catch(Exception e){
								e.printStackTrace();
						}//end catch
						}
}
-----------------------------------------------------------------
java.lang.NumberFormatException: For input string: "AAA"
				at java.lang.NumberFormatException.forInputString(Unknown Source)
				at java.lang.Integer.parseInt(Unknown Source)
				at java.lang.Integer.parseInt(Unknown Source)
				at ExceptionFlow.main(ExceptionFlow.java:8)
```

---

### Exception은 상속 구조이다.

<aside>
💡 프로그램에서 발생하는 모든 예외는 Exception의 하위 클래스입니다. 따라서 catch(Exception e)로 처리
하게 되면 모든 예외를 다 처리할 수 있습니다.

```java
try{
			//예외가 발생할 가능성이 있는 코드
			//모든 예외는 Exception의 하위 클래스인 객체이다.
}catch(Exception e) { // 모든 Exception이 다 처리된다.
			//예외 발생 시 대안 처리
}
```

</aside>

<aside>
💡 **Exception은 상속 구조라는 점과 try ~ catch라는 구문을 이용해서 처리한다는 점, 그리고 `catch 블록 안에 Exception e라고 선언하게 되면 거의 모든 종류의 예외를 처리`할 수 있다는 점이 핵심이다.!!**

</aside>

<aside>
💡 ***우리가 앞으로 작성하게 될 만병통치약의 try~catch 코드의 템플릿***

```java
try{
			// 예외 발생 가능한 코드
}catch(Exception e){
			e.printStackTrace();
}
```

</aside>

---

### catch 블록은 여러 개 사용할 수 있다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d26dc682-56e0-4588-94a5-557caf90d493/Untitled.png)

- 여러 가지 예외가 하나의 try에서 발생하는 상황

```java
import java.util.Scanner;

public class ExceptionEx3 {
		public static void main(String[] args) {
					Scanner scanner= new Scanner([System.in](http://system.in/));
					int x = 0;
					int y = 0;
					try{
								//숫자를 입력받는 부분
								System.out.println("x 값을 입력해주세요.");
								x = scanner.nextInt();
								System.out.println("y 값을 입력해주세요.");
								y = scanner.nextInt();
								//데이터를 처리하는 부분
								System.out.println("두 수의 나누기는 " + (x/y));
					}catch(Exception e){
								e.printStackTrace();
					}
		}
}
------------------------------------------
x 값을 입력해주세요.
10
y 값을 입력해주세요.
0
java.lang.ArithmeticException: / by zero
		at ExceptionEx3.main(ExceptionEx3.java:21)

```

위 코드의 결과를 보면 입력 쪽에서 문제가 생긴 것이 아니라 연산 쪽에서 문제가 발생했습니다. 즉 예외가 발생할 수 있는 로직이 입력을 처리하는 작업과 연산하는 작업의 두 가지입니다.

---

### 끝끝내 실행하는 finally가 있습니다.

try ~ catch 구문은 추가로 하나의 구문을 더 가질 수 있다. 어떤 상황에서도 반드시 실행된다는 의미의 finally이다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4759f86f-7861-4cec-b712-e1d29b8a0c2f/Untitled.png)

finally 구문이 중요한 이유는 단 한 가지입니다. **`예외가 발생하거나 하지 않거나 간에 무조건 실행된다는 사실`**입니다.

- **주로 연결을 종료하는 작업은 finally로 합니다**
- **finally를 이용해서 예외가 발생할 때도 무언가 작업할 수 있게 되었습니다.**
    
    ```java
    import java.util.Scanner;
    
    public class FinallyEx {
    						public static void main(String[] args) {
    									Scanner s = new Scanner([System.in](http://system.in/));
    									int value = 0;
    									try{
    												value = s.nextInt(); //정상적일 때는 사용자가 입력한 값을 숫자로 변환
    									}catch(Exception e){
    												value = -1; //비정상적일 때는 -1을 값에 할당
    													
    									}finally{
    												System.out.println("VALUE : " + value); //결과가 어찌 되든 간에 value 값은 화면에 출력
    									}
    						}
    }
    ```
    
- **finally는 외부 자원 연결을 종료할 때는 반드시 사용합니다.**
    - JVM 바깥과 연결할 때 예외가 발생하든 않든 반드시 연결된 자원을 해제해야할 필요성이 있다. 이때 연결을 종료하기 위해 finally를 사용한다.

---

### throws로 발생한 예외를 던져버린다: 책임지기 싫으면 남에게 책임을 미루자!

<aside>
💡 예외에 대처하는 방식

- 직접 try ~ catch를 이용해서 예외에 대한 책임을 스스로 감당하는 방식
- throws Exception을 이용해서 발생한 예외의 책임을 호출하는 쪽으로 전가하는 방식
</aside>

**Q. 그렇다면 예외를 어디까지 던질 수 있을까? 예외를 던지는 상황!**

```java

public class ThrowsEx {
				public void doA()throws Exception{ // 3. doA( )는 다시 Main( )에게 던짐
							doB();
				}
				public void doB()throws Exception{ // 2. doB( )는 다시 doA( )에게 던짐
							doC();
				}
				public void doC()throws Exception{ // 1. doC( )가 doB( )에게 던짐
							//Exception이 발생할 코드
				}
				public static void main(String[] args) throws Exception { // 4. Main 메소드도 예외를 처리하지 않고 던짐
							ThrowsEx ex = new ThrowsEx();
							ex.doA();
				}
}
```

---

# ❗예외를 잡느냐, 던지느냐를 판단하는 것이 가장 중요합니다.

<aside>
💡 **예외 처리의 노하우**

- 호출하는 쪽에 예외를 보고해야 한다면 throws 방식으로 처리합니다.
- 최종적인 책임을 져야 하는 경우라면 try ~ catch를 고려합니다.
</aside>

- 예외를 던지는 것이 맞는지, 예외를 처리하는 것이 맞는지 정말 고민된다면 , 해당 메소드가 하는 작업이 **`다른 메소드와 연결이 되어서 작업되는 메소드인지`**, 아니면 `**단독으로 실행되는 메소드인지**`를 파악하라!
- 종속적인 작업일때는 예외를 처리하지 않고 던져서, 전체를 컨트롤하는 메소드에서 알아서 판단할 수 있게 하자는 것이다.
