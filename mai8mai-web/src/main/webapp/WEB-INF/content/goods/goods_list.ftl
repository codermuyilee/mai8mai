<#include "layout.ftl">
<@layout>
  <div id="block_nav_primary">
    <div class="container_12">
      <div class="grid_12">
        <nav class="primary">
          <ul>
            <li class="curent"><a href="index.html">首页</a></li>
            <li><a href="catalog_grid.html">好货晒单</a></li>
            <li><a href="catalog_grid.html">神价监控</a></li>
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
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>Categories</h3>
		     
		     <nav class="left_menu">
			    <ul>
				   <li><a href="#">Solids <span>(21)</span></a></li>
				   <li><a href="#">Liquids <span> (27)</span></a></li>
				   <li><a href="#">Spray <span>(33)</span></a></li>
				   <li><a href="#">Electric <span>(17)</span></a></li>
				   <li><a href="#">For Cars <span>(23)</span></a></li>
				   <li><a href="#">For Room <span>(7)</span></a></li>
				   <li class="last"><a href="#">Other <span>(135)</span></a></li>
			    </ul>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav -->
	      
	      <aside id="shop_by">
		     <h3>Shop By</h3>
		     
		     <div class="currently_shopping">
			    <p>Currently Shopping by:</p>
			    <ul>
				   <li><a title="close" class="close" href="#"></a>Price: <span>$0.00 - $999.99</span></li>
				   <li><a title="close" class="close" href="#"></a>Manufacturer: <span>Apple</span></li>
			    </ul>
			    
			    <a class="clear_all" href="#">Clear All</a>
			    
			    <div class="clear"></div>
		     </div><!-- .currently_shopping -->
		     
		     <h4>Category</h4>
		     
		     <form action="#" class="check_opt">
			    <p><input class="niceCheck" type="checkbox" >For Home (23)</p>
			    <p><input class="niceCheck" type="checkbox" name="" value="">For Car (27)</p>
			    <p><input class="niceCheck" type="checkbox" name="" value="">For Office (9)</p>
		     </form>
		     
		     <h4>Price</h4>
		     
		     <form action="#" class="check_opt">
			    <p><input class="niceCheck" type="checkbox" name="" value="">0.00 - $49.99 (21)</p>
			    <p><input class="niceCheck" type="checkbox" name="" value="">$50.00 - $99.99 (7)</p>
			    <p><input class="niceCheck" type="checkbox" name="" value="">0$100.00 and above (15)</p>
		     </form>
	      </aside><!-- #shop_by -->
	      
	      <aside id="specials" class="specials">
		     <h3>Specials</h3>
		     
		     <ul>
			    <li>
				   <div class="prev">
					  <a href="product_page.html"><img src="${contextPath}/images/special1.png" alt="" title="" /></a>
				   </div>
				   
				   <div class="cont">
					  <a href="product_page.html">Honeysuckle Flameless Luminary Refill</a>
					  <div class="prise"><span class="old">$177.00</span>$75.00</div>
				   </div>   
			    </li>
			    
			    <li>
				   <div class="prev">
					  <a href="product_page.html"><img src="${contextPath}/images/special2.png" alt="" title="" /></a>
				   </div>
				   
				   <div class="cont">
					  <a href="product_page.html">Honeysuckle Flameless Luminary Refill</a>
					  <div class="prise"><span class="old">$177.00</span>$75.00</div>
				   </div>   
			    </li>
		     </ul>
	      </aside><!-- #specials -->
	      
	      <aside id="newsletter_signup">
		     <h3>Newsletter Signup</h3>
		     <p>Phasellus vel ultricies felis. Duis 
		     rhoncus risus eu urna pretium.</p>
		     
		     <form class="newsletter">
			    <input type="email" name="newsletter" class="your_email" value="" placeholder="Enter your email address..."/>
			    <input type="submit" id="submit" value="Subscribe" />
		     </form>
	      </aside><!-- #newsletter_signup -->
       </div><!-- .sidebar -->
      
       <div id="content" class="grid_9">
	      <h1 class="page_title">Product List</h1>
	      
	      <div class="options">
		     <div class="grid-list">
			   <a class="grid curent" href="index.html"><span>img</span></a>
			   <a class="list" href="catalog_list.html"><span>img</span></a>
		     </div><!-- .grid-list -->
		     
		     <div class="show">
			    Show
			    <select>
				   <option>1</option>
				   <option>2</option>
				   <option>3</option>
				   <option>4</option>
				   <option>5</option>
				   <option>6</option>
				   <option>7</option>
				   <option>8</option>
				   <option>9</option>
				   <option>10</option>
				   <option>11</option>
				   <option>12</option>
			     </select>
			    
			    per page
		     </div><!-- .show -->
		     
		     <div class="sort">
			   Sort By
			    <select>
				   <option>Position</option>
				   <option>Price</option>
				   <option>Rating</option>
				   <option>Name</option>
			     </select>
			    
			    <a class="sort_up" href="#">&#8593;</a>
		     </div><!-- .sort -->
	      </div><!-- .options -->
	      
	      <div class="grid_product">
			  <#list goodsList as goods>
                  <div class="grid_3 product">
                      <div class="prev">
                          <a href="product_page.html"><img src="${imagePath}/${goods.pic}" alt="" title="" /></a>
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