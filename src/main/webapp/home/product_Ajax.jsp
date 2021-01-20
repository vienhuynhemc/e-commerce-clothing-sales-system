<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Product" %>
<%@ page import="beans.product.ProductImage" %>
<%@ page import="java.util.Map" %>
<%@ page import="beans.encode.ConvertPrice" %>

<!-------------load các danh sách------------>
<% ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");

    int numPage = (int) request.getAttribute("numPage");
%>


<div class="aa-product-catg-body">

    <ul class="aa-product-catg">
        <!-- start single product item -->

        <%
            for ( Product p: listProduct ) {

        %>
        <li>
            <figure>
                <a class="aa-product-img" href="detailsProduct.html">


                    <!-------Load hình đầu tiên ------->
                    <img
                            src="<%=p.getListIMG().get(1).getLink_hinh()%>"
                            alt="polo shirt img">
                    <!-------Load hình đầu tiên ------->


                </a>
                <button class="aa-add-card-btn" onclick="addCart(this)">
                    <input type="hidden" name="" id="sp_1">
                    <input type="hidden" name="" id="mau_1">
                    <span
                            class="fa fa-shopping-cart">
                                        </span>
                    Thêm vào giỏ

                </button>
                <figcaption>
                    <!-------Load giá và giá khuyến mãi  ------->
                    <h4 class="aa-product-title"><a href="detailsProduct.html"><%=p.getTen_sp()%></a></h4>
                    <span class="aa-product-price sprice">
                        <%= ConvertPrice.convertPrice(p.getPriceSale().getGia_sp_km())%> VND</span>
                    <span class="aa-product-price"><del>
                    <%=ConvertPrice.convertPrice(p.getPrice().getGia_sp()) %>VND</del></span>

                    <!-------Load giá và giá khuyến mãi ------->




                    <!-------Load danh sách thông tin ------->


                    <% for (int i = 0; i < p.getListInfo().size(); i++) {
                    %>
                    <p class="aa-product-descrip">
                      <%=p.getListInfo().get(i).getThong_tin()%>
                        <br>
                    </p>
                    <%} %>

                        <!-------Load danh sách thông tin ------->


                </figcaption>
            </figure>
            <div class="aa-product-hvr-content">
                <a href="wishlist.html" data-toggle="tooltip" data-placement="top"
                   title="Thêm vào yêu thích"><span
                        class="fa fa-heart"></span></a>
                <!-- <a href="#" data-toggle="tooltip" data-placement="top" title="Compare"><span class="fa fa-exchange"></span></a> -->
                <a href="#" data-toggle2="tooltip" data-placement="top" title="Xem nhanh"
                   data-toggle="modal"
                   data-target="#quick-view-modal_<%=p.getMa_sp()%>" id="<%=p.getMa_sp()%>" onclick="loadSize(this)" >
                    <span class="fa fa-eye"  ></span>
                </a>
            </div>
            <!-- product badge -->
            <span class="aa-badge aa-sale" href="#">Giảm giá!</span>
        </li>
        <!-- Xem nhanh modal -->
        <div class="modal fade quick-view-modal_all" id="quick-view-modal_<%=p.getMa_sp()%>"    tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel"
             aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <div class="row">
                            <!-- Modal view slider -->
                            <div class="col-md-6 col-sm-6 col-xs-12 viewnhanhcol">
                                <div class="aa-product-view-slider viewnhanhcol">
                                    <div class="simpleLens-gallery-container viewnhanhcol contentviewnhanh"
                                         id="demo-1">
                                        <div class="simpleLens-container">
                                            <div class="simpleLens-big-image-container viewnhanhcol">
                                                <a class="simpleLens-lens-image"
                                                   data-lens-image="<%=p.getListIMG().get(1).getLink_hinh()%>">
                                                    <img src="<%=p.getListIMG().get(1).getLink_hinh()%>"
                                                         class="simpleLens-big-image">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="simpleLens-thumbnails-container div2scl">


                                            <!------laod hình ảnh xem nhanh----------->
                                            <%
                                                for (int i = 0; i < p.getListIMG().size(); i++) {

                                            %>

                                            <a href="#" class="simpleLens-thumbnail-wrapper"
                                               data-lens-image="<%=p.getListIMG().get(i).getLink_hinh()%>"
                                               data-big-image="<%=p.getListIMG().get(i).getLink_hinh()%>">
                                                <img src="<%=p.getListIMG().get(i).getLink_hinh()%>">
                                            </a>


                                            <%}%>


                                            <!------laod hình ảnh xem nhanh ----------->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal view content -->
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <div class="aa-product-view-content">
                                    <h3><%=p.getTen_sp()%> <span style="color: #ff7315"> MSY </span></h3>
                                    <div class="aa-price-block">
                                        <div class="rating">
                                            <div>
                                                <i class="staryellow fa fa-star"></i>
                                                <i class="staryellow fa fa-star"></i>
                                                <i class="staryellow fa fa-star"></i>
                                                <i class="staryellow fa fa-star"></i>
                                                <i class="graystar fa fa-star"></i>
                                            </div>
                                            <a href="">( 14 người đánh giá )</a>
                                            <div class="istock">
                                                <i class="fa fa-check-circle-o"></i>
                                                <span>Còn hàng ( 14 ) </span>
                                            </div>
                                        </div>
                                        <!-------Load giá------->
                                        <span class="aa-product-view-price"><%=ConvertPrice.convertPrice(p.getPriceSale().getGia_sp_km())%> VND</span>
                                    </div>
                                    <p>
                                        <!-------Load danh sách thông tin ------->

                                            <% for (int i = 0; i < p.getListInfo().size(); i++) {
                                           %>
                                         <p class="aa-product-descrip">
                                          <%=p.getListInfo().get(i).getThong_tin()%>
                                             <br>
                                         </p>
                                          <%} %>

                                        <!-------Load danh sách thông tin ------->

                                    <h4>Size</h4>
                                    <div class="aa-prod-view-size">

                                        <!------ Laod Size khi click vào xem nhanh --->

                                        <div id="loadSizeByID_<%=p.getMa_sp()%>" style="position: relative; z-index: 10000;">

                                        </div>


                                        <!------ Laod Size khi click vào xem nhanh --->

                                    </div>
                                    <h4>Color</h4>
                                    <div class="aa-prod-view-size" >

                                        <!------ Laod color khi click vào xem nhanh --->

                                        <div id="loadColor_<%=p.getMa_sp()%>">

                                        </div>


                                        <!------ Laod color khi click vào xem nhanh --->

                                    </div>
                                    <div class="aa-prod-quantity">
                                        <div class="inputsl">
                                            <button onclick="subtocard()"><span>-</span></button>
                                            <input type="text" value="1" id="sladdtocard">
                                            <button onclick="plustocard()"><span>+</span></button>
                                        </div>
                                        <div class="danhmucprod">
                                            <p class="aa-prod-category">
                                                <span>Danh mục: </span><a href="#"><%=p.getCategoryName()%></a>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="aa-prod-view-bottom">
                                        <a href="cart.html"
                                           class="aa-add-to-cart-btn addTocardViewQuick"
                                           style="color: white;"><span
                                                class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                        <a href="detailsProduct.html" class="aa-add-to-cart-btn"
                                           style="color: white;"><span
                                                class="fa fa-eye"></span>Xem chi tiết</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- / Xem nhanh modal -->
        <% }%>

    </ul>

</div>



<div class="aa-product-catg-pagination">
    <nav>
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true" class="nextprebar">&laquo;</span>
                </a>
            </li>

            <% for(int i= 1; i <= numPage;i ++){

              %>

            <li><a href="#" class="activenextbar"><%=i%></a></li>

           <% }%>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true" class="nextprebar">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>
