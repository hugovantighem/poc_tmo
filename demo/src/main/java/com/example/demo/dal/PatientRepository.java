package com.example.demo.dal;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    // @Query(value = "select * from T_PATIENT p left join T_EXAMINATION e on p.id = e.patient_id where p.firstname like '%123%' and e.weight = 50 order by requester asc")
    @Query(value = "select p from Patient p where p.firstname like '%123%'")
    List<Patient> search();

}
