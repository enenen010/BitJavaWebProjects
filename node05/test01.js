function Cl(a,b){
    var aa1=1234;
    let aa2=2354;
    this.year=b;
  	this.th=this;
    this.func=function(){return this};
  	return this.year;
}

class Cl2{
    aa1=1234;
    aa2=2345;
    constructor(){
        this.aa1=5432;
    }
}

var mmm = new Cl(111,222);
var mmm2 = Cl;
var mmm3 = new Cl2();
console.log('mmm :'+mmm.aa1);
console.log('mmm3 :'+mmm3.aa1);
console.log(mmm2());