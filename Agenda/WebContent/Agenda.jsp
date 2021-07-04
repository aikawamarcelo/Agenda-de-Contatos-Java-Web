<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "Model.JavaBeans"%>
<%@ page import = "java.util.ArrayList"%>

<%


//for(int i = 0; i < lista.size(); i++){
	// out.println(lista.get(i).getIdcontatos());
	// out.println(lista.get(i).getNome());
	// out.println(lista.get(i).getTelefone());
	// out.println(lista.get(i).getEmail());
	//}



@ SuppressWarnings ("unchecked") //Para ignorar avisos
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

// Alt+shift+ y quebra autom de linhas

%>

<!DOCTYPE html>


<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel ="stylesheet" href="Style.css">
<title>Agenda de Contatos</title>
<link rel="icon" href="img/Telefone.png">
</head>
<body>

   <h1>Agenda de Contatos</h1>
   
   <a href="Novo.html" class="BAzul">Novo Contato</a>
   <a href = "report" class="BVermelho">Relatório</a>
   <table id = "tabela">
   
   <thead>
   <tr>
       <th>Código</th>
       <th>Nome</th>
       <th>Telefone</th>
       <th>E-mail</th> 
       <th>Opções</th>
   </tr> 
   </thead>
   
   <tbody>
   
   <% //Scriplet 
   for (int i = 0 ; i<lista.size(); i++){
	
	   %>
	   <tr>
	  <td> <%= lista.get(i).getIdcontatos()  %></td>
	  <td> <%= lista.get(i).getNome()  %></td>
	  <td> <%= lista.get(i).getTelefone()  %></td>
	  <td> <%= lista.get(i).getEmail()  %></td>
	  <td><a href="select?idcontatos=<%=lista.get(i).getIdcontatos()%>" class="BAzul">Alterar</a></td> 
	  <td><a href ="javascript: confirmar(<%=lista.get(i).getIdcontatos()%>)" class="BVermelho">Excluir</a></td> 
	   </tr>
	 <%}%>
   
   </tbody>
     
  
  
   </table>
 <script src ="scripts/confirmador.js"></script>
</body>
</html>