create table T_PATIENT (
    id serial PRIMARY KEY,
    email VARCHAR (50) UNIQUE NOT NULL,
    firstname VARCHAR (50) UNIQUE NOT NULL,
    lastname VARCHAR (50) UNIQUE NOT NULL
);
create table T_EXAMINATION (
    weight integer NOT NULL,
    requester VARCHAR (50) NOT NULL,
    patient_id integer NOT NULL,
    CONSTRAINT fk_examination_patient FOREIGN KEY (patient_id)
        REFERENCES T_PATIENT (id) MATCH SIMPLE
);

