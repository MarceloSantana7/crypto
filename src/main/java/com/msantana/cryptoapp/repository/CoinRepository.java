package com.msantana.cryptoapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.msantana.cryptoapp.dto.CoinTransationDTO;
import com.msantana.cryptoapp.entity.Coin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@EnableAutoConfiguration
public class CoinRepository {

	@Autowired
	private EntityManager entityManager;

	@Transactional	
	public Coin insert(Coin coin) {
		entityManager.persist(coin);
		return coin;
	}
	
	@Transactional
	public Coin update(Coin coin) {
		entityManager.merge(coin);
		return coin;
	}

	public List<CoinTransationDTO> getAll() {
		String jpql = "select new com.msantana.cryptoapp.dto.CoinTransationDTO(c.name,sum(c.quantity)) from Coin c group by c.name";
		TypedQuery<CoinTransationDTO> query = entityManager.createQuery(jpql, CoinTransationDTO.class);
		return query.getResultList();
	}

//	public List<Coin> getByName(String name) {
//		Object[] attr = new Object[] { name };
//		return jdbcTemplate.query(SELECT_BY_NAME, new RowMapper<Coin>() {
//			@Override
//			public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Coin coin = new Coin();
//				coin.setId(rs.getInt("id"));
//				coin.setName(rs.getString("name"));
//				coin.setPrice(rs.getBigDecimal("price"));
//				coin.setQuantity(rs.getBigDecimal("quantity"));
//				coin.setDateTime(rs.getTimestamp("datetime"));
//
//				return coin;
//			}
//		}, attr);
//	}

//	public int remove(int id) {
//		return jdbcTemplate.update(DELETE, id);
//	}
//
	
}
