package com.Jobportal.Jobportal.Reppo;

import com.Jobportal.Jobportal.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepo extends JpaRepository<Info,Integer> {
}
