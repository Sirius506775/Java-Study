package org.zerock.vote.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.zerock.candidate.dao.CandidateDAO;
import org.zerock.vote.dao.VoteDAO;
import org.zerock.vote.domain.VoteVO;
import org.zerock.voter.dao.VoterDAO;

@RequiredArgsConstructor
public class VoteService {

    @NonNull
    private VoterDAO voterDAO;
    @NonNull
    private CandidateDAO candidateDAO;
    @NonNull
    private VoteDAO voteDAO;

    public void vote(VoteVO voteVO) throws Exception {

        Integer candidate = voteVO.getCandidate();

        candidateDAO.check(candidate);

        Integer voter = voteVO.getVoter();

        voterDAO.check(voter);

        voteDAO.checkVoter(voter);

        voteDAO.add(voteVO);

    }

}
