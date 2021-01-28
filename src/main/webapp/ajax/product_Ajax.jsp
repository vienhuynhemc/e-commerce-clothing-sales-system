<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Product" %>
<%@ page import="beans.product.ProductImage" %>
<%@ page import="java.util.Map" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-------------load các danh sách------------>
<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
    int count = 0;
    int numPage = (int) request.getAttribute("numPage");
    int nowpage = (int) request.getAttribute("page");
%>


<div class="aa-product-catg-body">

    <ul class="aa-product-catg">
        <!-- start single product item -->


        <!-------load sản phẩm -------------->
        <%
            int j = 0;
            for ( Product p: listProduct ) {


        %>
        <li>
            <figure>
<%--                <a class="aa-product-img" href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&ma_mau=<%=p.getListColor().get(j).getMa_mau()%>&ma_size=<%=p.getListSize().get(j).getMa_size()%>&type=&page=1">--%>

                    <a class="aa-product-img" href="sLoadDetailProductController?idProduct=<%=p.getMa_sp()%>">
                    <!-------Load hình đầu tiên ------->
                    <img
                            src="<%=p.getListIMG().get(0).getLink_hinh()%>"
                            alt="polo shirt img">
                    <!-------Load hình đầu tiên ------->

                </a>

                <a  href="#"  data-toggle2="tooltip" data-placement="top" title="Xem nhanh"
                    data-toggle="modal"
                    data-target="#quick-view-modal_<%=count%>"  class="aa-add-card-btn" id="<%=p.getMa_sp()%>" onclick="loadSize(this)">
                    <input type="hidden" name="" value="<%=p.getMa_sp()%>">
                    <span class="fa fa-shopping-cart"></span>
                    Thêm vào giỏ

                </a>

                <figcaption>
                    <!-------Load giá và giá khuyến mãi  ------->
                    <h4 class="aa-product-title"><a href="LoadDetailProductController?idProduct=<%=p.getMa_sp()%>"><%=p.getTen_sp()%></a></h4>
                    <span class="aa-product-price sprice">

                        <%if (p.getPriceSale().getGia_sp_km() != 0){%>

                        <%= ConvertPrice.convertPrice(p.getPriceSale().getGia_sp_km())%>

                        <%}else{%>
                        <%=ConvertPrice.convertPrice(p.getPrice().getGia_sp())%>
                        <%}%>

                        VND</span>
                    <span class="aa-product-price"><del>


                    <%if (p.getPriceSale().getGia_sp_km() != 0){%>

                    <%=ConvertPrice.convertPrice(p.getPrice().getGia_sp())%> VND

                    <%}%>


                    </del></span>

                    <!-------Load giá và giá khuyến mãi ------->




                    <!-------Load danh sách thông tin ------->


                    <% for (int i = 0; i < p.getListInfo().size(); i++) {
                    %>
                    <p class="aa-product-descrip">
                      <%=p.getListInfo().get(i).getThong_tin()%>
                    </p>
                    <%} %>

                        <!-------Load danh sách thông tin ------->


                </figcaption>
            </figure>
            <div class="aa-product-hvr-content">
                <a href="#" data-toggle="tooltip" data-placement="top"
                   title="Thêm vào yêu thích"><span
                        class="fa fa-heart"></span></a>
                <!-- <a href="#" data-toggle="tooltip" data-placement="top" title="Compare"><span class="fa fa-exchange"></span></a> -->
                <a href="#" data-toggle2="tooltip" data-placement="top" title="Xem nhanh"
                   data-toggle="modal"
                   data-target="#quick-view-modal_<%=p.getMa_sp()%>"  onclick="loadSize(this)" >
                    <input type="hidden" name="" value="<%=p.getMa_sp()%>">
                    <span class="fa fa-eye"  ></span>
                </a>
            </div>
            <!-- product badge -->
            <span class="aa-badge aa-sale" href="#">Giảm giá!</span>
        </li>
        <div class="modal fade quick-view-modal_all" id="quick-view-modal_<%=count%>"    tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel"
             aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content" style="height: 406px;width: 815px; margin-left: 0;">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <div class="row">
                            <!-- Modal view slider -->
                            <div class="col-md-6 col-sm-6 col-xs-12 viewnhanhcol">
                                <div class="aa-product-view-slider viewnhanhcol">
                                    <div class="simpleLens-gallery-container viewnhanhcol contentviewnhanh"
                                         id="demo-2">
                                        <div class="simpleLens-container">
                                            <div class="simpleLens-big-image-container viewnhanhcol" style="position: absolute;">
                                                <a class="simpleLens-lens-image"
                                                   data-lens-image="<%=p.getListIMG().get(0).getLink_hinh()%>">
                                                    <img style="height: 411px;" src="<%=p.getListIMG().get(0).getLink_hinh()%>"
                                                         class="simpleLens-big-image">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal view content -->
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <div class="aa-product-view-content">
                                    <h3><%=p.getTen_sp()%> <span style="color: #ff7315"> MSY </span></h3>

                                    <!-------Load danh sách thông tin ------->

                                    <h4>Size</h4>
                                    <div class="aa-prod-view-size">

                                        <!------ Laod Size khi click vào xem nhanh --->

                                        <div class="loadSizeByID_<%=p.getMa_sp()%>" style="position: relative; z-index: 10000;" >

                                        </div>

                                        <!------ Laod Size khi click vào xem nhanh --->

                                    </div>
                                    <h4>Color</h4>
                                    <div class="aa-prod-view-size" id="laymamaudccheck" >

                                        <!------ Laod color khi click vào xem nhanh --->

                                        <div class="loadColor_<%=p.getMa_sp()%>">

                                        </div>


                                        <!------ Laod color khi click vào xem nhanh --->

                                    </div>
                                    <div class="aa-prod-view-bottom">
                                        <a href="#"
                                           class="aa-add-to-cart-btn addTocardViewQuick"
                                           style="color: white;" onclick="addCart()"><span
                                                class="fa fa-shopping-cart" ></span>Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div><!-- / Xem nhanh modal -->

        <%count++;%>
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
                                                   data-lens-image="<%=p.getListIMG().get(0).getLink_hinh()%>">
                                                    <img src="<%=p.getListIMG().get(0).getLink_hinh()%>"
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
                                                <span>
                                                    <%if(p.getSo_luong_con_lai() > 0){
                                                    %>
                                                    Còn hàng ( <%=p.getSo_luong_con_lai()%> )
                                               <% }else{%>
                                                    Hết hàng
                                              <% }%>

                                                </span>
                                            </div>
                                        </div>
                                        <!-------Load giá------->
                                        <span class="aa-product-view-price">

                                            <%if(p.getPriceSale().getGia_sp_km() != 0) {%>

                                            <%=ConvertPrice.convertPrice(p.getPriceSale().getGia_sp_km())%>

                                             <%}else{%>

                                            <%=ConvertPrice.convertPrice(p.getPrice().getGia_sp())%>

                                            <%}%>
                                            VND
                                        </span>
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

                                        <div class="loadSizeByID_<%=p.getMa_sp()%>" style="position: relative; z-index: 10000;">

                                        </div>


                                        <!------ Laod Size khi click vào xem nhanh --->

                                    </div>
                                    <h4>Color</h4>
                                    <div class="aa-prod-view-size" >

                                        <!------ Laod color khi click vào xem nhanh --->

                                        <div class="loadColor_<%=p.getMa_sp()%>">

                                        </div>


                                        <!------ Laod color khi click vào xem nhanh --->

                                    </div>
                                    <div class="aa-prod-quantity">
                                        <div class="inputsl">
                                            <button onclick="subtocard()"><span>-</span></button>
                                            <input type="text" value="1" class="sladdtocard">
                                            <button onclick="plustocard()"><span>+</span></button>
                                        </div>
                                        <div class="danhmucprod">
                                            <p class="aa-prod-category">
                                                <span>Danh mục: </span><a href="#"><%=p.getCategoryName()%></a>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="aa-prod-view-bottom">
                                        <a href="#"
                                           class="aa-add-to-cart-btn addTocardViewQuick"
                                           style="color: white;" onclick="addCart()"><span
                                                class="fa fa-shopping-cart" ></span>Thêm vào giỏ hàng</a>
                                        <a href="LoadDetailProductController?idProduct=<%= p.getMa_sp()%>" class="aa-add-to-cart-btn"
                                           style="color: white;"><span
                                                class="fa fa-eye"></span>Xem chi tiết</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div><!-- / Xem nhanh modal -->
        <% j++; }%>

    </ul>

