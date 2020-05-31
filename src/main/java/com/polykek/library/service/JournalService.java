package com.polykek.library.service;

import com.polykek.library.entity.Journal;

import java.util.List;

public interface JournalService {
    List<Journal> listJournals();

    Journal findJournal(long id);
    Journal addJournal(Journal journal);
    Journal updateJournal(long id, Journal journal);
    void deleteJournal(long id);
}
