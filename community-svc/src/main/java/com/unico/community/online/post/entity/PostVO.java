package com.unico.community.online.post.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class PostVO implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postNum;
    private String postCatgUuid;
    private long userNum;

    @Override
    public String toString() {
        return "PostVO{" +
                "postNum=" + postNum +
                ", postCatgUuid='" + postCatgUuid + '\'' +
                '}';
    }
}
