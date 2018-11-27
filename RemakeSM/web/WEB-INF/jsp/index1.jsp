<%-- 
    Document   : index1
    Created on : 21-11-2018, 14:49:16
    Author     : Kevin_PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Santo Mercado</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <style>
             body{
                 background-repeat: no-repeat;
                 background-attachment: fixed;
                 background-position: center;
                 background-image: url(https://www.analyticsindiamag.com/wp-content/uploads/2013/03/prestashop.jpg);
                 background-color: #cccccc;
             }
         </style>
    </head>
    <body>
        
        <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="login.htm">Santo Mercado</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Salir</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        
            <div class="col-md-4 col-md-offset-3">
                <h2>Registrar usuario</h2>
                <form>
                    <div class="form-group">
                        <label for="nombre">Nombre Usuario</label>
                        <input class="form-control" name="nombre" id="nombre" type="text" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input class="form-control" name="password" id="password" type="password" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre_completo">Nombre completo</label>
                        <input class="form-control" name="nombre_completo" id="nombre_completo" type="text" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="rut">Rut</label>
                        <input class="form-control" name="rut" id="rut" type="text" required>
                    </div>
                    
                    <div >
                            <label for="sel1">Comuna/Sector</label>
                            <select class="form-control" id="sel1">
                            <option value="opcion" selected>Eliga una opcion</option>
                            <option value="Mirasol">Mirasol</option>
                            <option value="Alerce">Alerce</option>
                            <option value="Puerto_Varas">Puerto Varas</option>
                            <option value="Llanquihue">Llanquihue</option>
                            <option value="Frutillar">Frutillar</option>
                            <option value="Puerto_Montt">Puerto Montt</option>
                            
                        </select>
                        </div>
                    
                    
                    <div >
                            <label for="sel1">Sede</label>
                            <select class="form-control" id="sel1">
                            <option value="opcion" selected>Eliga una opcion</option>
                            <option value="Sede_Puerto_Montt">Sede Puerto Montt</option>
                            <option value="Sede_Puerto_Varas">Sede Temuco</option>
                            
                        </select>
                        </div>

                    <button type="submit" class="btn btn-primary">Guardar</button>
                </form>
            </div>
        
    </body>
</html>
