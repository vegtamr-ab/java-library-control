package com.polykek.library.service;

import com.polykek.library.entity.Journal;
import com.polykek.library.exception.JournalNotFoundException;
import com.polykek.library.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository journalRepository;

    @Override
    public List<Journal> listJournals() {
        return (List<Journal>) journalRepository.findAll();
    }

    @Override
    public Journal findJournal(long id) {
        Optional<Journal> optionalJournal = journalRepository.findById(id);
        if (optionalJournal.isPresent()) {
            return optionalJournal.get();
        } else {
            throw new JournalNotFoundException("Book not found!");
        }
    }

    @Override
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public Journal updateJournal(long id, Journal journal) {
        Journal existingJournal = findJournal(id);
        BeanUtils.copyProperties(journal, existingJournal);
        return journalRepository.save(existingJournal);
    }

    @Override
    public void deleteJournal(long id) {
        journalRepository.delete(findJournal(id));
    }
}
