import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class RequestService {
    constructor(private http: HttpClient){ }

    getCategories() {
        return this.http.get(environment.api_url + "/category");
    }

    get_items(catID) {
        return this.http.get(environment.api_url + `/item?categoryId=${catID}`);
    }

    /*   ADMIN   */
    addItem(item) {
        return this.http.put(environment.api_url + "/item", item);
    }

    updateItem(item) {
        return this.http.post(environment.api_url + "/item", item);
    }

    deleteItem(itemID) {
        return this.http.delete(environment.api_url + `/item/${itemID}`);
    }

    addCategory(category) {
        return this.http.put(environment.api_url + "/category", category);
    }

    updateCategory(category) {
        return this.http.post(environment.api_url + "/category", category);
    }

    deleteCategory(categoryID) {
        return this.http.delete(environment.api_url + `/category/${categoryID}`);
    }
}