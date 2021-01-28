<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.ringNotification.RingNotification" %>
<%@ page import="model.headerAdmin.HeaderAdminModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/12/2020
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
    List<RingNotification> ringNotificationList = HeaderAdminModel.getInstance().getListRingNotificationFromId(userAdmin.getAccount().getId());
%>

<div class="indextop">
    <h3>TVT<span style="color: #2a2935;">S</span>hop</h3>
    <div class="indextopright">
        <div class="indextopbell  dontindextopbellinfor" onclick="indextopbellinfor(this)">
            <i class="fa fa-bell-o"></i>
            <div>
                <i class="fa fa-circle"></i>
            </div>
            <div class="indextopbellinfor">
                <i class="fa fa-caret-up"></i>
                <div>
                    <h3>Thông báo</h3>
                    <div class="indextopbellinforcontent">
                        <div>

                            <%

                                for(RingNotification ringNotification : ringNotificationList){


                            %>

                            <a class="indextopbellinforcontentitem" href="<%=ringNotification.getLink()%>">
                                <div>
                                    <img src="<%=ringNotification.getLinkImgSender()%>" alt="">
                                </div>
                                <div>
                                    <p><strong><%=ringNotification.getNameSender()%></strong> <%=ringNotification.getContent()%></p>
                                    <p><%=ringNotification.getDateCreated().toStrngRingNotification()%></p>
                                </div>
                            </a>
                            <div class="lineindextopbellinforcontentitem"></div>

                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <input type="checkbox" style="display: none;">
        </div>
        <a class="indextopaccount">
            <div>
                <img src="<%=userAdmin.getAccount().getAvatarLink()%>" alt="">
            </div>
            <div>
                <h3><%=userAdmin.getAccount().getDisplayName()%></h3>
                <p><%=request.getParameter("level")%></p>
            </div>
        </a>
    </div>
</div>

<div class="backgroundindexmain">
</div>