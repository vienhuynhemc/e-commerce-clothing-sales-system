<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Category" %>
<%@ page import="beans.product.ProductColor" %>
<%@ page import="beans.product.Size" %>
<%@ page import="beans.product.Product" %>
<%@ page import="beans.encode.ConvertPrice" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 7:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TVT Shop | Danh sách sản phẩm</title>

    <!-- Font awesome -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <!-- Top Slider CSS -->
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link rel="stylesheet" href="css/style.css">
    <link href="css/product.css" rel="stylesheet">
    <link rel="stylesheet" href="css/trangChu.css">
    <link rel="stylesheet" href="css/banner.css">
<%--    <script src="js"></script>--%>

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>
    <![endif]-->
<%request.setCharacterEncoding("utf-8");%>

    <!-------Laod các thuộc tính cần thiết--------------------->


    <% String type = (String) request.getAttribute("type");
        ArrayList<Category> listCategory = (ArrayList<Category>) request.getAttribute("listCategory");
        ArrayList<ProductColor> listColer = (ArrayList<ProductColor>) request.getAttribute("listColor");
        ArrayList<Size> listSize = (ArrayList<Size>) request.getAttribute("listSize");
        ArrayList<Product> listTop = (ArrayList<Product>) request.getAttribute("listTop");
    %>


    <!-------Laod các thuộc tính cần thiết--------------------->
</head>
<!-- !Important notice -->
<!-- Only for product page body tag have to added .productPage class -->


<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="CartLanguageController"/>
    <jsp:param name="levelPage" value=""/>
    <jsp:param name="activeselect" value="index.jsp"/>
</jsp:include>


<body class="productPage">
<!-- wpf loader Two -->
<%--<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>--%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Sản phẩm"/>
    <jsp:param name="titleEnglish" value="Product"/>
</jsp:include>



<!-- / catg header banner section -->




