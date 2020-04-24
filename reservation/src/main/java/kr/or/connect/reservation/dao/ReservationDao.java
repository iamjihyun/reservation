package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.DELETE_BY_ID;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.SELECT_COUNT;
import static kr.or.connect.reservation.dao.ReservationDaoSqls.SELECT_PAGING;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;

@Repository
public class ReservationDao {
	 private NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	 
	 public ReservationDao(DataSource dataSource) {
	        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	        this.insertAction = new SimpleJdbcInsert(dataSource)
	                .withTableName("product")
	                .usingGeneratedKeyColumns("id");
	    }
	//전체 조회
	public List<Product> selectAll(Integer start, Integer limit, Integer cate) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		params.put("cate", cate);
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	//한개 추가
	public int insert(Product p) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(p);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	//한개 지우기
	public int deleteById(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	//데이터 몇 갠지?
	public int selectCount(Integer cate) {
		Map<String, ?> params = Collections.singletonMap("cate", cate);
		return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
	}

}
