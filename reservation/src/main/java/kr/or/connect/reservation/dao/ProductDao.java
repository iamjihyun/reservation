package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

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

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {
	 private final NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	 private RowMapper<DisplayInfo> rowMapper2 = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	 private RowMapper<DisplayInfoImage> disInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	 private RowMapper<Comment> commentRowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	 
	 public ProductDao(DataSource dataSource) {
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
		
		if(cate == 0) {
			return jdbc.query(SELECT_PAGING_ALL, params, rowMapper);
		}else {
			params.put("cate", cate);
			return jdbc.query(SELECT_PAGING, params, rowMapper);	
		}
		
	}
	
	//메인-리스트 수 조회
	public int selectCount(Integer cate) {
		Map<String, ?> params = Collections.singletonMap("cate", cate);
		if(cate == 0) {
			return jdbc.queryForObject(SELECT_COUNT_ALL, params, Integer.class);
		}else {
			return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
		}
	}

	//전시정보 한 개 조회
	public DisplayInfo selectOneDisplayInfo(int displayInfoId) {
		Map<String, ?> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper2);
	}
	
	//한줄평 리스트 조회
	public List<Comment> selectCommentList(int productId, int commentLimit) {
		Map<String,Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("limit", commentLimit);
		return jdbc.query(SELECT_COMMENT, params, commentRowMapper);
	}
	

	public int getCommentListCount(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public DisplayInfoImage selectOneDisplayInfoImage(int displayInfoId) {
		Map<String, ?> params = Collections.singletonMap("displayInfoId", displayInfoId);
		return jdbc.queryForObject(SELECT_ONE_DISPLAY_INFO_IMAGE, params, disInfoImageRowMapper);
	}
	
	
	
	/////////////////////////////////////
	//한개 지우기
	public int deleteById(int id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}

	//한개 추가
	public int insert(Product p) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(p);
		return insertAction.executeAndReturnKey(params).intValue();
	}

}
