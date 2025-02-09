function evaluateExpression(n) {
    let sum = 1;
    let fact = 1;
    
    for (let i = 2; i <= n; i++) {
        fact *= i;
        sum += i / fact;
    }
    
    return sum;
}

let n = 5;
console.log(evaluateExpression(n));



let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

let email = "test@example.com";
console.log(emailRegex.test(email));