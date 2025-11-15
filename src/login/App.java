package login;
public class App {
    public static void main(String[] args) throws Exception {
        
        User user = new User();

        boolean ok = user.verificarUsuario("teste", "teste");

        if (ok) {
            System.out.println("Usuário encontrado: " + user.nome);
        } else {
            System.out.println("Usuário NÃO encontrado!");
        }

    }
}
