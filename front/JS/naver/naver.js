/* 롤링 관련 이벤트 */
$(function(){
	$('.box-body-right2 .btn-next').click(function(e){
		e.preventDefault();
		moveLeft('.box-body-right2 .item-stock','.box-body-right2 .list-stock',1000)
	});
	$('.box-body-right2 .btn-prev').click(function(){
		e.preventDefault();
		moveRight('.box-body-right2 .item-stock','.box-body-right2 .list-stock',1000)
	});
	$('.box-body-right2 .box-in').hover(function(){
		clearInterval(rollingRight2)
	},function(){
		rollingRight2 = rollingLeft(rollingObjRight2.li,rollingObjRight2.ul,rollingObjRight2.time,rollingObjRight2.duration);
	})
	$('.box-body-left2 .list-issue').hover(function(){
		clearInterval(rollingLeft2)
	},function(){
		rollingLeft2 = rollingTop(rollingObjLeft2);
	})
	
})
/* 페이지네이션 버튼 이벤트 */
$(function(){
	$('.box-shop-in .btn-prev').click(function(e){
		e.preventDefault();
		let boxShopIn = $(this).parents('.box-shop-in')
		let curPage = boxShopIn.find('.page').eq(0).text();
		let maxPage = boxShopIn.find('.max-page').first().text();
		curPage = +curPage;
		curPage = --curPage == 0 ? maxPage : curPage;
		boxShopIn.find('.page').text(curPage);
	})
	$('.box-shop-in .btn-next').click(function(e){
		e.preventDefault();
		let boxShopIn = $(this).parents('.box-shop-in')
		let curPage = boxShopIn.find('.page').eq(0).text();
		let maxPage = boxShopIn.find('.max-page').first().text();
		curPage = +curPage;
		curPage = ++curPage > maxPage ? 1 : curPage;
		boxShopIn.find('.page').text(curPage);
	})
})

let rollingObjRight2 = {
	li : '.box-body-right2 .item-stock',
	ul: '.box-body-right2 .list-stock',
	time: 1000,
	duration : 2000
}

let rollingObjLeft2 = {
	liSelector : '.box-body-left2 .item-issue',
	ulSelector : '.box-body-left2 .list-issue',
	animationTime : 1000,
	duration : 2000
}

let rollingRight2 = rollingLeft(rollingObjRight2.li,rollingObjRight2.ul,rollingObjRight2.time,rollingObjRight2.duration);
let rollingLeft2 = rollingTop(rollingObjLeft2);

function moveLeft(liSelector, ulSelector, time){
	let width = $(liSelector).first().innerWidth()
	if(!$(liSelector).first().is(':animated')){
		$(liSelector).first().animate({
			marginLeft : `-${width}`
		},time,function(){
			$(this).detach().appendTo(ulSelector).removeAttr('style','')
		})
	}
}
function moveRight(liSelector, ulSelector, time){
	let width = $(liSelector).last().innerWidth()
	$(liSelector).last().detach().prependTo(ulSelector).css('margin-left',`-${width}px`)
	if(!$(liSelector).first().is(':animated')){
		$(liSelector).first().animate({
			marginLeft : 0
		},time)
	}
}
function rollingLeft(liSelector, ulSelector, animationTime,duration){
	return setInterval(moveLeft,duration,liSelector, ulSelector, animationTime)
}

function moveTop(liSelector, ulSelector, animationTime){
	let height = $(liSelector).first().innerHeight()
	if(!$(liSelector).first().is(':animated')){
		$(liSelector).first().animate({
			marginTop : `-${height}`
		},animationTime, function(){
			$(this).detach().appendTo(ulSelector).removeAttr('style');
		});
	}
}
function rollingTop(rollingObjLeft2){
	return setInterval(moveTop,rollingObjLeft2.duration,rollingObjLeft2.liSelector, 
		rollingObjLeft2.ulSelector, rollingObjLeft2.animationTime)
}

