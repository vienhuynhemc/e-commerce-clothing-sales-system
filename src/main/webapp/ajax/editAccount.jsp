<%@ page import="java.util.Map" %>
<%@ page import="model.language.ChangInfoCustomerLanguageModel" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.DateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-------------------------------------- lấy session chứa tài khoản ------------------------------>

<% AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user"); %>

<!-------------------------------------- ----------------------------- ------------------------------>
<!-------------------------------------- lấy session chứa tài khoản ------------------------------>

<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = ChangInfoCustomerLanguageModel.getInstance().getList("vietnamese");
    }

%>


<div class="left" id="leftaccount">
    <p class="titleleft"><i class="fa fa-address-card-o"></i> TVTShop</p>
    <div class="leftitemselect activeeselect" onclick="trangthai()" id="buttontrangthai">
        <p><i class="fa fa-tasks"></i> <%=lang.get("26")%></p>
        <i class="fa fa-chevron-right"></i>
    </div>
    <div class="leftitemselect" onclick="lichsumua()" id="buttonlsm">
        <p><i class="fa fa-history"></i><%=lang.get("27")%></p>
        <i class="fa fa-chevron-right"></i>
    </div>
    <form action="LogOutController" method="post">
        <div class="leftitemselect">
            <a href="dang-xuat"><i class="fa fa-power-off"></i><%=lang.get("28")%></a>
            <%--                       <input type="submit">--%>
            <i class="fa fa-power-off"></i>

            <i class="fa fa-chevron-right"></i>
        </div>
    </form>
    <div class="lineleft"></div>

    <div class="customer">
        <div class="imguser">
            <img id="avatar" src="<%=accountCustomer.getAvatar()%>" alt="">
        </div>
        <p class="titleuser"><%=accountCustomer.getFullName()%><i class="fa fa-circle"></i></p>
        <p class="gmailuser"><%=accountCustomer.getEmail()%></p>
        <p class="soinoi"><%=lang.get("29")%>: Tiêu chuẩn</p>
        <input id="fileInput" type="file" style="display:none;" onchange="loadIMG(event)"/>
        <button type="button" class=" changeimg" onclick="document.getElementById('fileInput').click()"><%=lang.get("30")%>
        </button>

        <div class=" planclick">
            <div class="headerplanclick">
                <p><%=lang.get("31")%></p>
                <div class="lineheaderplanclick">
                    <div></div>
                </div>
            </div>
            <div class="contetnplanclick">
                <div class="itemplanclick">
                    <h3>5,467</h3>
                    <p><%=lang.get("32")%></p>
                </div>
                <div class="lineitemplanclick"></div>
                <div class="itemplanclick">
                    <h3>102,467</h3>
                    <p><%=lang.get("33")%></p>
                </div>
            </div>
        </div>


    </div>

</div>

<div class="rightaccount" id="rightaccount">

    <div class="status" id="status">
        <p class="statustitle"><%=lang.get("4")%></p>
        <p class="statusavatar"><%=lang.get("1")%></p>
        <div class="divavatar">
            <div class="avatar">
                <input id="loadAvatar" type="hidden" name="avatar" value="<%=accountCustomer.getAvatar()%>" >
                <img name="avatar" id="avatar2" src="<%=accountCustomer.getAvatar()%>" alt="">
            </div>
            <button type="button" onclick="document.getElementById('fileInput').click()"><%=lang.get("2")%></button>
            <button type="button" onclick="removeAvatarAccount()"><%=lang.get("3")%></button>
        </div>
        <div class="linestatus"></div>
        <div class="statusdivinput">
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("5")%></p>
                    <p><%=lang.get("6")%></p>
                </div>
                <input name="displayName" id="ten_hien_thi" type="text" value="<%=accountCustomer.getDisplayName()%>">
            </div>
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("7")%></p>
                    <p><%=lang.get("8")%></p>
                </div>
                <input name="fullName" id="ten_day_du" type="text" value="<%=accountCustomer.getFullName()%>">
            </div>
        </div>
        <div class="linestatus"></div>
        <div class="statusdivinput">
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("4")%></p>
                    <p><%=lang.get("9")%></p>
                </div>
                <input name="" type="text" value="<%=accountCustomer.getUserName()%> " disabled>
                <input name="userName" type="hidden" value="<%=accountCustomer.getUserName()%>">
            </div>
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("10")%></p>
                    <p id="doimatkhau" onclick="doimatkhau()" class="doimatkhau"><%=lang.get("11")%></p>
                </div>
                <input type="password" value="<%=accountCustomer.getPassWord() %>" disabled>
            </div>
        </div>
        <div class="linestatus"></div>
        <div class="statusdivinput">
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("12")%></p>
                    <p><%=lang.get("13")%></p>
                </div>
                <input type="text" value="<%=accountCustomer.getEmail()%>" disabled>
            </div>
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("14")%></p>
                    <p><%=lang.get("13")%></p>
                </div>
                <input type="text" value="<%=accountCustomer.getPhone()%>" disabled>
            </div>
        </div>
        <div class="linestatus"></div>
        <div class="statusdivinput">
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("15")%></p>
                    <p><%=lang.get("16")%></p>
                </div>

                <%DateTime date = accountCustomer.getRegisDate();%>

                <input type="text" value="<%=date.getDay()%> - <%=date.getMonth()%> - <%=date.getYear()%>" disabled>
            </div>
            <div class="statusdivinputitem">
                <div>
                    <p><%=lang.get("17")%></p>
                    <p><%=lang.get("18")%></p>
                </div>
                <input type="text" value="<%=accountCustomer.getIdUser()%>" disabled>
            </div>
        </div>
        <div class="linestatus"></div>
        <div class="connectgg">
            <p><%=lang.get("19")%></p>
            <p><%=lang.get("20")%></p>
            <div>
                <div><img src="../img/google.jpg" alt="">
                    <p><%=lang.get("21")%></p>
                </div>
                <button><%=lang.get("22")%></button>
            </div>
        </div>
        <div class="linestatus"></div>

        <div class="deleleaccount">
            <div>
                <p><%=lang.get("23")%></p>
                <p><%=lang.get("24")%></p>
            </div>
            <p onclick="xoataikhoan()"><%=lang.get("23")%>...</p>
        </div>

        <div class="linestatus"></div>

        <button type="button" class="savestatus" onclick="changeInfo()"><%=lang.get("25")%></button>
    </div>

    <div class="historyorder" id="historyorder">

        <div class="historyheader">
            <p class="historytitle"><%=lang.get("27")%></p>
            <input type="text" id="searchE" oninput="loadHistory()" value="" placeholder="Tìm kiếm mã đơn hàng">
        </div>

        <!------ load lịch sử đơn hàng vào thẻ div này------>
        <div id="loadHistoryIn"></div>
        <!------ load lịch sử đơn hàng vào thẻ div này------>

    </div>

