import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

export default function DeptDetail() {
  const navigate=useNavigate();
  const [edit,setEdit]=useState(false);
  const [bean, setBean]=useState({});
  const {deptno} = useParams();
  const [dInput, setDinput]=useState({});

  const input1=e=>{
    setDinput({...dInput,dname:e.target.value});
  };
  const input2=e=>{
    setDinput({...dInput,loc:e.target.value});
  };
  const editForm=e=>{
    e.preventDefault();
    setEdit(true);
  };
  const sbt=e=>{
    e.preventDefault();
    const params={
      deptno: e.target.deptno.value,
      dname: e.target.dname.value,
      loc: e.target.loc.value
    };
    axios
    // .put('http://localhost:8080/api/'+deptno, {
    //   deptno: e.target.deptno.value,
    //   dname: e.target.dname.value,
    //   loc: e.target.loc.value
    // })
    ({method: 'put', url:"http://localhost:8080/api/"+deptno, data:params})
    .then(e=>navigate('/dept/'));
  };
  const delFrom=e=>{};
  const bck=(e)=>{
    if(edit)
      setEdit(!edit);
    else
    navigate(-1);
  };

  useEffect(()=>{
    axios.get('http://localhost:8080/api/'+deptno)
    .then(e=>{setBean(e.data); setDinput(e.data)});
  },[deptno]);

  return (
    <>
    <div className='page-header'>
      <h1>{deptno} {!edit?'Detail':'Update'} Page</h1>
    </div>
    <form onSubmit={sbt}>
            <div className='form-group'>
                {!edit?(bean.deptno
                ):(
                  <input className="form-control" name="deptno" value={deptno}/>
                )}
            </div>
            <div className='form-group'>
              {!edit?(bean.dname
                ):(
                  <input onChange={input1} className="form-control" name="dname" value={dInput.dname}/>
              )}
                
            </div>
            <div className='form-group'>
            {!edit?(bean.loc
                ):(
                  <input onChange={input2} className="form-control" name="loc" value={dInput.loc}/>
              )}
            </div>
            <div className='form-group'>
              {!edit?(
              <>
                <button onClick={editForm} className='btn btn-primary btn-block' type='button'>수정</button>
                <button onClick={delFrom} className='btn btn-danger btn-block' type='button'>삭제</button>
              </>
              ):(
              <button className='btn btn-primary btn-block' type='submit'>수정</button>
              )}
              <button className='btn btn-default btn-block' type='reset'>취소</button>
              <button className='btn btn-default btn-block' type='button' onClick={bck}>뒤로</button>
            </div>
      </form>
    </>
  )
}