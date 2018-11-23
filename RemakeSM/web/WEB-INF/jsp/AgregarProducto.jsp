<%-- 
    Document   : AgregarProducto
    Created on : 23-nov-2018, 14:43:51
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css></linl">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <title>DISCLOSURE</title>
    </head>
    <body>
       <div class="container">

            <h1 class="text-center">Gestion de Registro</h1>
            <div class="row">
                <section class="col-md-3">
                    <form action="./Productos" method="POST">
                        <div ><input type="hidden" name="id" value="${prod.getId()}"></div>
                        <div class="form-group"><label for="nombre">Nombre: </label><input class="form-control"  type="text" name="nombre" value="${prod.getNombre()}"></div>
                        <div class="form-group"><label for="descripcion">Descripcion: </label><input class="form-control" type="text" name="descripcion" value="${prod.getDescripcion()}"> </div>
                        <div class="form-group"><label for="valor">Valor $</label><input class="form-control" type="number" min="0" value="${prod.getValor()}" name="valor"></div>
                        <input type="submit" value="Enviar" class="btn btn-primary btn-sm btn-block">
                        <a  href="./index.jsp"><button  type="button" class="btn btn-danger btn-primary btn-sm btn-block alert-link">Salir</button></a>
                    </form>
                </section>
                <section class="col-md-9">
                    <table class="table table-sm table-hover">
                        <thead class="thead-inverse">
                        <th>id</th>
                        <th>nombre</th>
                        <th>descripcion</th>
                        <th>valor</th>
                        <th>acciones</th>
                        </thead>
                        <c:forEach items="${productos}" var="producto">
                            <tr>
                                <td>${producto.getId()}</td>
                                <td>${producto.getNombre()}</td>
                                <td>${producto.getDescripcion()}</td>
                                <td>${producto.getValor()}</td>
                                <td class="row">
                                    <a href="./Productos?id=${producto.getId()}" class="btn btn-warning">editar</a>&nbsp;
                                    <form action="./Productos" method="POST">
                                        <input type="hidden" name="id" value="${producto.getId()}">
                                        <input type="hidden" name="eliminar" value="true">
                                        <button type="submit" class="btn btn-danger">Eliminar</button>

                                    </form>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>
                </section>
            </div>
        </div>
    </body>
</html>
