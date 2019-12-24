const http = require('http');
let server = http.createServer((req, res)=>{
    console.log(req.headers);
    res.statusCode = 200;
    //res.setHeader("Content-type", "text/html");
    //res.end("<html><body><h1>Hello, world!</h1></body></html>");
}).listen(3000, ()=>{
    console.log("Server is running at 3000");
});