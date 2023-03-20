import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

export default function DeptList() {
  const [depts, setDepts]=useState([]);

  useEffect(()=>{
    // const xhr=new XMLHttpRequest();
    // xhr.onload=(e)=>{
    //   if(xhr.readyState===4 && xhr.status===200){
    //     const result=JSON.parse(xhr.response);
    //     setDepts(result);
    //   }else{
    //     console.log(xhr.status);
    //   }
    // };
    // xhr.open("get", "http://localhost:8080/api/");
    // xhr.send();

    // // promise
    // const getList=new Promise((resolve, reject)=>{
    //   setTimeout(()=>{
    //     resolve("3초 뒤 호출됨");
    //   }, 3000);
    // });
    // getList.then((data)=>{
    //   console.log('step1');
    //   return data;
    // })
    // .then((e)=>{
    //   console.log('step2');
    //   console.log(e);
    // });

    ///////////////////
    // fetch
    // fetch("http://localhost:8080/api/")
    //  .then(ele=>(ele.json()))
    //  .then(ele=>setDepts(ele))
    //  .catch(e=>console.log(e));

    ///////////////////
    //axios
    axios.get("http://localhost:8080/api/")
    .then(e=>setDepts(e.data));
  },[]);

  return (
    <>
      <div className="page-header">
        <h1>Dept List</h1>
      </div>
      <Link to='add' className='btn btn-block btn-primary' role="button">add</Link>
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