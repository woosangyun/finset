<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>koscom</title>
<%@ include file="/WEB-INF/include/headComm.jsp"%>
<script src="<c:url value="/script/jquery/jquery.animateNumber.min.js"/>"></script>
<script type="text/javascript">
</script>
</head>
<body class="bg-white">
<div id="wrapper" class="pop-full">
	<!-- Header -->
	<header id="header">
		<div class="input-group">
			<div class="input-group-btn">
				<button type="button" class="ui-nav nav-back" onclick="history.back();">뒤로가기</button>
			</div>
			<h1>고유식별정보처리 동의</h1>
			<button class="btn-header-close" onclick="history.back();">
				<span class="ico-close">닫기</span>
			</button>
		</div>
	</header>
	<!-- Content -->
	<div id="content">
		<div class="container">
			<div class="terms-body">
				<h1>통신사(에스케이텔레콤㈜, ㈜케이티, LGU플러스㈜) 귀중</h1>
				<p>본인은 이 상거래와 관련하여 귀사(이하 ‘회사’)가 휴대폰본인확인서비스(이하 ‘서비스’)를 제공하기 위하여 고유식별정보를 다음과 같이 제3자에게 제공 등 처리 하는 데에 동의합니다.</p>
				<ol>
					<li>
						<ol>
							<li>고유식별정보를 제공받는자<br>
								<p>에스케이텔레콤 : NICE평가정보(주), 서울신용평가정보(주)</p>
								<p>(주)케이티 : 코리아크레딧뷰로, 서울신용평가정보(주)</p>
								<p>LGU플러스 : 서울신용평가정보(주)</p>
							</li>
							<li>고유식별정보를 제공받는 자의 목적: 연계정보(CI)와 중복가입확인정보(DI)의 생성 및 ‘회사’ 제공</li>
							<li>고유식별정보: ‘회사’가 보유하고 있는 고객의 주민등록번호와 외국인등록번호</li>
							<li>고유식별정보를 제공받는 자의 보유 및 이용기간: 연계정보(CI) 및 중복가입확인정보(DI) 생성 후 즉시 폐기</li>
						</ol>
					</li>
					<p>※ 귀하는 동의를 거부할 권리가 있으나, 동의하지 않는 경우 ‘서비스’를 이용할 수 없습니다.</p>
				</ol>
				<h1>코리아크레딧뷰로㈜ 귀중</h1>
				<p>귀사가 에스케이텔레콤㈜, ㈜케이티, LGU플러스㈜ 등 통신사로부터 위탁 받아 제공하는 휴대폰본인확인서비스 이용과 관련하여, 본인의 개인정보를 수집•이용하고자 하는 경우 「개인정보보호법」 제17조, 제22조, 제24조, 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 제24조의2에 따라 제3자에게 제공할 경우 본인의 사전동의를 얻어야 합니다. 이에 귀사가 아래와 같이 본인의 고유식별정보를 처리하는 것에 동의 합니다.</p>
				<p>수집·이용 및 제공 목적</p>
				<ol>
					<li>정보통신망법 제23조의2 제2항에 따라 인터넷상에서 주민등록번호를 입력하지 않고도 본인임을 확인할 수 있는 휴대폰 본인인증 서비스를 제공하기 위해 고유식별정보를 이용</li>
					<li>'본인확인기관 지정 등에 관한 기준(방송통신위원회 고시)'에 따라 "회사"와 계약한 정보통신서비스 제공자의 연계서비스 및 중복가입확인을 위해 필요한 경우, 다른 본인확인기관이 아래의 고유식별정보를 제공받아 처리하기 위함.</li>
				</ol>
				<p>수집·이용 및 제공하는 고유식별정보 항목</p>	
				<ol>
					<li>주민등록번호(내국인)</li>
					<li>외국인등록번호(국내거주외국인)</li>
				</ol>
				<p>고유식별정보 보유 및 이용기간</p>	
				<p>고유식별정보의 수집•이용 및 제공 목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다.<br>
					다만, 전자상거래 등에서의 소비자보호에 관한 법률 등 관련법령의 규정에 의하여 일정기간 보유하여야 할 필요가 있을 경우에는 일정기간 보유합니다.
				</p>
				<p>- 계약 또는 청약철회 등에 관한 기록 : 5년</p>	
				<p>- 대금결제 및 재화등의 공급에 관한 기록 : 5년</p>	
				<p>- 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년</p>	
				<p>- 기타 다른 법률의 규정에 의하여 보유가 허용되는 기간</p>	
				<p>동의거부 및 거부 시 불이익</p>	
				<p>고유식별정보 수집·이용 및 제공에 대한 동의는 거부할 수 있으며, 동의 후에도 철회 가능합니다. 다만, 동의 거부 및 철회 시에는 서비스 이용이 제한될 수 있습니다.</p>	
			</div>	
		</div>
	</div>
	<!-- //Content -->
</div>
</body>
</html>
