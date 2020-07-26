package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CheckList;

public interface CheckListRepository extends JpaRepository<CheckList, Integer>{

}
