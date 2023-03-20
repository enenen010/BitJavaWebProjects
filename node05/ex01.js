var na = 111;

var obj = {na};
console.log(obj.na);


const a1 = function(){ const a2=function(){console.log(this)}; a2(); };
a1();

const a2 = function(){ const a2=function(){console.log(this)}; a2(); };


Object.defineProperty(obj,'na',{
    get(val){return `${val}`}
});

var arr= [1,2,3,4,5];