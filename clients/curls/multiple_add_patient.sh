
END=120

for i in $(seq 1 $END); 
do
    curl -i -XPOST localhost:8080/patients/add
    sleep 0.7
done
