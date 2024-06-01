import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {

	private int codigoReserva;
	private Livro livro;
	private Usuario usuario;
	private LocalDateTime dataReserva;
	private LocalDateTime dataDevolucao;
	
	public Emprestimo(int codigoReserva, Usuario usuario, Livro livro, LocalDateTime dataReserva, LocalDateTime dataDevolucao)
	{
		this.codigoReserva = codigoReserva;
		this.usuario = usuario;
		this.livro = livro;
		this.dataReserva = dataReserva;
		this.dataDevolucao = dataDevolucao;		
	}
	
	public int getCodigoReserva()
	{
		return this.codigoReserva;
	}
	
	public void setCodigoReserva(int codigoReserva)
	{
		this.codigoReserva = codigoReserva;
	}
	
	public Livro getLivro()
	{
		return this.livro;
	}
	
	public void setLivro(Livro livro)
	{
		this.livro = livro;
	}
	
	public Usuario getUsuario()
	{
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	public LocalDateTime getDataReserva()
	{
		return this.dataReserva;
	}
	
	public void setDataReserva(LocalDateTime dataReserva)
	{
		this.dataReserva = dataReserva;
	}
	
	public LocalDateTime getDataDevolucao()
	{
		return this.dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDateTime dataDevolucao)
	{
		this.dataDevolucao = dataDevolucao;
	}
}
