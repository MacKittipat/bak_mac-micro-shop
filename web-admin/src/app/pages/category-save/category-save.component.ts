import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Form, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CategoryService} from "../../services/category.service";

@Component({
  selector: 'app-category-save',
  templateUrl: './category-save.component.html',
  styleUrls: ['./category-save.component.css']
})
export class CategorySaveComponent implements OnInit {

  id: number;
  action: string;
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

    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
    });

    this.action = 'Create';
    if (this.id) {
      this.action = 'Edit'
    }
  }

  onSubmit(): void {
    this.categoryService.save(this.categoryForm.value).subscribe();
    this.router.navigate(['/category']);
  }

}
