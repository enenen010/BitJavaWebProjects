/*
useEffect : 앞에 Did마운트 후행작업 처리할때 랜더링 되고 처리해야될 작업 처리가능
그래서 이런작업이 가능하게 하기 위해서 useEffect
*/
import React,{useState,useEffect} from "react";


//랜더링 후 이펙트
export default function Ex03() {
    const [msg,setMsg]=useState('hello');

    const onClick=(e)=>{
        setMsg('환영합니다:)');
    };

    useEffect(()=>{
        console.log('이펙트')
    });
    return(
        <div>
            <h1>{msg}</h1>
            <button onClick={onClick}>변경</button>
        </div>
    )
}

//did마운트, did업데이트
//useEffect 안에서 setMsg('')하면 바뀌고 랜더링, ...  무한루프(어느정도 버전상승때 막긴했어도 하지말자)

/*
const [msg,setMsg]=useState('hello');
    useEffect(()=>{
        console.log('이펙트')
    },[]);
    
    //1번째 콜백 
    //2번째 매개변수 배열: 종속성=빈배열:1번만 수행, [msg]:msg가 바뀌었을때만
*/




//안쪽에서 정의되는 비동기적인 처리는 안쪽에서 클리어해달라
function Timer() {
    const [count, setCount] = useState(0);
    const a = <><input></input></>;
    useEffect(() => { 
      let timer = setTimeout(() => {
      setCount((count) => count + 1);
    }, 1000);
  
    return () => clearTimeout(timer)//해달라
    }, []);
  
    return <h1>I've rendered {count} times!</h1>;
  }


  /*
  useRef: 
  
  엘리먼트에 ref로 id? 붙여놓으면 id.current로 잡을 수 있다.

  아이디, 클래스, 
  여기서는 그게 제한됨 못쓰니까 qureySelecter 등 못쓰니까 react에서
  그것을 해결한것이 useRef
  
  */