package com.unico.community.online.post.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.unico.community.online.BaseVO;
import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor
@Entity
@Getter
@Builder
@Table(name = "TB_POST_M")
public class PostEntity extends BaseVO {

    @EmbeddedId
    @Column(unique = true, nullable = false)
    private PostVO postVO;


    @ManyToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumn(name="postCatgUuid", referencedColumnName = "postCatgUuid", insertable = false, updatable = false)
    private PostCatgEntity postCatgEntity;


    public void setPostCatgEntity(PostCatgEntity postCatgEntity){
        if( postCatgEntity != null )
            postCatgEntity.getPostList().remove(this);

        this.postCatgEntity = postCatgEntity;
        this.postCatgEntity.getPostList().add(this);//양방향 관계설정
    }


    private String postTitle;
    private String postContents;
    @ColumnDefault("true")
    private boolean postUseYn;


    public void update(PostDTO dto){

        if(!dto.getPostContents().equals("") && !this.postContents.equals(dto.getPostContents())){
            this.postContents = dto.getPostContents();
        }

        if(!dto.getPostTitle().equals("") && !this.postTitle.equals(dto.getPostTitle())){
            this.postTitle = dto.getPostTitle();
        }

        if(this.isPostUseYn() != dto.isPostUseYn()){
            this.postUseYn = dto.isPostUseYn();
        }

        this.updatedAt = updatedAt.now();

    }



    @Override
    public String toString() {
        return "PostEntity{" +
                "postVO=" + postVO +
                ", postCatgEntity=" + postCatgEntity +
                ", postTitle='" + postTitle + '\'' +
                ", postContents='" + postContents + '\'' +
                ", postUseYn=" + postUseYn +
                '}';
    }
}


