<%-- 
    Document   : addrole
    Author     : namhla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Role Page</title>
    </head>
   <body>
    <header id="header">
       
    </header> <!-- end of header bar -->

    <section id="secondary_bar">
        <div class="user">
            
        </div>
        <div class="breadcrumbs_container">
            <article class="breadcrumbs"><a href="/admin/">Home </a> </article>
        </div>
    </section>
    <form action="createRole" method="post" modelAttribute="RoleModel">
        <section id="main" class="column">
            <div id='headermsg'>
                <!-- <h4 class="alert_warning">A Warning Alert</h4> -->
                <div id='dashalert'></div>
            </div>	

            <article class="module width_full" id='middlecontent'>
                <header>
                    <h3 class="tabs_involved">Role </h3>
                </header>
                <div class="tab_container" id='centercontent'>
                    <div id="tab1" class="tab_content">            
                        <table width="300" border="0">
                            <tr>
                                <td width="85" height="30">Role Name : </td>
                                <td> <input name="name" type="text" value="${Roles.roleName}" size="30" maxlength="30"></td>

                            </tr>
                            <tr>
                                <td width="85" height="30">Description : </td>
                                <td><input name="description" type="text" value="${Roles.description}" size="30" maxlength="30"></td>

                            </tr>
                         
                        </table> 
                        <td align="left">
                            <input name="submit" type="button" value="Add" width="40" height="30">
                        </td>
                     
                    </div>
                    <!-- end of #tab1 -->			
                    <div id="tab2" class="tab_content">

                    </div>
                    <!-- end of #tab2 -->

                    <div id="tab3" class="tab_content">

                    </div>
                </div><!-- end of .tab_container -->	
            </article>

            <div class="clear"></div>

            <div class="spacer"></div>
        </section> 
    </form>
</html>
