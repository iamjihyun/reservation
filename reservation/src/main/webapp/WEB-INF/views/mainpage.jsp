<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description"
	content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">

<title>네이버 예약</title>
<link
	href="<%=request.getContextPath()%>/resources/reservation.v1.5/resevation-html-base/style.css"
	rel="stylesheet">
</head>

<body>

	<div id="container">
		<div class="header">
			<header class="header_tit">
				<h1 class="logo">
					<a href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span
						class="spr_bi ico_n_logo">네이버</span>
					</a> <a href="./myreservation.html" class="lnk_logo" title="예약"> <span
						class="spr_bi ico_bk_logo">예약</span>
					</a>
				</h1>
				<a href="./bookinglogin.html" class="btn_my"> <span
					class="viewReservation" title="예약확인">예약확인</span>
				</a>
			</header>
		</div>
		<hr>



		<div class="event">
			<div class="section_visual">
				<div class="group_visual">
					<div class="container_visual">
						<div class="prev_e" style="display: none;">
							<div class="prev_inn">
								<a href="#" class="btn_pre_e" title="이전"> <i
									class="spr_book_event spr_event_pre">이전</i>
								</a>
							</div>
						</div>
						<div class="nxt_e" style="display: none;">
							<div class="nxt_inn">
								<a href="#" class="btn_nxt_e" title="다음"> <i
									class="spr_book_event spr_event_nxt">다음</i>
								</a>
							</div>
						</div>
						<div>
							<div class="container_visual">
								<!-- 슬라이딩기능: 이미지 (type = 'th')를 순차적으로 노출 -->
								<ul class="visual_img">
								</ul>
							</div>
							<span class="nxt_fix" style="display: none;"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="section_event_tab">
				<ul class="event_tab_lst tab_lst_min" data-current-category="0">
					<li class="item" data-category="0">
						<a class="anchor active">
							<span>전체리스트</span>
						</a>
					</li>
					<li class="item" data-category="1"><a class="anchor"> <span>전시</span>
					</a></li>
					<li class="item" data-category="2"><a class="anchor"> <span>뮤지컬</span>
					</a></li>
					<li class="item" data-category="3"><a class="anchor"> <span>콘서트</span>
					</a></li>
					<li class="item" data-category="4"><a class="anchor"> <span>클래식</span>
					</a></li>
					<li class="item" data-category="5"><a class="anchor"> <span>연극</span>
					</a></li>
					<!-- li class="item" data-category="7">
                        <a class="anchor"> <span>클래스</span> </a>
                    </li>
                    <li class="item" data-category="8">
                        <a class="anchor"> <span>체험</span> </a>
                    </li>
                    <li class="item" data-category="9">
                        <a class="anchor last"> <span>키즈</span> </a>
                    </li -->
				</ul>
			</div>
			
			<div class="section_event_lst">
				<p class="event_lst_txt">바로 예매 가능한 행사가 <span class="data_count pink">0개</span> 있습니다	</p>
				<div class="wrap_event_box">
					<!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
					<ul class="lst_event_box">
					</ul>

					<ul class="lst_event_box">
					</ul>

					<!-- 더보기 -->
					<div class="more">
						<button class="btn moreBtn" data-current-page="1" onclick="clickMoreBtn(this);">
							<span>더보기</span>
						</button>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<footer>
		<div class="gototop">
			<a href="#" class="lnk_top" onClick="javascript:window.scrollTo(0,0)"><span class="lnk_top_text" onClick="javascript:window.scrollTo(0,0)">TOP</span>
			</a>
		</div>
		<div class="footer">
			<p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및
				환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
			<span class="copyright">© NAVER Corp.</span>
		</div>
	</footer>


	<script>	
	function clickMoreBtn(target){
		console.log("-----더보기버튼 클릭 메소드-----");
		//현재 카테고리Id
		var categoryId = document.querySelector(".event_tab_lst").currentCategory;
		
		//현재 페이지
		var start = target.currentPage;
		sendAjax(categoryId,start);
	}
	
	
	//ajax로 가져온 데이터 화면에 그리기
 	function makeTemplate(data, moreNum) {
		// 템플릿 가져오기.
	    var html = document.getElementById("itemList").innerHTML;
		
		// 화면에 그릴 공간 가져오기.
	    var lst_event_box = document.querySelectorAll(".lst_event_box");
		var currentPage = document.querySelector(".moreBtn").currentPage;
		if(currentPage == 2){
			
		}
	    lst_event_box[0].innerHTML = "";
	    lst_event_box[1].innerHTML = "";		
	    
	    //////////////makeTemplate html초기화되는 부분 분리해서 쓸 것.
	    // 화면에 뿌리기.
		for (var i = 0; i < data.list.items.length; i++) {
 	       var resultHTML = html.replace("{displayInfoId}", data.list.items[i].displayInfoId)
						        .replace("{productDescription}", data.list.items[i].productDescription)
						        .replace("{fileName}", data.list.items[i].fileName)
						        .replace("{productContent}", data.list.items[i].productContent)
						        .replace("{placeName}", data.list.items[i].placeName)
					 	        .replace("{productImageUrl}", data.list.items[i].productImageUrl);
	       
	       lst_event_box[i % 2].innerHTML += resultHTML;
	    }
	    
	    var count =document.querySelector(".data_count"); 
	console.log("count : " + count.innerHTML);
	  //카운트도 가져와서 적용
		document.querySelector(".data_count").innerHTML=data.list.totalCount+"개";
	}
	
	
	// 페이징 or 더보기버튼을 전역으로 안쓰는 방법이 있는지 궁금 -> data attribute써야하는 것 같음
	function sendAjax(categoryId=0, start=1){

		var url = "api/products";
		var start2 = start;
		var categoryId2 = categoryId;
		var oReq = new XMLHttpRequest();
		
		console.log("-----ajax 메소드-----");
		console.log("카테고리Id : " + categoryId2);
		console.log("현재페이지 : " + start2);
		
 		oReq.addEventListener("load", function() {
			// ajax로 DB갔다옴. & 가져온 데이터 담기.
			var data = JSON.parse(oReq.responseText);
		    console.log(data);
		    
		    // 카테고리, 페이지 갱신
		    var newCate = document.querySelector(".event_tab_lst");
		    newCate.currentCategory = categoryId2;
		    console.log("갱신된 카테고리Id: " + document.querySelector(".event_tab_lst").currentCategory);
		    
		    var newPage = document.querySelector(".moreBtn");
		    newPage.currentPage = start2 + 1;
		    console.log("갱신된 현재 페이지 : " + document.querySelector(".moreBtn").currentPage);
		    
		    makeTemplate(data);
		 });
 		
		   oReq.open("GET", "api/products?categoryId=" + categoryId2 + "&start=" + start2);
		   oReq.send();
	}

	window.onload = function(){
		//첫페이지 로딩
		sendAjax();
	}

	
    // 함수를 제외한 전역변수들은 다 onload함수 안에
    var clickedCategoryName = document.querySelector(".event_tab_lst");
    clickedCategoryName.addEventListener("click", function (evt) {
        
        // 모든 카테고리 색초기화
    	var cateList = document.querySelectorAll(".anchor");
        cateList.forEach(function(element){
        	element.classList.remove("active");
        });
    	
    	// 델리게이션 적용 & 카테고리 색깔 변경
        // 데이터셋 카테고리 번호 가져오기 
        var target2 = evt.target;
        var categoryId = "";
        
        // 태그 순서 : ul -> li -> a -> span
        if (target2.tagName === "A") {
            console.log("a의 부모태그 li : " + target2.parentNode.dataset.category);            
            categoryId = target2.parentNode.dataset.category;
            
            //컬러변경
            target2.classList.add('active');
            
        } else if (target2.tagName === "SPAN") {
            //console.log("SPAN의 부모태그 li : " + target2.parentNode);
            //console.log("SPAN의 부모태그 li : " + target2.parentElement);
            console.log("SPAN의 부모부모태그 li : " + target2.parentNode.parentNode.dataset.category);
            categoryId = target2.parentNode.parentNode.dataset.category;
            
            //컬러변경
            target2.parentNode.classList.add('active');           
            
        } else if(target2.tagName === "LI"){
            console.log("li 태그 : " + target2.dataset.category);
            categoryId = target2.dataset.category;
            
            //컬러변경****어려움...자식은 여러명일 수 있어서 확실히 선택해주어야 함.
            target2.children[0].classList.add('active');     
        }
        console.log("-----카테고리 클릭 메소드-----");
        console.log("클릭된 카테고리 값 : " + categoryId);
        sendAjax(categoryId, 1);
    });
</script>


	<script type="rv-template" id="promotionItem">
    <li class="item" style="background-image: url(http://localhost:8800/reservation/resources/reservation.v1.5/img/1_ma_2.png);">
        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
            <div class="event_txt">
                <h4 class="event_txt_tit"></h4>
                <p class="event_txt_adr"></p>
                <p class="event_txt_dsc"></p>
            </div>
        </a>
    </li>
    </script>

	<script type="rv-template" id="itemList">
        <li class="item">
            <a href="detail" class="item_book">
                <div class="item_preview">
                    <img alt="{displayInfoId}" class="img_thumb" src="http://localhost:8800/reservation/resources/reservation.v1.5/{productImageUrl}">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>{productDescription}</span> <small class="sm">{placeName}</small> </h4>
                    <p class="event_txt_dsc">{productContent}</p>
                </div>
            </a>
        </li>
    </script>

</body>
</html>
