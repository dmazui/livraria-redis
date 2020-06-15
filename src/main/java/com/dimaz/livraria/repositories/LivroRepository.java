package com.dimaz.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import com.dimaz.livraria.domain.models.Livro;

@Repository
@EnableRedisRepositories
public interface LivroRepository extends JpaRepository<Livro, String>{
//public interface LivroRepository extends CrudRepository<Livro, String>{

}
