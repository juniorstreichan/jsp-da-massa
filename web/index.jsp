<%--
    Document   : index
    Created on : 22/03/2018, 19:24:40
    Author     : Junior.erdmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP DA MASSA</title>
        <link rel="stylesheet" type="text/css" href="css/materialize.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    </head>
    <body class="teal">
        <div class="container row">
            <br>
            <br>
            <br>
            <div class="col s12 m4 offset-m4 card-panel z-depth-4">
                <form action="Controle">
                    <br>
                    <div class="input-field ">
                        <i class="material-icons prefix">account_circle</i>
                        <input name="login" id="login" type="text" class="validate">
                        <label for="login">Login</label>
                    </div>

                    <div class="input-field ">
                        <i class="material-icons prefix">vpn_key</i>
                        <input name="senha"  id="senha" type="password" class="validate">
                        <label for="senha">Senha</label>
                    </div>

                    <div class="center">
                        <input class="btn waves-effect waves-light" type="submit" value="Login" />
                    </div>
                    <br><br>
                </form>

            </div>
        </div>


        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

    </body>
</html>
