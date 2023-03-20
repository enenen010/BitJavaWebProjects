import axios from 'axios';
import React from 'react'
import { useNavigate} from 'react-router-dom';

export default function DeptAdd() {
    const navigate=useNavigate();
    const bck=()=>navigate(-1);
    const sbt=(e)=>{
        e.preventDefault();
        //@RequestBody 일 경우
        // let params={
        //     deptno:Number(e.target.deptno.value)
        //     ,dname:e.target.dname.value
        //     ,loc:e.target.loc.value
        // };

        //@ModelAttribute("bean")일 경우
        let params='deptno='+Number(e.target.deptno.value)+'dname='+e.target.dname.value+'loc='+e.target.loc.value;

        axios
        // .post("http://localhost:8080/api/",params)
        ({method:'post', url:'http://localhost:8080/api/',data:params })
        .finally(function(){
                 //항상 실행하는 영역
                 navigate('/dept');
        });
    };

  return (
    <>
        <div className="page-header">
            <h1>Dept Insert</h1>
        </div>
        <form onSubmit={sbt}>
            <div className='form-group'>
                <input className="form-control" name="deptno" placeholder='deptno'/>
            </div>
            <div className='form-group'>
                <input className="form-control" name="dname" placeholder='dname'/>
            </div>
            <div className='form-group'>
                <input className="form-control" name="loc" placeholder='loc'/>
            </div>
            <div>
                <button className='btn btn-primary btn-block' type='submit'>입력</button>
                <button className='btn btn-default btn-block' type='reset'>취소</button>
                <button className='btn btn-default btn-block' type='button' onClick={bck}>뒤로</button>
            </div>
        </form>
    </>
  )
}