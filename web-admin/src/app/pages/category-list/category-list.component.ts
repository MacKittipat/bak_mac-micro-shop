import {Component, OnInit} from '@angular/core';
import {CategorySearchResult} from "../../dto/category-search-result";
import {CategoryService} from "../../services/category.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categorySearchResult: CategorySearchResult;
  page: number;

  constructor(private categoryService: CategoryService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.page = Number(this.route.snapshot.queryParamMap.get('page'));
    if (!this.page) {
      this.page = 1;
    }
    this.searchCategory(this.page);
  }

  onPageChanged(page): void {
    this.searchCategory(page);
    this.router.navigate([], {queryParams: {page: page}});
  }

  searchCategory(page) {
    this.categoryService.search({page: page}).subscribe(categorySearchResult => {
      this.categorySearchResult = categorySearchResult;
    });
  }

}
