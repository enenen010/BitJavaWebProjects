import React from 'react';
import { useState } from "react";

export default function Ex02(){
    const [title, setTitle]=useState("Default");

    const func01=(e)=>{
        e.preventDefault();
        setTitle(e.target.ename.value);
    };
    return(
        <>
        <form onSubmit={func01}>
            <h1>{title}</h1>
            <input name="ename"/>
            
            <button>전송</button>
        </form>
        <button onClick={()=>setTitle('제목있음')}>클릭</button>
        </>
    );
}

//value 값이 있으면..
function Ex02_value(){
    const [title, setTitle]=useState("Default");
    const [ipval, setIpval]=useState("")

    const func01=(e)=>{
        e.preventDefault();
        setTitle(e.target.ename.value);
    };

    const func02=(e)=>{
        setIpval(e.target.value);
    }

    return (
        <form onSubmit={func01}>
            <h1>{title}</h1>
            <input name="ename" onChange={func02} val={ipval}/>
            <button>전송</button>
        </form>
    );
}

//
function Ex02_val(){
    const [title, setTitle]=useState("Default");
    const [ipval, setIpval]=useState("")

    const func01=(e)=>{
        e.preventDefault();
        setTitle(e.target.ename.value);
    };

    const func02=(e)=>{
        if(e.target.name='ename')
            setIpval(e.target.value.ipval[1]);
        else if(e.target.name='ename2')
            // setIpval(e.target.value.ipval[0]);
            setIpval(ipval.map((ele,idx)=>idx==1?e.target.value:ele));
    }

    return (
        <form onSubmit={func01}>
            <h1>{title}</h1>
            <input name="ename" onChange={func02} val={ipval}/>
            <button>전송</button>
        </form>
    );
}

/*
useState를 통해 값을 변경하여 랜더링을 하려면


*/



//textaera
/*
<textarea>
  Content of the textarea.
</textarea>
return (
      <textarea value={textarea} onChange={handleChange} />
  )
*/


//select 이것만 알면 라디오버튼 등 셀렉트도 똫같겠네
/*
<select>
  <option value="Ford">Ford</option>
  <option value="Volvo" selected>Volvo</option>
  <option value="Fiat">Fiat</option>
</select>


<select value={myCar} onChange={handleChange}>
        <option value="Ford">Ford</option>
        <option value="Volvo">Volvo</option>
        <option value="Fiat">Fiat</option>
</select>
*/

