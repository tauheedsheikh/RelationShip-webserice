package com.alzohar.relationship.webservice.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alzohar.relationship.webservice.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
