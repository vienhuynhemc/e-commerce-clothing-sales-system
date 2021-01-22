<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Size" %>

<% ArrayList<Size> list = (ArrayList<Size>) request.getAttribute("listSize"); %>

    <% for (Size s: list) {

     %>
        <button style="background-color: transparent;border: none;" type="button" id="<%=s.getMa_size()%>" onclick="changeColor(this)"><%=s.getTen_size()%></button>
  <%}%>
