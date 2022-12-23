package com.example.countryproject.repository;

import com.example.countryproject.entity.Country;
import com.example.countryproject.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository  extends CrudRepository<Question, Long> {
    List<Question> findAllByCountryId(long Id);
}
