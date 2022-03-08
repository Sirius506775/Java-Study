package org.zerock.store.store;
/*
    로직 위주의 클래스
    데이터 불러오기를 위한 클래스
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoreLoader  {

    private  StoreDTO[] stores ; //음식점의 목록

    //음식점 목록을 주려고 하면 준비가 되어야 줄 수 있다. -> 생성자를 만든다
    public StoreLoader() throws FileNotFoundException { //생성자 생성
        // 객체를 만드는데에 file이 없을 수 없습니다!를 알려주는 throws

        //옛날 방식
          stores = new StoreDTO[5];
          File storeFile = new File("C:\\zzz\\store.txt");
          Scanner scanner = new Scanner(storeFile);


        for (int i = 0; i < stores.length; i++) {

            String line = scanner.nextLine();
            String[] arr = line.split(",");
            int sno = Integer.parseInt(arr[0]);
            String name = arr[1];
            double lat = Double.parseDouble(arr[2]);
            double lng = Double.parseDouble(arr[3]);

            StoreDTO storeDTO = new StoreDTO(sno,name,lat,lng);

            stores[i] = storeDTO;
        }//end for

//        stores[0] = new StoreDTO(1, "우레옥", 37.111, 127.111);
//        stores[1] = new StoreDTO(2, "AAA", 37.111, 127.111);
//        stores[2] = new StoreDTO(3, "BBB", 37.111, 127.111);
//        stores[3] = new StoreDTO(4, "CCC", 37.111, 127.111);
//        stores[4] = new StoreDTO(5, "DDD", 37.111, 127.111);
    }

        public StoreDTO[] getStores(){ //실행했을 때 파일 데이터를 읽어온다면 유지할 필요가 없다. 하지만 우리는 한 번만 로딩해서 쓰려고 합니다. 음식점의 목록을 유지해놔야합니다.

            return this.stores; //현재 인스턴스가 가지고 있는 배열들을 반환
        }

}
