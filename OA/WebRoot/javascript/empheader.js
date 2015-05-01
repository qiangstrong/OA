$(document).ready(function() {
			
			/* 	完整版示例	*/

			// 把每个a中的内容包含到一个层（span.out）中，在span.out层后面追加背景图层（span.bg）
			$("#menu li a").wrapInner( '<span class="out"></span>' ).append( '<span class="bg"></span>' );

			// 循环为菜单的a每个添加一个层（span.over）
			$("#menu li a").each(function() {
				$( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
			});

			$("#menu li a").hover(function() {
				// 鼠标经过时候被触发的函数
				$(".out",this).stop().animate({'top':'45px'},250); // 向下滑动 - 隐藏
				$(".over",this).stop().animate({'top':'0px'},250); // 向下滑动 - 显示
				$(".bg",this).stop().animate({'top':'0px'},	120); // 向下滑动 - 显示

			}, function() {
				// 鼠标移出时候被触发的函数
				$(".out",this).stop().animate({'top':'0px'},250); // 向上滑动 - 显示
				$(".over",this).stop().animate({'top':'-45px'},250); // 向上滑动 - 隐藏
				$(".bg",this).stop().animate({'top':'-45px'},120); // 向上滑动 - 隐藏
			});
					

			/*	简化版示例	*/
					
			$("#menu2 li a").wrapInner( '<span class="out"></span>' );
			
			$("#menu2 li a").each(function() {
				$('<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
			});

			$("#menu2 li a").hover(function() {
				$(".out",this).stop().animate({'top':'45px'},200); // 向下滑动 - 隐藏
				$(".over",this).stop().animate({'top':'0px'},200); // 向下滑动 - 显示

			}, function() {
				$(".out",this).stop().animate({'top':'0px'},200); // 向上滑动 - 显示
				$(".over",this).stop().animate({'top':'-45px'},200); // 向上滑动 - 隐藏
			});

		});