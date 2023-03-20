var express = require('express')
var app = express()
var f=express.static('js02');
var ejs=require('ejs');

// app.get('/', function (req, res) {
//   res.send('Hello World')
// });

//특정 요청(url 패턴)으로 들어왔을때 이벤트 호출
// 예시: /dept 아래에서만 이벤트 호출
// app.use('/dept', function(){
//     console.log('이벤트 호출.../dept');
// });

// /dept, / 동시에 
// app.use('/dept', function(req,res, next){
//     console.log('이벤트 호출... /dept');
//     next();
// });

// app.use('/dept', function(req,res, next){
//     console.log(req,res,next);
// });

//static
app.use(f);

// body-parser 
app.use(express.json());
app.use(express.urlencoded({extended:false}));

//template
//ejs
app.set('views', __dirname+'/views');
app.set('view engine', 'ejs');

app.get('/intro',function(req,res){
    var arr1=['item1','item2','item3','item4'];
    var obj1={key1:'val1', key2:'val2'};
    res.render('intro', {msg:'hello', arr:arr1, obj:obj1, nalja:new Date()});
});

//params
// app.post('/dept/:deptno', function(req,res){
//     console.log(req.method, req.params.deptno);
//     res.send('<h1>dept page(post)</h1>');
// });

//query
// app.post('/dept', function(req,res){
//     console.log(req.method, req.body.deptno);
//     res.send('<h1>dept page(post)</h1>');
// });

//params
// app.get('/dept/:deptno', function(req,res){
//     console.log(req.method, req.params.deptno);
//     res.send('<h1>dept page(get)</h1>');
// });

//query
// app.get('/dept', function(req,res){
//     console.log(req.method, req.query.deptno);
//     res.send('<h1>dept page(get)</h1>');
// });

// app.put('/dept', function(req,res,next){
//     console.log(req.method);
//     res.send('<h1>dept page(put)</h1>');
// });

// app.delete('/dept', function(req,res,next){
//     console.log(req.method);
//     res.send('<h1>dept page(delete)</h1>');
// });

// 상위 패턴(/)이 하위 패턴(/dept)보다 코드상 아래에 위치
// app.use('/', function(req,res,next){
//     // console.log('이벤트 호출.../');
//     // res.setHeader('Content-Type','text/html; charset=utf-8');
//     // res.write('<h1>출력...</h1>');
//     // res.end();

//     // res.status(404);
//     res.send('<h1>ok page</h1>');
// });

app.listen(3000);