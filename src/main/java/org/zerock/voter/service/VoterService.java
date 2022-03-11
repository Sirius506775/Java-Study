package org.zerock.voter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.zerock.voter.dao.VoterDAO;
import org.zerock.voter.domain.VoterVO;

@RequiredArgsConstructor
public class VoterService {

    @NonNull
    private VoterDAO voterDAO;

    public VoterVO readOne(Integer vno)throws Exception{
        VoterVO voter = voterDAO.getOne(vno);
        //null일 경우 UI에서 반드시 알아야합니다.
        //호출한 쪽에게 찾는게 없다고 반드시 알려주기 위해 예외를 던진다. UI가 처리하게끔

        if (voter == null){
            throw new Exception("Voter is null");
        }

        return voter;
    }




}
