package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	//특정카테고리 공연정보
	public static final String SELECT_PAGING = "SELECT "
			+ " d.product_id"
			+ ",d.id		 	 AS displayInfoId"
			+ ",d.place_name"
			+ ",p.description 	 AS productDescription"
			+ ",p.content 		 AS productContent"
			+ ",f.save_file_name AS productImageUrl"
			+ " from product as p\n"
			+ "join product_image i on(i.product_id=p.id)\n "
			+ "join file_info 	  f on(i.file_id=f.id)\n"
			+ "join display_info  d on(d.product_id=p.id)\n"
			+ "WHERE p.CATEGORY_ID = :cate\n"
			+ "  AND i.type = 'th'\n"
			+ "ORDER BY p.id limit :start, :limit";
	
	//전체 공연정보리스트
	public static final String SELECT_PAGING_ALL = "SELECT "
			+ " d.product_id"
			+ ",d.id AS displayInfoId"
			+ ",d.place_name"
			+ ",p.description AS productDescription"
			+ ",p.content AS productContent"
			+ ",f.save_file_name AS productImageUrl"
			+ " from product as p\n"
			+ "join product_image i on(i.product_id=p.id)\n"
			+ "join file_info f on(i.file_id=f.id)\n"
			+ "join display_info d on(d.product_id=p.id)\n"
			+ "WHERE i.type= 'th'\n"
			+ "ORDER BY p.id limit :start, :limit";

	public static final String SELECT_COUNT = "SELECT count(*) FROM product WHERE CATEGORY_ID = :cate";
	public static final String SELECT_COUNT_ALL = "SELECT count(*) FROM product";
	
	//전시정보 한개 조회
	public static final String SELECT_BY_ID = "SELECT "
			+ " A.id AS displayInfoId"
			+ ",A.product_id"
			+ ",A.opening_hours"
			+ ",A.place_name"
			+ ",A.place_lot"
			+ ",A.place_street"
			+ ",A.tel AS telephone"
			+ ",A.homepage"
			+ ",A.email"
			+ ",A.create_date"
			+ ",A.modify_date "
			+ ",B.description 		AS productDescription "
			+ ",B.content 		AS productContent "
			+ ", C."
			+ "FROM display_info 					 AS A "
			+ "JOIN product 	 					 AS B ON B.id = A.product_id "
			+ "LEFT OUTER JOIN display_info_image	 AS B ON B.display_info_id = A.id "
			+ "LEFT OUTER JOIN file_info			 AS C ON C.id = B.file_id "
			+ "WHERE id = :displayInfoId ";

	// 전시정보 이미지 한 개 조회
	public static final String SELECT_ONE_DISPLAY_INFO_IMAGE = "SELECT "
			+ " B.content_type "
			+ ",B.create_date "
			+ ",B.delete_flag "
			+ ",B.file_name "
			+ ",A.display_info_id"
			+ ",A.id 			AS displayInfoImageId "
			+ ",B.id 			AS fileId"
			+ ",B.modify_date "
			+ ",B.save_file_name "
			+ "FROM display_info_image 	AS A "
			+ "JOIN file_info 			AS B ON B.id = A.file_id "
			+ "WHERE A.display_info_id = :displayInfoId";

	//한줄평 조회(3개까지)
	public static final String SELECT_COMMENT = "SELECT"
			+ " A.id					 	AS commentId"
			+ ",A.product_id				AS productId"				
			+ ",A.reservation_info_id   	AS reservationInfoId"  
			+ ",A.score               		AS score"              
			+ ",A.comment              		AS comment"            
			+ ",A.create_date           	AS createDate"         
			+ ",A.modify_date           	AS modifyDate"         
			+ ",B.reservation_name       	AS reservationName"    
			+ ",B.reservation_tel  			AS reservationTelephone"
			+ ",B.reservation_email      	AS reservationEmail"  
			+ ",B.reservation_date       	AS reservationDate"    
			+ " "
			+ " from reservation_user_comment 		 			AS A "
			+ "LEFT OUTER JOIN reservation_info 				AS B on(A.reservation_info_id = B.id) "
			+ "LEFT OUTER JOIN reservation_user_comment_image   AS C on(B.id = C.reservation_info_id) "
			+ "LEFT OUTER JOIN file_info 						AS D on(C.file_id = D.id)"

			+ "WHERE A.product_id = :productId "
			+ "ORDER BY A.create_date desc limit 1, :limit";
	
	public static final String SELECT_COMMENT_COUNT = "SELECT count(*) from reservation_user_comment";
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	static final String DELETE_BY_ID = "DELETE FROM display_info WHERE id = :id";
}