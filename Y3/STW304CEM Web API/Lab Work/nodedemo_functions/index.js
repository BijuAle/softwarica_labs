//console.log("Hello, World!");

let rect = {
    perimeter: function(l,b){
        return 2*(l+b);
    },
    area: function(l, b){
        return l*b;
    }
};

function perimeter (l,b){
    return 2 * (l+b);
}

function area(l,b){
    return l*b;
}

let perimeter1 = function(l,b){
    return 2 * (l+b);
}

let perimeter2 = (l,b)=>{
    return 2 * (l+b);
}

let rectangle = {
        perimeter: function(l,b){
            return 2 *(l+b);
        },
        area:(l,b)=>{
            return l*b;
        }
}

console.log(perimeter(2,3));
console.log(rectangle.area(2,3));


let circle = {
    perimeter: function(r){
        return 2 * Math.PI * r;
    },
    area:(r) =>{
        return Math.PI * r * r;
    }
}

console.log(circle.perimeter(5));
console.log(circle.area(5));