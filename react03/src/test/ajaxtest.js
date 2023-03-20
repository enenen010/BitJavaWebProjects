import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'

export default function DeptList() {
  const [depts, setDepts]=useState([]);

  useEffect(()=>{
    const xhr=new XMLHttpRequest();
    xhr.onload=(e)=>{
      if(xhr.readyState===4 && xhr.status===200){
        const result=JSON.parse(xhr.response);
        setDepts(result);
      }else{
        console.log(xhr.status);
      }
    };
    xhr.open("get", "http://localhost:8080/api/");
    xhr.send();

    // promise
    const getList=new Promise((resolve, reject)=>{
      setTimeout(()=>{
        resolve("3초 뒤 호출됨");
      }, 3000);
    });
    getList.then((data)=>{
      console.log('step1');
      return data;
    })
    .then((e)=>{
      console.log('step2');
      console.log(e);
    }); //then으로 실행순서를 결정

    // fetch
    fetch("http://localhost:8080/api/")
     .then(ele=>(ele.json()))
     .then(ele=>setDepts(ele))
     .catch(e=>console.log(e));//가 나오는순간 return이 끊김 그래서 마지막에

     // axios
     axios.get('http://localhost:8080/api/') //사용이 간편 json을 알아서 해줌(위가 있는그대로의 String body를 받아왔다면 이건 옵션에의해 다 바꾼걸 매개변수로써 줌)
        .then(e=>setDepts(e.data))
     

  },[]);

  return (
    <>
      <div className="page-header">
        <h1>Dept List</h1>
      </div>
      {depts.map((ele)=>(
        <Link to={'./'+ele.deptno} key={ele.deptno}>
          <div className="panel panel-info">
            <div className="panel-heading">{ele.dname}</div>
            <div className="panel-body">{ele.loc}</div>
          </div>
        </Link>
      ))}

    </>
  )
}