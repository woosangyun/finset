var userAgent; // 모바일 OS 구분 /** * 모바일 OS 구분  * This function either returns 'iOS', 'Android' or 'unknown' * * @returns {String} */function getMobileOperatingSystem() {	var userAgent = navigator.userAgent || navigator.vendor || window.opera;	if(userAgent.match(/iPad/i) || userAgent.match(/iPhone/i) || userAgent.match(/iPod/i)) {		return 'iOS';	} else if(userAgent.match(/Android/i)) {		return 'Android';	} else {		return 'unknown';	}}$(function(){	userAgent = getMobileOperatingSystem();		// ios a, button 태그 이벤트	$('body *').on('touchstart', function (){});	    // Tab    $(".tabs a").click(function(e){        e.preventDefault();        $(this).tab('show');        $(document).scrollTop(0);    });        // loan select    $(".loan-block > .loan-product").each(function(i, e){    	$(this).click(function(){    		$(".loan-block > .loan-product").not(this).each(function(i, e){    			$(this).removeClass("active");    		});;    		$(this).addClass("active");    		//$(this).toggleClass("active");    	});    });        //affix    $(".affix-fixed").each(function(){    	if ( $(this) ){    		$('body').affix({    			offset: {    				top: 1    			}    		});    		    	}    });        // mask    if ( !$("#mask").length > 0 ) {        $("#wrapper").after("<div id='mask'></div>");	}    		var body = $("body"),	    wrapper = $("#wrapper"),	    isOpen = false;	    	function flag() {	    if( isOpen ) {	        body.removeClass('swipe');	    } else {	        body.addClass('swipe');	    }	    isOpen = !isOpen;	}		// selectpicker	$('.selectpicker').on('show.bs.select', function (e) {		flag();	});	$('.selectpicker').on('hide.bs.select', function (e) {		flag();	});	$(".selectbox").selectpicker();		// collapse	$(".collapse").on('show.bs.collapse', function (e) {		$(this).siblings("[data-toggle='collapse'], .panel-heading").addClass("active");		//console.log("show");	});	$(".collapse").on('hide.bs.collapse', function (e) {		$(this).siblings("[data-toggle='collapse'], .panel-heading").removeClass("active");		//console.log("hide");	});		// 탭 활성화 표시 모션	var actWidth = $(".tabs .active > a").innerWidth(),		actPosition = $(".tabs .active > a").position();		if(actWidth != null) {		$(".tabs").append("<div class='pseudo-bar'></div>");				$(".pseudo-bar").css({			"width": actWidth,			"left": actPosition.left		});				$(".tabs a").click(function() {			var width = $(this).innerWidth(),				position = $(this).position();							$(".pseudo-bar").css({				"width": width,				"left": position.left			});		});	}		// 하단고정버튼이 있는 경우	if (($("#menu-fixed-bottom").is(":visible")===true)||($(".btn-fixed-bottom").is(":visible")===true) ){		$("#content").css("padding-bottom","64px");	}});// 스크롤 하단 버튼 노출 및 하단 고정 버튼 활성화$(window).scroll(function(){	// var scrollTop = $(this).scrollTop();	// if( scrollTop >= 10 ) {	// 	$(".btn-fixed-bottom").addClass("affix-bottom");	// } else if ( $("input:checkbox[name='goods_choice']:checked").length > 0 ) {	//	// } else {	// 	$(".btn-fixed-bottom").removeClass("affix-bottom");	// }});//스크롤 시 내용 숨김$(window).scroll(function(){	var scrollTop = $(this).scrollTop();	if( scrollTop >= 10 ) {		$('.scroll-toggle').slideUp();	} else {		$('.scroll-toggle').slideDown();	}});function affixBottom(flag) {    // alert('affixBottom');	var active = {};	active = {		show: function() {            $('.btn-fixed-bottom').addClass("affix-bottom");		},		hide: function() {			$('.btn-fixed-bottom').removeClass("affix-bottom");		}	};    enableBottom("false");    if(flag == 'show') {        // alert('affixBottom.active.show():1');		active.show();        // alert('affixBottom.active.show():2');	} else if(flag == 'hide'){        // alert('affixBottom.active.hide():1');        active.hide();        // alert('affixBottom.active.hide():2');	}	active[flag]();}function enableBottom(flag) {    // alert('enableBottom');	var active = {};	active = {		enabled: function() {			$('.btn-fixed-bottom').find(".btn-disabled").addClass("btn-primary");		},		disabled: function() {			$('.btn-fixed-bottom').find(".btn-disabled").removeClass("btn-primary");		}	};	 if(flag == 'true') {        // alert('affixBottom.active.show():1');		active.enabled();        // alert('affixBottom.active.show():2');	} else if(flag == 'false'){        // alert('affixBottom.active.hide():1');        active.disabled();        // alert('affixBottom.active.hide():2');	}	// active[flag]();}//modal$("#popModal").on("show.bs.modal", function (event) {    var button = $(event.relatedTarget),        title = button.data("whatever"),        url = button.data("url"),        modal = $(this);        if ( title === false ) {    	$(".modal-header").hide();    } else {    	$(".modal-header").show();        modal.find(".modal-title").text(title);            	    }    modal.find(".modal-body-block").load(url);});//alertfunction alertMsg(text) {	if ( text !== undefined ) {		// 메시지만 바뀌는 경우		$("#alertMsg").modal("show");		$("#alertText").html(text);	} else {		$("#alertMsg").modal("show");		// 콘텐츠가 여러 형태의 경우 url로 불러옴-개발환경에 맞게 수정		//$("#alertContent").load(url);	}}function updateMsg(text) {	if ( text !== undefined ) {		// 메시지만 바뀌는 경우		$("#updateMsg").modal("show");		$("#updateText").html(text);	} else {		$("#updateMsg").modal("show");		// 콘텐츠가 여러 형태의 경우 url로 불러옴-개발환경에 맞게 수정		//$("#alertContent").load(url);	}}//도움말 레이어창function popInfo() {    	$("[data-layer='popup']").each(function(i, e){		var top = $(this).offset().top,		height = $(this).height(),			id = $(this).attr("href");				$(id).css("top", top + height);				$(this).on("click", function(){			$(id).after("<div class='backdrop'></div>");		});				$("body").on("click", ".backdrop" ,function(){			$(".collapse.in").removeClass("in");			$(".backdrop").remove();		});				$(id).on('hidden.bs.collapse', function () {			$(".backdrop").remove();		});	});}