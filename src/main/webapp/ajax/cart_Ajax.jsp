<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.cart.Cart" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.language.CartLanguageModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = CartLanguageModel.getInstance().getList("vietnamese");
    }

%>

<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listProduct");%>

<div class="cartleft" id="">

    <!-- dùng ajax để load cart-->

    <div class="cartleftheader">
        <h3> T<span style="color:#ff7315">V</span>T</h3>
        <h5>|</h5>
        <p><%=lang.get("1")%></p>
        <button class="reload" type="button" onclick="loadCart()">
            <i class="fas fa-sync-alt"></i>
        </button>
    </div>

    <div class="scrollmain">
        <div class="cartleftmain" id="b">


            <!-- load danh sách cart vào chỗ này-->

            <%
                int count= 0;
                int tong_gia = 0;
                int soluong = 0;
                for (Cart c: carts) {
                count ++;

                if(c.getGia_km() == 0){
                    tong_gia += (int)c.getGia();
                }else{
                    tong_gia += (int)c.getGia_km();
                }

                soluong += c.getSo_luong();
            %>
            <div class="cartleftmainitem">
                <div class="cartleftmainitemleft">
                    <a href="" class="cartleftmainimg"> <img src="<%=c.getHinh_sp()%>" alt=""></a>
                    <a href="">
                        <div class="cartleftmainiteminfor">
                            <p><%=c.getTen_sp()%></p>
                            <h6>Áo thun | Size : <%=c.getSize()%></h6>
                        </div>
                    </a>
                    <p class="cartleftmainitemcolor"><%=c.getMau_sp()%></p>
                    <div class="cartleftmainitemsl">

                        <!-- tại s sử dụng biến count? để có id không trùng -->

                        <p id="so_luong_sp_<%=count%>"><%=c.getSo_luong()%></p>

                        <!-- tại s sử dụng biến count? để có id không trùng -->
                        <div>

                            <!-- khi thằng này dc click thì gọi hàm để tăng hàm này sẽ set lại số lượng sp
                             sau khi tăng hoặc giảm ? thếm biến count để nó nhận biết, à id nào đc sét lại
                              để value bằng biến count, khi set lại chỉ đơn giản là lấy id thẻ p + count(value) là dc-->
                            <button id="tang" value="<%=count%>" onclick="increase(this)">+

                                <input type="hidden" value="<%=c.getMa_sp()%>" disabled>
                                <input type="hidden" value="<%=c.getMa_mau()%>" disabled>
                                <input type="hidden" value="<%=c.getMa_size()%>" disabled>

                            </button>
                            <button id="giam" value="<%=count%>" onclick="increase(this)">-
                                <input type="hidden" value="<%=c.getMa_sp()%>" disabled>
                                <input type="hidden" value="<%=c.getMa_mau()%>" disabled>
                                <input type="hidden" value="<%=c.getMa_size()%>" disabled>
                            </button>
                        </div>
                    </div>
                    <p class="cartleftmainitemprice" id="gia_<%=count%>">


                        <!--------- hiển thị giá khuyến mãi -------->
                        <% if(c.getGia_km() != 0){ %>

                        <%=ConvertPrice.convertPrice((int)c.getGia_km())%>

                        <%}else {%>

                        <%=ConvertPrice.convertPrice((int)c.getGia())%>

                        <%}%>

                     VND</p>
                </div>
                <div class="cartleftmainitemright" onclick="removeCart(this)">

                    <div></div>
                    <div></div>
                    <input type="hidden" value="<%=c.getMa_sp()%>" disabled>
                    <input type="hidden" value="<%=c.getMa_mau()%>" disabled>
                    <input type="hidden" value="<%=c.getMa_size()%>" disabled>
                </div>
            </div>
            <% } %>




        </div>
    </div>

    <div class="cartleftfooter">
        <a href="product.html" class="back">
            <i class="fa fa-long-arrow-left"></i> <%=lang.get("2")%>
        </a>
        <div class="footertongtien">
            <p><%=lang.get("3")%></p>
            <p id="total_all_2"  > <%=  ConvertPrice.convertPrice(tong_gia) %>  VND </p>
        </div>

    </div>



    <!-- end Code-->
</div>

