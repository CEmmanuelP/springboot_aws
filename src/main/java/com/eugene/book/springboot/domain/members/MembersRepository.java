package com.eugene.book.springboot.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members, Long>{

    Optional<Members> findByName(String name);

}