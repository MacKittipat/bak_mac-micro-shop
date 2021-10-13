import {Injectable} from '@angular/core';
import {CategorySearchForm} from "../dto/category-search-form";
import {HttpClient, HttpParams} from "@angular/common/http";
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
      environment.url_product + 'categories', {
        params: new HttpParams()
          .set('page', categorySearchForm.page)
          .set('name', categorySearchForm.name)
      });
  }

  findById(id: number): Observable<Category> {
    return this.httpClient.get<Category>(
      environment.url_product + 'categories/' + id);
  }

  save(category: Category): Observable<Category> {
    if (category.id) {
      return this.httpClient.put<Category>(
        environment.url_product + 'categories', category);
    } else {
      return this.httpClient.post<Category>(
        environment.url_product + 'categories', category);
    }
  }
}
