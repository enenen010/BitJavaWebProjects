var http=require('http');
var url=require('url');
var fs=require('fs');

var serv=http.createServer(function(req,res){
    // res.write('abcd...');
    // console.log(url.parse(req.url).path);
    // console.log(url.parse(req.url, true).query.id);
    // res.setHeader('200', {'Content-Type': 'text/html'});
    res.writeHead(200, {'Content-Type': 'text/html'});
    // res.write('<h1>abcd</h1>');
    
    //동기적
    // var msg=fs.readFileSync('ex22.html');
    // res.write(msg);

    //비동기적 -> callback이기 때문에 end를 안에 넣어줌.
    fs.readFile('ex22.html', function(err, data){
        res.write(data);
        res.end();
    });
    // res.end();
});

// serv.listen(3000);
serv.listen(3000, function(){
    console.log('server start...');
})