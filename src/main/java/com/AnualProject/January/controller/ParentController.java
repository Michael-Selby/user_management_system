package com.AnualProject.January.controller;


import com.AnualProject.January.dto.ParentDto;
import com.AnualProject.January.model.Parent;
import com.AnualProject.January.repository.ParentRepository;
import com.AnualProject.January.service.ParentServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/v1/parent/")
@RequiredArgsConstructor
public class ParentController {

    private ParentServiceImp serviceImp;

    @Autowired
    public ParentController(ParentServiceImp serviceImp) {
        this.serviceImp = serviceImp;

    }
    @PostMapping("/create")
    public ResponseEntity<Parent> create(@Valid  @RequestBody ParentDto parentDto){
        Parent parent=serviceImp.createAccount(parentDto);
        return ResponseEntity.ok(parent);
    }

    @GetMapping("/retrieve{id}")
    public ResponseEntity<List<Parent>> retrieve(Long id){
       Parent parent=serviceImp.retrieveDetails(id).get(0);
        return ResponseEntity.ok(List.copyOf(List.of(parent)));


    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Parent> edit(@PathVariable Long id, @RequestBody ParentDto parentDto){
        Parent parent=serviceImp.updateDetails(parentDto);
        return ResponseEntity.ok(parent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Parent> delete(@PathVariable  Long id){
        serviceImp.deleteDetails(id);
        return ResponseEntity.noContent().build();
    }


}
