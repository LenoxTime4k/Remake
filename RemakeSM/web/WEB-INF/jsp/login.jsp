<%-- 
    Document   : login
    Created on : 21-11-2018, 14:45:29
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
        
        <div class="container">
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
                        <a class="navbar-brand" href="#">Santo Mercado</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            
                            <li><a href="agregarProducto.htm">Producto</a></li>
                            <li><a href="index1.htm">Registrar Usuario</a></li>
                            
                        </ul>
                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Buscar">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </form>
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
            
            <div class="col-md-6 col-md-offset-3">
                <h1>Iniciar sesión</h1>
                <form>
                    <div class="form-group">
                        <label for="email">Correo electrónico</label>
                        <input class="form-control" name="email" id="email">
                    </div>

                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input class="form-control" name="password" id="password" type="password">
                    </div>

                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
            </div>
        </div>
    </body>
</html>
