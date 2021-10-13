import {Component, OnInit} from '@angular/core';
import {CategorySearchResult} from "../../dto/category-search-result";
import {CategoryService} from "../../services/category.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CategorySearchForm} from "../../dto/category-search-form";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categorySearchResult: CategorySearchResult;
  page: number;
  categorySearchFg: FormGroup;

  constructor(private categoryService: CategoryService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder) {
    this.categorySearchFg = this.formBuilder.group({
      name: ['', []]
    });
    this.page = 1;
  }

  ngOnInit(): void {
    this.searchCategory({page: this.page, name: this.categorySearchFg.get('name').value});
  }

  onPageChanged(page): void {
    this.searchCategory({page: page, name: this.categorySearchFg.get('name').value});
  }

  onSearch(): void {
    this.page = 1;
    this.searchCategory({page: this.page, name: this.categorySearchFg.get('name').value});
  }

  searchCategory(categorySearchForm: CategorySearchForm) {
    this.categoryService.search(categorySearchForm).subscribe(categorySearchResult => {
      this.categorySearchResult = categorySearchResult;
    });
  }

}
