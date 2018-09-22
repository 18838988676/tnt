var offsetX = $("#loveHeart").width() / 2;
		var offsetY = $("#loveHeart").height() / 2 - 55;
		var together = new Date();
		together.setFullYear(2014, 07, 21);
		together.setHours(20);
		together.setMinutes(0);
		together.setSeconds(0);
		together.setMilliseconds(0);
		
		if (!document.createElement('canvas').getContext) {
			var msg = document.createElement("div");
			msg.id = "errorMsg";
			msg.innerHTML = "提醒您：您的浏览器版本过旧^_^<br/>"+
				"推荐使用 <a href='http://dlsw.br.baidu.com/ditui/zujian/bdBrowserSetup-5956-ftn_1000061134.exe' target='_blank'>百度浏览器<br/>请先升级您的浏览器，效果很炫哦~~"; 
			document.body.appendChild(msg);
			$("#code").css("display", "none")
			$("#copyright").css("position", "absolute");
			$("#copyright").css("bottom", "10px");
		    document.execCommand("stop");
		} else {
			setTimeout(function () {
				adjustWordsPosition();
				startHeartAnimation();
			}, 1000);

			timeElapse(together);
			setInterval(function () {
				timeElapse(together);
			}, 00);

			adjustCodePosition();
			$("#code").typewriter();
		}