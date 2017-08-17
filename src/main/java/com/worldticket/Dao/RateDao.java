package com.worldticket.Dao;

import org.springframework.data.repository.CrudRepository;

import com.worldticket.domain.Rate;

public interface RateDao extends CrudRepository<Rate,Long>{

	Rate findByCountry(String country);
}
