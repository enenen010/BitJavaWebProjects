import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Menu from './test/Nav'
import DeptList from './testPages/DeptList';
import DeptAdd from './testPages/DeptAdd'; 
import DeptDetail from './testPages/DeptDetail';
// import Menu from './test/Nav'
// import Ex01 from './test/memo01';
// import Ex02 from './test/memo02';
// import Ex03 from './test/memo03';
import reportWebVitals from './reportWebVitals';
import { Route, Routes, BrowserRouter} from 'react-router-dom';

// class My01 extends React.Component{
//   render(){
//     return <h1>환영합니다.</h1>
//   }
// }

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );
// root.render(
//   <BrowserRouter>
//     <Routes>
//       <Route path="/" element={<Menu />}>
//         <Route index element={<App/>}/>
//         <Route path='/p1' element={<Ex01/>}/>
//         <Route path='/p2' element={<Ex02/>}/>
//         <Route path='/p3' element={<Ex03/>}/>
//       </Route>
//     </Routes>
//   </BrowserRouter>
// );
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Menu />}>
          <Route index element={<App/>}/> 
          <Route path="list" element={<DeptList/>}/> 
          <Route path="add" element={<DeptAdd/>}/> 
          <Route path="detail" element={<DeptDetail/>}/> 
      </Route>
    </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();