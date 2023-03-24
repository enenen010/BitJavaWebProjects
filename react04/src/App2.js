import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import {createStore} from "redux";
import { Provider, useDispatch, useSelector, useStore } from 'react-redux';

//전역상태 관리를 위한 상태관리도구(redux, context)

//전역상태 저장소(store)
//저장소에 접근을위한 리듀서(reducer)
//리듀서에 행동을 지시하는 액션(action)
//저장소에서 상태를 가져오는 서브스크립션(subscription)

/*
redux vs context
*/

function reducer(prev={val:1},action){
  if(action.type=='up') return {...prev,val:prev.val+1};
  if(action.type=='upup') return {...prev,val:prev.val+action.su};
  return {...prev};
}


const store = createStore(reducer);

export default function App2() {
  const [su,setSu] = useState(0);



  // <Comn1 su={su} setSu={setSu}/>
  // <Comn2 su={su} />

  return(
    <Provider store={store}>
        <Comn3 />
        <Comn1 />
        <Comn2 />
    </Provider>
  )
}
function Comn3(){
  const dispatch = useDispatch();//값을 
  return <div><button onClick={e=>dispatch({type:'upup',su:10})}>클릭</button></div>
}

//커맨드로 길다긴 메서드를 축약 -> 실행을 커맨드를 받은 리듀서에서, 리듀서!
function Comn1(){
  const dispatch = useDispatch();//값을 
  //<div><button onClick={e=>setSu(su+1)}>클릭</button></div>
  return <div><button onClick={e=>dispatch({type:'up'})}>클릭</button></div>
}

function Comn2(){
  const su = useSelector(state=>state.val);
  return <div><h1>{su}</h1></div>
}

