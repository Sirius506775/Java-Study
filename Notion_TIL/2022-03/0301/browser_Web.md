# TIL 22-03-01

## Browser와 Web에 대한 이해

---

<aside>
💡 목적: 브라우저의 내부를 이해하면 웹 개발을 하면서 맞닥뜨리는 난해한 문제를 해결할 수 있고, 보다 최적화된 웹개발을 할 수 있다.

</aside>

---

**Brower는 월드와이드웹(WWW)에서 정보를 검색, 표현하고 탐색하기 위한 소프트웨어**

Browser는 데이터를 해석해주는 파서와 데이터를 화면에 표현해주는 렌더링엔진이 포함되어 있다.

url입력창과 Server와 HTTP로 데이터를 주고 받을 수 있는 network 모듈을 포함

Server에서 받은 문서(HTML, CSS, JavaScript)를 해석하고 실행하여 화면에 표현하기 위한 해석기(Parser)들을 가지고 있다.

---

![webkitflow.png](TIL%2022-03-%20561a0/webkitflow.png)

*Safari Browser에서 처리되는 webkit Rendering engine의 처리과정*

---

1. HTML을 해석해서 Dom Tree 만들고, CSS를 해석해서 CSS Tree)를 만든다(이 과정에서 Parsing 과정이 필요하며 토근 단위 해석방식은 일반적인 소스코드의 컴파일 과정과 같음)
2. Dom Tree와 Css Tree는 Render Tree로 다시 조합
3. ⇒ 조합된 결과는 화면에 어떻게 배치할지 크기와 위치 정보를 담고 있다.
4. 이후 Render Tree정보를 통해 화면에서 어떤 부분에 어떻게 색칠을 할지 Painting 과정을 거치게됌 

<aside>
💡 브라우저의 렌더링은 시스템 자원을 많이 잡아 먹기 때문에 DOM의 구조가 바뀌지 않는 스크롤이나 탐색기능을 사용할때는 다시 렌더링 하지않고, CSS style 만 변경하여 재배치 한다.

</aside>

** 

HTML / CSS 파싱 및 DOM트리 구축 > (HTML+CSS)렌더트리 구축 > 렌더트리 배치 > 렌더트리 그리기

브라우저를 표시하기 위해 위와 같은 과정이 필요하다.여기서 렌더링엔진은 좀 더 나은 사용자 경험을 위해 먼저 파싱된 내용부터 화면에 그리는데스크롤을 하거나, 사용자의 입력으로 화면의 위치(Layout)가 바뀌게 될 경우동일한 부분을 제외하고 달라지는 부분(DOM 노드의 레이아웃에 영향을 주는 요소들이 바뀌게 되면)만파싱하여 렌더트리를 재배치하고, 그리게 된다.반면 레이아웃과 관계 없는 스타일적인 요소만 바뀌게 될 경우 렌더트리를 재배치하는 일 없이 다시 그리는 과정만 수행된다.

---

**HTTPS(HyperText Transfer Protocol over Secure Socket Layer)** 

HTTP를 보완하는 수단으로서 HTTP의 일반 텍스트(text)에 SSL(보안소켓계층)이나 TLS프로토콜을 씌워 통해 데이터를 암호화하는 기법

- HTTP는 암호화되지 않았기 때문에 도난이나 변조, 도청이 가능

→ 이와 같은 HTTP 프로토콜의 문제점인 정보의 암호화 해결이 필요

- HTTPS를 사용하는 경우 URL에서 [http://가](http://xn--o39a/) 아닌 [https://를](https://xn--bx2b/) 사용합니다.
- 443번 이라는 다른 포트 번호를 사용한다.(HTTP의 기본 포트 80, HTTS는 443)
- 로그인이나 결제화면에서 주로 쓰이며,  주로 금융거래, 개인정보등 민감한 정보를 다룰 때 사용된다.
- 단점으로는 암호화, 복호화 과정이 필요하기 때문에 HTTP 방식보다속도가 느리다. 인증서 발급을 유지하기 위한 추가비용이 발생한다.

**렌더링(Rendering)**

---

HTML,CSS 등 개발자가 작성한 문서가 브라우저에 출력되는 과정

각 브라우저는 렌더링을 수행하는 렌더링 엔진을 가지고 있음

(ex. Chrome - 블링크(Blink), Safari - Webkit, Firefox - 게코(Gecko) 

<aside>
💡 크로미움은 V8 + Blink를 포함한 구글 브라우저 오픈소스 어플리케이션. 크롬은 크로미움 기반으로 만들어짐(크로미움은 렌더링 엔진으로 Blink(webkit에서 fork된)를 사용한다.  Blink ≠ Chromium

</aside>

Client가 브라우저를 통해 웹사이트에 접속하면 Server로부터 웹사이트에 필요한 resource download

- More Detail
    
    Browser가 paga를 Rendering하려면 먼저 HTML code가 Dom, CSS는 Cssom TREE를 생성해야함
    

---

**Parsing** 

구문 분석, 즉 데이터를 분해하고 분석하여 원하는 형태로 조립하고 다시 빼내는 프로그램

웹상에서 주어진 데이터를 내가 원하는 형태로 분해/분석/가공하여 서버에서 불러들이는 것

웹에서 떠다니는 데이터들은 리스트,딕셔너리 같은 자료구조와 달라 사용자 마음대로 만지기 쉽지 않다. 그렇기 때문에 이런 데이터들을 다루기 쉬운 형태로 바꿔주는 과정이 필요하다, 이 역할을 하는 함수나 프로그램을 Parser라고 하며, 이 과정을 Parsing이라고 한다.

<aside>
💡 Parser :Compiler나 Interpreter에서 원시 프로그램을 읽어 들여, 그 문장의 구조를 알아내는 Parsing을 행하여 주는 함수나 프로그램

</aside>

![992F5C475AE5C0572E.png](TIL%2022-03-%20561a0/992F5C475AE5C0572E.png)
