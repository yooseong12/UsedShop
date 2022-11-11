package com.example.usedshop.DTO;

import com.example.usedshop.entity.File;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileRequest {
    private Long id;
    private String originFileName;
    private String fullPath;

    public File toEntity() {
        return File.builder()
                .id(this.id)
                .originFileName(this.originFileName)
                .fullPath(this.fullPath)
                .build();
    }

    @Builder
    public FileRequest(Long id,String originFileName, String fullPath){
        this.id = id;
        this.originFileName = originFileName;
        this.fullPath = fullPath;
    }
}
