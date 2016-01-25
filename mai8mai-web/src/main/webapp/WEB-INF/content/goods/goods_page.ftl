<#include "layout.ftl">
<@layout>
<div id="block_nav_primary">
    <div class="container_12">
        <div class="grid_12">
            <nav class="primary">
                <ul>
                    <li class="curent"><a href="home.action">首页</a></li>
                    <li><a href="catalog_grid.html">好货晒单</a></li>
                    <li><a href="catalog_grid.html">神价监控</a></li>
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
            <a href="index.html">首页</a><span>&#8250;</span><span class="current">每日精选</span>
        </div>
        <!-- .breadcrumbs -->
    </div>
    <!-- .grid_12 -->
</div><!-- .container_12 -->

<div class="clear"></div>

<section id="main">
    <div class="container_12">
        <div id="content" class="grid_12">
            <a href="${goods.gotoBuyUrl}"><h1 class="page_title">${goods.name}</h1></a>

            <div class="product_page">
                <div>
                ${goods.detail}
                </div>
                <div class="goods_img_div">
                    <a href="${goods.gotoBuyUrl}" target="_blank">
                        <img src="${imagePath}/${goods.pic}" alt="" title=""/>
                    </a>
                    <a href="${goods.gotoBuyUrl}" class="bay">点我去买</a>
                </div>
            </div>
            <div class="clear"></div>

        </div>
        <!-- #content -->

        <div class="clear"></div>

    </div>
    <!-- .container_12 -->
</section><!-- #main -->

<div class="clear"></div>
</@layout>