
public class Robo {

    public int codigo;
    public String nome;
    public int ataque;
    public int defesa;
    public int energia;
    public int vitorias;
    public int derrotas;
    public int pontos;
    public int combates;

    public static final int energia_min = 30;

    /*
    O código deverá ser positivo e exclusivo; o nome não poderá estar vazio; o ataque deverá estar entre 10 e 30; 
    e a defesa, entre 0 e 20. Cada robô começará com 100 de energia e os demais indicadores zerados.
    Realizar um combate: possuir pelo menos 30 de energia
    
    */

    public Robo(int codigo, String nome, int ataque, int defesa) {
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = 100;
        this.vitorias = 0;
        this.derrotas = 0;
        this.pontos = 0;
        this.combates = 0;
    }

    public String situacao() {
        if (this.energia >= energia_min) {
           return "Disponível";
        } else {
            return "Em recuperação";
        }
    }


    public void consultarRobos() {
        System.out.println(
            "Nome: " + this.nome + " | " + 
            "Ataque: " + this.ataque + " | " + 
            "Defesa: " + this.defesa +" | " + 
            "Energia: " + this.energia + " | " + 
            "Vitórias: " + this.vitorias + " | " + 
            "Derrotas: " + this.derrotas + " | " +
            "Pontos: " + this.pontos + " | " +
            "Combates: " + this.combates + " | " +
            "Situação: " + situacao() );
    }

    public int getPontos() { 
        return pontos; 
    }

    public int getCodigo() { 
        return codigo; 
    }

}

