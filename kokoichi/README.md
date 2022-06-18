# Demo project
Thank you for [this youtube](https://www.youtube.com/watch?v=TJcshrJOnsE&list=PL6gx4Cwl9DGDPsneZWaOFg0H2wsundyGr&ab_channel=thenewboston)

## IntelliJ IDEA
- Use 'Live Templates'

## database
``` sh
docker run --name postgres12 -p 30123:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=test -d postgres:12-alpine
docker exec -it postgres12 createdb --username=postgres --owner=postgres test_db
docker exec -it postgres12 psql -h localhost -p 5432 -U postgres
docker exec -it postgres12 dropdb test_db

CREATE TABLE banks (
    id SERIAL PRIMARY KEY,
    account_number text UNIQUE,
    trust DOUBLE PRECISION,
    transaction_fee int
);

# # persist data (relative path)
# docker run --name postgres12 -v $PWD/data:/var/lib/postgresql/data -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=test -d postgres:12-alpine
```

## MyBatis

