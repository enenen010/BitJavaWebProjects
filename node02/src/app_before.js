var express = require('express');
var ejs = require('ejs');
var path = require('path');
var mysql = require('mysql');
var bodyParser=require('body-parser');

var PORT = 3000;
var app = express();
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }));
// parse application/json
app.use(bodyParser.json());

console.log(__dirname);
app.use(express.static(path.join(__dirname, './../public')));
app.set('views', path.join(__dirname, './../views'));
app.set('view engine', 'ejs');

app.get('/intro', function (req, res) {
    res.render('intro');
});


var conn = mysql.createConnection({
    host: "192.168.99.100",
    user: "scott",
    password: "tiger",
    port: 3306,
    database: 'lecture'
});

// update 구문
// var sql='insert into dept values(333,'회계팀','창원')';
// conn.connect(function(err) {
//     if (err) throw err;
//     console.log("Connected!");
//     conn.query(sql, function (err, result) {
//       if (err) throw err;
//       console.log("Result: " + result);
//     });
//   });


// select 구문
// var sql = 'select * from dept';
// conn.connect(function (err) {
//     if (err) throw err;
//     console.log("Connected!");
//     conn.query(sql, function (err, result, fields) {
//         if (err) throw err;
//         console.log("Result: " + result, "fields: " + fields);
//         result.forEach((element, idx) => {
//             console.log(element.DEPTNO, idx);
//         });
//     });
// });

// 리스트 페이지 .ejs
// app.get('/dept/',function(req,res){
//     res.render('dept/list');
// });

//리스트 페이지 select .ejs 조합
app.get('/dept/', function (req, res) {
    var sql = 'select * from dept';
    conn.connect(function (err) {
        if (err) throw err;
        console.log("Connected!");
        conn.query(sql, function (err, result, fields) {
            res.render('dept/list',{result});
        });
    });
});

app.post('/dept/', function(req,res){
    console.log(req.body);
    let sql="insert into dept values (?,?,?)";
    conn.query(sql, [req.body.deptno, req.body.dname, req.body.loc], function(err,result){
        res.redirect('./');
    });
});
app.get('/dept/add', function(req,res){
    res.render('dept/add');
});
app.get('/dept/:deptno', function(req,res){
    console.log(req.params.deptno);
    let sql="select * from dept where deptno=?";
    conn.query(sql, [req.params.deptno], function(err, result, fields){
        if(err) return res.render('dept/detail');
        console.log(result);
        res.render('dept/detail',{dept:result[0]});
    });
});
app.post('/dept/:deptno', function(req,res){
    let arr=[req.body.dname, req.body.loc, req.params.deptno];
    let sql="update dept set dname=?, loc=? where deptno=?";
    conn.query(sql, arr, function(err, result){
        if(err) 
            return res.render('dept/detail', {dept:{deptno:req.body.deptno, dname:req.body.dname, loc:req.body.loc}});
        if(result.changeRows)
            res.redirect('./');
        else    
            res.render('dept/detail',  {dept:{deptno:req.body.deptno, dname:req.body.dname, loc:req.body.loc}});
    });
});
app.delete(`/dept/:deptno`,function(req,res){
    let deptno=req.params.deptno;
    let sql=`delete from dept where deptno=${deptno}`;
    conn.query(sql,function(err,result){
        res.status(200).send();
    });
})
app.listen(PORT);