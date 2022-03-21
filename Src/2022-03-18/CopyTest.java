package org.zerock.ex1;

import java.io.*;

public class CopyTest {
    public static void main(String[] args) throws Exception { //예외 처리 생략

        InputStream inputStream = new FileInputStream("C:\\zzz\\So-yangRiver.jpg"); //file에 맞는 파이프를 꽂는다.

        System.out.println(inputStream);
        //FileOutputStream은 없으면 파일을 새로 만들고, 있으면 덮어 쓴다.
        OutputStream outputStream = new FileOutputStream("C:\\zzz\\copy.jpg"); //file에 맞는 output 파이프를 꽂는다.


        long start = System.currentTimeMillis(); //1970-01-01

        byte[] buffer = new byte[1024*8]; //100byte씩 읽어들이는 바가지!!->
        //1024 => 1kb , 1024*8 => 8kb : 실무에서는 이런식으로 읽어들입니다.
        //한꺼번에 담아갈 바가지 == buffer 메모리 상에서 잠깐 들고 있는 애들이 buffer라고 한다..!
        //반복문 바깥에 있는건 만들어 놓고 계속 써먹는다는 이야기입니다.

        while (true){ //
            //데이터는 바가지 몇 개나 새로운 데이터를 읽어왔는지 ... count
            int count = inputStream.read(buffer); //바가지에 한번에 데이터를 담아서 count에 보관
            //읽어낸 한 바이트의 데이터는 int값으로 나온다. -> int값 == 1byte에 쓰여 있는 값
            //1 byte씩 읽으면 내부적으로 255값을 더해서, 더한 상태로 나옵니다.

            //System.out.println(count); //System.out.println() 을 쓰면 성능이 저하되는 것이 사실입니다.

            if(count == -1){ //커서의 개념을 생각해보기 -> 1byte씩 끝까지 읽었는데 더이상 읽을 것이 없을 때 나오는 것은 -1이다. 때문에 여기서 break로 빠져나간다.
                break;
            }//end if

            outputStream.write(buffer,0, count); //인덱스 0부터 새로 읽은 숫자만큼만 써줘라.

        }// end while

        long end = System.currentTimeMillis();

        System.out.println("-------------------");
        System.out.println(end - start);
    }
}
