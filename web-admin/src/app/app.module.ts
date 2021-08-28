import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './pages/home/home.component';
import {CategorySearchComponent} from './pages/category-search/category-search.component';
import {HttpClientModule} from "@angular/common/http";
import {NgbAccordionModule, NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";
import {CategorySaveComponent} from './pages/category-save/category-save.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CategorySearchComponent,
    CategorySaveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbPaginationModule,
    NgbAccordionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
