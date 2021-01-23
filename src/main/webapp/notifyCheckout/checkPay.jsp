<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% boolean check = (boolean) request.getAttribute("check"); %>

<% if (check) {%>
<p> Chúc mừng bạn đã thanh toán thành công </p>
<p> Sản phẩm đang trên đường giao đến tay bạn sớm nhất, hãy thoải mái mua sắm bạn nhé!!</p>
<%}else { %>
<p> Thanh toán thất bại </p>
<p> Có vẻ như sản phẩm của bạn đã hết hàng, hoặc sản phẩm đã ngừng hoạt động, hãy chọn sản phẩm khác bạn nhé.
</p>
<%}%>

<button onclick="gobackpassword()">Trở về
</button>