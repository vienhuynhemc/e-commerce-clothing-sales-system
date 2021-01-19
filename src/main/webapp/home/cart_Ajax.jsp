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

<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listCart"); %>

<div class="cartleft" id="">

    <!-- dùng ajax để load cart-->

    <div class="cartleftheader">
        <h3> T<span style="color:#ff7315">V</span>T</h3>
        <h5>|</h5>
        <p><%=lang.get("1")%></p>
    </div>

    <div class="scrollmain">
        <div class="cartleftmain" id="b">


            <!-- load danh sách cart vào chỗ này-->

            <%
                int count= 0;
                int sum = 0;
                int soluong = 0;
                for (Cart c: carts) {
                count ++;
                sum += (int)c.getGia();
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
                        <p id="so_luong_sp_<%=count%>"><%=c.getSo_luong()%></p>
                        <div>
                            <button id="tang" value="<%=count%>" onclick="increase(this)">+

                                <input type="hidden" value="<%=c.getMa_sp()%>">
                                <input type="hidden" value="<%=c.getMa_mau()%>">

                            </button>
                            <button id="giam" value="<%=count%>" onclick="increase(this)">-
                                <input type="hidden" value="<%=c.getMa_sp()%>">
                                <input type="hidden" value="<%=c.getMa_mau()%>">
                            </button>
                        </div>
                    </div>
                    <p class="cartleftmainitemprice" id="gia_<%=count%>"> <%=  ConvertPrice.convertPrice((int)c.getGia()) %> VND</p>
                </div>
                <div class="cartleftmainitemright">
                    <div></div>
                    <div></div>
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
            <p id="total_all_2"  > <%=  ConvertPrice.convertPrice(sum) %>  VND </p>
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
            <input type="hidden" name="" id="getgia" value="<%=sum%>">
            <p id="total_all_1"><%= ConvertPrice.convertPrice(sum) %> VND</p>
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
    <a href="checkout.html" class="submit">
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

<script>

    function increase(event) {

        var list = event.children;
        console.log(list);
        var ma_sp = $(list[0]).attr("value");
        var ma_mau =  $(list[1]).attr("value");
        var active = $(event).attr("id");

        console.log(ma_sp);
        console.log(ma_mau);

        $.ajax({
            url:'ChangeProductInCartController',
            type:'get',
            dataType:'json',
            data:{
                ma_sp:ma_sp,
                ma_mau:ma_mau,
                active: active
            },
            success:function (data){
                var c = $(event).val();
                   <!-- sét lại số lượng-->

                document.getElementById("so_luong_sp_"+c).innerText = data.so_luong;
                document.getElementById("so_luong_right").innerText = data.so_luong;

                   <!-- sét lại giá-->

                document.getElementById("gia_"+c).innerText = data.gia.toLocaleString("vi-VN") + " VND";

                 var total = $('#getgia').val();

                 var tonggia = parseInt(total);

                 console.log(tonggia);
                var giamoi;
                 if (active == "tang"){
                     giamoi  = tonggia + data.gia/data.so_luong;
                 }else {
                     giamoi  = tonggia - data.gia/data.so_luong;
                 }
                var convert = giamoi.toLocaleString('vi-VN')

                document.getElementById("total_all_1").innerText = convert + " VND";
                document.getElementById("total_all_2").innerText = convert+ " VND";
                $('#getgia').prop("value",giamoi);
            },
            error:function () {
                alert("that bai");
            }
        });

    }

    // $(document).ready(function (){
    //     var total = $('#getgia').val();
    //     document.getElementById("total_all_1").innerText = total + " VND";
    //     document.getElementById("total_all_2").innerText = total+ " VND";
    //
    // })

</script>