<!-- product category -->
<section id="aa-product-category">
    <div class="container contentlist">
        <div class="row ">
            <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
                <div class="aa-product-catg-content">
                    <div class="aa-product-catg-head">
                        <div class="aa-product-catg-head-left headerproduct">
                            <form action="" class="aa-sort-form">
                                <label for="" >XẾP THEO</label>
                                <select name="" id="selectOrder" onchange="changeListProduct()">
                                    <option value="mac-dinh" selected>Mặc định</option>
                                    <option value="ten_sp" >Tên sản phẩm</option>
                                    <option value="gia">Giá</option>
                                    <option value="ngay_tao">Ngày cập nhập</option>
                                </select>
                            </form>
                            <form action="" class="aa-show-form">
                                <label for="">XEM</label>
                                <select name="" id="xem_sl_sp" onchange="changeListProduct()">
                                    <option value="6" selected>6</option>
                                    <option value="12">12</option>
                                    <option value="18">18</option>
                                </select>
                            </form>
                        </div>
                        <div class="aa-product-catg-head-right  headerproduct">
                            <P>CHẾ ĐỘ XEM</P>
                            <a id="grid-catg" href="#" class="color1li"><span class="fa fa-th"></span></a>
                            <a id="list-catg" href="#" class="color2li"><span class="fa fa-list"></span></a>
                        </div>
                    </div>

            <!-------------Load danh sách sản phẩm ở đây ---------------->

                    <div id="loadProduct"></div>

                    <!-------------Load danh sách sản phẩm ở đây ---------------->

                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                <aside class="aa-sidebar">
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3><span class="red">Danh</span> Mục
                            <div class="iconec">
                                <div class="plus"></div>
                            </div>
                        </h3>
                        <ul class="aa-catg-nav">



         <!------------------- Load danh mục----------------------------------->

                            <%
                                for (Category c : listCategory){
                                %>
                            <li><button type="button" id="danhmuccho" onclick="loadProductByCategory(this)" value="<%=c.getMa_dm()%>">
                                <%=c.getTen_dm()%>
                            </button></li>
                            <%}%>

                            <input type="hidden" name="" id="laymadm" value="nocategory">
        <!---------------------------- Load danh mục----------------------------------->
                        </ul>

                    </div>

                    <h3 class="maintitilefilter">Lọc bởi
                        <div class="iconec">
                            <div class="plus"></div>
                        </div>
                    </h3>

                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <p><span class="red healtitle">Màu</span> sắc</p>
                        <div class="aa-color-tag">

                            <!---------Load màu sắc ở đây---->

                            <% for ( ProductColor color : listColer) {

                           %>

                            <button type="button" id="color" onclick="loadProductByColor(this)" value="<%=color.getMa_mau()%>"> <img id="mau" src="<%=color.getLink_hinh()%>" alt=""> </button>

                           <% } %>

                            <input type="hidden" name="" id="laymamau" value="nocolor">
                            <!---------Load màu sắc ở đây---->
                        </div>
                    </div>
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <p><span class="red healtitle">Khoảng</span> Giá</p>
                        <!-- price range -->
                        <div class="aa-sidebar-price-range">
                            <form action="">
                                <div id="skipstep" class="noUi-target noUi-ltr noUi-horizontal noUi-background">
                                </div>
                                <div class="rangespan">
                                    <span id="skip-value-lower" class="example-val">300,000 VND</span>
                                    <span id="skip-value-upper"   class="example-val">1,000,000 VND</span>
                                    <input type="hidden" name="" id="laygia" value="0">
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <p><span class="red healtitle">Size</span></p>
                        <div class="divsize">

                            <!---------Load size ở đây---->



                            <% for (Size size: listSize) {
                            %>
                            <button type="button" value="<%=size.getMa_size()%>" onclick="loadProductBySize(this)"><%=size.getTen_size()%></button>
                            <%} %>


                            <input type="hidden" name="" id="laysize" value="nosize">
                            <!---------Load size ở đây---->
                        </div>
                    </div>

                </aside>
                <div class="leftdivsmall">
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3><span class="red">Top</span>
                            <div class="iconec">
                                <div class="plus"></div>
                            </div>
                        </h3>
                        <div class="aa-recently-views">
                            <ul>

                                <!-------Load top sản phẩm chỗ này--------------->
                                <% for (Product p : listTop) {
                                  %>

                                <li>
                                    <a href="detailsProduct.html" class="aa-cartbox-img g1"></a>
                                    <div class="aa-cartbox-info">
                                        <div class="imggddiv">
                                            <img class="imggd" src="<%=p.getListIMG().get(0).getLink_hinh()%>" alt="">
                                        </div>
                                        <h4><a href="detailsProduct.html"><%=p.getTen_sp()%>%</a></h4>
                                        <div class="gdprice">
                                            <p><%=ConvertPrice.convertPrice(p.getPrice().getGia_sp())%> VND</p>
                                            <del><%=ConvertPrice.convertPrice(p.getPriceSale().getGia_sp_km())%> VND</del>
                                        </div>
                                    </div>
                                </li>

                               <% } %>
                                <!-------Load top sản phẩm chỗ này--------------->
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div id="addCartStatus" style="display:none; z-index: 100000;position: relative">
        <div class="changepassword" id="changepassword">
            <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
            <div class="mainchangepassword">
                <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
                <div class="changepasswordsuccess" id="changepasswordsuccess">


                </div>
            </div>
        </div>
    </div>


    <div id="addCartStatus2" style="display:none; z-index: 100000;position: relative">
        <div class="changepassword" id="changepassword2">
            <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
            <div class="mainchangepassword">
                <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
                <div class="changepasswordsuccess" id="changepasswordsuccess2">
                    <p> Vui lòng chọn đầy đủ thông tin để thêm sản phẩm vào giỏ hàng </p>
                    <button onclick="gobackpassword()">Trở về
                    </button>
                </div>
            </div>
        </div>
    </div>

</section>
<!-- / product category -->
<!-----các thẻ input hiden làm nhiệm vụ lấy dữ liệu------>

<input type="hidden" name="" id="ma_sp" value="">
<input type="hidden" name="" id="soluongsp" value="1">
<input type="hidden" name="" id="sexType" value="<%=request.getAttribute("type")%>">
<input type="hidden" name="" id="page" value="1">


<!-----các thẻ input hiden làm nhiệm vụ lấy dữ liệu------>
<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp">
    <jsp:param name="levelPage" value=""/>
