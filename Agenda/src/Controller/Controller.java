package Controller;
import Model.DAO;
import Model.JavaBeans;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;










// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Controller.
 */
@WebServlet(urlPatterns= {"/Controller", "/main", "/inserir", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	    /** The contato. */
    	JavaBeans contato = new JavaBeans();	
	    
    	/** The dao. */
    	DAO dao = new DAO();
    
    /**
     * Instantiates a new controller.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Teste de Conexão
	//	dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/main")) {
		contatos(request,response);	
		
		}
		
		else if(action.equals("/inserir")) {
			
		adicionarContato(request,response);	
				
		}
		
		
		else if(action.equals("/select")) {
			
			citarContato(request,response);
			
		}
		
        else if(action.equals("/update")) {
			
			alterarContato(request,response);
			
		}
		
        else if(action.equals("/delete")) {
			
			removerContato(request,response);
			
		}
		
        else if(action.equals("/report")) {
			
            gerarRelatorio(request,response);
			
		}
		
		else {
			
			response.sendRedirect("index.html");
			
		}
		
	}



	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		     Document documento = new Document();
		        
			try {
				
				
				response.setContentType("application/pdf");
				//nome do documento
				response.reset(); // com este código pode substituir apllication por application
				response.addHeader("Content-Disposition", "inline;filename=" + "contatos.pdf");
				
				//Criar o documento
				
				PdfWriter.getInstance(documento, response.getOutputStream());
				
				documento.open();
				documento.add(new Paragraph("Lista de Contatos: "));
				documento.add(new Paragraph(" "));
				
				//Criar uma tabela
				
				PdfPTable tabela = new PdfPTable(3);
				
				//Cabeçalho
			
				
				PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
				
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				
				//Popular a tabela com os contatos
				
				ArrayList<JavaBeans> lista = dao.listarContatos();
			
				for (int i = 0; i < lista.size(); i++) {
					
				      tabela.addCell(lista.get(i).getNome());
				      tabela.addCell(lista.get(i).getTelefone());
				      tabela.addCell(lista.get(i).getEmail());
					
				}
				
				documento.add(tabela);
				
				documento.close();
				
			}catch(Exception e) {
				
				System.out.println(e);
				documento.close();
				
			}
	}

	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		int idcontatos =(Integer.parseInt(request.getParameter("idcontatos")));
		
		contato.setIdcontatos(idcontatos);
		
		dao.excluirContato(contato);
		
		//request.setAttribute("idcontatos", contato.getIdcontatos());
		
		response.sendRedirect("main");
	    //Encaminhar ao documento "Agenda.jsp"
	   
		
	}

	/**
	 * Alterar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void alterarContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//teste de recebimento
		
		// System.out.println(Integer.parseInt(request.getParameter("idcontatos")));
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("telefone"));
		// System.out.println(request.getParameter("email"));
		
		// setar as variáveis JavaBeans.
		contato.setIdcontatos(Integer.parseInt(request.getParameter("idcontatos")));
		contato.setNome(request.getParameter("nome"));
	    contato.setTelefone(request.getParameter("telefone"));
	    contato.setEmail(request.getParameter("email"));
	
	    dao.atualizarContato(contato);
	   
	    
	    // redirecionar para o documento agenda.jsp (atualizando as alterações)
	    
	    response.sendRedirect("main");
	    
	}

	//Listar Contatos
	
	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
	    
		//Criando um objeto que irá receber os dados do JavaBeans
		
		//response.sendRedirect("Agenda.jsp");
		
		ArrayList <JavaBeans> lista = dao.listarContatos();
		
		
		
		//for(int i = 0; i < lista.size() ; i++) {
			
		//	System.out.println(lista.get(i).getIdcontatos());
		//	System.out.println(lista.get(i).getNome());
		//	System.out.println(lista.get(i).getTelefone());
		//	System.out.println(lista.get(i).getEmail());
	//}
		//Encaminhar a lista ao documento Agenda.jsp
			
		request.setAttribute("contatos", lista);	
		
		// Trabalha com requisicões e respostas no Servlet.
		
		RequestDispatcher rd = request.getRequestDispatcher("Agenda.jsp"); 	
		rd.forward(request,response);
	
	
		
		
		
	}
		
	
	
	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
	
		
		 // Setar as variáveis JavaBeans

    	// Invocar o método Inserir Contato
    	
    	
	 contato.setNome(request.getParameter("nome"));
	 contato.setTelefone(request.getParameter("telefone"));
	 contato.setEmail(request.getParameter("email"));
	 
	 dao.criarContato(contato);
	 
	 // Redirecionar para o documento agenda.jsp
	 
	 response.sendRedirect("main");
	 
	}
	
	
	/**
	 * Citar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void citarContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
	
		//Recebimento do ID do contato.
		
	int idcontatos = Integer.parseInt(request.getParameter("idcontatos"));
		
	 //  System.out.println(idcontatos);
	
      contato.setIdcontatos(idcontatos);
        
        // EXECUTAR O MÉTODO DA CLASSE DAO
	
       dao.selecionarContato(contato);

		//Setar os atributos do formulário com os JavaBeans	
			
		request.setAttribute("idcontatos", contato.getIdcontatos());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
	    //Encaminhar ao documento Editar.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
	    rd.forward(request, response);
	}
	
	
	
}
