package Model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

/** The idcontatos. */
private int idcontatos;

/** The nome. */
private String nome;

/** The telefone. */
private String telefone;

/** The email. */
private String email;



/**
 * Instantiates a new java beans.
 */
public JavaBeans() {
	super();
}

/**
 * Instantiates a new java beans.
 *
 * @param idcontatos the idcontatos
 * @param nome the nome
 * @param telefone the telefone
 * @param email the email
 */
public JavaBeans(int idcontatos, String nome, String telefone, String email) {
	super();
	this.idcontatos = idcontatos;
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
}

/**
 * Gets the idcontatos.
 *
 * @return the idcontatos
 */
public int getIdcontatos() {
	return idcontatos;
}

/**
 * Sets the idcontatos.
 *
 * @param idcontatos the new idcontatos
 */
public void setIdcontatos(int idcontatos) {
	this.idcontatos = idcontatos;
}

/**
 * Gets the nome.
 *
 * @return the nome
 */
public String getNome() {
	return nome;
}

/**
 * Sets the nome.
 *
 * @param nome the new nome
 */
public void setNome(String nome) {
	this.nome = nome;
}

/**
 * Gets the telefone.
 *
 * @return the telefone
 */
public String getTelefone() {
	return telefone;
}

/**
 * Sets the telefone.
 *
 * @param telefone the new telefone
 */
public void setTelefone(String telefone) {
	this.telefone = telefone;
}

/**
 * Gets the email.
 *
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * Sets the email.
 *
 * @param email the new email
 */
public void setEmail(String email) {
	this.email = email;
}



}
