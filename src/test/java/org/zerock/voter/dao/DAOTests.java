package org.zerock.voter.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.PortUnreachableException;

public class DAOTests {

    private VoterDAO dao;

    @BeforeEach
    public void ready(){
        dao = new VoterDAO();
    }
    @Test
    public void testGetOne(){

        Assertions.assertEquals(dao.getOne(1).getName(), "홍길동");
        Assertions.assertNull(dao.getOne(10)); //10을 넣었을 때 NULL이 있으면 통과

    }
}
