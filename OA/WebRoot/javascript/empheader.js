$(document).ready(function() {
			
			/* 	������ʾ��	*/

			// ��ÿ��a�е����ݰ�����һ���㣨span.out���У���span.out�����׷�ӱ���ͼ�㣨span.bg��
			$("#menu li a").wrapInner( '<span class="out"></span>' ).append( '<span class="bg"></span>' );

			// ѭ��Ϊ�˵���aÿ�����һ���㣨span.over��
			$("#menu li a").each(function() {
				$( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
			});

			$("#menu li a").hover(function() {
				// ��꾭��ʱ�򱻴����ĺ���
				$(".out",this).stop().animate({'top':'45px'},250); // ���»��� - ����
				$(".over",this).stop().animate({'top':'0px'},250); // ���»��� - ��ʾ
				$(".bg",this).stop().animate({'top':'0px'},	120); // ���»��� - ��ʾ

			}, function() {
				// ����Ƴ�ʱ�򱻴����ĺ���
				$(".out",this).stop().animate({'top':'0px'},250); // ���ϻ��� - ��ʾ
				$(".over",this).stop().animate({'top':'-45px'},250); // ���ϻ��� - ����
				$(".bg",this).stop().animate({'top':'-45px'},120); // ���ϻ��� - ����
			});
					

			/*	�򻯰�ʾ��	*/
					
			$("#menu2 li a").wrapInner( '<span class="out"></span>' );
			
			$("#menu2 li a").each(function() {
				$('<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
			});

			$("#menu2 li a").hover(function() {
				$(".out",this).stop().animate({'top':'45px'},200); // ���»��� - ����
				$(".over",this).stop().animate({'top':'0px'},200); // ���»��� - ��ʾ

			}, function() {
				$(".out",this).stop().animate({'top':'0px'},200); // ���ϻ��� - ��ʾ
				$(".over",this).stop().animate({'top':'-45px'},200); // ���ϻ��� - ����
			});

		});