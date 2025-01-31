package com.AnualProject.January.service;

import com.AnualProject.January.dto.ParentDto;
import com.AnualProject.January.mapper.ParentMapper;
import com.AnualProject.January.model.Parent;
import com.AnualProject.January.repository.ParentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
@RequiredArgsConstructor
public class ParentServiceImp implements ParentService {
    private  ParentRepository parentRepository;
    private  ParentMapper parentMapper;
    private static final Logger logger = Logger.getLogger(ParentServiceImp.class.getName());
    @Autowired
    public ParentServiceImp(ParentRepository parentRepository, ParentMapper parentMapper) {
        this.parentRepository = parentRepository;
        this.parentMapper = parentMapper;
    }


    @Override
    public Parent createAccount(ParentDto parentDto) {
        logger.info("Creating parent with DTO: " + parentDto);
        if(parentRepository.findByEmail(parentDto.getEmail()).isPresent()){
            throw(new IllegalArgumentException("Email already exists"));
        }
        Parent parent=parentMapper.toEntity(parentDto);
        return parentRepository.save(parent);

    }

    @Override
    public Parent updateDetails(ParentDto parentDto) {
        Optional<Parent> parent=parentRepository.findByEmail(parentDto.getEmail());
        if(parent.isPresent()){
            Parent update=parent.get();
            parentMapper.toUpdateEntity(parentDto,update);
            return parentRepository.save(update);
        }

        else{
            throw(new IllegalArgumentException("Email not found"));
        }
    }

    @Override
    public List<Parent> retrieveDetails(Long id) {
        Optional<Parent> retrieveList=parentRepository.findById(id);
        if(retrieveList.isPresent()){
            return List.of(retrieveList.get());
        }
       else {
           throw(new IllegalArgumentException("Parent not found"));
        }
    }

    @Override
    public Parent deleteDetails(Long Id) {
        Optional<Parent> parent=parentRepository.findById(Id);
        if(parent.isPresent()){
            Parent delete=parent.get();
            parentRepository.delete(delete);
            return delete;
        }
        else {
            throw(new IllegalArgumentException("Parent not found"));
        }
    }
}
