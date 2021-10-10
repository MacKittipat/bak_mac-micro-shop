# Product Service

## Database
```sql
CREATE DATABASE shop_product;

GRANT ALL PRIVILEGES ON DATABASE shop_product to postgres;
```

## APIs 

### Category
```
curl --location --request POST 'http://localhost:8081/api/product/categories/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Home"
}'

curl --location --request GET 'http://localhost:8081/api/product/categories/'

curl --location --request PUT 'http://localhost:8081/api/product/categories/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "uuid": "628360d9-ffab-459f-82b9-2be53e8577ba",
    "name": "Food"
}'
```
