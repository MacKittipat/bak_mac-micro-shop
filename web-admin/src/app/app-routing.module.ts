import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {CategorySearchComponent} from "./pages/category-search/category-search.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'category', component: CategorySearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
