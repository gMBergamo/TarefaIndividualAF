package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    // Método para conectar ao Banco de Dados
    // TODO: Realizar a conexão com o banco de dados em uma classe separada.
    public Connection conectarBD(){
        Connection conn = null;
        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Estabelecer a conexão com o banco de dados
            // TODO: ajustar URL, usuário e senha conforme o seu ambiente, tranferindo-os para variáveis de ambiente em uma classe separada.
            // OBS: código abaixo está com credenciais escritas no código, não sendo possível executá-lo em qualquer ambiente e esperar que haja algum retorno no método verificarUsuario.
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=lopes&password=123");
        } catch (Exception e) { } // TODO: tratar exceção adequadamente, desta forma não é possível identificar erros de conexão.
        return conn; }
    public String nome="";
    public boolean result = false;

    // Método para verificar usuário no Banco de Dados
    public boolean verificarUsuario(String login, String senha){
        // TODO: Tratar possíveis exceções e null pointers para login, senha e conn.
        // TODO: Ajustar indentação e formatar código.
        String sql = "";
        Connection conn = conectarBD();
        // OBS: Devido a conexão estar com credenciais escritas no código, não será possível executar este método e esperar que haja algum retorno diferente de false.
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        // OBS: Como não existem verificações para os valores recebidos em login e senha, este código está vulnerável a ataques de SQL Injection. Poderá usar Prepared Statements para evitar este tipo de vulnerabilidade.
        // Executar a consulta SQL
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nome = rs.getString("nome");
                result = true;}
        } catch (Exception e) { } // TODO: tratar exceção adequadamente, desta forma não é possível identificar erros na execução da query.
        // TODO: Fechar conexões com banco de dados, statements e result sets. Se não fechados, podem ocorrer vazamentos de memória e esgotamento de conexões.
        return result;
    }// fim da class
}
