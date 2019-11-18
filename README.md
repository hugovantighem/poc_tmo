Sample commands to run against DB

sqlite3
```
sqlite3 -header -column main.db < check_insert.sql
```

Postgres
```
sudo docker cp ../db-schema.sql  poc_postgres:/schema.sql
sudo docker cp ../data.sql poc_postgres:/data.sql

psql -h localhost -d poc -U root -f db-schema.sql
psql -h localhost -d poc -U root -f data.sql 

psql -h localhost -d poc -U root -f check_insert.sql

psql -h localhost -d poc -U root -c "select count(*) from T_PATIENT;"

psql -h localhost -d poc -U root -c "select * from T_PATIENT p left join T_EXAMINATION e on p.id = e.patient_id where p.firstname like '%123%' and e.weight = 50 order by requester asc;"
```

Backend API
```
curl -i localhost:8080/patients/search/arg
curl -i localhost:8080/patients/compute/arg
```


## Docker

`docker/scripts/` folder is mounted into the `poc_postgres` container to easilly run sql scripts against DB.

Do not forget to copy scripts to `docker/scripts/` before running docker-compose up
```
cp *.sql docker/scripts/
```
