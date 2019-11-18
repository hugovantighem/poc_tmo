package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.example.demo.dal.PatientRepository;
import com.example.demo.model.Patient;


@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    protected PatientRepository repo;

    @GetMapping("search")
    public ResponseEntity<List<Patient>> search() {
        return ResponseEntity.ok().body(repo.search());
    }

    @GetMapping("compute")
    public ResponseEntity<List<Patient>> compute() {
        return ResponseEntity.ok().body(this.process());
    }


    private List<Patient> process(){
        List<Patient> result = repo.search();
        return result;
    }
}
