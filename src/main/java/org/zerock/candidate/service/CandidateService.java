package org.zerock.candidate.service;
//DTO 는 읽기쓰기가 가능한 애들
//VO는 읽기만 가능한 애들
//안전하게 코드를 짜려면 읽기전용으로 하는게 가장 좋아요.
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.zerock.candidate.dao.CandidateDAO;
import org.zerock.candidate.domain.CandidateVO;

@RequiredArgsConstructor
public class CandidateService {

    @NonNull
    private CandidateDAO candidateDAO;

    public CandidateVO[] readAll(){

        return candidateDAO.getAll();


    }

}
