//app을 전달받아 exepors 해야됨(기본)
//아니 라우터를 이용해서 저쪽에서 use하도록
const express = require('express');
const router = express.Router();

router.get('/intro', function (req, res) {
    res.render('intro');
});

module.exports=router;