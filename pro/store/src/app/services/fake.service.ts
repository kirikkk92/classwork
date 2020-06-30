import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FakeRequestService {
    constructor(private http: HttpClient) { }

    getCategories() {
        return new Promise( (accept)=>{
            let categoriesJSON = localStorage.getItem("CATEGORIES");
            let categories = [];
            if (categoriesJSON != null) {
                categories = JSON.parse(categoriesJSON);
            }
            accept(categories);
        }); 
    }

    getItems(catID) {
        return new Promise((accept)=> {
            let itemsJSON = localStorage.getItem("ITEMS");
            let items = [];
            if (itemsJSON != null) {
                items = JSON.parse(itemsJSON);
            }
            let filtetedItems = [];
            for (let item of items) {
                if (item.categoryID == catID) {
                    filtetedItems.push(item);
                }
            }
            accept(filtetedItems);
        });
    }

    addNewCategory(category) {
        return new Promise((accept)=> {
            let categoriesJSON = localStorage.getItem("CATEGORIES");
            let categories = [];
            if (categoriesJSON != null) {
                categories = JSON.parse(categoriesJSON);
            }
            let newCategory = {
                name:category,
                id: (new Date()).getTime()
            };
            categories.push(newCategory);
            categoriesJSON= JSON.stringify(categories);
            localStorage.setItem("CATEGORIES",categoriesJSON);
            accept(newCategory);
        });
    }

    editCategory(category){
        return new Promise((accept)=>{
            let categoriesJSON = localStorage.getItem("CATEGORIES");
            let categories = [];
            if (categoriesJSON != null) {
                categories = JSON.parse(categoriesJSON);
            }
            for(let i = 0; i < categories.length; i++) {
                if (categories[i].id == category.id) {
                    categories[i].name = category.name;
                    break;
                }
            }
            categoriesJSON = JSON.stringify(categories);
            localStorage.setItem("CATEGORIES",categoriesJSON);
            accept();
        });
    }

    removeCategory(categoryID) {
        return new Promise((accept)=>{
            let categoriesJSON = localStorage.getItem("CATEGORIES");
            let categories = [];
            if (categoriesJSON != null) {
                categories = JSON.parse(categoriesJSON);
            }
            for(let i = 0; i < categories.length; i++) {
                if (categories[i].id == categoryID) {
                    categories.splice(i,1);
                    break;
                }
            }
            categoriesJSON = JSON.stringify(categories);
            localStorage.setItem("CATEGORIES",categoriesJSON);
            accept();
        });
    }
}