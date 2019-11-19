package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.dal.PatientRepository;
import com.example.demo.model.Patient;


@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    protected PatientRepository repo;

    @GetMapping("search/{value}")
    public ResponseEntity<List<Patient>> search(@PathVariable("value") String value) {
        System.out.println("search " + value);
        return ResponseEntity.ok().body(repo.search(value));
    }

    @GetMapping("compute/{value}")
    public ResponseEntity<List<Patient>> compute(@PathVariable("value") String value) {
        System.out.println("compute " + value);
        return ResponseEntity.ok().body(this.process(value));
    }


    private List<Patient> process(String value){
        List<Patient> result = repo.computeSimple(value);
        this.compute(result);
        return result.stream().map(
            item -> {
                item.firstname = item.firstname.toUpperCase();
                return item;
            }
        ).collect(Collectors.toList());
    }

    /**
     * Simulate processing
     * 
     * @param items
     */
    private void compute(List<Patient> items){
        items.stream().map(
            item -> Integer.parseInt(item.firstname.split("_")[1])
        ).reduce(
            0, (total, item) -> item % 2 == 0 ? total+1 : total
        );
    }
}
