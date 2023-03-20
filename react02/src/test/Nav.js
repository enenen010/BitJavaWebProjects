import React from "react";
import { Link, Outlet } from "react-router-dom";

/*
    [새 컨테이너  <Outlet />에 끼워넣기]
    a: 페이지 이동, 히스토리
    Link: 페이지 이동X, 히스토리 

    내부적으로 history.pushState() 사용
    => 빌드한거 보면 그냥 a임  jsx를 빌드했다는 증거
    #유의 : 그래서 CSS,제이쿼리 등으로 잡을때 a로 잡아야 된다(빌드된게 뭔지 확인) 
*/
const Nav=()=>{
    return (
    <>
        <nav>
            <Link to="/">HOME</Link >
            <Link  to="/p1">Ex01</Link >
            <Link  to="/p2">Ex02</Link >
            <Link  to="/p3">Ex03</Link >
        </nav>
        <Outlet />
    </>
    )
}

export default Nav;