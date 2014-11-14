<%-- 
    Document   : updateRole
    Author     : namhla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <header id="header">
        <hgroup>
            <h1 class="site_title"><img src="images/logo.png" alt="logo" width="40" height="40"></h1>
            <h2 class="section_title">Cafe App</h2>
            <div class="btn_view_site">			
            </div>
        </hgroup>
    </header> <!-- end of header bar -->

    <section id="secondary_bar">
        <div class="user">
         
        </div>
        
    </section>
    <form action="updateRole" method="post" modelAttribute="role">
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
                                <td> <input name="name" type="text" value="${role.roleName}" size="30" maxlength="30"></td>

                            </tr>
                            <tr>
                                <td width="85" height="30">Description : </td>
                                <td><input name="description" type="text" value="${role.description}" size="30" maxlength="30"></td>

                            </tr>
                           
                        </table> 
                        <td align="left">
                            <input name="submit" type="button" value="Update" width="40" height="30">
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

</body>
