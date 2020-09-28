//МАССИВЫ

//добавление элемента в конец массива
var arr= [1,2,3];
arr.push(4,5);
console.log(arr);
//удаление последнего элемента  в массиве
let delElem  = arr.pop();
console.log(delElem, arr)

//добавление элемента в начало массива
arr.unshift(-1,0);
console.log(arr);

//удаление первого элемента массива
let first = arr.shift();
console.log(first,arr);

//получение индекса элемента по его значению
let index = arr.indexOf(3);
console.log(index);

//удаление элемента по индексу
arr.splice(2,1);
console.log(arr);

//удаление элемента по значению
let value = 4;
let i= arr.indexOf(value);
arr.splice(i,1);
console.log(arr);

arr.forEach(function(item,i,arr){
    console.log(item);
});

//filter = фильтрует массив по заданному критерию

let filterArr = arr.filter((item)=>item%2!=0);
console.log(filterArr);

//map= преобразует массив в  соответствии с заданным критериям
let squareArr = arr.map((item)=> item*item);
console.log(squareArr);

//every = возвращает значение тру если все элементы массива соответствуют заданному критерию
let isSquare = (item)=>{
    let sqr = Math.sqrt(item);
    return sqr == Math.trunc(sqr);
}
let res = arr.every(isSquare);
console.log(res);

//some = возвращает тру если один из элементов соотв зад критерию

//reduce= возвращает резултат полученный в ходе обхода массива с лево на право с сохранением прмежуточного результата вычисления
let result=arr.reduce((prevValue,item,i,arr)=>{
    //prevValue  рузультат последнего вызова функции ca;llback
    //при первом срабатывании функции callback будет равно initialvalue=0
    return item + prevValue;
},0);
console.log(result);

//reduceRight = тоже что и редьюс,но обход по массиву начинается с права налево

//revers = изменяет порядок следования элементов на противоположный

//sort сортирует массив по заданным критериям
arr.sort((x,y)=>{
    //x,y значения эл массив которые в данный момент подвергаются сравнению
    return y-x;
});
console.log(arr);

//session и local storage
//localStorage.setItem("KEY","JavaScript");
//sessionStorage.setItem("KEY","JavaScript");

let local = localStorage.getItem("KEY");
console.log("local:",local);
let session = sessionStorage.getItem("KEY");
console.log("session",session);

