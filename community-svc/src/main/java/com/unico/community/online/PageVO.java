package com.unico.community.online;

import com.querydsl.core.types.OrderSpecifier;
import lombok.Builder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * paging 처리를 위한 VO 객체 ( paging 처리를 위한 DTO class 에서 extends 필요 )
 */
public class PageVO {
    @Builder.Default
    int page = 1;
    @Builder.Default
    int size = 0;
    @Builder.Default
    Sort sort = Sort.unsorted();

    public Pageable getPageable(){
        return PageRequest.of(this.page, this.size, this.sort);
    }
    public OrderSpecifier[] getOrderArr(){ return this.sort.stream().toArray(OrderSpecifier[]::new);}
}
