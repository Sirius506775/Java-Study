package org.zerock.candidate.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DAOTests {

    private CandidateDAO dao;

    @BeforeEach
    public void ready(){

        System.out.println("ready......");
        dao = new CandidateDAO();

    }

    @Test

    public void test1(){

       Assertions.assertEquals(dao.getAll()[1].getName(),"윤석열");
       //입력한 데이터와 배열 안에 있는 데이터가 일치하는지 확인
        System.out.println(Arrays.toString(dao.getAll()));

    }
}
