import {Injectable} from '@angular/core';
import {CategorySearchForm} from "../dto/category-search-form";
import {HttpClient} from "@angular/common/http";
import {environment} from '../../environments/environment';
import {Observable} from "rxjs";
import {CategorySearchResult} from "../dto/category-search-result";
import {Category} from "../dto/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) {
  }

  search(categorySearchForm: CategorySearchForm): Observable<CategorySearchResult> {
    return this.httpClient.get<CategorySearchResult>(
      environment.url_product + 'categories?page=' + categorySearchForm.page);
  }

  save(category: Category): Observable<Category> {
    console.log(category);
    return this.httpClient.post<Category>(
      environment.url_product + 'categories', category);
  }
}