<div class="cartright">
    <h3><%=lang.get("4")%></h3>
    <div class="pricecr">
        <div class="pricedivright">
            <p><%=lang.get("5")%> </p>
            <p>70.000 VND</p>
        </div>
        <div class="pricedivright">
            <p><%=lang.get("6")%> </p>

            <p id="total_all_1"><%= ConvertPrice.convertPrice(tong_gia) %> VND</p>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="pricecr">
        <div class="pricedivright">
            <p><%=lang.get("7")%></p>
            <p><%=carts.size()%></p>
        </div>
        <div class="pricedivright">
            <p><%=lang.get("8")%></p>
            <p id="so_luong_right"><%= soluong%></p>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="pricecr">
        <div class="pricedivrightinfor">
            <div>
                <i class="fa fa-clock-o"></i>
                <p><%=lang.get("9")%></p>
            </div>
            <div>
                <i class="fa fa-truck"></i>
                <p><%=lang.get("10")%></p>
            </div>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="note">
        <p><%=lang.get("11")%></p>
        <textarea name="" id="a" cols="30" rows="10"></textarea>
    </div>
    <a href="ChessSessionCheckoutController" class="submit">
        <%=lang.get("12")%>
    </a>

    <!-- Lam dep -->>
    <div class="box1">
    </div>
    <div class="box2">
        <div></div>
        <div style="background-color: #ff7315;"></div>
        <div></div>
    </div>
</div>

<input type="hidden" name="" id="getgia" value="<%=tong_gia%>">
<input type="hidden" name="" id="conver" value="<%=ConvertPrice.convertPrice(tong_gia)%>">

<script>

    function increase(event) {

        var list = event.children;


        var ma_sp = $(list[0]).attr("value");
        var ma_mau =  $(list[1]).attr("value");
        var ma_size = $(list[2]).attr("value");

        var active = $(event).attr("id");


        $.ajax({
            url:'ChangeProductInCartController',
            type:'get',
            dataType:'json',
            data:{
                ma_sp:ma_sp,
                ma_mau:ma_mau,
                ma_size: ma_size,
                active: active
            },
            success:function (data){

                var c = $(event).val();
                   <!-- sét lại số lượng và giá-->

                var sltrcthaydoi = parseInt($('#so_luong_sp_' + c).text()) ;
                var slsauthaydoi = data.so_luong;
                var tongsl = parseInt($("#so_luong_right").text());

                var total = $('#getgia').val();

                var tonggia = parseInt(total);
                var giamoi;

                if(slsauthaydoi > sltrcthaydoi){
                // nếu số lượng trc thay đổi lơn hơn số lượng sau thay đổi thì + 1 cho tổng số lương thôi
                    document.getElementById("so_luong_right").innerText = tongsl + 1;

                    //sét lại giá nếu có khuyến mãi thì sét theo giá khuyến mãi
                    if(data.gia_km > 0){
                        giamoi  = tonggia + data.gia_km/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia_km.toLocaleString("vi-VN") + " VND";
                    }else{
                        giamoi  = tonggia + data.gia/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia.toLocaleString("vi-VN") + " VND";
                    }

                }else if(slsauthaydoi < sltrcthaydoi){
                    // nếu số lượng trc thay đổi nhỏ hơn số lượng sau thay đổi thì - 1 cho tổng số lương thôi
                    document.getElementById("so_luong_right").innerText = tongsl - 1;
                        //sét lại giá nếu có khuyến mãi thì sét theo giá khuyến mãi
                    if(data.gia_km > 0){
                        giamoi  = tonggia - data.gia_km/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia_km.toLocaleString("vi-VN") + " VND";
                    }else{
                        giamoi  = tonggia - data.gia/data.so_luong;
                        document.getElementById("gia_"+c).innerText = data.gia.toLocaleString("vi-VN") + " VND";
                    }
                }else{
                    giamoi = tonggia;
                }

                // sét lại số lượng cho thằng sản phẩm đã
                document.getElementById("so_luong_sp_"+c).innerText = data.so_luong;

                var convert = giamoi.toLocaleString('vi-VN');

                document.getElementById("total_all_1").innerText = convert + " VND";
                document.getElementById("total_all_2").innerText = convert+ " VND";
                $('#getgia').prop("value",giamoi);
            },
            error:function () {
                alert("that bai");
            }
        });

    }

    function removeCart(event){

        var list = event.children;
        console.log(list);

        var ma_sp = $(list[2]).attr("value");
        var ma_mau =  $(list[3]).attr("value");
        var ma_size = $(list[4]).attr("value");

        $.ajax({
            url:'RemoveCartController',
            type:'get',
            dataType:'json',
            data:{
                ma_sp:ma_sp,
                ma_mau:ma_mau,
                ma_size: ma_size,
            },
            success:function (data){

                if(data == true){
                    loadCart();
                }
            },
            error:function () {
                alert("that bai");
            }
        });

    }

</script>