const mysql = require('mysql')
const pool  = mysql.createPool({
  connectionLimit : 10,
  host: '192.168.99.100',
  user: 'scott',
  password: 'tiger',
  database: 'lecture'
});

module.exports=pool;