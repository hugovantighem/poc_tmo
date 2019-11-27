
ITEMS=( "123" "5863" "963" "125" "5865" "965" )

for val in "${ITEMS[@]}"; 
do
    curl -i localhost:8080/patients/compute2/$val
    sleep 0.1
done
