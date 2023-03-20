var mysql = require('mysql');
var conn = mysql.createConnection({
    host: "192.168.99.100",
    user: "scott",
    password: "tiger",
    port: 3306,
    database: 'lecture'
});
conn.connect(function(err){
    if(err) throw err;
    console.log('connect!!');
});
module.exports=conn;