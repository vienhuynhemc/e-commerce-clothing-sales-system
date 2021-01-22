
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<% boolean check = (boolean) request.getAttribute("check"); %>

            <% if (check) {%>
            <p> Thêm sản phẩm vào giỏ hàng thành công </p>
            <p> Chúc mừng bạn đã thêm sản phẩm vào giỏ hàng thành công!
                Hãy tiếp tục mua sắm thoải mái hoặc vào giỏ hàng để kiểm tra sản phẩm nhé.</p>
            <%}else { %>
            <p> Thêm sản phẩm vào giỏ hàng thất bại </p>
            <p> Thêm sản phẩm không thành công có thể bạn đã chưa đăng nhập, hoặc sản phẩm đã ngừng hoạt động.
                Hãy vui lòng đăng nhập để tiếp tục hoặc chọn sản phẩm khác bạn nhé!!
            </p>
            <%}%>

<button onclick="gobackpassword()">Trở về
</button>


