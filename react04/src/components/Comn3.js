export default function Comn3(){
    const dispatch = useDispatch();
    return <div><button onClick={e=>dispatch({type:'upup',su:10})}>클릭</button></div>
  }