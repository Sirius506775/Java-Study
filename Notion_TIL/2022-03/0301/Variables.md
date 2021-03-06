# 20220301

## 변수(Variables)

```
 int v1 = 10;
        int v2 = 20;
        int c = 0;
        c = v1 + v2;

System.out.println(c);
```

JAVA는 반드시 변수의 타입에 맞는 데이터만 표현 가능

변수의 이름은 성격에 맞게 구체적으로 작성

이름은 CamelCase로 지정

<aside>
💡 변수를 선언한다는 것은 메모리에 일정 공간을 차지하는 상자를 만든다는 것입니다.

</aside>

기본 자료형 = 단순한 데이터를 담는 상자

대부분 다 소문자

객체 자료형 = 데이터들을 모아놓은 상자

대문자, 배열

**사용되는 자료형 type**  

*1byte = 8bit*

- int(4byte) 정수형
- double(8byte) 소수형
- boolean 참/거짓
- char(2byte)문자

**변수 선언**

ex. 

int value = 10; 

Input ⇒ User ⇒ JVM

(value라는 int 자료형의 데이터를 보관할 공간을 만들고 10이라는 데이터를 넣어라!) 

<aside>
💡 = **할당 연산자(Assign Operator)**
• =의 왼쪽은 데이터를 넣으려고 하는 대상(상자)을 의미
• =의 오른쪽은 넣고 꺼낼 데이터를 의미

</aside>

<aside>
💡 **변수를 선언하는 판단기준**

- 연산한 결과를 보관할 때
- 한 번 선언한 데이터를 여러 곳에서 사용할 때
- 매번 다른 데이터를 사용할 때
</aside>
