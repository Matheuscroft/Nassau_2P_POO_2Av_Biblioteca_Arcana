import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private LocalDate dataNascimento;
	
	public Pessoa(String nome, LocalDate dataNascimento)
	{
		this.nome = nome;
        this.dataNascimento = dataNascimento;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String _nome)
	{
		this.nome = _nome;
	}
	
	public LocalDate getDataNascimento()
	{
		return this.dataNascimento;
	}
	
	public void setDataNascimento(LocalDate _dataNascimento)
	{
		this.dataNascimento = _dataNascimento;
	}

}
