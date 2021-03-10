package com.unico.community.online.post.dto;

import com.unico.community.online.PageVO;
import lombok.Data;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Data
public class PostSearchDTO extends PageVO {

    private String postCatgUuid;
    private String userNm;
    private String postTitle;
    private String postContents;



}
