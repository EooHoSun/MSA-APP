package com.unico.community.online.postCatg.controller;

import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.service.PostCatgService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping( "/postCatg" )
public class PostCatgController {

    private final PostCatgService service;

    @GetMapping("/list/v1")
    public ResponseEntity<List<PostCatgDTO>> findAll(){
        ResponseEntity<List<PostCatgDTO>> result = null;

        try{
            result = ResponseEntity.ok(service.findAll());
        } catch(Exception e) {
        }

        return result;
    }

    @PostMapping("/v1")
    public ResponseEntity<PostCatgDTO> createPostCatg(@RequestBody PostCatgDTO dto){
        ResponseEntity<PostCatgDTO> result = null;

        try{
            result = ResponseEntity.ok(service.createPostCatg(dto));
        } catch(Exception e) {
        }

        return result;

    }

    @PutMapping("/v1")
    public ResponseEntity<PostCatgDTO> updatePostCatg(@RequestBody PostCatgDTO dto){
        ResponseEntity<PostCatgDTO> result = null;

        try{
            result = ResponseEntity.ok(service.updatePostCatg(dto));
        } catch(Exception e) {
        }

        return result;

    }

    @DeleteMapping("/v1")
    public ResponseEntity<Boolean> deletePostCatg(@RequestBody PostCatgDTO dto){
        ResponseEntity<Boolean> result = null;

        try{
            result = ResponseEntity.ok(service.deletePostCatg(dto));
        } catch(Exception e) {
        }

        return result;

    }

}


