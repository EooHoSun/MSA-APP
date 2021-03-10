package com.unico.community.online.post.dto;

import com.unico.community.online.postCatg.entity.PostCatgEntity;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class PostDTO {

    private PostVODTO postVO;
    private long userNum;
    private String postTitle;
    private String postContents;
    private boolean postUseYn;


}
