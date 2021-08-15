import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../services/category.service";
import {Category} from "../../dto/category";
import {CategorySearchResult} from "../../dto/category-search-result";
import {Observable} from "rxjs";

@Component({
  selector: 'app-category-search',
  templateUrl: './category-search.component.html',
  styleUrls: ['./category-search.component.css']
})
export class CategorySearchComponent implements OnInit {

  categorySearchResult: CategorySearchResult;
  page: number;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.page = 1;
    this.searchCategory(this.page)
  }

  onPageChanged(page): void {
    this.searchCategory(page)
  }

  searchCategory(page) {
    this.categoryService.search({page: page}).subscribe(categorySearchResult => {
      this.categorySearchResult = categorySearchResult;
    });
  }
}
