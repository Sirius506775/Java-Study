package org.zerock.candidate.dao;

import org.zerock.candidate.domain.CandidateVO;

public class CandidateDAO {

    private CandidateVO[] arr;
    public CandidateDAO(){

        arr = new CandidateVO[3];
        arr[0] = new CandidateVO(1, "이재명");
        arr[1] = new CandidateVO(2, "윤석열");
        arr[2] = new CandidateVO(3, "심상정");
    }

    public CandidateVO[] getAll(){
        return arr.clone(); //복사본 사용
    }

    public void check(Integer candidate)throws Exception {


    }
}
