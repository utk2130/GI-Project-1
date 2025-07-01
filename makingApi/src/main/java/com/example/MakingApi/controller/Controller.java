package com.example.MakingApi.controller;

import com.example.MakingApi.model.Model;
import com.example.MakingApi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    Repository repository;

    // Get all models (optional filter by title)
    @GetMapping("/model")
    public ResponseEntity<List<Model>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Model> models;

            if (title == null)
                models = repository.findAll();
            else
                models = repository.findByTitleContaining(title);

            if (models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a model by ID
    @GetMapping("/model/{id}")
    public ResponseEntity<Model> getTutorialById(@PathVariable("id") long id) {
        Optional<Model> modelData = repository.findById(id);

        if (modelData.isPresent()) {
            return new ResponseEntity<>(modelData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new model
    @PostMapping("/model")
    public ResponseEntity<Model> createTutorial(@RequestBody Model model) {
        try {
            Model _model = repository.save(new Model(model.getTitle(), model.getDescription(), model.isPublished()));
            return new ResponseEntity<>(_model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a model by ID
    @PutMapping("/model/{id}")
    public ResponseEntity<Model> updateTutorial(@PathVariable("id") long id, @RequestBody Model model) {
        Optional<Model> modelData = repository.findById(id);

        if (modelData.isPresent()) {
            Model _model = modelData.get();
            _model.setTitle(model.getTitle());
            _model.setDescription(model.getDescription());
            _model.setPublished(model.isPublished());
            return new ResponseEntity<>(repository.save(_model), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a model by ID
    @DeleteMapping("/model/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all models
    @DeleteMapping("/model")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all published models
    @GetMapping("/model/published")
    public ResponseEntity<List<Model>> findByPublished() {
        try {
            List<Model> models = repository.findByPublished(true);

            if (models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
