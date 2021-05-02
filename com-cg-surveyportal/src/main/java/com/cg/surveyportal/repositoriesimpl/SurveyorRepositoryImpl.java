package com.cg.surveyportal.repositoriesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.repositories.ISurveyorRepository;

public class SurveyorRepositoryImpl implements ISurveyorRepository {

	@Override
	public List<Surveyor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Surveyor> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Surveyor> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}
	@Override
	public <S extends Surveyor> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteInBatch(Iterable<Surveyor> entities) {
		// TODO Auto-generated method stub

	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}
	@Override
	public Surveyor getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Surveyor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Surveyor> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(Surveyor entity) {
		// TODO Auto-generated method stub

	}
	@Override
	public void deleteAll(Iterable<? extends Surveyor> entities) {
		// TODO Auto-generated method stub

	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
	@Override
	public <S extends Surveyor> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Surveyor> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends Surveyor> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Surveyor findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
