package com.example.usedshop.controller;

import com.example.usedshop.DTO.ItemDto;
import com.example.usedshop.entity.File;
import com.example.usedshop.request.ItemRequest;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @GetMapping("/form")
    public String homeView(Model model) {
        model.addAttribute("item", new ItemDto());
        return "home";
    }

    @Value("${image.path}")
    private String uploadDir;

    @PostMapping("/form")
    public String saveFormRequests(@ModelAttribute("item") ItemRequest itemRequest) throws IOException {
        String itemName = itemRequest.getItemName();
        Integer qty = itemRequest.getQty();
        ItemDto itemDto = ItemDto.builder()
                .itemName(itemName)
                .quantity(qty)
                .build();

        if (itemRequest.getFile() != null) {
            MultipartFile file = itemRequest.getFile();
            String fullPath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
            log.info("file.getOriginalFilename = {}", file.getOriginalFilename());
            log.info("fullPath = {}", fullPath);

            FileDto fileDto = FileDto.builder()
                    .originFileName(file.getOriginalFilename())
                    .fullPath(uploadDir + file.getOriginalFilename())
                    .build();
            Long savedFileId = fileService.save(fileDto);
            itemDto.setFileId(savedFileId);
        }
        itemService.save(itemDto);

        return "redirect:/form";
    }
}
