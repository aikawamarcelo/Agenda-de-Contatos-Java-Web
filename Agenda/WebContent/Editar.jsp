<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel ="stylesheet" href="Style.css">
<title>Agenda de Contatos</title>
<link rel="icon" href="img/Telefone.png">

</head>
<body>

    <h1>Editar contato</h1>

<form name="frmContato" action="update">

<table>

<tr>
<td>
<input type="text" name="idcontatos"  id="Caixa3" readonly
value="<%out.print(request.getAttribute("idcontatos"));%>"></td>
</tr>
<tr>
<td>
<input type="text" name="nome"  class="Caixa1" 
value="<%out.print(request.getAttribute("nome"));%>"></td>
</tr>
<tr>
<td>
<input type="text" name="telefone"  class="Caixa2"
value="<%out.print(request.getAttribute("telefone"));%>"></td>
</tr>
<tr>
<td>
<input type="text" name="email" class="Caixa1"
value="<%out.print(request.getAttribute("email"));%>"></td>
</tr>
</table>

<input type="button" value="Salvar" class="BAzul"  onClick="validar()">

</form>
<script src="scripts/Validador.js"></script>
</body>
</html>