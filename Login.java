import java.util.*;

public class Login {
    private String username;
    private String senha;
    private String email;
   
    public Login(String username, String senha,String email) {
        this.username = username;
        this.senha = senha;
        this.email = email;
    }
    public String getusername() {
        return username;
    }
     public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }

}
class Produto{
    private int id;
    private String nomeProduto;
    private double preco;
    public Produto(int id, String nomeProduto, double preco) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }
    public int getId() {
        return id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public double getPreco() {
        return preco;
    }
    public String toString(){
        return "ID:"+getId() +"\n" + "Nome do Produto:"+getNomeProduto() +"\n" +"Preço:"+getPreco();
    }
}
class Main{
    static List<Login> login = new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static boolean cadastrar = false;
    static boolean logado = false;
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1-Logar");
            System.out.println("2-Cadastrar Usuário");
            System.out.println("3-Cadastrar Produto");
            System.out.println("4-Filtrar  Produto por ID");
            System.out.println("5-Remover  Produto por ID");
            System.out.println("6-Listar Todos os Produtos");
            System.out.println("7-Mostrar usuários Cadastrados");
            System.out.println("8-Sair");
            
            System.out.print("Escolha sua opção:");
            op = sc.nextInt();
            switch (op) {
                case 1-> LoginUser(sc);
                case 2->CadastrarUser(sc);
                case 3-> CadastrarProduto(sc);
                case 4-> FiltrarProduto(sc);
                case 5->RemoverProduto(sc);
                case 6-> ListarTodosProdutos();
                case 7->MostrarUsuariosCadastrados();
                case 8->System.out.println("Programa Encerrado");
                default->System.out.println("Opção Inválida");
                }
            } while (op!=8);
                sc.close();
                        
                    }
                
                  
                
        private static void LoginUser(Scanner sc){
        sc.nextLine();
        if(cadastrar == false){
            System.out.println("Cadastre-se primeiro");
            System.out.println("========================================================");
            return;
        }
        else{
            System.out.println("Digite seu E-mail:");
    
            String email = sc.nextLine();
            if(!email.contains("@gmail.com")){
                System.out.println("E-mail inválido. Digite um E-mail com @gmail.com");
                return;
            }
            System.out.println("Digite sua Senha");
            String senha = sc.nextLine();

            for (Login l : login) {
                    if (l.getEmail().equals(email) && l.getSenha().equals(senha)) {
                        System.out.println("Logado com Sucesso");
                    }

                    else{
                        System.out.println("Usuário ou Senha inválido");
                    }
            }
            logado=true;
            
        }
         System.out.println("========================================================");

    }

    private static void CadastrarUser(Scanner sc){sc.nextLine();
    
   
      
    System.out.println("Digite seu Nome:");
    
    String nome = sc.nextLine();
    System.out.println("Digite sua Senha:");
    String senha = sc.nextLine();
    System.out.println("Digite seu E-mail:");
    String email = sc.nextLine();
    
    if(!email.contains("@gmail.com")){
        System.out.println("E-mail inválido. Digite um E-mail com @gmail.com");
        return;
    }
      System.out.println("========================================================");
    Login log = new Login(nome, senha,email);

    login.add(log);
    cadastrar = true;
    }
      private static void CadastrarProduto(Scanner sc) {sc.nextLine();
        if(logado == false){
            System.out.println("Faça o login primeiro");
            System.out.println("========================================================");
            return;
             
        }
        
            sc.nextLine();
            System.out.println("Digite o ID do Produto:");
            System.out.print("ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite o nome do Produto:");
            System.out.print("Nome:");
            String nome  = sc.nextLine();
            System.out.println("Digite o Preço do Produto:");
            System.out.print("Preço:");
            double preco = sc.nextDouble();
            Produto ps = new Produto(id, nome, preco);
            produtos.add(ps);
            System.out.println("========================================================");


        }

        private static void FiltrarProduto(Scanner sc){
          if(logado == false){
            System.out.println("Faça o login primeiro");
            System.out.println("========================================================");
            return;
             
        }
        else if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
              System.out.println("========================================================");
            return;
        }
            System.out.println("Digite o ID do Produto:");
            System.out.print("ID:");
            int id = sc.nextInt();
             System.out.println("========================================================");
            produtos.stream().filter(p->p.getId() == id).forEach(System.out::println);
             System.out.println("========================================================");


        }
        private static void RemoverProduto(Scanner sc){sc.nextLine();
           if(logado == false){
            System.out.println("Faça o login primeiro");
            System.out.println("========================================================");
            return;
             
        }
        else if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
              System.out.println("========================================================");
            return;
        }
            System.out.println("Digite o ID do Produto:");
            System.out.print("ID:");
            int id = sc.nextInt();
           produtos.removeIf(produto-> produto.getId() == id);
           System.out.println("Produto removido com sucesso");
            System.out.println("========================================================");
        }
        private static void ListarTodosProdutos(){
             if(logado == false){
            System.out.println("Faça o login primeiro");
            System.out.println("========================================================");
            return;
             
        }
        else if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
              System.out.println("========================================================");
            return;
        }
        for (Produto p : produtos) {
              System.out.println("========================================================");
                System.out.println(p);
              System.out.println("========================================================");
        }
        }

        private static void MostrarUsuariosCadastrados(){
            
             if(logado == false){
            System.out.println("Faça o login primeiro");
            System.out.println("========================================================");
            return;
             
        }
        else if (login.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
              System.out.println("========================================================");
            return;
        }
        for (Login log : login) {
              System.out.println("========================================================");
                System.out.println("Nome:"+log.getusername() +"\n" + "Email:"+log.getEmail());
              System.out.println("========================================================");
        }
        }
    }
