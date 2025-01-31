package com.AnualProject.January.service;


import com.AnualProject.January.dto.ParentDto;
import com.AnualProject.January.model.Parent;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParentService {
    Parent createAccount(ParentDto parentDto);
    Parent updateDetails(ParentDto parentDto);
    List<Parent> retrieveDetails(Long Id);
    Parent deleteDetails(Long Id);
}
