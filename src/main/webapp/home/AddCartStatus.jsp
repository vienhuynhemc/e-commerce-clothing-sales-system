
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<p> Thêm sản phẩm vào giỏ hàng thành công </p>
<p> Chúc mừng bạn đã thêm sản phẩm vào giỏ hàng thành công!
    Hãy tiếp tục mua sắm thoải mái hoặc vào giỏ hàng để kiểm tra sản phẩm nhé.</p>

<% boolean check = (boolean) request.getAttribute("check"); %>

            <% if (check) {%>
            <p> Thêm sản phẩm vào giỏ hàng thành công </p>
            <p> Chúc mừng bạn đã thêm sản phẩm vào giỏ hàng thành công!
                Hãy tiếp tục mua sắm thoải mái hoặc vào giỏ hàng để kiểm tra sản phẩm nhé.</p>
            <%}else { %>
            <p> Thêm sản phẩm vào giỏ hàng thất bại </p>
            <p> Có lẽ đã sảy ra vấn đề nào đó về sản phẩm, chúng tôi sẽ sớm khác phục nhanh
            nhất có thể, hãy lựa chọn sản phẩm khác bạn nhé.</p>
            <%}%>

<button onclick="gobackpassword()">Trở về
</button>


