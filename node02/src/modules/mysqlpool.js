const mysql=require('mysql');
const info={
    connectionLimit : 10,
    host            : '192.168.',
    user            : 'bob',
    password        : 'secret',
    database        : 'my_db'
}

const pool=mysql.createPool();
module.exports=pool;
