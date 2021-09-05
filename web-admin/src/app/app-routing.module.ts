import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {CategorySaveComponent} from "./pages/category-save/category-save.component";
import {CategoryListComponent} from "./pages/category-list/category-list.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'category', component: CategoryListComponent},
  {path: 'category/create', component: CategorySaveComponent},
  {path: 'category/edit/:id', component: CategorySaveComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
