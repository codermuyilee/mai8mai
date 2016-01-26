<#assign contextPath = request.contextPath/>
<#assign imagePath = "http://mai8mai.com/resource/images" />

<!DOCTYPE HTML>
<html>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta name="keywords" content="">

    <title>Home</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${contextPath}/css/style.css" media="screen" rel="stylesheet" type="text/css">
    <link href="${contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css">

    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${contextPath}/js/html5.js"></script>
    <script src="${contextPath}/js/jflow.plus.js"></script>
    <script src="${contextPath}/js/jquery.carouFredSel-5.2.2-packed.js"></script>
    <script src="${contextPath}/js/cart.js"></script>

    <script>
	$(document).ready(function(){
	    $("#myController").jFlow({
			controller: ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides: "#slider",  // the div where all your sliding divs are nested in
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "984px",  // this is the width for the content-slider
			height: "480px",  // this is the height for the content-slider
			duration: 400,  // time in miliseconds to transition one slide
			prev: ".slidprev", // must be class, use . sign
			next: ".slidnext", // must be class, use . sign
			auto: true
    });
  });
  </script>
  <script>
	$(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>

    <script>
        //回到顶部
        $(function() {
            $(window).scroll(function() {
                if($(this).scrollTop() != 0) {
                    $("#toTop").fadeIn();
                } else {
                    $("#toTop").fadeOut();
                }
            });
            $("body").append("<div id=\"toTop\" style=\"border:1px solid #444;background:#333;color:#fff;text-align:center;padding:10px 13px 7px 13px;position:fixed;bottom:10px;right:10px;cursor:pointer;display:none;font-family:verdana;font-size:22px;\">^</div>");
            $("#toTop").click(function() {
                $("body,html").animate({scrollTop:0},800);
            });
        });
    </script>
</head>
<body>
  <div class="container_12">
    <header id="branding">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo" ><a href="index.html" title=""><img src="${contextPath}/images/logo.png" alt="Online Store Theme Logo"/></a></h1>
          <h2 id="site_description">Online Store Theme</h2>
        </hgroup>
      </div><!-- .grid_3 -->

      <div class="grid_3">
        <form class="search">
          <input type="text" name="search" class="entry_form" value="" placeholder="Search entire store here..."/>
	</form>
      </div><!-- .grid_3 -->

      <div class="grid_6">
        <ul id="cart_nav">
          <li>
            <a class="cart_li" href="#">想买</a>
            <ul class="cart_cont">
              <li class="no_border"><p>Recently added item(s)</p></li>
              <li>
                <a href="product_page.html" class="prev_cart"><div class="cart_vert"><img src="${contextPath}/images/cart_img.png" alt="" title="" /></div></a>
                <div class="cont_cart">
                  <h4>Caldrea Linen and Room Spray</h4>
                  <div class="price">1 x $399.00</div>
                </div>
                <a title="close" class="close" href="#"></a>
                <div class="clear"></div>
              </li>

              <li>
                <a href="product_page.html" class="prev_cart"><div class="cart_vert"><img src="${contextPath}/images/produkt_slid1.png" alt="" title="" /></div></a>
                <div class="cont_cart">
                  <h4>Caldrea Linen and Room Spray</h4>
                  <div class="price">1 x $399.00</div>
                </div>
                <a title="close" class="close" href="#"></a>
                <div class="clear"></div>
              </li>
	      <li class="no_border">
		<a href="shopping_cart.html" class="view_cart">View shopping cart</a>
		<a href="checkout.html" class="checkout">Procced to Checkout</a>
	      </li>
            </ul>
          </li>
        </ul>

        <nav class="private">
          <ul>
            <li><a href="#">我的买吧</a></li>
		<li class="separator">|</li>
            <li><a href="login.html">登陆</a></li>
          </ul>
      </div><!-- .grid_6 -->
    </header><!-- #branding -->
  </div><!-- .container_12 -->

  <div class="clear"></div>