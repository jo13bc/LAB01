<html>  
    <head>
        <%@page contentType="text/html"%>
        <%@page pageEncoding="UTF-8"%>
        <%@ include file="Head.jspf" %>
        <script src="Javascript/principal.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md" style="text-align: center">
                            <h1 id="principal_title"></h1>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-4" id="card-dashboard">
                            <div id="activos">
                                <div class="card">
                                    <div class="card-header" style="text-align: center;">
                                        <a class="card-link" data-toggle="collapse"
                                           href="#collapseActivos">
                                            <h1>Cursos</h1>
                                        </a>
                                    </div>
                                    <div id="collapseActivos" class="collapse"
                                         data-parent="#activos">
                                        <div class="card-body">
                                            <div class="row d-flex justify-content-center">
                                                <a href="crud_curso.jsp">
                                                    Lista de cursos&nbsp;
                                                    <i class="fa fa-desktop fa-lg"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="Footer.jspf" %>
        </div>
    </body>
</html>

