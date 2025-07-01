package com.example.MakingApi.controller;

import com.example.MakingApi.model.JournalEntries;
import com.example.MakingApi.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntry {

    private Map<Long, JournalEntries> journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntries> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public Boolean createEntry(@RequestBody JournalEntries myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
}
