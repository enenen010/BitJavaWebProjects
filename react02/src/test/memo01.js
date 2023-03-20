import React from "react";
/*
1.function class 비교
시작은 class로 했으나 이제 function 더 많다
*/
class H2 extends React.Component{
    constructor(props){
        super();
        this.msg=props.msg2;
    }
    render(){
        return <h2>Hi, {this.msg}!</h2>
    }
}

function Ex02(props){
    return(
        <>
            <h1 className="cl01">제목</h1>
            <p>{props.msg}</p>
        </>
    )
}

/*
2.리턴방식
로
*/
function Ex01(){
    // let msg='Ex01 page';
    // const redColor="red";
    // return React.createElement('h1',{},'I do not use JSX!');

    return (
        <>
        <Ex02 msg="환영합니다"/>
        <Ex02 msg="Welcome"/>
        <H2 msg2="클래스 방식"/>
        </>
        )
}

//컴포넌트 단위로 랜더링 : 전부가 아니라
/*
언제? state가 바뀔때!
가상 DOM을 갱신하면 실제 DOM을 갱신한다 -> state를 갱신한다

아무렇게나 접근하면 안됨: set을 통해서만
*/

//앞서할때 특정 object의 특정값을 바꿧을때만 바뀜(가상 Dom을)
var vmDOM;
Object.defineProperty(vmDOM,'state',{set:()=>console.log('state 바꿀때만 나올래')})

class H3 extends React.Component{
    constructor(props){
        super();
    }
    render(){
        return (
        <>
            <h2>{this.state.brand}, {this.msg}!</h2>
            <button onClick={()=>{
                var obj = this.state;
                this.setState({...obj,brand:"Ford"})
            }}>변경 클릭</button>
        </>
        );
    }
}


/*마운팅(수명주기1):로딩
constructor() :컴포넌트 생성때
getDerivedStateFromProps()
render()  필수
componentDidMount()
*/
class Header1 extends React.Component {
    constructor(props) {
      super(props);
      this.state = {favoritecolor: "red"};
    }
    render() {
      return (
        <h1>My Favorite Color is {this.state.favoritecolor}</h1>
      );
    }
  }

/*수명주기2:업데이트
getDerivedStateFromProps()
shouldComponentUpdate()
render()   필수(항상호출)
getSnapshotBeforeUpdate()
componentDidUpdate() :컴포넌트 수정 시

그냥 컴포넌트 단순화는 함수형어도 했음 함수형에선 위같은 제어가 불가능
-> 이를 통하여 훅이 등장하게 되었다
*/






//prop ?를 이용한 props.변수 축약
function Ex00({sub,msg},msg2){
    return(
        <>
            <h1>{sub}</h1>
            <p>{msg}</p>
            <p>props.msg2</p>
        </>
    );
}
function Ex04(){
    return (
        <>
        <Ex00 msg="환영합니다"/>
        <Ex00 msg="Welcome"/>
        <Ex00 msg2="Welcome"/>
        </>
        )
}


/*
이벤트
HTML 이벤트와 유사

-바뀐거-
on.. -> on대문자... 
change  = input 엔터 -> 타이핑 모든 순간 

*/
function Football() {
    const shoot = (a, event) => {
      console.log(event.type);
      alert(event.target);
    }
  
    return (
      <button onClick={(event) => shoot("Goal!", event)}>Take the shot!</button>
    );
  }



//
  function Garage(props) {
    const cars = props.cars;
    return (
      <>
        <h1>Garage</h1>
        {cars.length > 0 && //false면 뒤에 안봄 = if코드 줄이기
          <h2>
            You have {cars.length} cars in your garage.
          </h2>
        }
      </>
    );
  }
  
  const cars = ['Ford', 'BMW', 'Audi'];


//Lists
  function Car(props) {
    return <li>I am a { props.brand }</li>;
  }
  
  function Garage2() {
    const cars = [
      {id: 1, brand: 'Ford'},
      {id: 2, brand: 'BMW'},
      {id: 3, brand: 'Audi'}
    ];
    return (
      <>
        <h1>Who lives in my garage?</h1>
        <ul>
          {cars.map((car) => <Car key={car.id} brand={car.brand} />)}
        </ul>
      </>
    );
  }



  

export default Ex01;