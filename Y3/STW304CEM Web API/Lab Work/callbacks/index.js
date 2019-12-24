//Synchronous:
console.log("Synchronous:")
const fs = require("fs");
let content = fs.readFileSync("test.txt");

console.log(content.toString());
console.log("Finished reading,");
console.log("...................");

//Asynchronous:
console.log("Asynchronous:");
fs.readFile("test.txt", (err, data)=>{
    if(err) console.error(err);
    console.log(data.toString());
});
console.log("Finished reading");