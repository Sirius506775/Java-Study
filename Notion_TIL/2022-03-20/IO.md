# JAVA IO

엔터프라이즈 프로그램에서

### In - Read

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d690611f-1dfc-4ce6-976c-8931a9a27743/Untitled.png)

### Out-Write

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e2986d61-3032-422f-b8c1-840d08473089/Untitled.png)

이미지 파일의 복사본을 만드는 작업을 해봅시다.

C드라이브 안에 zzz폴더 안에 SoyangRiver.jpg  파일을 하나 넣어놓았습니다. 

파일의 크기를 살펴봅시다. 

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7e397824-25a3-45fa-92e5-0bb4c253dc75/Untitled.png)

속성에서 조회해보니 해당 jpg 파일의 데이터 크기는 742,014 byte입니다.

그럼 이제 이 파일을 읽어와야하니 InputStream이라는 파이프를 사용해봅시다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/29fe4776-fe15-4a65-b7ca-d88ce56d75ca/Untitled.png)

InputStream을 사용하면서 파이프는 클래스로 제공되거나, 메소드의 리턴 타입으로 제공되는 파이프 2가지가 있는데 File은 Class로 존재하기 때문에 여기서는

FileInputStream()을 이용하여 파일을 읽어오도록한다.

하지만 여기서 에러가 뜬다

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/86d20cbf-132c-41b2-95c6-f5d4947da65e/Untitled.png)

외부 리소스랑 만약 파일이 없으면 외부 리소스랑 통신하는 것이니까 Try-catch로 잡으라고 뜨는 에러이다. 예외처리를 진행한다. 

<aside>
💡 원래는 try-catch로 작업해서 finally까지 close 하는 것이 바람직하다. 하지만 I/O의 작동원리를 알기 위해 테스트하는 예제코드이니 이번에는 예외 처리를 던지도록 설계한다.

</aside>

### InputStream()의 가장 핵심 기능은 read()

추상클래스로 설계되어 있다.

한 byte의 내용을 int타입으로 읽어낸다. (커서가 이동한다.)

- 이때 int 값이 -1인 경우는 더 이상 읽어낼 데이터가 없는 경우이다.

 read(byte[]) : 

읽어낸 데이터가 byte[] 안으로 들어가고, int는 몇 개의 새로운 데이터를 읽어냈는지 말한다.

### OutputStream()의 가장 핵심 기능은 write()

연결된 파이프를 통해 write(int) 해주면 대상으로 데이터를 전송

<aside>
💡 byte을 하나씩 따서 이동하는 건 너무 오래 걸리면 비효율적..!!

</aside>