</div>


<!-----------bien lay gia tri de them vao gio hang-->
<input type="hidden" name="" id="layma_sanphamthemvaogiohang" value="">
<input type="hidden" name="" id="layma_sizethemvaogiohang" value="">
<input type="hidden" name="" id="layma_mauthemvaogiohang" value="">


<!-----------bien lay gia tri de them vao gio hang-->


<div class="aa-product-catg-pagination">
    <nav>
        <ul class="pagination">


            <%if(nowpage == 1){
            %>
            <li>
                <button type="button" aria-label="Previous">
                    <span aria-hidden="true" class="nextprebar">&laquo;</span>
                </button>
            </li>
            <%}else{%>
            <li>
                <button type="button" aria-label="Previous" id="<%=nowpage-1%>" onclick="changePage(this)">
                    <span aria-hidden="true" class="nextprebar">&laquo;</span>
                </button>
            </li>
            <%}%>


            <% for(int i= 1; i <= numPage;i ++){
                if (i == nowpage){
              %>

            <li><button type="button" onclick="changePage(this)" id="<%=i%>" class="activenextbar"><%=i%></button></li>

            <%}else{%>

            <li><button type="button" onclick="changePage(this)" id="<%=i%>" class=""><%=i%></button></li>

           <% }}%>

            <%if(nowpage == numPage){
            %>

            <li>
                <button type="button" aria-label="Next">
                    <span aria-hidden="true" class="nextprebar">&raquo;</span>
                </button>
            </li>

            <%}else{%>

            <li>
                <button type="button" aria-label="Next" id="<%=nowpage+1%>" onclick="changePage(this)">
                    <span aria-hidden="true" class="nextprebar">&raquo;</span>
                </button>
            </li>
            <%}%>
        </ul>
    </nav>
</div>

