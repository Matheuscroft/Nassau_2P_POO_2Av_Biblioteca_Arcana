import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AV2_Biblioteca {
   
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        
		menuPrincipal(scanner, usuarios, livros, emprestimos);
		
		scanner.close();
		
    }
    
    public static void menuPrincipal(Scanner scanner, ArrayList<Usuario> _usuarios, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos) {
    	
    	ArrayList<Usuario> usuarios = _usuarios;
    	ArrayList<Livro> livros = _livros;
    	ArrayList<Emprestimo> emprestimos = _emprestimos;
    	
		System.out.println(
				"\nBoas vindas à Biblioteca Arcana\nDeseja acessar qual menu?\n"
				+ "1 - Gerenciar Usuários\n2 - Gerenciar Livros\n3 - Gerenciar Empréstimos\n0 - Encerrar\n");
		int opcaoMenu = tentarLerInt(scanner);

		switch (opcaoMenu) {
		case 1:
			usuarios = menuUsuario(scanner, usuarios, livros, emprestimos);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 2:
			livros = menuLivro(scanner, usuarios, livros, emprestimos);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 3:
			emprestimos = menuEmprestimo(scanner, usuarios, livros, emprestimos);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 0:
		    System.out.println("Sistema encerrado");
		    scanner.close();
		    System.exit(0); 
		    break;
		default:
			System.out.println("Escolheu incorretamente.");
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		}

	}
    
    
    public static ArrayList<Usuario> menuUsuario(Scanner scanner, ArrayList<Usuario> _usuarios, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos)
	{
    	ArrayList<Usuario> usuarios = _usuarios;
    	ArrayList<Livro> livros = _livros;
    	ArrayList<Emprestimo> emprestimos = _emprestimos;
    	Usuario usuario = null;
    	
    	System.out.println(
				"\nEscolha a opção:\n"
				+ "1 - Cadastrar Usuário\n2 - Buscar Usuário por nome\n3 - Listar Usuários\n4 - Deletar Usuário\n0 - Voltar\n");
		int opcaoMenu = tentarLerInt(scanner);

		switch (opcaoMenu) {
		case 1:
			usuarios.add(usuario = cadastrarUsuario(scanner, usuarios));
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 2:
			buscarUsuarioPorNome(scanner, usuarios);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 3:
			listarUsuarios(scanner, usuarios);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 4:
			usuarios = deletarUsuario(scanner, usuarios);
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			break;
		case 0:
			menuPrincipal(scanner, usuarios, livros, emprestimos);
		default:
			System.out.println("Escolheu incorretamente.");
			menuPrincipal(scanner, usuarios, livros, emprestimos);
			
			break;
		}
		
		return usuarios;
    	
		
	}
    
    public static Usuario cadastrarUsuario(Scanner scanner, ArrayList<Usuario> _usuarios)
	{
    	
    	System.out.println(
				"\nCadastro de Usuário\n"
				+ "Digite as informações a seguir:");
		String nome;
		LocalDate dataNascimento;
		int id = 1;
		String logradouro;
		String numeroResidencia;
		String bairro;
		String cidade;
		String estado;
		String cep;
		String cpf;
		String rg;
		String telefone;
		String email;
		LocalDateTime dataCadastro;
		
		if(_usuarios.size() > 0)
		{
			id = _usuarios.size() + 1;
		}
    	
		nome = colocarNome(scanner);
		
		dataNascimento = solicitarData(scanner);
		System.out.println("Data salva: " + formatarData(dataNascimento));
		
		scanner.nextLine();
		
		System.out.println("\nLogradouro:\n");
		logradouro = scanner.nextLine().toUpperCase();
		
		System.out.println("\nNúmero da Residência:\n");
		numeroResidencia = scanner.nextLine().toUpperCase();
		
		System.out.println("\nBairro:\n");
		bairro = scanner.nextLine().toUpperCase();
		
		System.out.println("\nCidade:\n");
		cidade = scanner.nextLine().toUpperCase();
		
		System.out.println("\nEstado:\n");
		estado = scanner.nextLine().toUpperCase();
		
		cep = solicitarEntrada(scanner, "cep");
		
		cpf = solicitarEntrada(scanner, "cpf");
		
		rg = solicitarEntrada(scanner, "rg");
		
		telefone = solicitarEntrada(scanner, "Telefone");
		
		email = solicitarEntrada(scanner, "E-mail");
		
		dataCadastro = LocalDateTime.now();
		System.out.println("Data e hora de cadastro: " + formatarData(dataCadastro));
        
        
        
        Usuario usuario = new Usuario(id, nome, dataNascimento, logradouro, numeroResidencia, bairro, cidade, estado, cep, cpf, rg, telefone, email, dataCadastro);
        
        return usuario;
    	
	}

    public static String colocarNome(Scanner scanner)
    {
        String nome;
        String sobrenome;
        String nomeCompleto;

        scanner.nextLine();
        
        System.out.println("\nDigite o primeiro nome do usuário:");
        nome = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite o sobrenome do usuário:");
        sobrenome = scanner.nextLine().toUpperCase();

        nomeCompleto = confirmarNome(scanner, nome, sobrenome);

        return nomeCompleto;
    }
    public static String confirmarNome(Scanner scanner, String nome, String sobrenome){

        String confirmacaoNome;
        String nomeCompleto = null;

        System.out.println("\nNome escolhido: " + nome + " " + sobrenome);
        System.out.println("Confirmar nome? Digite S ou N.");

        confirmacaoNome = scanner.next().toUpperCase();

       if(confirmacaoNome.equals("S")){
           return nome + " " + sobrenome;
        } else if(confirmacaoNome.equals("N")){
           nomeCompleto = colocarNome(scanner);
           return nomeCompleto;
        } else {
            System.out.println("Entrada incorreta");
            nomeCompleto = confirmarNome(scanner, nome, sobrenome);
        }
       return nomeCompleto;
    }
    
    public static LocalDate solicitarData(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = null;
        boolean dataValida = false;

        while (!dataValida) {
            System.out.println("\nData de Nascimento (dd/MM/yyyy):\n");
            String data = scanner.next();

            try {
                dataNascimento = LocalDate.parse(data, formatter);
                if (dataNascimento.isAfter(LocalDate.now())) {
                    System.out.println("Data de nascimento não pode estar no futuro. Por favor, insira uma data válida.");
                } else {
                    dataValida = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, insira no formato dd/MM/yyyy.");
            }
        }

        return dataNascimento;
    }
    
    public static String formatarData(TemporalAccessor data) {
        DateTimeFormatter formatador;
        
        if (data instanceof LocalDateTime) {
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        } else if (data instanceof LocalDate) {
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        } else {
            throw new IllegalArgumentException("Tipo de data não suportado");
        }

        return formatador.format(data);
    }
    
    public static String solicitarEntrada(Scanner scanner, String tipo) {
    	
        String padrao;
        String entrada = null;
        boolean valido = false;

        while (!valido) {
            System.out.println("\n" + tipo.toUpperCase() + ":\n");
            entrada = scanner.nextLine().toUpperCase();

            switch (tipo.toUpperCase()) {
                case "CEP":
                    padrao = "(\\d{5})(\\d{3})";
                    if (entrada.matches("\\d{5}-\\d{3}")) {
                        valido = true;
                    } else if (entrada.matches("\\d{8}")) {
                        entrada = entrada.replaceAll(padrao, "$1-$2");
                        valido = true;
                    }
                    break;
                case "CPF":
                    padrao = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
                    if (entrada.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                        valido = true;
                    } else if (entrada.matches("\\d{11}")) {
                        entrada = entrada.replaceAll(padrao, "$1.$2.$3-$4");
                        valido = true;
                    }
                    break;
                case "RG":
                    padrao = "(\\d{1})(\\d{3})(\\d{3})";
                    if (entrada.matches("\\d{1}\\.\\d{3}\\.\\d{3}")) {
                        valido = true;
                    } else if (entrada.matches("\\d{7}")) {
                        entrada = entrada.replaceAll(padrao, "$1.$2.$3");
                        valido = true;
                    }
                    break;
                case "TELEFONE":
                    padrao = "(\\d{2})(\\d{5})(\\d{4})";
                    if (entrada.matches("\\(\\d{2}\\) \\d{5}-\\d{4}")) {
                        valido = true;
                    } else if (entrada.matches("\\d{11}")) {
                        entrada = entrada.replaceAll(padrao, "($1) $2-$3");
                        valido = true;
                    }
                    break;
                case "E-MAIL":
                    padrao = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
                    if (entrada.matches(padrao)) {
                        valido = true;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de dado não suportado: " + tipo);
            }

            if (!valido) {
                System.out.println("Formato de " + tipo.toUpperCase() + " inválido. Por favor, insira no formato correto.");
            }
        }

        return entrada;
    }
    
    public static Usuario buscarUsuarioPorNome(Scanner scanner, ArrayList<Usuario> _usuarios)
	{
		String nome;
		int quantidadeUsuarios = 0;
		int id;
		Usuario usuario = null;

		if (_usuarios.size() > 0) {

			System.out.println("\nDigite o nome do usuário que deseja buscar\n");

			nome = scanner.next().toUpperCase();

			for (int i = 0; i < _usuarios.size(); i++) {
				
				if(_usuarios.get(i).getNome().contains(nome))
				{
					quantidadeUsuarios++;
					System.out.println("\nID: " + _usuarios.get(i).getID() + " - " + _usuarios.get(i).getNome());
					usuario = _usuarios.get(i);
				}
			}
			
			if(quantidadeUsuarios > 1)
			{
				System.out.println("\nEncontramos mais de um usuário que contém esse nome.\n");
				System.out.println("Digite o ID do usuário desejado:\n");
				
				id = scanner.nextInt();			
				
				for (int i = 0; i < _usuarios.size(); i++) {
					
					if(_usuarios.get(i).getID() == id)
					{
						System.out.println("\nInformações do usuário:");
						System.out.println("ID: "+ _usuarios.get(i).getID());
						System.out.println("Nome: "+ _usuarios.get(i).getNome());
						System.out.println("Data de Nascimento: "+ _usuarios.get(i).getDataNascimento() + "\n");
						return usuario;
					} else {
						if (i == _usuarios.size() - 1)
						{
							System.out.println("Não existe usuário com esse ID.");
						}
					}
				}
			
				
			} else {
				
				System.out.println("\nInformações do usuário:");
				System.out.println("ID: "+ usuario.getID());
				System.out.println("Nome: "+ usuario.getNome());
				System.out.println("Data de Nascimento: "+ usuario.getDataNascimento());
				return usuario;
			}

		} else {
			System.out.println("\nNão há nenhum usuário cadastrado.");
		}
		
		return usuario;

	}
    
    public static void listarUsuarios(Scanner scanner, ArrayList<Usuario> _usuarios)
	{
    	if(_usuarios.size() > 0)
    	{

    		System.out.println("\nListagem de usuários:\n");

    		for(int i = 0; i < _usuarios.size(); i++)
    		{
    			System.out.println("ID: " + _usuarios.get(i).getID() + " - " + _usuarios.get(i).getNome());
    		}
    	} else {
    		System.out.println("\nNão há nenhum usuário cadastrado\n");
    	}

	}
    
    public static ArrayList<Usuario> deletarUsuario(Scanner scanner, ArrayList<Usuario> _usuarios)
	{
		ArrayList<Usuario> usuarios = _usuarios;

		int id;
		boolean excluir;

		if (usuarios.size() > 0) {

			System.out.println("\nDigite o número do ID do usuário que deseja deletar\n");

			id = tentarLerInt(scanner);

			for (int i = 0; i < usuarios.size(); i++) {

				if (usuarios.get(i).getID() == id) {
					
					System.out.println("\nID: " + usuarios.get(i).getID() + " - " + usuarios.get(i).getNome());
					excluir = confirmarExclusao(scanner, usuarios.get(i).getNome());
					
					if(excluir)
					{
						System.out.println("Usuário "+usuarios.get(i).getNome()+" excluído.");
						usuarios.remove(usuarios.get(i));
						break;

					} else {
						System.out.println(usuarios.get(i).getNome() + " não foi excluído.");
						break;
					}

				} else
				{
					if(i == usuarios.size() - 1) {
						System.out.println("\nNão há nenhum usuário com esse ID.");
					}
					
				}
			}

		}

		else {
			System.out.println("\nNão há nenhum usuário cadastrado.");
		}

		return usuarios;
	}
    
    public static boolean confirmarExclusao(Scanner scanner, String nome){

        String opcao;
        boolean confirmacaoExclusao;

        System.out.println("Confirmar exclusão de " + nome + "? Digite S ou N.");
        opcao = scanner.next().toUpperCase();

        if(opcao.equals("S")){
            return true;
        } else if (opcao.equals("N")) {
            return false;
        } else {
            System.out.println("Entrada incorreta.");
            confirmacaoExclusao = confirmarExclusao(scanner, nome);
        }
        return confirmacaoExclusao;
    }
    
    public static ArrayList<Livro> menuLivro(Scanner scanner, ArrayList<Usuario> _usuarios, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos)
	{
    	
    	ArrayList<Livro> livros = _livros;
    	Livro livro = null;
    	
    	System.out.println(
				"\nEscolha a opção:\n"
				+ "1 - Cadastrar Livro\n2 - Buscar Livro por nome\n3 - Listar Livros\n4 - Deletar Livro");
		int opcaoMenu = tentarLerInt(scanner);

		switch (opcaoMenu) {
		case 1:
			livros.add(livro = cadastrarLivro(scanner, livros));
			menuPrincipal(scanner, _usuarios, livros, _emprestimos);
			break;
		case 2:
			buscarLivroPorTitulo(scanner, livros);
			menuPrincipal(scanner, _usuarios, livros, _emprestimos);
			break;
		case 3:
			listarLivros(scanner, livros);
			menuPrincipal(scanner, _usuarios, livros, _emprestimos);
			break;
		case 4:
			livros = deletarLivro(scanner, livros);
			menuPrincipal(scanner, _usuarios, livros, _emprestimos);
			break;
		default:
			System.out.println("Escolheu incorretamente.");
			menuPrincipal(scanner, _usuarios, livros, _emprestimos);
			
			break;
		}
		
		return livros;
		
	}
    
    public static Livro cadastrarLivro(Scanner scanner, ArrayList<Livro> _livros)
	{
    	System.out.println(
				"\nCadastro de Livro\n"
				+ "Digite as informações a seguir:");
    	String tombo;
    	String titulo;
    	String autor;
    	String categoria;
    	String editora;
    	int ano;
    	LocalDateTime dataCadastro;
    	String situacao = "Disponível";
    	
		System.out.println("\nNúmero do tombo:\n");
		tombo = scanner.next().toUpperCase();
		
		scanner.nextLine();
		
		System.out.println("\nTítulo do livro:\n");
		titulo = scanner.nextLine().toUpperCase();	
		
		System.out.println("\nAutor:\n");
		autor = scanner.nextLine().toUpperCase();
		
		System.out.println("\nCategoria:\n");
		categoria = scanner.nextLine().toUpperCase();
		
		System.out.println("\nEditora:\n");
		editora = scanner.nextLine().toUpperCase();
		
		System.out.println("\nAno:\n");
		ano = scanner.nextInt();
		
		scanner.nextLine();
		
		
		dataCadastro = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataCadastro.format(formatador);
        System.out.println("Data e hora de cadastro: " + dataFormatada);
        
        
        
        Livro livro = new Livro(tombo, titulo, autor, categoria, editora, ano, dataCadastro, situacao);
        
        return livro;
    	
	}
    
    
    public static Livro buscarLivroPorTitulo(Scanner scanner, ArrayList<Livro> _livros)
	{
		String titulo;
		int quantidadeLivros = 0;
		String tombo;
		Livro livro = null;

		if (_livros.size() > 0) {

			System.out.println("\nDigite o nome do livro que deseja buscar\n");

			titulo = scanner.next().toUpperCase();

			for (int i = 0; i < _livros.size(); i++) {
				
				if(_livros.get(i).getTitulo().contains(titulo))
				{
					quantidadeLivros++;
					System.out.println("\nTombo: " + _livros.get(i).getTombo() + " - " + _livros.get(i).getTitulo());
					livro = _livros.get(i);
				}
			}
			
			scanner.nextLine();
			
			if(quantidadeLivros > 1)
			{
				System.out.println("\nEncontramos mais de um livro que contém esse nome.\n");
				System.out.println("Digite o tombo do livro desejado:\n");
				
				tombo = scanner.next().toUpperCase();			
				
				for (int i = 0; i < _livros.size(); i++) {
					if(_livros.get(i).getTombo().equals(tombo))
					{
						System.out.println("\nInformações do livro:");
						System.out.println("Tombo: "+ _livros.get(i).getTombo());
						System.out.println("Título: "+ _livros.get(i).getTitulo());
						System.out.println("Autor: "+ _livros.get(i).getAutor() + "\n");
						livro = _livros.get(i);
						return livro;
					} else {
						if (i == _livros.size() - 1)
						{
							System.out.println("Não existe livro com esse número de tombo.");
						}
					}
					
				}
			
				
			} else {
				
				System.out.println("\nInformações do livro:");
				System.out.println("Tombo: "+ livro.getTombo());
				System.out.println("Título: "+ livro.getTitulo());
				System.out.println("Autor: "+ livro.getAutor() + "\n");
				return livro;
			}

		} else {
			System.out.println("\nNão há nenhum livro cadastrado.");
		}
		
		return livro;

	}
    
    public static void listarLivros(Scanner scanner, ArrayList<Livro> _livros)
	{
    	if(_livros.size() > 0)
    	{

    		System.out.println("\nListagem de livros:\n");

    		for(int i = 0; i < _livros.size(); i++)
    		{
    			System.out.println("Tombo: " + _livros.get(i).getTombo() + " - " + _livros.get(i).getTitulo() + " - " + _livros.get(i).getAno());
    		}
    	} else {
    		System.out.println("\nNão há nenhum livro cadastrado\n");
    	}

	}
    
    public static ArrayList<Livro> deletarLivro(Scanner scanner, ArrayList<Livro> _livros)
	{
		ArrayList<Livro> livros = _livros;

		String tombo;
		boolean excluir;

		if (livros.size() > 0) {

			System.out.println("\nDigite o número do tombo do livro que deseja deletar\n");

			scanner.nextLine();
			tombo = scanner.next();

			for (int i = 0; i < livros.size(); i++) {

				if (livros.get(i).getTombo().equals(tombo)) {
					
					System.out.println("\nTombo: " + livros.get(i).getTombo() + " - " + livros.get(i).getTitulo());
					excluir = confirmarExclusao(scanner, livros.get(i).getTitulo());
					
					if(excluir)
					{
						System.out.println("Livro "+ livros.get(i).getTitulo()+" excluído.");
						livros.remove(livros.get(i));
						break;

					} else {
						System.out.println(livros.get(i).getTitulo() + " não foi excluído.");
						break;
					}

				} else
				{
					if(i == livros.size() - 1) {
						System.out.println("\nNão há nenhum livro com esse tombo.");
					}
				}
			}

		}

		else {
			System.out.println("\nNão há nenhum livro cadastrado.");
		}

		return livros;
	}
    
    public static ArrayList<Emprestimo> menuEmprestimo(Scanner scanner, ArrayList<Usuario> _usuarios, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos)
	{
    	ArrayList<Emprestimo> emprestimos = _emprestimos;
    	ArrayList<Livro> livros = _livros;
    	Emprestimo emprestimo = null;
    	
    	System.out.println(
				"\nEscolha a opção:\n"
				+ "1 - Realizar Empréstimo de Livro\n2 - Devolver Livro\n3 - Listar Livros Disponíveis\n4 - Listar Usuários com Livros Emprestados\n5 - Renovar Empréstimo");
		int opcaoMenu = tentarLerInt(scanner);

		switch (opcaoMenu) {
		case 1:
			emprestimo = realizarEmprestimo(scanner, _usuarios, livros, emprestimos);
			if(emprestimo != null)
			{
				emprestimos.add(emprestimo);
				livros = mudarSituacaoLivro(emprestimo.getLivro(), livros);
			}
			menuPrincipal(scanner, _usuarios, livros, emprestimos);
			break;
		case 2:
			emprestimo = devolverLivro(scanner, livros, emprestimos);
			if(emprestimo != null)
			{
				livros = mudarSituacaoLivro(emprestimo.getLivro(), livros);
				emprestimos.remove(emprestimo);
			}
			menuPrincipal(scanner, _usuarios, livros, emprestimos);
			break;
		case 3:
			listarLivrosDisponiveis(livros);
			menuPrincipal(scanner, _usuarios, livros, emprestimos);
			break;
		case 4:
			listarUsuariosComLivrosEmprestados(emprestimos);
			menuPrincipal(scanner, _usuarios, _livros, emprestimos);
			break;
		case 5:
			emprestimos = renovarEmprestimo(scanner, emprestimos, livros);
			menuPrincipal(scanner, _usuarios, livros, emprestimos);
			break;
		default:
			System.out.println("Escolheu incorretamente.");
			menuPrincipal(scanner, _usuarios, livros, emprestimos);
			
			break;
		}
		
		
    	return _emprestimos;
    	
		
	}
    
    public static Emprestimo realizarEmprestimo(Scanner scanner, ArrayList<Usuario> _usuarios, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos)
   	{
    	Emprestimo emprestimo = null;
    	
    	if(_usuarios.size() > 0 && _livros.size() > 0)
    	{
    		int codigoReserva = 1;
        	
        	if(_emprestimos != null && _emprestimos.size() > 0)
    		{
        		codigoReserva = _emprestimos.size() + 1;
    		}
       		
       		Usuario usuario = buscarUsuarioPorNome(scanner, _usuarios);
       		Livro livro = verificarSituacaoLivro(scanner, _livros);
       		if(livro == null) {
       			return null;
       		}
       		
       		LocalDateTime dataReserva = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = dataReserva.format(formatador);
            
            LocalDateTime dataDevolucao = dataReserva.plusDays(4);
            String dataDevolucaoFormatada = dataDevolucao.format(formatador);
            
            System.out.println("Livro emprestado com sucesso!\n");
            System.out.println("Código da reserva: " + codigoReserva);
            System.out.println("Nome do usuário: " + usuario.getNome());
            System.out.println("Título do livro: " + livro.getTitulo());
            System.out.println("Data de reserva: " + dataFormatada);
            System.out.println("Data de devolução: " + dataDevolucaoFormatada);
            
       		
       		emprestimo = new Emprestimo(codigoReserva, usuario, livro, dataReserva, dataDevolucao);
    		
    	} else if(_usuarios.size() == 0) {
    		
    		System.out.println("\nNão há nenhum usuário cadastrado\n");
    		
    	} else {
    		
    		System.out.println("\nNão há nenhum livro cadastrado\n");
    	}
    	
   		
   		return emprestimo;
   	}
    
    public static Livro verificarSituacaoLivro(Scanner scanner, ArrayList<Livro> livros)
    {
    	Livro livro = null;
    	boolean haLivroDisponivel = false;
    	
    	for(int i = 0; i < livros.size(); i++) {

			if(livros.get(i).getSituacao() == "Disponível") {

				haLivroDisponivel = true;
							

			} else {
				if (i == livros.size() - 1 && !haLivroDisponivel) {

					System.out.println("\nNão há nenhum livro disponível no momento");
					return null;
				}
			}

		}
    	
    	if(haLivroDisponivel) {
    		
    		livro = buscarLivroPorTitulo(scanner, livros);
			
			if(livro.getSituacao() == "Emprestado") {
				System.out.println("O livro " + livro.getTitulo() + " está indisponível no momento");
				livro = verificarSituacaoLivro(scanner, livros);
			}
    	}
    	
		
		return livro;
    }
    
    public static ArrayList<Livro> mudarSituacaoLivro(Livro livro, ArrayList<Livro> livros)
    {
    	for(int i = 0; i < livros.size(); i++)
    	{
    		if(livros.get(i).getTombo().equals(livro.getTombo()))
    		{
    			if(livros.get(i).getSituacao().equals("Disponível"))
    			{
    				livros.get(i).setSituacao("Emprestado");
    			} else {
    				
    				livros.get(i).setSituacao("Disponível");
    				
    			}
    			
    		}
    	}
    	
		return livros;
    }
    
    public static Emprestimo devolverLivro(Scanner scanner, ArrayList<Livro> _livros, ArrayList<Emprestimo> _emprestimos){
    	
    	Livro livro;
    	Emprestimo emprestimo = null;
    	
    	System.out.println("\nDevolução de livros");
    	livro = buscarLivroPorTitulo(scanner, _livros);
    	
    	if(livro != null) {
    		
    		if(livro.getSituacao().equals("Disponível")) {
        		System.out.println("Este livro não foi emprestado!");
        		return null;
        	} else {
        		
        		for(int i = 0; i < _emprestimos.size(); i++) {
            		
            		if(_emprestimos.get(i).getLivro().getTombo().equals(livro.getTombo())) {
            		
            			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            			
            			System.out.println("Dados do empréstimo\n");
            			System.out.println("Código do empréstimo: " +  _emprestimos.get(i).getCodigoReserva());
            			System.out.println("Nome do usuário: " + _emprestimos.get(i).getUsuario().getNome());
            			System.out.println("Título do livro: " + _emprestimos.get(i).getLivro().getTitulo());
            			System.out.println("Data de reserva: " + _emprestimos.get(i).getDataReserva().format(formatador));
            			System.out.println("Data limite de devolução: " + _emprestimos.get(i).getDataDevolucao().format(formatador));
            			
            			System.out.println("\n" + _emprestimos.get(i).getLivro().getTitulo() + " devolvido com sucesso!");
            			LocalDateTime data = LocalDateTime.now();
                        
                        String dataFormatada = data.format(formatador);
            			System.out.println("Data de devolução: " + dataFormatada);
            			
            			emprestimo = _emprestimos.get(i);
            			
            			
            		}
            		
            	}
        		
        	}
    		
    	}
    	    	
    	
    	return emprestimo;
    	
    }
    
    public static void listarLivrosDisponiveis(ArrayList<Livro> _livros) {
    	
    	
    	if(_livros.size() > 0) {
    		
    		boolean todosEmprestados = true;
    		
    		System.out.println();
    		
    		for(int i = 0; i < _livros.size(); i++) {
        		
        		if(_livros.get(i).getSituacao() == "Disponível") {
        			
        			System.out.println("Tombo: " + _livros.get(i).getTombo() + ". Título: " + _livros.get(i).getTitulo() + " - " + _livros.get(i).getSituacao());
        			todosEmprestados = false;
        			
        		} else {
        			if(i == _livros.size() - 1 && todosEmprestados) {
        				System.out.println("\nTodos os livros estão emprestados.");
        			}
        		}
        		
        	}
    	} else {
    		System.out.println("\nNão há livros cadastrados.");
    	}
    	
    	
    	
    }
    
    public static void listarUsuariosComLivrosEmprestados(ArrayList<Emprestimo> _emprestimos) {
    	
    	if(_emprestimos != null && _emprestimos.size() > 0) {

    		System.out.println();

    		for(int i = 0; i < _emprestimos.size(); i++) {

    			
    				System.out.println("Usuário: " + _emprestimos.get(i).getUsuario().getNome() + ". Livro: " + _emprestimos.get(i).getLivro().getTitulo());

    		}
    	} else {
    		System.out.println("\nNenhum empréstimo foi efetuado.");
    	}
    }
    
    public static ArrayList<Emprestimo> renovarEmprestimo(Scanner scanner, ArrayList<Emprestimo> _emprestimos, ArrayList<Livro> _livros) {
    	
    	Livro livro;
    	
    	System.out.println("\nRenovação de empréstimo");
    	livro = buscarLivroPorTitulo(scanner, _livros);
    	
    	if(livro != null) {
    		
    		if(livro.getSituacao().equals("Disponível")) {
        		System.out.println("Este livro não foi emprestado!");
        		return _emprestimos;
        	} else {
        		
        		for(int i = 0; i < _emprestimos.size(); i++) {
            		
            		if(_emprestimos.get(i).getLivro().getTombo().equals(livro.getTombo())) {
            		
            			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            			
            			System.out.println("Dados do empréstimo\n");
            			System.out.println("Código do empréstimo: " +  _emprestimos.get(i).getCodigoReserva());
            			System.out.println("Nome do usuário: " + _emprestimos.get(i).getUsuario().getNome());
            			System.out.println("Título do livro: " + _emprestimos.get(i).getLivro().getTitulo());
            			System.out.println("Data de reserva: " + _emprestimos.get(i).getDataReserva().format(formatador));
            			System.out.println("Data limite de devolução: " + _emprestimos.get(i).getDataDevolucao().format(formatador));
            			
            			
            			LocalDateTime data = _emprestimos.get(i).getDataDevolucao().plusDays(4);
            			_emprestimos.get(i).setDataDevolucao(data);
            			System.out.println("\nEmpréstimo renovado com sucesso!");
                        
                        String dataFormatada = data.format(formatador);
            			System.out.println("Nova data de devolução: " + dataFormatada);
            			
            			            			
            		}
            		
            	}
        		
        	}
    		
    	}
    	
    	return _emprestimos;
    }
    
    public static int tentarLerInt(Scanner scanner)
	{
		int opcao = 0;
		
		try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Digite um número!");
            scanner.next();
            opcao = tentarLerInt(scanner);
            //return opcao;
        }
		
		return opcao;
	}
    
    
    
    
    
    
    
}