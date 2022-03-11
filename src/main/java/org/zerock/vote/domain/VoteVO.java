package org.zerock.vote.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class VoteVO {
    private Integer voter;
    private Integer candidate;
}
