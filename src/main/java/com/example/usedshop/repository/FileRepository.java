package com.example.usedshop.repository;

import com.example.usedshop.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {

}
