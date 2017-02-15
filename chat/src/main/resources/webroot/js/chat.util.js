$(document).ready(function(){
	
	//alert("jQuery已生效");
	
	//判断浏览器是否支持WebSocket协议
	if(!window.WebSocket){
		window.WebSocket = window.MozWebSocket;
	}
	
	if(window.WebSocket){
		var socket = new WebSocket("ws://localhost:8080/im");
		socket.onmessage = function(e){
			console.log("获取服务器发来的消息" + e.data);
		};
		socket.onopen = function(e){
			console.log("与服务器建立连接");
			socket.send("你好");
		}
		socket.onclose = function(e){
			console.log("服务器关闭");
		}
	}else{
		alert("您的浏览器不支持WebSocket！");
	}
	
	
});