import random

def insert_multiple(rows):
    batch_size = 1000
    data = open('data.sql', 'w')
    transactional = True

    data.writelines('BEGIN;\n')
    count = 0

    for row in rows:
        if transactional == False:
            data.writelines('BEGIN;\n')
            transactional = True
            
        data.writelines(row)

        if count % batch_size == 0:
            data.writelines('COMMIT;\n')
            transactional = False
        
        count = count + 1

    if transactional == True:
        data.writelines('COMMIT;\n')
        transactional = False

    data.close()

insert_patient = 'INSERT INTO T_PATIENT (id, email, firstname, lastname) VALUES ({id},\'{email}\',\'{firstname}\',\'{lastname}\');\n'
insert_examination = 'INSERT INTO T_EXAMINATION (weight, requester, patient_id) VALUES (\'{weight}\',\'{requester}\',{patient_id});\n'

# total = 100000 generate rows
total = 2000000
patient_ids = [n for n in range(total)]


patient_rows = []
exam_rows = []

for id in patient_ids:

    email = 'patient_{id}@test.com'.format(id=id)
    firstname = 'firstname_{id}'.format(id=id)
    lastname = 'lastname_{id}'.format(id=id)

    patient_rows.append(insert_patient.format(id=id,email=email,firstname=firstname,lastname=lastname))

    exam_rows.append(insert_examination.format(weight=random.randint(50, 60)
        ,requester='requester_{val}'.format(val=random.randint(0, 100)),patient_id=id))
    exam_rows.append(insert_examination.format(weight=random.randint(50, 60)
        ,requester='requester_{val}'.format(val=random.randint(0, 100)),patient_id=id))


random.shuffle(exam_rows)

rows = patient_rows + exam_rows

insert_multiple(rows)
