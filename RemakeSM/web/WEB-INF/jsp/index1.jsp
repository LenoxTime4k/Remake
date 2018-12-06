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
        <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/magnific-popup.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     
     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/templatemo-style.css">
    </head>
    <body>
        <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
               <div class="navbar-header">
                    <!-- lOGO TEXT HERE -->
                    <a href="index.htm" class="navbar-brand">Santo Mercado</a>
               </div>
          </section>      
        <section id="home" data-stellar-background-ratio="0.1">
          <div class="overlay"></div>
        
            <div class="col-md-4 col-md-offset-3">
                <h2>Registrar usuario</h2>
                <form id="command" method="post">
                    <div class="form-group">
                        <label for="nombre">Nombre Usuario</label>
                        <input class="form-control" name="nombreUsuario" id="nombreUsuario" type="text" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input class="form-control" name="contraseña" id="contraseña" type="text" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre_completo">Nombre completo</label>
                        <input class="form-control" name="nombreCompleto" id="nombreCompleto" type="text" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="rut">Rut</label>
                        <input class="form-control" name="rutReg" id="rutReg" type="text" required>
                    </div>
                    
                    <div >
                            <label for="sel1">Comuna/Sector</label>
                            <select class="form-control" name="comunaresidencia" id="sel1">
                            <option value="opcion" selected>Eliga una opcion</option>
                            <option value="Mirasol">Mirasol</option>
                            <option value="Alerce">Alerce</option>
                            <option value="Puerto_Varas">Puerto Varas</option>
                            <option value="Llanquihue">Llanquihue</option>
                            <option value="Frutillar">Frutillar</option>
                            <option value="Puerto_Montt">Puerto Montt</option>
                            </select>
                    </div>
                    
                    <div>
                            <label for="sel1">Sede</label>
                            <select class="form-control" name="sede" id="sel1">
                            <option value="opcion" selected>Eliga una opcion</option>
                            <option value="Sede_Puerto_Montt">Sede Puerto Montt</option>
                            <option value="Sede_Puerto_Varas">Sede Temuco</option>
                            
                        </select>
                        </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <br>
                    <div>
                        <label>Lista de Usuarios1 </label>
                        
                    </div>
                </form>
            </div>
          </section>
    </body>
</html>
