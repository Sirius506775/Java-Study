# 상속(Inheritance)

---

### 상속의 기본 구조

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled.png)

- 상속이란?

특정 클래스를 생성할 때 기존에 생성된 클래스가 가지고 있는 데이터와 메소드를 물려받아서 사용하는 것을 의미한다. 여기서 물려받는 클래스는 자식클래스 , 물려주는 클래스는 부모클래스라고 부른다. 

상속은 이미 작성된 코드를 재사용하여 절약할 수 있다는 장점이 있습니다.

<aside>
💡 상속받는 코드가 많은 것이 절대 좋은 것이 아니다!!

</aside>

- **상속의 기본 문법**

`class B extends A(상속받을 클래스){`

`}`

하위 클래스가 상위 클래스의 속성과 기능을 확장(extends)한다는 의미입니다.

- **단일 상속(Single Inheritance)**

JAVA는 단일 상속만을 지원합니다 . extends 키워드 뒤에는 반드시 하나의 클래스만 올 수 있습니다. 

JAVA는 기존에 있던 C나 C++보다 안전한 언어를 만들고자 초기부터 안정성과 심플함을 추구했습니다. 

![어떤 cry[]를 ㅂ=](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%201.png)

어떤 cry[]를 ㅂ=

물론 상속을 받을 수 있는 클래스들이 많아질수록 기능의 확장이 있을 수 있지만, 그로 인해 발생할 수 있는 문제나 모호성을 없애고자 JAVA에서는 단일 상속만을 지원합니다.  

하위 클래스를 생성하면 상위 클래스가 먼저 생성됌

new VIPCustomer()

super() : 하위클래스가 상위 클래스의 인스턴스의 참조값을 가지게된다.

---

### 인스턴스 메모리의 상태

- 부모 클래스의 인스턴스 생성 후, 자식 클래스의 인스턴스 생성

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%202.png)

Q. 부모클래스의 접근제어자가 private면 인스턴스가 생성되지 않나요? 

⇒ **A. 생성되지만 접근을 못하는 것 뿐이다. 때문에 protected도 바꿔줄 수 있다.**

---

### 형 변환(업캐스팅)

- 상위 클래스로 변수를 선언 후,  하위 클래스의 생성자로 인스턴스를 생성할 수 있다. 묵시적 형 변환이 된다.

```java
Customer customerLee = new VIPCustomer();
```

VIPCustomer는 Customer type을 내포하고 있습니다. 

이미 Customer이면서, VIPCustomer의 속성을 더 가지고 있기 때문에 VIPCustomer의 인스턴스는 Customer type으로 대입될 수 있습니다.

- 상위 클래스 타입의 변수에 하위 클래스 변수가 대입

```java
VIPCustomer vCustomer = new VIPCustomer(); 
// VIPCustomer를 만들고, vCustomer에 할당
addCustomer(vCustomer);
// addCustomer라는 메소드로 vCustomer를 호출

int addCustomer(Customer customer){
	} //매개변수를 Customer type으로 받아줍니다. 
```

Q. addCustomer의 매개변수를 Customer type으로 받아도 인자를 넘길 수 있는 이유가 뭘까?

⇒ **A.  vCustomer는 VIPCustomer지만, Customer의 type으로 형변환이 될 수 있기 때문이다.** 

 상위 클래스로 형변환이 되는 것 = UpCasting

↔ 상위클래스로 형변환이 된 것이 원래의 인스턴스 type으로 오는 것 = DownCasting 

상속 관계에서 모든 하위 클래스는 상위 클래스로 업캐스팅이 된다.

<aside>
💡 모든 Customer가 VIP인 것은 아니다. 모든 포유류가 사람인 것과 마찬가지이다.  **때문에 그 역은 성립되지 않는다.**

</aside>

---

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%203.png)

vc는 VIPCustomer로 생성했지만, Customer로 형 변환이 되었기 때문에 Customer의 인스턴스들만 호출되는 것을 확인할 수 있다.

VIP의 인스턴스 상태라고 해도, Customer로 형변환이 되었으면 Customer의 멤버변수와 메소드만 사용 가능한 것이다. 

여기서 알 수 있는 사실은 변수(Variable)는 자신의 type만 쓴다는 것이다. 

만약, VIPCustomer의 멤버변수를 다 써야한다면, 다운캐스팅을 해야한다.

