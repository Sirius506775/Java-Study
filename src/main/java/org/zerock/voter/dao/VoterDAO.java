package org.zerock.voter.dao;

import org.zerock.voter.domain.VoterVO;

public class VoterDAO {
    
        private VoterVO[] arr;
        
        public VoterDAO(){
                arr = new VoterVO[3];
                arr[0] = new VoterVO(1,"홍길동");
                arr[1] = new VoterVO(2,"김길동");
                arr[2] = new VoterVO(3,"이길동");
        }

        //식별 번호를 가지고 voterVO를 찾아주는 기능

        public VoterVO getOne(Integer vno){ //서비스랑만 통신하니까 꼭 퍼블릭일 필요는 없음
                VoterVO result = null;

                for (VoterVO vo:arr) {
                        if (vo.getVno() == vno){
                                result = vo;
                                break;
                        }

                }

                return result;
        }


        public void check(Integer voter) {
        }
}

/*


Q. 이렇게 패키지 하나하나 복잡하게 만들어야하나요?
 */
// 시간이 지나도 이 코드를 재사용할 수 있게끔 하기 위해 이렇게 클래시
