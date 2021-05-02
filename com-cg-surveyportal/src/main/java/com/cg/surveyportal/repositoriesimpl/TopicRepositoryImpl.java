package com.cg.surveyportal.repositoriesimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.cg.surveyportal.entities.Topic;
import com.cg.surveyportal.repositories.ITopicRepository;

/**
 * Implement all unimplemented methods of ITopicRepository
 */
public class TopicRepositoryImpl implements ITopicRepository {

	@Override
	public List<Topic> findByName(String name) {
		return null;
	}
	@Override
	public Optional<Topic> findById(Long id) {
		return null;
	}
	@Override
	public void deleteById(Long id) {
	}
	@Override
	public long count() {
		return 0;
	}
	@Override
	public List<Topic> findAll() {
		return null;
	}
	@Override
	public List<Topic> findAll(Sort sort) {
		return null;
	}
	@Override
	public List<Topic> findAllById(Iterable<Long> ids) {
		return null;
	}
	@Override
	public <S extends Topic> List<S> saveAll(Iterable<S> entities) {
		return null;
	}
	@Override
	public void flush() {
	}
	@Override
	public <S extends Topic> S saveAndFlush(S entity) {
		return null;
	}
	@Override
	public void deleteInBatch(Iterable<Topic> entities) {
	}
	@Override
	public void deleteAllInBatch() {
	}
	@Override
	public Topic getOne(Long id) {
		return null;
	}
	@Override
	public <S extends Topic> List<S> findAll(Example<S> example) {
		return null;
	}
	@Override
	public <S extends Topic> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}
	@Override
	public Page<Topic> findAll(Pageable pageable) {
		return null;
	}
	@Override
	public <S extends Topic> S save(S entity) {
		return null;
	}
	@Override
	public boolean existsById(Long id) {
		return false;
	}
	@Override
	public void delete(Topic entity) {
	}
	@Override
	public void deleteAll(Iterable<? extends Topic> entities) {
	}
	@Override
	public void deleteAll() {
	}
	@Override
	public <S extends Topic> Optional<S> findOne(Example<S> example) {
		return null;
	}
	@Override
	public <S extends Topic> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}
	@Override
	public <S extends Topic> long count(Example<S> example) {
		return 0;
	}
	@Override
	public <S extends Topic> boolean exists(Example<S> example) {
		return false;
	}
}
