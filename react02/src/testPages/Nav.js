import React from "react";
import { Link, Outlet } from "react-router-dom";

const Nav=()=>{
    return (
    <>
        <nav className="navbar navbar-default">
            <div className="container-fluid">
                <div className="navbar-header">
                    <Link className="navbar-brand" to="/">
                        <div>비트교육센터</div>
                    </Link>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><Link to="/">HOME</Link ></li>
                        <li><Link  to="/add">Intro</Link ></li>
                        <li><Link  to="/list">Dept</Link ></li>
                        <li><Link  to="/detail">Login</Link ></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div className="container">
            <Outlet />
        </div>
    </>
    )
}

export default Nav;