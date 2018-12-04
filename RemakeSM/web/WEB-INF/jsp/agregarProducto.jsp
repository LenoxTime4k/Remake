<%-- 
    Document   : agregarProducto
    Created on : 23-11-2018, 14:02:10
    Author     : Kevin_PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Santo Mercado</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/magnific-popup.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     
     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/templatemo-style.css">
    </head>
    <body>
        <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
          <div class="container">

               <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                    </button>

                    <!-- lOGO TEXT HERE -->
                    <a href="index.htm" class="navbar-brand">Santo Mercado</a>
               </div>
          </section>      
        <section id="home" data-stellar-background-ratio="0.5">
          <div class="overlay"></div>
          
          <div class="container">
              
              <div class="row">
                    <div class="col-md-4 col-md-offset-3">
                           <h1>Registrar Producto</h1>
                           <form>
                               <div class="form-group">
                                   <label for="nombre">Nombre Producto</label>
                                   <input class="form-control" name="nombre" id="nombre" type="text" required>
                               </div>

                               <div class="form-group">
                                   <label for="precio">Precio</label>
                                   <input class="form-control" name="precio" type="text" required>
                               </div>

                               <div class="form-group">
                                   <label for="descripcion">Descripcion</label>
                                   <input class="form-control" name="descripcion" id="descripcion" type="text" required>
                               </div>

                               <br>

                               <div>
                                 <button type="submit" class="btn btn-primary">Guardar</button>  
                               </div>


                           </form>
                    </div>
              </div>
              </div>
        </section>
    </body>
</html>
