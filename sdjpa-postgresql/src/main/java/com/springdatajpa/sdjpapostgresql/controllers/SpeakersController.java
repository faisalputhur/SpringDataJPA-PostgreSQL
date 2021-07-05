package com.springdatajpa.sdjpapostgresql.controllers;


import com.springdatajpa.sdjpapostgresql.models.Speaker;
import com.springdatajpa.sdjpapostgresql.repositories.SpeakerRepositroy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    SpeakerRepositroy speakerRepositroy;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepositroy.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable  Long id){
        return speakerRepositroy.getById(id);
    }

    @PostMapping
    public Speaker create (@RequestBody final Speaker speaker){
        return speakerRepositroy.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        speakerRepositroy.deleteById(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepositroy.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepositroy.saveAndFlush(speaker);
    }

}
