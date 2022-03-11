package org.zerock.vote.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.vote.domain.VoteVO;

public class DAOTests {

    private VoteDAO voteDAO;

    @BeforeEach
    public void ready(){
        voteDAO = new VoteDAO();

        for (int i = 0; i < 5; i++) {
            voteDAO.add(new VoteVO(i,2));
        }
        for (int i = 6; i < 9; i++) {
            voteDAO.add(new VoteVO(i,1));
        }
    }

    @Test
    public void testGetResult(){

        for (VoteVO voteVO:voteDAO.getResult()) {
            System.out.println(voteVO);
        }

    }

}
