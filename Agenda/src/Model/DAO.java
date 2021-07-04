package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/* MÓDULOS DE CONEXÃO */

	//PARÂMETROS DE CONEXÃO
	/** The driver. */
	//="com.driver.cj.mysql.Driver"; "com.mysql.jdbc.Driver";
	private String driver = "com.mysql.jdbc.Driver";
    
    /** The url. */
    private String url = "jdbc:mysql://localhost:3307/dbagenda";
    
    /** The user. */
    private String user = "root";
    
    /** The password. */
    private String password = "123456";
    //MÉTODO DE CONEXÃO
    
    /**
     * Conexao.
     *
     * @return the connection
     */
    private Connection Conexao() {
    	

              Connection con = null;
    
    	try {
    		
    		Class.forName(driver);
    	con = DriverManager.getConnection(url, user, password);
    		return con;
    	}catch(Exception ex) {
    		
    		System.out.println(ex);
    		return null;
    	}
    	
    	
    }
    
    /* CRUD CREATE */
    
    /**
     * Criar contato.
     *
     * @param contato the contato
     */
    public void criarContato(JavaBeans contato) {
    	
    	// Invocar o método Inserir Contato
    	
    	String criar = "Insert into contatos (nome, telefone, email) values (?,?,?)";
    	try {
    		// Abrir a conexão
    		
    		Connection con =  Conexao(); 
    		
    		// Preparar a query para a execução do Banco de Dados.
    		
    		PreparedStatement stmt = con.prepareStatement(criar);
    		
    		// Substituir os parâmetros ? ? ? pelo conteúdo das variáveis 
    		// JavaBeans
    		
    		stmt.setString(1, contato.getNome());
    		stmt.setString(2, contato.getTelefone());
    		stmt.setString(3, contato.getEmail());
    		
    		// Executar a query
    		
    		stmt.executeUpdate();
    		
    		// Encerrar a conexão
    		
    		con.close();
    	   	
    	}catch(Exception e) {
    		
    		System.out.println(e);
    		
    	}
    	
    }
    
    /* CRUD READ */
    
    /**
     * Listar contatos.
     *
     * @return the array list
     */
    public ArrayList <JavaBeans> listarContatos() {
    	// Criando um objeto para acessar a classe JavaBeans.
    	ArrayList <JavaBeans> contatos = new ArrayList<>();
    	String ler = "select * from contatos order by nome" ;
    	try {
    		
    		Connection con = Conexao();
    		PreparedStatement stmt = con.prepareStatement(ler);
    		ResultSet rs = stmt.executeQuery();
    		// O laço abaixo será realizado enquanto tiver mais contatos.
    		
    		while(rs.next()) {
    			
    			// Variáveis de apoio que recebem os dados do banco
    			
    			int idcontatos = rs.getInt(1);
    			String nome = rs.getString(2);
    			String telefone = rs.getString(3);
    			String email = rs.getString(4);
    			
    			// Populando o ArrayList
    			
    			contatos.add(new JavaBeans(idcontatos,nome,telefone,email));
    				
    		}
    		
    		con.close();
    		return contatos;
   
    	}
    	catch (Exception e) {
			
    		System.out.println(e);
			return null;
		}
    	
     	
    	
    }
    
    /* CRUD UPDATE */
    
    /**
     * Selecionar contato.
     *
     * @param contato the contato
     */
    public void selecionarContato(JavaBeans contato) {
    	
    	String read2 = "select * from contatos where idcontatos= ?" ;
    	try {
    		
    		Connection con = Conexao();
    		
    		PreparedStatement stmt = con.prepareStatement(read2);
    		stmt.setInt(1,contato.getIdcontatos());
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			
    			// SETAR AS VARIÁVEIS JAVABEANS
    		
    	    contato.setIdcontatos(rs.getInt(1));	
    		contato.setNome(rs.getString(2));
    		contato.setTelefone(rs.getString(3));
    		contato.setEmail(rs.getString(4));
    		
    		}
    		
    		
    		
    		con.close();
    	  
    	}catch(Exception e) {
    		
    		System.out.println(e);
    		
    	}
    	
     
    
    }
    // Editar o contato
    
    /**
     * Atualizar contato.
     *
     * @param contato the contato
     */
    public void atualizarContato(JavaBeans contato) {
    	
    String alterar = "update contatos set nome = ?, telefone = ?, email = ? where idcontatos= ?";	
    	
    try {
    	
    	Connection con = Conexao();
    	
        PreparedStatement stmt = con.prepareStatement(alterar);
    	stmt.setString(1,contato.getNome());
    	stmt.setString(2, contato.getTelefone());
    	stmt.setString(3, contato.getEmail());
    	stmt.setInt(4, contato.getIdcontatos());
    	stmt.executeUpdate();
    	
    	con.close();
    	
    }
    
      
    
    catch(Exception e) {
    	
    	System.out.println(e);
    	
    }
    
    }
    
    
    /*CRUD DELETE*/
    
    /**
     * Excluir contato.
     *
     * @param contato the contato
     */
    public void excluirContato(JavaBeans contato) {
    	
    	String excluir = "delete from contatos where idcontatos = ?";
    	try {
    		
    		Connection con = Conexao();
    		
    		PreparedStatement stmt = con.prepareStatement(excluir);
    		
    		stmt.setInt(1, contato.getIdcontatos());
    		stmt.executeUpdate();
    		
    		con.close();
    		
    	}catch(Exception e) {
    		

        	System.out.println(e);

        	
    		
    	}
    }
    
    /**
     * Teste conexao.
     */
    //Teste de Conexão
    public void testeConexao() {
    	
    	try {
    		
    		Connection con = Conexao();
    		System.out.println(con);
    		con.close();
    		
    	}catch(Exception e) {
    		
    		System.out.println(e);
    
    	}
    	
    	
    	
    }
    
    
    
    
}
