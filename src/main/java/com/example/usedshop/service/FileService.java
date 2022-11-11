package com.example.usedshop.service;

import com.example.usedshop.DTO.FileRequest;
import com.example.usedshop.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    public Long save(FileRequest fileRequest){
        return fileRepository.save(fileRequest.toEntity()).getId();
    }
}
