schema:
	sqlite3 main.db < db-schema.sql

generate_rows:
	python generate_rows.py

insert_data:
	sqlite3 main.db < data.sql

check_data:
	sqlite3 -header -column main.db < check_insert.sql

clean:
	rm data.sql
	rm main.db