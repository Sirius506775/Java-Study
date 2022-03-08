package org.zerock.store.store;

import java.io.FileNotFoundException;

public class StoreTest {
    public static void main(String[] args) throws FileNotFoundException {

        // 없으면 내가 책임지겟다 try/catch = 내가 알아서 책임질게
        // 하고 싶으면 하고 나도 모르겟다~ 무책임하게 던지는게 throws
        // UI 에서는 잡는게 맞고, 대부분은 사용자에게 예외를 던지는게 맞다.
        StoreLoader loader = new StoreLoader();

        StoreDTO[] dtos = loader.getStores();

        for (StoreDTO dto:dtos) {
            System.out.println(dto);
        }//end for
    }
}
