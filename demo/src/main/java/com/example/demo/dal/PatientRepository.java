package com.example.demo.dal;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    // )
    @Query(value = "select p from Patient p where p.firstname like %:value%")
    List<Patient> search(@Param("value")String value);
    @Query(
        value = "select * from T_PATIENT p left join T_EXAMINATION e on p.id = e.patient_id where p.firstname like %:value% and e.weight = 50 and p.id not in (select id from T_PATIENT where p.firstname like '%10%') order by requester asc"
        , nativeQuery = true)
    List<Patient> compute(@Param("value")String value);

    @Query(
        value = "select * from T_PATIENT p left join T_EXAMINATION e on p.id = e.patient_id where p.firstname like %:value% and e.weight = 50 order by requester asc limit 1000"
        , nativeQuery = true)
    List<Patient> computeSimple(@Param("value")String value);

    @Query(
        value = "select * from T_PATIENT p left join T_EXAMINATION e on p.id = e.patient_id where p.firstname like :value% and e.weight = 50 order by requester asc limit 1000"
        , nativeQuery = true)
    List<Patient> computeSimple2(@Param("value")String value);

}