![Upcasting 시 접근가능한 범위.png](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Upcasting_%EC%8B%9C_%EC%A0%91%EA%B7%BC%EA%B0%80%EB%8A%A5%ED%95%9C_%EB%B2%94%EC%9C%84.png)

메모리 구조 상으로 vc가 실제 접근할 수 있는 부분은 Customer의 변수와 메소드이다.

생성은 다 되지만, 상위 클래스의 형으로 변환이 되면, 접근할 수 있는 상위 클래스 타입이 선언되어 있는 요소만 사용 가능

---

### 메소드 재정의(Overriding)

- 상위 클래스에서 구현된 메소드를 하위 클래스에서 재정의할 시 주의할 점

⇒ **(function signature) 부분이 반환값, 메소드 이름, 매개변수의 타입과 개수가 같아야한다.**

맞지 않을 경우 다른 메소드로 처리된다.

---

### 메소드의 호출 원리

- JAVA에서 모든 메소드는 가상메소드이며, 메소드의 이름은 주소값을 나타낸다.
- 메소드는 명령어의 set이고, 프로그램이 로드되면 메소드 영역에 명령어 set이 위치한다.
- 해당 메소드가 호출되면 명령어 set이 있는 주소를 찾아서 명령어가 실행된다.
- 이때 메소드에서 사용되는 변수들은 스택 메모리에 위치한다.
- 따라서 다른 인스턴스라도 같은 메소드의 코드는 같으므로 같은 메소드가 호출된다.
- 인스턴스가 생성되면 변수는 힙 메모리에 따로 생성되지만, 메소드 명령어 set은 딱 한 번만 로드된다.

```java
public class TestMethod{

			int num;

			void aaa(){
								System.out.println("aaa() 호출");
			}

			public static void main(String[] args) {

								TestMethod a1 = new TestMethod(); 
								a1.aaa();

								TestMethod a1 = new TestMethod(); 
								a2.aaa();
			}
}
```

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%204.png)

---

### 가상 메소드의 원리

- 재정의된 경우는 재정의 된 메소드의 주소를 가리킴

ShowCustomerInfo는 override 하지 않았기 때문에 Customer의 주소를 가지고 있다. 

VIPCostumer 클래스의 CalcPrice는 재정의 되었기 때문에 재정의 된(Overriding이 된) 주소를 가리킨다.

인스턴스의 메소드 호출 → 가상메소드 테이블로 이동 → 재정의된 자신의 함수가 호출된다.

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%205.png)

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%206.png)

---

### 컴파일러 타임 / 런타임

컴파일러는 변수 타입으로 선언된 클래스 안에 해당하는 메소드가 있는지 확인만 합니다.

(컴파일러타임)

실행될 때는 연결된 객체이며, 만일 실제 객체에 해당 메소드가 없다면 그때 부모 클래스로 올라가서 정보를 추적합니다.

(런타임)

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%207.png)

---

### this와 super

![Untitled](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8(Inheritance)%20d1a07675f2674eeba4a5f591859c21a7/Untitled%208.png)

---

### 상속에서의 private

부모 클래스에 **private**이 붙은 메소드나 변수는 기본적으로 접근할 수 없는 것이지 상속할 수 없
는 것은 아니다. 상속의 개념으로 이해하면 안된다...! 

또한, 

**private**을 이용하면 상속이 안 되는 것이 아니라 접근을 못 한다는 개념으로 이해해야 한다.

[상속을 사용하면서 만나는 상황](https://www.notion.so/18863434a1b84cb89b0917977a5e0912)

---

### 다형성(Polymorphism)

상속을 사용하면 하나의 변수 타입으로 여러 개의 객체를 가리킬 수 있기 때문에 코드를 고치지 않고 처리할 수 있는 부분이 많아진다. 이것이 다형성이다. 

JAVA에서는 상속과 인터페이스를 이용해서 다형성을 구현할 수 있다.

<aside>
💡 흔히들 상속과 다형성이라고 나누어서 설명하지만 실제로는 상속을 통해서 다형성을 구현할 수 있다는 표현이 더 정확한 표현이다.

</aside>

---

### 상속의 장단점

1. 변수의 타입과 실제 객체가 일치하지 않아도 된다는 장점이 있다.
2. 부모의 타입으로 파라미터를 선언할 수 있다.
3. 부모 타입으로 배열도 선언할 수 있다. 
4. 상속은 개발 시간을 단축시킵니다.