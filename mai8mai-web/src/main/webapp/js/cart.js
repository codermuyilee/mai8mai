/**
 * Created by Administrator on 2016/1/26.
 */
function addToCart(goodsId){
    var userId=$.cookie('user_id')
    if(userId==null || userId==""){
        $.cookie('user_id')
    }
    htmlobj=$.ajax(
        {
            url:"//test1.txt",
            async:false
        });

}