</div>

<input type="hidden" name="" id="hinhanh" value="<%=accountCustomer.getAvatar()%>">
<input type="hidden" name="" id="sotrang" value="1">
<input type="hidden" name="" id="laymadonhang" value="">

<script>

    function loadHistoryByPage(event){

        var page = $(event).val();

        $("#sotrang").prop("value",page);

        loadHistory();

    }

    function loadHistory(){
        var page = $("#sotrang").val();
        var search = $("#searchE").val();

        console.log(page);
        $.ajax({
            url:'LoadListPayController',
            dataType:'html',
            type:"get",
            data:{
                page:page,
                search:search
            },
            success:function (data) {
                $("#loadHistoryIn").html(data);
            },
            error:function (){
                //alert("loi load lich su don hang");
            }

        });
    }


    function changeInfo(){

        var ten_day_du = $("#ten_day_du").val();
        var ten_hien_thi = $("#ten_hien_thi").val();

        $.ajax({
            url:'EditAccountController',
            dataType:'json',
            type:'post',
            data:{
                displayName:ten_hien_thi,
                fullName:ten_day_du,
            },
            success:function (data){
                if (!data){
                    window.location.href = "index.jsp";
                }else{
                    loadInfo();
                }
            },
            error:function (){

            }
        });

    }

</script>
<script>
    // Your web app's Firebase configuration
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    var firebaseConfig = {
        apiKey: "AIzaSyCNKrWfzyctIJeK4XgPlU5AKR1y2hY1zA0",
        authDomain: "ecommerce-b6c08.firebaseapp.com",
        databaseURL: "https://ecommerce-b6c08-default-rtdb.firebaseio.com",
        projectId: "ecommerce-b6c08",
        storageBucket: "ecommerce-b6c08.appspot.com",
        messagingSenderId: "390576423583",
        appId: "1:390576423583:web:efcf73909008a68dcd18aa",
        measurementId: "G-LR0V7PWKZN"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();

    function loadIMG(event) {
        if (event.target.files.length > 0) {

            const ref = firebase.storage().ref();
            const file = event.target.files[0];
            const name = file.name;
            let link;
            let nameData = name.split('.')[0];
            const folder = "Avatar/" + nameData;
            const metadata = {contentType: file.type};
            let urlm;
            const task = ref.child(folder).put(file, metadata);
            task
                .then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    alert("Thanh cong");
                    document.getElementById('avatar').src = url;
                    document.getElementById('avatar2').src = url;
                    document.getElementById("loadAvatar").value = url;
                    urlm = url;

                    link = url;
                    firebase.database().ref(folder).set({
                        Name: nameData,
                        Link: link
                    })
                });

// Lấy dữ liệu xuống như lấy thuộc tính từ đối tượng ra , chỉ cần truyền đúng link thì oke
//             firebase.database().ref().on('value', function (snapshot) {
//                 document.getElementById('avatar').src = snapshot.val().Link;
//                 document.getElementById('avatar2').src = snapshot.val().Link;
//                 document.getElementById("loadAvatar").value = snapshot.val().Link;
//             })
        }
    }

    function removeAvatar() {

        document.getElementById('avatar').src = '../img/user.jpg';
        document.getElementById('avatar2').src = '../img/user.jpg';
// xoá thì truyền link vào
//database
        firebase.database().ref(<%=accountCustomer.getAvatar()%>).remove();
        // img
        firebase.storage().ref(<%=accountCustomer.getAvatar()%>).delete();


    }

</script>