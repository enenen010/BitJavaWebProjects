
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://127.0.0.1:27017/";

// MongoClient.connect(url, function (err, db) {
//     if (err) throw err;
//     var dbo = db.db("lecture");
//     var coll = dbo.collection("dept");

//     //insertOne
//     // var myobj = { deptno: 3111, dname: "전산팀", loc: "부산" };
//     // coll.insertOne(myobj, function (err, res) {
//     //     if (err) throw err;
//     //     console.log("1 document inserted");
//     //     db.close();
//     // });

//     // //insertMany
//     // var myobj = [
//     //     { deptno: 2222, dname: "전산팀", loc: "부산" },
//     //     { deptno: 3333, dname: "바람팀", loc: "양산" },
//     //     { deptno: 4444, dname: "산국팀", loc: "울산" },
//     //     { deptno: 5555, dname: "비리팀", loc: "배산" },
//     //     { deptno: 6666, dname: "네오팀", loc: "양산" },
//     //     { deptno: 7777, dname: "티아팀", loc: "울산" },
//     //     { deptno: 8888, dname: "라아팀", loc: "부산" },
//     //     { deptno: 9999, dname: "이티팀", loc: "부산" }
//     // ];
//     // coll.insertMany(myobj, function(err, res) {
//     //     if (err) throw err;
//     //     console.log("Number of documents inserted: " + res.insertedCount);
//     //     db.close();
//     // });

//     // find
//     //   var result=coll.find({});
//     //   result.toArray(function(err, result) {
//     //     if (err) throw err;
//     //     console.log(result);
//     //     db.close();
//     //   });
// });

module.exports={MongoClient, url};