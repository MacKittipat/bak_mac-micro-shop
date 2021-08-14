import {Injectable} from '@angular/core';
import {CategorySearchForm} from "../dto/category-search-form";
import {HttpClient} from "@angular/common/http";
import {environment} from '../../environments/environment';
import {Observable} from "rxjs";
import {CategorySearchResult} from "../dto/category-search-result";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) {
  }

  search(categorySearchForm: CategorySearchForm) : Observable<CategorySearchResult> {
    return this.httpClient.get<CategorySearchResult>(environment.url_product + 'categories');
  }
}
