var express = require('express')
var app = express()
var f=express.static('js02');

// app.get('/', function (req, res) {
//   res.send('Hello World')
// });
app.use(f);

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


// 상위 패턴(/)이 하위 패턴(/dept)보다 코드상 아래에 위치
app.use('/', function(req,res,next){
    // console.log('이벤트 호출.../');
    // res.setHeader('Content-Type','text/html; charset=utf-8');
    // res.write('<h1>출력...</h1>');
    // res.end();

    res.status(404);
    res.send('<h1>ok page</h1>');
});

app.listen(3000);