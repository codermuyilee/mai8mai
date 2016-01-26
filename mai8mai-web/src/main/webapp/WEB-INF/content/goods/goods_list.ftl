<#include "layout.ftl">
<@layout>
  <div id="block_nav_primary">
    <div class="container_12">
        <div class="grid_12">
            <nav class="primary">
                <ul>
                    <li class="curent"><a href="home.action">首页</a></li>
                    <li><a href="#">好货晒单</a></li>
                    <li><a href="#">神价监控</a></li>
                </ul>
            </nav><!-- .primary -->
        </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
</div><!-- .block_nav_primary -->

<div class="clear"></div>
  
  <div class="container_12">
    <div class="grid_12">
       <div class="breadcrumbs">
	      <a href="index.html">Home</a><span>&#8250;</span><a href="#">Category</a><span>&#8250;</span><span class="current">This page</span>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">

       <div id="content" class="grid_12">
	      <h1 class="page_title">每日精选</h1>
	      
	      <div class="options">
		     <div class="grid-list">
			   <a class="grid curent" href="home.action"><span>img</span></a>
			   <a class="list" href="list_v.action"><span>img</span></a>
		     </div><!-- .grid-list -->
	      </div><!-- .options -->
	      
	      <div class="grid_product">
			  <#list goodsList as goods>
                  <div class="grid_3 product">
                      <div class="prev">
                          <a href="get.action?id=${goods.id}"><img src="${imagePath}/${goods.pic}" alt="" title="" /></a>
                      </div><!-- .prev -->
                      <h3 class="title">${goods.name}</h3>
                      <div class="cart">
                          <div class="price">
                              <div class="vert">
                                  <div class="price_new">$550.00</div>
                                  <div class="price_old">$725.00</div>
                              </div>
                          </div>
                          <a href="#" class="obn"></a>
                          <a href="#" class="like"></a>
                          <a href="#" class="bay"></a>
                      </div><!-- .cart -->
                  </div><!-- .grid_3 -->
			  </#list>

	      <div class="clear"></div>
	      </div><!-- .grid_product -->
	      
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
	      </div><!-- .pagination -->
	      <p class="pagination_info">Displaying 1 to 12 (of 100 products)</p>
       </div><!-- #content -->
       
      <div class="clear"></div>
      
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
</@layout>