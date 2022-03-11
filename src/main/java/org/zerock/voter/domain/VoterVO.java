package org.zerock.voter.domain;
//읽기 전용
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class VoterVO {

    private Integer vno;
    private String name;


}
