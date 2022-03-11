package org.zerock.voter.dao.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.voter.dao.VoterDAO;
import org.zerock.voter.domain.VoterVO;
import org.zerock.voter.service.VoterService;

public class ServiceTests {

    private VoterService voterService;

    @BeforeEach
    public void ready(){
        voterService = new VoterService(new VoterDAO());
    }
    @Test
    public void testReadOne() {

        VoterVO vo = null; //그냥 가져오는 것만으로는 안된다. 예외
        try {
            vo = voterService.readOne(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertNull(vo);
    }
}
