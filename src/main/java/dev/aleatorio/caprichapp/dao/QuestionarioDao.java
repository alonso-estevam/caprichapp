package dev.aleatorio.caprichapp.dao;

import java.util.List;

import dev.aleatorio.caprichapp.model.Questionario;

public interface QuestionarioDao {
	
	List<Questionario> findAll();
	
	Questionario findById(Integer id);
	
	void insert(Questionario questionario);
	
    void update(Integer id, Questionario questionario);
    
    void deleteById(Integer id);
	
}
