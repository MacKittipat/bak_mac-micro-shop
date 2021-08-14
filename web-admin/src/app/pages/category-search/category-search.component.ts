import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CategoryService} from "../../services/category.service";
import {CategorySearchResult} from "../../dto/category-search-result";
import {CategorySearchForm} from "../../dto/category-search-form";

@Component({
  selector: 'app-category-search',
  templateUrl: './category-search.component.html',
  styleUrls: ['./category-search.component.css']
})
export class CategorySearchComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'createdDate'];
  categorySearchResult: any;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    let searchForm = {page: 1}
    this.categoryService.search(searchForm).subscribe(searchResult => {
      console.log(searchResult);
      this.categorySearchResult = searchResult
    });
  }

}
