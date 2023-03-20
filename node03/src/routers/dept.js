const express=require('express');
const router=express.Router();
const MongoClient=require("../modules/mongodb").MongoClient;
const url=require("../modules/mongodb").url;

router.get('/', (req,res)=>{
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("lecture");
        coll=dbo.collection("dept");
        //find
        var result=coll.find({});
        result.toArray(function(err, result) {
            if (err) throw err;
            // console.log(result);
            db.close();
            res.render('dept/list', {result});
        });
    });
});
router.post('/',(req,res)=>{
    var myobj = {
        deptno:Number(req.body.deptno),
        dname: req.body.dname,
        loc: req.body.loc
    };
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("lecture");
        coll=dbo.collection("dept");
        coll.insertOne(myobj, function(err, result) {
            if (err) throw err;
            db.close();
            res.redirect('./');
        });
    });
})
router.get('/add', (req,res)=>res.render('dept/add'));
router.get('/:id', (req,res)=>{
    let param=req.params.id;
    MongoClient.connect(url, function(err, db){
        if(err) throw err;
        var dbo=db.db("lecture");
        coll=dbo.collection("dept");
        coll.find({deptno:Number(param)}).toArray((err,result)=>{
            if(err) throw err;
            res.render('dept/detail', {dept:result[0]});
        });
    })
})

module.exports=router;