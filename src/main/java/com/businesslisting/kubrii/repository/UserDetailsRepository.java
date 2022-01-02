package com.businesslisting.kubrii.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.businesslisting.kubrii.entity.UserDetail;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetail , Integer> {
}

