<%-- 
    Document   : role
  
    Author     : namhla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Role Page</title>
    </head>
     <div class="header">
        
    </div >
    <br>

    <div >
        <ul id="menu" >
            <li ><a href="/cafeapp">Home</a></li>
            <li><a href="#">roles</a>
                <ul>
                    <c:forEach var="roles" items="${roles}">
                        <li><a href="editrole?id=${role.id}"> ${channel.name} </a></li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
    <br>
    <br>


        <div class ="container">

            <div >
                <ul id="toolbar" >
                    <li><a href="#"> Create/Read/Update or Delete Role</a>
                </ul>

                <br>
               <br>
                <br>
            </div>
            <form  method="post" modelAttribute="role" action="updaterole">
                 <table width="100%" border="0" align="center" >
                  <tr>
                         <td align="center"> <a href="#"><img src="resources/images/chatimage.jpg" width="85" align="left"  alt="Profile picture" hspace="150" class="input">

                    <tr>

                    <tr>
                        <td class="input">Role Name: &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input type="text" name="name" class="input" value="${role.name}"></td>

                    <tr>


                        <td class="input">Role Description:&nbsp; &nbsp;<input type="text" name="description" class="input" value="${role.description}"></td>
                    </tr>

                  

                </table>

            </form>
        </div>
<br>
        <div class="footer"><h3>&copy;Namhla And Vuyokazi</h3></div>

</html>
