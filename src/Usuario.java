import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario extends Pessoa {

	 private int id;
	 private String logradouro;
	 private String numeroResidencia;
	 private String bairro;
	 private String cidade;
	 private String estado;
	 private String cep;
	 private String cpf;
	 private String rg;
	 private String telefone;
	 private String email;
	 private LocalDateTime dataCadastro;
	 
	public Usuario(int id, String nome, LocalDate dataNascimento, String logradouro, String numeroResidencia, String bairro, String cidade, String estado, String cep, String cpf, String rg, String telefone, String email, LocalDateTime dataCadastro)
	{
		super(nome, dataNascimento);
		this.id = id;
		this.logradouro = logradouro;
		this.numeroResidencia = numeroResidencia;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
}
