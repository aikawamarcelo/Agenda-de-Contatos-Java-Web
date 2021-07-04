/**
 * Confirmação de Exclusão de um contato.
 */



//window.location.href = usado para fazer um redirecionamento fazendo com que o usuario sai desse documento e vai para outro local
//Teste de Exclusão
//alert(idcontatos)


function confirmar(idcontatos){
	 
	let resposta = confirm("Confirma a exclus\u00e3o deste contato? ")
	if(resposta === true){
		
		
		window.location.href = "delete?idcontatos=" + idcontatos 
		
	}
	
	
}