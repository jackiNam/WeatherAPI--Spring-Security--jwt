package com.java.namle.weatherAPI.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.java.namle.weatherAPI.dao.CityDao;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Repository
@Transactional
public class CityDaoImpl implements CityDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(City city) {
		entityManager.persist(city);

	}

	@Override
	public void update(City city) {
		entityManager.merge(city);

	}

	@Override
	public void delete(City city) {
		entityManager.remove(city);

	}

	@Override
	public City getById(Long id) {

		return entityManager.find(City.class, id);
	}

	@Override
	public List<City> findCity(SearchDTO searchDTO) {
		// criteriaBuilder giúp tạo ra đối tượng chứa câu lệnh truy vấn CriteriaQuery
		// và cung cấp cơ số các phép biến đổi, phép logic, điều kiện cho câu lệnh (and,
		// or, not, avg, greater than,v.v...)
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// khai báo đối tượng bạn muốn lấy ra sau khi thực hiện query - tương ứng chữ
		// trong ngoặc Select "city" From...
		CriteriaQuery<City> query = criteriaBuilder.createQuery(City.class);

		// khai báo đối tượng bạn sẽ sử dụng trong query - tương ứng đối tượng sau mệnh
		// đề From "City c"
		Root<City> root = query.from(City.class);

		// Predicate là một mệnh đề điều kiện trong câu lệnh truy vấn.
		// Dùng list để sau có thể thêm nhiều predicate các thuộc tính tìm kiếm khác 
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (StringUtils.isNotBlank(searchDTO.getName())) {

			Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + searchDTO.getName().toLowerCase() + "%");
			predicates.add(criteriaBuilder.or(predicate));
		}
		if ( searchDTO.getId()!= null) {
			Predicate predicate = criteriaBuilder.equal(root.get("idCity"), searchDTO.getId());
			predicates.add(predicate);
		}
		 if (StringUtils.isNotBlank(searchDTO.getFromDate())) {
	            try {
	                Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate"),
	                        DateTimeUtils.parseDate(searchDTO.getFromDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
	                predicates.add(criteriaBuilder.or(predicate));
	            } catch (RuntimeException ignored) {

	            }
	        }
	        if (StringUtils.isNotBlank(searchDTO.getToDate())) {
	            try {
	                Predicate predicate = criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"),
	                        DateTimeUtils.parseDate(searchDTO.getToDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
	                predicates.add(criteriaBuilder.or(predicate));
	            } catch (RuntimeException ignored) {

	            }
	        }
		query.where(predicates.toArray(new Predicate[]{}));
		TypedQuery<City> typedQuery = entityManager.createQuery(query.select(root).distinct(true));
		
		return typedQuery.getResultList();
	}

}
