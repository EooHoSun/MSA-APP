package com.unico.community.online.postCatg.service;

import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import com.unico.community.online.postCatg.repository.PostCatgMapper;
import com.unico.community.online.postCatg.repository.PostCatgRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@AllArgsConstructor
public class PostCatgService {

    private final PostCatgMapper mapper;
    private final PostCatgRepository repository;

    public List<PostCatgDTO> findAll(){
        return repository
                .findAll()
                .stream()
                .map(mapper::toPostCatgDTO)
                .collect(Collectors.toList());
    }

    public PostCatgDTO createPostCatg( PostCatgDTO dto){

        PostCatgEntity entity = PostCatgEntity.builder()
                                .postCatgNm(dto.getPostCatgNm())
                                .postCatgUseYn(true)
                                .postCatgUuid(UUID.randomUUID().toString())
                                .regnNm(dto.getRegnNm())
                                .build();

        return mapper.toPostCatgDTO(repository.save(entity));
    }

    public PostCatgDTO updatePostCatg(PostCatgDTO dto){
        PostCatgEntity entity = repository.findById(dto.getPostCatgUuid()).orElse(null);
        entity.update(dto);
        return mapper.toPostCatgDTO(entity);
    }

    public Boolean deletePostCatg(PostCatgDTO dto){
        repository.deleteById(dto.getPostCatgUuid());
        return !repository.existsById(dto.getPostCatgUuid());
    }
}
