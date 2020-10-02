// Работ с форматом JSON
// преобразование строки в объект
let str = `{"name":"Vasya","age":30}`;
let obj = JSON.parse(str);
console.log(obj);
//преобразование объекта в строку
let cat = {
    color:"black",
    food:["milk","felix","chicken"],
    name:"Barsik",
}
let catStr = JSON.stringify(cat);
console.log(catStr);

//Асинхронные запросы
$.ajax({
    url:`https://www.google.com`,
    method: `GET`,
    data:{},
    success(resp){
        console.log(resp.data);
    },
    error(err){
        console.log(err);
    }
});

// Работа с API  НБРБ
function getRate(curID) {
    return new Promise(function (resolve, reject) {
      $.ajax({
        url: 'https://www.nbrb.by/api/exrates/rates/' + curID,
        success(resp) {
          resolve(resp);
        },
        error(err) {
          reject(err);
        }
      });
    });
  }
  let usd = document.getElementById('usd');
  let eur = document.getElementById('eur');
  let rub = document.getElementById('rub');
getRate(145).then((data) => usd.innerText = data.Cur_OfficialRate);
getRate(292).then((data) => eur.innerText = data.Cur_OfficialRate);
getRate(298).then((data) => rub.innerText = `${data.Cur_OfficialRate} (${data.Cur_Scale})`);