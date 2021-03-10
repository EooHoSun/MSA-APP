package com.unico.community.online.post.controller;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.dto.PostSearchDTO;
import com.unico.community.online.post.dto.PostVODTO;
import com.unico.community.online.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RequestMapping( "/post" )
@RestController
public class PostController {

    private final PostService service;

    @GetMapping("/v1")
    public ResponseEntity<List<PostDTO>> findAll(){
        ResponseEntity<List<PostDTO>> result = null;

        try{
            result = ResponseEntity.ok(service.findAll());
        }catch(Exception e){

        }
        return result;
    }


    @PostMapping("/search/paging/v1")
    public ResponseEntity<List<PostDTO>> findAllBySearchCondAndPagind(@RequestBody PostSearchDTO dto){
        ResponseEntity<List<PostDTO>> result = null;

        try{
            result = ResponseEntity.ok(service.findAllBySearchCondAndPaging(dto));
        }catch(Exception e){

        }
        return result;

    }



    @GetMapping("/v1/{postNum}")
    public ResponseEntity<PostDTO> findOneById(@PathVariable PostVODTO voDTO){
        ResponseEntity<PostDTO> result = null;

        try{
            result = ResponseEntity.ok(service.findOneById(voDTO));
        }catch(Exception e){
        }
        return result;
    }

    @PostMapping("/v1")
    public ResponseEntity<PostDTO> insertPost(@RequestBody PostDTO dto) throws Exception {
        ResponseEntity<PostDTO> result = null;
        try{
            result = ResponseEntity.ok(service.insertPost(dto));
        }catch(Exception e){
            throw new Exception(e);
        }
        return result;
    }

    @PutMapping("/v1")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO dto){
        ResponseEntity<PostDTO> result = null;

        try{
            result = ResponseEntity.ok(service.updatePost(dto));
        }catch(Exception e){

        }
        return result;
    }

    @DeleteMapping("/v1")
    public boolean deletePost(@RequestBody PostDTO dto){
        boolean result = false;

        try{
            result = service.deletePost(dto);
        }catch(Exception e){

        }
        return result;
    }

}
