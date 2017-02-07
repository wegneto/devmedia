package com.wegneto.madlibs.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wegneto.madlibs.model.BaseModel;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends PagingAndSortingRepository<T, Long> {

}
