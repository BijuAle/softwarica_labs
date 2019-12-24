const person = {
    name :"Douglas Groothuis"
};

person.name = "William Craig"; //Allowed
//person = {}; //Not allowed/* 

function discountedPrices(prices, discount){
    let discounted = [];
    for (let i = 0; i < prices.length; i++){
        discounted.push(prices[i] * 1-(discount));
    }
    // If i was declared with var, console.log(i) would print 2;
    return discounted;
}
console.log(discountedPrices([100, 200], .2));


function doSth(n){
    let local = n;
    return function(){
        return local;
    }
    //return () => local;
}

console.log(doSth(1)()); //Immediately Evoked Function
//let firstCall = doSth(1);
//console.log(firstCall());

function multiply(factor){
    //return (number) => number * factor;
    return function sth(number){
        return number * factor;
    }
}

let x = multiply(2);
console.log(x(10));