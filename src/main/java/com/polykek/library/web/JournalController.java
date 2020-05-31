package com.polykek.library.web;

import com.polykek.library.entity.Journal;
import com.polykek.library.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JournalController {
    private final JournalService journalService;

    @GetMapping("journals/all")
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> list = journalService.listJournals();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