</jsp:include>
<!-- Login Modal -->


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>
<!-- To Slider JS -->
<script src="js/sequence.js"></script>
<script src="js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="js/nouislider.js"></script>
<!-- Custom js -->
<script src="js/custom.js"></script>
<%--<script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>--%>

<script>

    function addCart(){


        var ma_sp = $("#layma_sanphamthemvaogiohang").val();
        var ma_size =  $("#layma_sizethemvaogiohang").val();
       var ma_mau = $("#layma_mauthemvaogiohang").val();
       var soluong = $("#soluongsp").val();

        // console.log(ma_sp);
        // console.log(ma_size);
        // console.log(ma_mau);
        // console.log(soluong);
        document.getElementById("addCartStatus2").style.display = "none";
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        if(ma_sp == "" || ma_size == "" || ma_mau == ""){

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';

        }else{
            document.getElementById("addCartStatus").style.display = "none";
            document.getElementById('changepassword').style.transform = 'scaleY(0)';
            $.ajax({
                url:'AddCartController',
                type:'get',
                dataType:'html',
                data:{
                    ma_sp:ma_sp,
                    ma_mau:ma_mau,
                    ma_size:ma_size,
                    so_luong:soluong
                },
                success:function (data){
                    console.log(data);
                     $('#changepasswordsuccess').html(data);

                     document.getElementById("addCartStatus").style.display = "block";
                    document.getElementById('changepassword').style.transform = 'scaleY(1)';

                },
                error:function () {
                    alert(" them sp that bai");
                    // window.location.href = 'index.jsp';
                }
            });

        }
    }

    function gobackpassword() {
        document.getElementById('changepassword').style.transform = 'scaleY(0)';
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';
    }


    $(document).ready(function (){
        var type = $('#sexType').val();
        $.ajax({

            url:'LoadProduct',
            type: 'get',
            dataType: 'html',
            data: {
                page:1,
                num:6,
                type:type,
                order:"mac-dinh",
                category:"nocategory",
                color:"nocolor",
                price: 0,
                size:"nosize",
                search:""
            },

            success: function (data){
                $('#loadProduct').html(data);
            },
            error: function (){
                alert("load sp that bai");
            }

        });

    })


    function loadProductByCategory(event) {

        var ma_dm = $(event).val();
        console.log(ma_dm);

        $("#laymadm").prop("value",ma_dm);

        $("#laysize").prop("value","nosize");
        $("#laymamau").prop("value","nocolor");


        changeListProduct();
    }
    function loadProductBySize(event){
        var ma_size = $(event).val();
        console.log(ma_size);

        $("#laysize").prop("value",ma_size);
        $("#laymamau").prop("value","nocolor");
        $("#laymadm").prop("value","nocategory");

        changeListProduct();
    }
    function loadProductByColor(event) {

        var ma_mau = $(event).val();

        console.log(ma_mau);

        $("#laymamau").prop("value",ma_mau);
        $("#laymadm").prop("value","nocategory");
        $("#laysize").prop("value","nosize");

        changeListProduct();
    }

    function changeListProduct(){

        var order = $("#selectOrder").val();
        // console.log(order);

        var num = $("#xem_sl_sp").val();
        // console.log(num);

        var ma_dm = $("#laymadm").val();
        // console.log(ma_dm);

        var ma_size = $("#laysize").val();
        // console.log(ma_size);

        var ma_mau = $("#laymamau").val();
        // console.log(ma_mau);

        var gia = $('#laygia').val();
        // console.log(gia);

        var type = $('#sexType').val();

        var page = $('#page').val();


        $.ajax({

            url:'LoadProduct',
            type: 'get',
            dataType: 'html',
            data: {
                page:page,
                num:num,
                type:type,
                order:order,
                category:ma_dm,
                color:ma_mau,
                price: gia,
                size:ma_size,
                search:""
            },

            success: function (data){
                $('#loadProduct').html(data);
            },
            error: function (){
                alert(" thay doi danh sach sp that bai");
            }

        });


    }

