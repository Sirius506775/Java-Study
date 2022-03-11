package org.zerock.vote.dao;

import org.zerock.vote.domain.VoteVO;

import java.util.ArrayList;

public class VoteDAO {

    private ArrayList<VoteVO> voteArrayList;

    public VoteDAO(){
        voteArrayList = new ArrayList<>();
    }

    public void add(VoteVO voteVO){
        voteArrayList.add(voteVO);
    }

    public ArrayList<VoteVO> getResult(){

        return (ArrayList<VoteVO>) voteArrayList.clone();
    }

    public void check(Integer voter) throws Exception{
    }

    public void checkVoter(Integer voter) throws Exception{
    }
}
