<#include "layout.ftl">
<@layout>
<script>
    $(document).ready(function () {
        $("select").selectBox();
    });
</script>

<script>
    $(document).ready(function () {
        $("#myController").jFlow({
            controller: ".control", // must be class, use . sign
            slideWrapper: "#jFlowSlider", // must be id, use # sign
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
    $(function () {
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
    $(document).ready(function () {
        $("button").click(function () {
            $(this).addClass('click')
        });
    })
</script>

<div id="block_nav_primary">
    <div class="container_12">
        <div class="grid_12">
            <nav class="primary">
                <ul>
                    <li class="curent"><a href="/goods/home.action">首页</a></li>
                    <li><a href="#">好货晒单</a></li>
                    <li><a href="#">神价监控</a></li>
                </ul>
            </nav>
            <!-- .primary -->
        </div>
        <!-- .grid_12 -->
    </div>
    <!-- .container_12 -->
</div><!-- .block_nav_primary -->

<div class="clear"></div>

<div class="container_12">
    <div class="grid_12">
        <div class="breadcrumbs">
            <a href="index.html">Home</a><span>&#8250;</span><a href="#">Category</a><span>&#8250;</span><span
                class="current">This page</span>
        </div>
        <!-- .breadcrumbs -->
    </div>
    <!-- .grid_12 -->
</div><!-- .container_12 -->

<div class="clear"></div>

<section id="main">
    <div class="container_12">
        <!-- .sidebar -->

        <div id="content" class="grid_12">
            <h1 class="page_title">每日精选</h1>

            <div class="options">
                <div class="grid-list">
                    <a class="grid curent" href="/goods/home.action"><span>img</span></a>
                    <a class="list" href="/goods/list_v.action"><span>img</span></a>
                </div>
            </div>
            <!-- .options -->

            <div class="listing_product">
                <#list goodsList as goods>

                <div class="product_li">
                    <div class="grid_3">
                        <img class="sale" src="../../../images/new.png" alt="New"/>
                        <div class="prev">
                            <a href="get.action?id=${goods.id}"><img src="${imagePath}/${goods.pic}" alt="" title="" /></a>
                        </div>
                        <!-- .prev -->
                    </div>
                    <!-- .grid_3 -->

                    <div class="grid_6">
                        <div class="entry_content">
                            <a href="product_page.html"><h3 class="title">${goods.name}</h3></a>
                            <div class="review">
                                <a class="plus" href="#"></a>
                                <a class="plus" href="#"></a>
                                <a class="plus" href="#"></a>
                                <a href="#"></a>
                                <a href="#"></a>
                                <span>1 REVIEW(S)</span>
                            </div>
                            <p class="goods_detail">${goods.detail}</p>
                            <a class="more" href="get.action?id=${goods.id}">Learn More</a>
                        </div>
                    </div>

                    <div class="grid_3">
                        <div class="cart">
                            <div class="price">
                                <#--<div class="price_new">$550.00</div>
                                <div class="price_old">$725.00</div>-->
                            </div>
                            <a href="#" class="bay">点我去买</a>
                            <a href="#" class="obn"></a>
                            <a href="#" class="like" onclick="addToCart(1)" ></a>
                        </div>
                        <!-- .cart -->
                    </div>
                    <!-- .grid_2 -->

                    <div class="clear"></div>
                </div>
                <!-- .article -->
            </#list>
                <div class="clear"></div>
            </div>
            <!-- .listing_product -->

            <div class="clear"></div>

            <div class="pagination">
                <ul>
                    <li class="prev"><span>&#8592;</span></li>
                    <li class="curent"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><span>...</span></li>
                    <li><a href="#">100</a></li>
                    <li class="next"><a href="#">&#8594;</a></li>
                </ul>
            </div>
            <p class="pagination_info">Displaying 1 to 12 (of 100 products)</p>
        </div>

        <div class="clear"></div>

    </div>
</section><!-- #main -->

<div class="clear"></div>
</@layout>