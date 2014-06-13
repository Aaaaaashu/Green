<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Green">
  <meta name="author" content="orangehat">

  <c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

  <link href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="${path}/css/ihover.min.css" rel="stylesheet">
  <link href="${path}/css/style.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <title>Green</title>
</head>
<body style="background: url(${path}/images/background.png);">
  <%@ include file="header.jsp"%>

  <div class="card card-1">
    <div class="ih-item circle  effect13 top_to_bottom">
	  <a href="<c:url value="/board/listBoardTopics-1.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/cerasus.jpg">
		</div>
		<div class="info-back">
		  <div class="info">
		    <h3>櫻花</h3>
			<p>進入社區</4>
		  </div>
		</div> 
	  </a>
	</div>
	<div class="card-content">
	  <h3>櫻花</h3>
	  <span>
	    樱花（學名：Cerasus），屬於蔷薇科李属(或於部分分類法上更細分的櫻亞屬或櫻屬並具備長花梗的組或節等分類)之物種的花。在日本廣為種植，在現代被日本人視作日本的精神象徵。奈良縣吉野山的櫻花最為聞名，故被譽為“吉野千棵櫻”。
		<br> <br>
		櫻花的花期很短，盛開一周之後，便紛紛飄落，春風徐來時，落下一陣陣櫻花的雨。所以日本人用櫻花短暫而燦爛的生命來比喻武士道精神，說：“花為櫻木，人則武士”。
	  </span>
	</div>
  </div>

  <div class="card card-2">
    <div class="card-content">
	  <h3>滿天星</h3>
	  <span> 
	    滿天星（學名：Gypsophila），俗名「Baby’s Breath」，為常綠矮生小灌木，
		每當初夏無數的花蕾集結於枝頭，花細如豆，每朵5瓣，潔白如雲，略有微香，猶如萬星閃耀，滿掛天邊。 <br> <br>
		花語：思念、關懷、清純、夢境、真心喜歡、配角，但不可缺。 
	  </span>
	</div>
	<div class="ih-item circle colored effect19">
	  <a href="<c:url value="/board/listBoardTopics-2.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/baby-breath.jpg">
		</div>
		<div class="info">
		  <h3>滿天星</h3>
		  <p>進入社區</p>
		</div> 
	  </a>
	</div>
  </div>

  <div class="card card-3">
    <div class="ih-item circle effect10 bottom_to_top">
      <a href="<c:url value="/board/listBoardTopics-3.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/daisy.jpg">
		</div>
		<div class="info">
		  <h3>雛菊</h3>
		  <p>進入社區</p>
		</div> 
	  </a>
    </div>
	<div class="card-content">
	  <h3>雛菊</h3>
	  <span> 
	    雛菊（學名：Bellis perennis）是菊科植物的一種，別名長命菊、延命菊，原產於歐洲，原種被視為叢生的雜草，開花期在春季。
		雛菊在原產地是多年生草本植物，但在日本由於夏季炎熱，雛菊多半活不過夏季，通常被當作秋天播種的一年生植物。 <br> <br>
		花語：純潔的美、天真、和平、希望以及「深藏在心底的愛」。 
	  </span>
	</div>
  </div>

  <div class="card card-4">
    <div class="card-content">
	  <h3>馬蹄蓮</h3>
	  <span> 
	    台灣所說的海芋是指馬蹄蓮。 海芋或稱姑婆芋（學名：Alocasia macrorrhizos），英文俗稱Calla Lily,
		原產南美洲，是一種常見的觀賞植物，有多個俗稱，如，痕芋頭、狼毒(廣東)、野芋頭、山芋頭、大根芋、大蟲芋、天芋、天蒙，作為觀賞植物時則稱其為滴水觀音，這是因為如果環境濕度過大，會從它闊大的葉片上往下滴水，其花是肉穗花序，外有一大型綠色佛焰苞，開展成舟型，如同觀音座像。
		<br> <br> 
		花語： 志同道合、誠意、有意思、內蘊清秀 
	  </span>
	</div>
	<div class="ih-item circle effect6 scale_up">
	  <a href="<c:url value="/board/listBoardTopics-4.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/calla.png">
	    </div>
		<div class="info">
		  <h3>馬蹄蓮</h3>
		  <p>進入社區</p>
		</div> 
	  </a>
	</div>
  </div>

  <div class="card card-5">
    <div class="ih-item circle effect17">
	  <a href="<c:url value="/board/listBoardTopics-5.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/rose.jpg">
		</div>
		<div class="info">
		  <h3>薔薇</h3>
		  <p>進入社區</p>
		</div> 
	  </a>
	</div>
	<div class="card-content">
	  <h3>蔷薇</h3>
	  <span> 
	    薔薇（學名：Rosa multiflora），又称野蔷薇，是一種蔓藤爬籬笆的小花，耐寒，有野生的，可以藥用。英語Multiflora Rose、Baby
		Rose、Rambler Rose。 <br> <br>
		玫瑰、月季和薔薇都是薔薇屬植物，之間有種類上的區別，沒有科屬上的差異。在漢語中人們習慣把花朵直徑大、單生的品種稱為玫瑰或月季，小朵叢生的稱為薔薇。但在英語中它們均稱為rose。
	  </span>
	</div>
  </div>
	
  <%@ include file="footer.jsp"%>
  
  <script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
