import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {CategorySearchComponent} from "./pages/category-search/category-search.component";
import {CategorySaveComponent} from "./pages/category-save/category-save.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'category', component: CategorySearchComponent},
  {path: 'category/save', component: CategorySaveComponent},
  {path: 'category/save/:id', component: CategorySaveComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
