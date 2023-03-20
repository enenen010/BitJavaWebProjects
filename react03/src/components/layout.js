import React from 'react'
import { Link, NavLink, Outlet } from 'react-router-dom'

export default function Layout() {


  return (
    <>
        <nav className="navbar navbar-default">
            <div className="container-fluid">
                <div className="navbar-header">
                <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span className="sr-only">Toggle navigation</span>
                    <span className="icon-bar"></span>
                    <span className="icon-bar"></span>
                    <span className="icon-bar"></span>
                </button>
                <Link className="navbar-brand" to="/">비트교육센터</Link>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                        <li><NavLink to="/" end>Home</NavLink></li>
                        <li><NavLink to="/intro" end>Intro</NavLink></li>
                        <li><NavLink to="/dept" end>Dept</NavLink></li>
                </ul>
                </div>
            </div>
        </nav>
        <div className='container'>
            <Outlet />
        </div>
    </>
  )
}