package org.zerock.store.store;
//데이터 클래스 먼저 만들어줍니다.

// 다른 객체들에게 주고받을 때 DTO(Data Transfer Object)
// ui상에서 만들어진 데이터를 서비스에게 전달하거나 가져오는 역할을 하는 장바구니랑 같음
// 거기에 내용이 다 다르니까 클래스를 만들어주는 거에요.

// 데이터를 담아서 한꺼번에 전달하거나 전달받을 때 사용

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor //컴파일 하는 시점에 자동으로 생성! 코드의 양을 줄여줍니다.
@ToString
@Getter
public class
StoreDTO {
//private이나 public이 없으면 같은 패키지 안에서만 사용
    int sno;
    String name;
    double lat;
    double lng;



}
