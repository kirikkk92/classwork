import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FakeRequestService {
    constructor(private http: HttpClient) { }

    getCategories() {
        return this.http.get("http://localhost:4200/assets/_fakedata/categories.json");
    }

    getItems(catID) {
        return this.http.get("http://localhost:4200/assets/_fakedata/items_" + catID + ".json");
    }
}