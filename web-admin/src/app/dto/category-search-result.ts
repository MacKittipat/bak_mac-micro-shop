import {Category} from "./category";

export interface CategorySearchResult {
  categories?: Category[];
  totalSize?: number;
  totalPage?: number;
}
