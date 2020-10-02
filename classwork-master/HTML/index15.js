/* Лямбда выражения */

var sum = function(a,b) {
    return a + b;
}
let s = sum(1,3);
console.log(s);

//Пример использования не именнованой функции
setTimeout(function() {
    console.log("hello");
}, 2000);

//Общий вид лямбда выражения
let div = (a,b) => {
    return a / b;
}
let d = div(20,4);
console.log(d);

//Если лямбда выражени состоит из единственного действия,
//то {} и return можно опустить

//Пример использования неименнованого лямбда выражения

setTimeout(() => console.log("lambda"),2500);


/* ООП */
//Инкапсуляция ((+) свойство, (+) методы, (-) модификаторы доступа)
//Полиморфизм (-) 
//Наследование ((+-) реализуется через прототипирование)

// Создание объекта (без шаблона)
let cat = {
    age: 3,
    color:"black",

    say: function() {
        console.log("meow");
    },
    eat: (food) => console.log("cat eats " + food)
};

console.log(cat.age);
cat.color = "white";
console.log(cat);
cat.say();
cat.eat("Fish");

//Прототипирование 

let cat2 = {
    name: "Barsic",

    sleep: function () {
        console.log("Z-z-z-z");
    }
}
cat2.__proto__ = cat;
cat2.sleep();
//Поскольку метода eat нет в объекте cat2,
//то js будет искать его реализацию во всех объектах
// которые заданы через свойство __proto__
cat2.eat("meat");

// сщздание объукта в динамической памяти
//любая функция в js может располагаться в динамической области памяти
function Dog(name,age) {
    //функция Dog будет выполнять роль конструктора объекта
    this.name = name;
    this.age = age;
    //В случае, если через this происходит обращение
    //к несуществующему полю объекта, то это поле
    //будет созданно автоматически для данного объекта
    this.say = function() {
        console.log("haw-haw");
    }
    this.info = function() {
        console.log("name: " + this.name + ", age: " + this.age);
    }
};
//Создание динамического объекта на основе функции:
let dog1 = new Dog("Bim",4);
dog1.say();
dog1.info();
let dog2 = new Dog("Rex",6);
dog2.info();
//Объект созданный на основе функции может обладать прототипом
dog2.__proto__ = cat;

//this и лямбда выражения
function Test () {
    this.value = "test value";

    this.run = function(){
        setTimeout(function() {this.value = "new value"},3000);
    }

    this.runWithLambda = function() {
        //у лямбда выражений нет ключевого слова this
        //в случае использования this внутри лямбда выражения
        //js будет искать ближайший по вложенности объект
        //у которого присутствует this
        setTimeout(()=>{this.value = "new value";},3000);
    }
}

let test = new Test();
test.run();
//дулаем задержку в 3.5 сек, что бы функция run 
//успела завершиться
setTimeout(function() {console.log(test.value);
    test.runWithLambda();
    //дулаем задержку в 3.5 сек, что бы функция run 
    //успела завершиться
    setTimeout(function() {console.log(test.value);},3500);
},3500);

/* Диалоговые окна в браузере */
//alert,prompt,confirm

//alert * показывает всплывающее сообщение
alert("Hello user!!!");
//prompt - запрашивает у пользователя ввод данных
let answer = prompt("Сколько вам лет?");

//преобразование строки в число
console.log(answer);
//parseInt - преобразует строку в целочисл. знач
//parseFloat- в вещественное знач
answer= parseInt(answer);
console.log(answer);

//confirm - запрашивает подтверждение действия
let action = confirm("Да/нет?")
console.log(action);
