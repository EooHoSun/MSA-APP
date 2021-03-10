package com.unico.community.online;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

public abstract class BaseVO {

    @Column
    @CreationTimestamp
    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();
    @Column
    @UpdateTimestamp
    protected LocalDateTime updatedAt;

}
