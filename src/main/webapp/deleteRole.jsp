<%-- 
    Document   : deleteRole
    Author     : namhla
--%>
<jsp/>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form  method="post" modelAttribute="role" action="deleteRole">
   
    <table >
       
            <tr>
                <td>Role Name</td>
                <td><input  type="text" name="name" value="${role.roleName}"/></td>
              
            </tr>
            <tr>
                <td>Description</td>
                <td><input  type="text" name="description" value="${role.description}"/></td>
                
            </tr>
            <tr> 
                
                    <td><button type="submit" >Delete Role</button>
          </td>
                <td></td>
            </tr>
    </table>

</form> 
<jsp/>
