/*
 초창기의 리액트 류 프로그램은 싱글페이지 목적이 아니라서 라우터는 외부의 라이브러리를 추가한 형태
 때문에 깔아야함
 최신버전쓸건데 제한: 무조건 버전 맞는 문서대로 

 리액트로 DOM조작 하는 거 보니까 이동 안하는데 진짜 이동하는 것 같다. component를 바꿔끼우는것 만으로
 히스토리만 남길 수 있으면 진짜 싱글페이지
 npm i -D react-router-dom

 => 라우터!!


 1. index.js 확인하면 브라우저라우터>라우터즈>상위라우터>라우터 이래되있다
 2. 상위 Dept의 jsx보면 <outlet />을 통해 하위 라우터 원하는 위치에 불러옴(Nav.js)
   = 경로가 레이아웃이 된다(현재버전에서는?! 껄껄 망할)
*/



//뒤로가기 useNavigate() 활용
import { useNavigate } from "react-router-dom";
function Ex03() {
    var nav = useNavigate();
    nav(-1);
}



//메모 :
/*
부모 컴포넌트가 갱신되면 자식도 전부 갱신(랜더링)된다
안바뀌면 그대로


우리입장에서는 차이없다 왠만큼 복잡하지 않으면 티도 안난다
그러나 확실히 메모리 성능차이가 있다.


콜백
콜백도 JS입장에서는 객체 부모자식 랜더링 대상
메모의 콜백함수 버전 함수 안바뀌면 그대로 쓴다.

*/ 

//리듀서
/*
리액트의 기본원칙:
컨텍스트와 맞물림, 직접값을 제어하지 않음 -> 콜백 
내가 만들어내는
디스패지를 통해 수행 타입을 정의해 타입마다 다른 동작을
특정 id에 수행한다. 

객체에 정의된 값을 
이게 컨텍스트로 이어짐

컨텍스트
페이지에 값이 항상 가지고있어야 할 값 리듀스 활용
 
*/


//사용자 지정 훅
//use계열 내가 만들어서 재사용 가능



//public>index.html 파일 가상DOM에서 변경 사항을 반영할 실제 DOM    
//index.html 안쪽에서 제이쿼리, 부트스트랩등 붙여놓으면 전체적용
//부트스트랩 = container클래스 아래적용 -> 상위컨테이너에 <div class='container'>로 <Outlet />싸면 전부적용



