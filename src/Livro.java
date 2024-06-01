import java.time.LocalDateTime;

public class Livro {
	
	private String tombo;
	private String titulo;
	private String autor;
	private String categoria;
	private String editora;
	private int ano;
	private LocalDateTime dataCadastro;
	private String situacao;
	
	public Livro(String tombo, String titulo, String autor, String categoria, String editora, int ano, LocalDateTime dataCadastro, String situacao)
	{
		this.tombo = tombo;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.editora = editora;
		this.ano = ano;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
	}
	
	public String getTitulo()
	{
		return this.titulo;
	}
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public String getTombo()
	{
		return this.tombo;
	}
	
	public void setTombo(String tombo)
	{
		this.tombo = tombo;
	}
	
	public String getAutor()
	{
		return this.autor;
	}
	
	public void setAutor(String autor)
	{
		this.autor = autor;
	}
	
	public String getSituacao()
	{
		return this.situacao;
	}
	
	public void setSituacao(String situacao)
	{
		this.situacao = situacao;
	}
	
	public int getAno()
	{
		return this.ano;
	}
	
	public void setAno(int ano)
	{
		this.ano = ano;
	}
	
}
