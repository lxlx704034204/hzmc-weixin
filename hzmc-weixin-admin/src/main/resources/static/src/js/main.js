function myAlert(str){
	 var alert='  <div class="cover"> </div><div class="add-container col-sm-4 col-sm-offset-4 no-padding">';		
	 alert += '<div class="navbar clear"><span class="right close closeDown"></span><h4 class="left">提示</h4></div>';
	 alert += '<div class="add-main">'+str+'</div>';
	 alert += '<div class="alert-footer"><div class="btn-event right closeDown">确认</div></div></div>';
	 
	 $('body').append(alert);
}

$('body').on('click','.closeDown',function($scope){
    $('.cover').remove();
    $('.add-container').remove();
});

angular.module('myApp',[]).controller('myCtrl',function($scope){
	
	$(function($){  
		$scope.currPage=0;
		redpackTemplet();
		PayRecord();
	});
	
	
	function disable(){
		for(var i=0; i<$('.tablePager').length; i++){
			if($('.tablePager')[i].innerHTML> ($scope.total/10+1)){
				$($('.tablePager')[i]).parent().addClass('disabled');
			}
		}
		
		if($('.active a').html() == '1'){
			$('.previous').addClass('disabled');
		}
		
		if($('.active a').html() == Math.floor($scope.total/10+1)){
			$('.latter').addClass('disabled');
		}
	}
	
	
	
	$('.previous').click(function(){
		if($('.pagination li').index($('li.active')) == 1){
			for(var i=0; i<$('.tablePager').length; i++){
				$($('.tablePager')[i]).html(parseInt($($('.tablePager')[i]).html())-1);
			}
		}else if($('.active a').html() != 1){
			$('.active').removeClass('active').prev().addClass('active');
			$('.latter').removeClass('disabled');
		}
		if($('.active a').html() == '1'){
			$('.previous').addClass('disabled');
		}	
		$scope.currPage = $('.active a').html();
		disable();
		PayRecord();
	});

	
	$('.latter').click(function(){
		if($('.pagination li').index($('li.active')) == 5){
			for(var i=0; i<$('.tablePager').length; i++){
				$($('.tablePager')[i]).html(parseInt($($('.tablePager')[i]).html())+1);
			}
		}else if($('.active a').html() != Math.floor($scope.total/10+1)){
			$('.active').removeClass('active').next().addClass('active');
			$('.previous').removeClass('disabled');
		}
		if($('.active a').html() == Math.floor($scope.total/10+1)){
			$('.latter').addClass('disabled');
		}
		$scope.currPage = $('.active a').html();
		disable();
		PayRecord();
	});
	
	$('.tablePager').click(function(e){
		$(e.target).parent().addClass('active').siblings('.active').removeClass('active');
		$scope.currPage = $('.active a').html()

		PayRecord();
		if($('.active a').html() == '1'){
			$('.previous').addClass('disabled');
		}else{
			$('.previous').removeClass('disabled');
		}
		if($('.active a').html() == Math.floor($scope.total/10+1)){
			$('.latter').addClass('disabled');
		}else{
			$('.latter').removeClass('disabled');
		}
	});
	
	
	function redpackTemplet(){
		$.ajax({
			type: 'GET',
			url: '/WxRedpackTemplet',
			success: function(data){
				$scope.actList = data.data;
			},
	    	error:function(data){
	    		if(data.status == 401){
	    			window.location.href='../../index.html';
	    		}
	    	} 
		});
		
	}


		
	function PayRecord(){
		$.ajax({
			type: 'GET',
			url: '/WxPayRecord/'+$scope.currPage*10+'/'+($scope.currPage*10+9),
			success: function(data){

				$scope.list = data;
				
				$scope.total = data.data.total;
				
				$scope.$apply($scope.list);
			},
	    	error:function(data){
	    		if(data.status == 401){
	    			window.location.href='../../index.html';
	    		}
	    	} 
		});	
	}
});