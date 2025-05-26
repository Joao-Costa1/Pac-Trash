package jogo;

import javax.swing.JFrame;
import jogo_modelo.Fase;

public class Janela extends JFrame { // criando a classe que será usada para fazer a "Janela do jogo", herdando atributos e métodos do JFrame;

    public Janela() {

        add (new Fase()); //adicionando um componente do tipo Fase;
        setTitle("Pac-Trash"); // nome da janela (nome do jogo);
        setSize(1000, 690); // define o tamanho da janela;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //método utilizado para encerrar o jogo ao clicar no "x" da janela;
        setLocationRelativeTo(null); //posição onde a janela será aberta, o parametro null é utilizado para ela aparecer no meio da tela;
        this.setResizable(false); //método utilizado para barra o usuário de aumentar ou diminuir o tamanho da tela;
        setVisible(true); // método utilizado para exibir ou não a janela;

    }
    
    public static void main(String[] args){ //método main;
        
        new Janela(); //executando o método construtor da classe Janela;
        
    }
}