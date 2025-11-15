## Resumo
Abaixo estão as atividades solicitadas pelo professor Daniel Ohata na matéria AS406TSN2 - UX/UI e Testes de Software.

Aluno: Giovanni M. G. Bergamo - RA: 248745.

## Identificação dos nós

1. public boolean verificarUsuario(String login, String senha){
    
2. String sql = "";<br>
    Connection conn = conectarBD();

3. sql += "select nome from usuarios ";<br>
    sql +="where login = " + "'" + login + "'";<br>
    sql += " and senha = " + "'" + senha + "';";
    
4. try {
    Statement st = conn.createStatement();<br>
    ResultSet rs = st.executeQuery(sql);<br>
5. if(rs.next()){
6. nome = rs.getString("nome");<br>
            result = true;}
} 
7. catch (Exception e) { } 
8. return result;
}

## Notação de grafo de fluxo

       1 -> 2 -> 3 -> 4 --> 5 -> 6--\ 
                        \    \ -> ----> 8 (Fim)
                         \ -> 7 ------/

## Complexidade Ciclomática

Formula: M = E − N + 2P

- E, é o número de arestas, neste programa 8.
- N, é o numero de nós, neste programa 8.
- P, é o número de componentes conectados.

Sendo assim: M = 8 - 8 + 2(1) -> M = 2

A complexidade ciclomática deste programa é 2.

## Caminhos básicos
- Retorno positivo:<br>
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 (Usuário encontrado)
- Retorno negativo:<br>
1 -> 2 -> 3 -> 4 -> 5 -> 8 (Usuário não encontrado)<br>
1 -> 2 -> 3 -> 4 -> 7 -> 8 (Exeção)

Apesar de existirem 3 caminhos, podemos considerar como apenas 2 caminhos lógicos, já que apenas o caminho 1 retorna true e os caminhos 2 e 3 retornam false, passando a atender ao resultado da complexidade ciclomática.
