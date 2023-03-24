import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import { Provider, useDispatch, useSelector, useStore } from 'react-redux';
import store from "./components/store";
import Comn1 from "./components/Comn1";
import Comn2 from "./components/Comn1";
import Comn3 from "./components/Comn1";
import Comn4 from "./components/Comn4";


//불러온다 select
//값바꾼다 dispatch

export default function App2() {

  return(
    <Provider store={store}>
        <Comn3 />
        <Comn4 />
        <Comn2 />
    </Provider>
  )
}



