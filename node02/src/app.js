var express = require('express');
var ejs = require('ejs');
var path = require('path');
//var mysql = require('mysql');
var bodyParser=require('body-parser');

var PORT = 3050;
var app = express();
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }));
// parse application/json
app.use(bodyParser.json());

console.log(__dirname);
app.use(express.static(path.join(__dirname, './../public')));
app.set('views', path.join(__dirname, './../views'));
app.set('view engine', 'ejs');

//라우터 객체로 use
app.use(require('/','./routes/index.js'));
app.use(require('dept','./routes/dept.js'));// /dept 경로 다뺄 수있다 -> 라우터



app.listen(PORT);