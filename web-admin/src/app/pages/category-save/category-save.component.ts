import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Form, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CategoryService} from "../../services/category.service";
import {Category} from "../../dto/category";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-category-save',
  templateUrl: './category-save.component.html',
  styleUrls: ['./category-save.component.css']
})
export class CategorySaveComponent implements OnInit {

  id: string;
  action: string;
  category: Category;
  categoryForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder,
              private categoryService: CategoryService) {
  }

  ngOnInit(): void {

    this.categoryForm = this.formBuilder.group({
      name: ['', [Validators.required]]
    });

    this.id = this.route.snapshot.paramMap.get('id');
    this.action = 'Create';
    if (this.id) {
      this.action = 'Edit';
      this.categoryService.findById(Number(this.id)).subscribe(category => {
        this.category = category;
        this.categoryForm.setValue({
          name: this.category.name
        });
      });
    }
  }

  onSubmit(): void {
    if (this.id) {
      this.category.name = this.categoryForm.get('name').value;
    } else {
      this.category = this.categoryForm.value;
    }
    this.categoryService.save(this.category).subscribe();
    this.router.navigate(['/category']);
  }

}