</script>
<script>

    function loadSize(event) {


        var list = event.children;

        var ma_sp = $(list[0]).val();

        $("#ma_sp").attr("value",ma_sp);

        console.log(ma_sp);

        $.ajax({

            url: 'LoadSizeByIDProduct',
            dataType:'html',
            type:'get',
            data:{
                ma_sp:ma_sp
            },
            success: function (data) {
                $(".loadSizeByID_" + ma_sp).html(data);
            },
            error:function (){
                alert("k load dc size");
            }

        })

        $.ajax({

            url: 'LoadColorByIDProduct',
            dataType:'html',
            type:'get',
            data:{
                ma_sp:ma_sp
            },
            success: function (data) {
                $(".loadColor_" + ma_sp).html(data);
            },
            error:function (){
                alert("k load dc mau");
            }

        })
        $("#layma_sanphamthemvaogiohang").prop("value","");
        $("#layma_sizethemvaogiohang").prop("value","");
        $("#layma_mauthemvaogiohang").prop("value","");
        $('#laymamaudccheck input[type = radio]').prop("checked",false);
        $(".sladdtocard").prop("value",1);
         $("#soluongsp").prop("value",1);
    }

    function changeColor(event){

        var ma_sp = $("#ma_sp").attr("value");

        <!-- chỗ này sử lí click hiện cho đẹp thôi  -->
        let l = document.getElementsByClassName("loadSizeByID_" + ma_sp);
        let l1 = l[0].children;
        let l2 = l[1].children;
        for (i = 0; i < l1.length; i ++){
            $(l1[i]).css("border","none");
            $(l2[i]).css("border","none");
        }
        $(event).css("border","1px solid red");
        $(event).css("border-radius","6px");
        $(event).css("outline","none");

        <!-- chỗ này sử lí click hiện cho đẹp thôi  -->


        console.log("ma_sp " + ma_sp);

        var ma_size = $(event).attr("id");

        <!-- khi click vào thì gán giá trị mã tương ứng để chờ add vào giỏ hàng-->

        $("#layma_sanphamthemvaogiohang").prop("value",ma_sp);
        $("#layma_sizethemvaogiohang").prop("value",ma_size);
        $("#layma_mauthemvaogiohang").prop("value","");

        <!-- khi click vào thì gán giá trị mã tương ứng để chờ add vào giỏ hàng-->
        console.log("ma_size " +ma_size);


        let list = document.getElementsByClassName("loadColor_" + ma_sp);

        let list1 = list[0].children;
        let list2 = list[1].children;


        console.log(list1);
        // console.log(list4);

        $.ajax({

            url: 'LoadColorBySize',
            dataType:'html',
            type:'get',
            data:{
                ma_sp:ma_sp,
                ma_size:ma_size
            },
            success: function (data) {
                $(".loadColor_" + ma_sp).html(data);
            },
            error:function (){
                alert("k load dc mau theo size");
            }

        })

    }

    function addcolor(event){

        var list = event.children;

         var ma_mau = $(list[0]).val();

             var ma_sp = $("#ma_sp").attr("value");
            <!-- chỗ này sử lí click hiện cho đẹp thôi  -->
            let l = document.getElementsByClassName("loadcolor_" + ma_sp);
            let l1 = l[0].children;
            let l2 = l[1].children;
            for (i = 0; i < l1.length; i ++){
                $(l1[i]).css("border","none");
                $(l2[i]).css("border","none");
            }
            $(event).css("border","1px solid red");
            $(event).css("border-radius","6px");
            $(event).css("outline","none");

            <!-- chỗ này sử lí click hiện cho đẹp thôi  -->

             $("#layma_mauthemvaogiohang").prop("value",ma_mau);

        }
    function plustocard() {
        var n = $(".sladdtocard").val();
        const nn = Number(n);
        $(".sladdtocard").prop("value",nn+1);
        $("#soluongsp").prop("value",nn+1);
    }

    function subtocard() {
        var n = $(".sladdtocard").val();
        const nn = Number(n);
        if (nn > 1) {
            $(".sladdtocard").prop("value",nn-1);
            $("#soluongsp").prop("value",nn-1);
        }
    }
    function changePage(event){
        var page = $(event).attr("id");
        document.getElementById("page").value = page;
        changeListProduct();
    }


</script>

</body>

</html>

