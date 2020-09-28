/*
Псевдотипы данных
строка "hello",'hello',`hello`
число: 120,12.36,3e10
boolean: true,false
*/
console.log("10"+2);

/*
Массивы
var arr = [];
*/
var arr = [10,"hello",true];
console.log(arr[0]);
//в js массивы обладают свойствами коллекций
//добавление элемента в массив
arr.push(78,"JavaScript");
console.log(arr);

/* Коллекция типа MAP */
var map = {"215487": "Sidorov", "326598":"Ivanov"}; 
console.log(map);
/*Добавление элемента в коллекцию*/
map["121212"]="Petrov";
console.log(map);
/*удаление элемента*/
delete map["121212"];
console.log(map);

/* Условные конструкции */
/* 
if... else
switch...case
 */
var a = 1;
if(a < 10){
    console.log("a < 10");
}else{
    console.log("a >= 10")
}
// && - логическое и
// || - логическое или
// === - равно (по значению + по типу данных)
//!== - не равно (по значению + по типу данных)

var month = 2;
switch (month){
    case 1:
        console.log("January");
        break;
    case 2:
        console.log("February");
        break;
    default:
        console.log("Неверное значение месяца!")
}
/* функции и лямбда выражения */
function min(a,b,c) {
    if (a < b && a < c) {
        return a;
    }
    if (b < c) {
        return b;
    }
    return c;
}

console.clear();

let r = min(2,1,4);
console.log(r);

/* необязательные аргументы функции */
function average(x,y,z) {
    if (x == undefined) {
        return 0;
    }
    if (y == undefined) {
        return x;
    }
    if (z == undefined) {
        return (x +y)/2;
    }
    return (x+y+z)/3;
}
console.log(average());
console.log(average(7));
console.log(average(8,2));
console.log(average(8,44,24));

// значение пргументов "по умолчанию"
//tips [0;1]
function cheque(sum, tips = 0.15) {
    return sum * (1 + tips);
}
console.log(cheque(15));
console.log(cheque(15,0.1));