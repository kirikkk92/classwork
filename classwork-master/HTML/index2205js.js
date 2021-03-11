/* DOM (DOCUMENT OBJECT MODEL) */
// getElementById - выбирает элемент по его идентификатору
let obj = document.getElementById('test_id');
console.log(obj);
//innerText - свойство в котором хранится текст расположенный между
//открывающимися и закрывающимися тегами данного элемента
obj.innerText = "New value";
obj.innerHTML ='<a href = "http://www.google.com">Google</a>';

//работа с атрибутами
obj.onclick = function () {
    alert('Hello');
}

//работа со стилями
obj.style.fontSize='42px';

//getElementsByClassName - возвращает список элементов по заданному классу
let elems = document.getElementsByClassName('test');
for(let obj of elems) {
    obj.style.color ="red";
}

//document.querySelector() возвращает первый элемент который удовлетворяет заданной выборке
document.querySelector('#id >div.block p');
//Возвращает все элементы
document.querySelectorAll('p > div');

/////////////
let colorInput = document.getElementById('color');
function changeColor() {
    colorInput.style.color = colorInput.value;
}
function changeInputColor(elem) {
    elem.style.color = elem.value;
}

// Добавление элементов
let img = document.createElement('img');
img.src = "data:image/jpeg;base64,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";
img.width = "320";
img.height = "240";
document.body.appendChild(img);

//Удаление элементов
setTimeout(()=>{
    document.body.removeChild(img);
},3000);

/////////////////////////////////
let table = document.getElementsByTagName('table')[0];
let name = document.getElementById('name');
let age = document.getElementById('age');
let email = document.getElementById('email');

function addUser() {
    createTableRecord(name.value, age.value,email.value);
    name.value = "";
    age.value = "";
    email.value = "";
}

function createTableRecord(name,age,email) {
    let tr = document.createElement('tr');
    let tdname = document.createElement('td');
    let tdage = document.createElement('td');
    let tdmail = document.createElement('td');
    let tdbutton = document.createElement('td');
    tdname.innerText = name;
    tdage.innerText = age;
    tdmail.innerText = email;
    let removedBtn = document.createElement('button');
    removedBtn.innerText = 'Удалить запись';
    tdbutton.appendChild(removedBtn);
    removeBtn.onclick = function(){
        let indexx = tr.rowIndex;
        removeTableRecord(indexx);
    }
    tr.appendChild(tdname);
    tr.appendChild(tdmail);
    tr.append(tdage);
    tr.appendChild(tdbutton);
    table.tBodies[0].appendChild(tr);
}
function removeTableRecord(index) {
    table.deleteRow(index);
}