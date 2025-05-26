package jogo_modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Fase extends JPanel implements ActionListener { // herdando JPanel e Implementando ActionListener;
    
    private Image fundo; // Criando um atributo do tipo "Image", para receber um plano de fundo;
    private Player player; // Criando um atributo do tipo Player;
    private int score;
    private int vida=3;
    private boolean jogo=false,vitoria=false,gameOver=false;
    
    public boolean getJogo() {
        return jogo;
    }

    public void setJogo(boolean jogo) {
        this.jogo = jogo;
    }

    private Timer timer; // Criando atributo do tipo Timer;
    private Inimigo inimigo;



    public boolean getVitoria() {
        return vitoria;
    }

    public void setVitoria(boolean win) {
        this.vitoria = win;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int mp[][]={ //matriz que representa o "mapa do jogo", com ela será possível exibir os icones nas posições corretas, e saber onde o player/inimigos estão se movimentando;
        //0,  1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  3, 18, 18, 18, 18, 18, 18, 18, 18, 18, 13, 18, 18, 18, 18},//0
        {18, 18, 18,  0,  7,  0,  5,  0,  0,  0,  0,  0,  7,  5,  7,  0,  6,  0,  0,  5,  0,  0,  0,  7, 18, 18, 18, 18},//1
        {18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//2
        {18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//3
        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//4
        {18, 77,  6,  6, 18, 18, 18,  0,  6,  6,  7,  6,  0,  7,  0,  0,  6, 18, 18, 18, 18, 18, 18,  6,  0,  0, 10, 18},//5
        {18,  0,  0,  0, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  7, 77, 18},//6
        {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//7
        {18, 18, 18,  6, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  5, 18, 18, 18, 18},//8
        {18, 18, 18,  0, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//9
        {18, 18, 18,  6, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//10
        {18, 18, 18,  0,  0,  0,  0,  0,  7,  0,  7,  0, 18, 18, 18, 18,  5, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//11
        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//12
        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//13
        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//14
        {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//15
        { 1,  0,  0,  7, 18, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18,  7,  0,  7,  0,  7,  0,  0,  5,  0,  6,  0,  2},//16
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//17
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  5, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//18
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//19
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//20
        {11,  0,  5,  0,  6,  0,  6,  0,  6,  6,  0,  6, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  7,  0,  5,  0, 12},//21
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//22
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//23
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  7, 18, 18, 18, 18},//24
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18,  7, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//25
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18,  6, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//26
        {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//27
        {18, 77,  0,  7, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6,  0,  0, 77, 18},//28
        {18, 18, 18,  6, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//29
        {18, 18, 18,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  4,  9,  9,  9,  9,  9,  9,  9,  9,  9, 14,  9, 18, 18, 18}};//30






    public Fase () { // método construtor

        ImageIcon backGround = new ImageIcon("src/Imagens/mapa.png"); //criando um objeto do tipo "ImageIcon";   
        fundo = backGround.getImage(); // atributo do tipo "Image", pegando a imagem atribuida ao objeto "backGround";
        
        setFocusable(true); // melhorar desempenho;
        setDoubleBuffered(true); // melhorar desempenho;

        player = new Player(); // instanciando um objeto do tipo Player;
        player.load(); // objeto 'player' chamando o método responsável por gerar imagens dos personagens;

        inimigo = new Inimigo();
        inimigo.load();

        addKeyListener(new Teclado()); // Instanciando o teclado na Fase;

        timer = new Timer(5,this); // (velocidade do jogo em milisegundos, local onde é executar o timer no caso 'this' é pra informar que é nessa classe);
        timer.start (); // iniciando o timer;

        jogo = true;

    }


    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g; // instânciando um objeto do tipo "Graphics2D", que vai ser responsavel por receber praticamente todas as imagens relacionadas ao mapa;
        Graphics2D pause = (Graphics2D) g;
        Font fonte = new Font("ARIAL",1,20);


        if(jogo == true && vitoria == false && gameOver == false) {

        graficos.drawImage(fundo, 0, 0, null); // agora o fundo ocupa todo o painel
        graficos.setFont(fonte);
        pause.setColor(Color.white);
        graficos.drawString(""+score, 892,99);
        graficos.drawString(""+vida, 868,147);

                // for que percorre toda a matriz e exibe um icone de acordo com o valor encontrado;
                for(int i = 0; i < 20; i++) {
                    for(int j = 0; j < 31; j++) {
                        int x = i * 27 + 22;
                        int y = j * 20 + 18;
                        switch(mp[j][i]) {
                            case 0:
                                graficos.drawImage(player.getPapel(), x, y, 27, 20, this);
                                break;
                            case 5:
                                graficos.drawImage(player.getSacoLixo(), x, y, 27, 20, this);
                                break;
                            case 6:
                                graficos.drawImage(player.getPlastico(), x, y, 27, 20, this);
                                break;
                            case 7:
                                graficos.drawImage(player.getBanana(), x, y, 27, 20, this);
                                break;
                            case 8:
                                graficos.drawImage(null, x, y, 27, 20, this);
                                break;
                            case 10:
                                graficos.drawImage(player.getR1(), x, y, 27, 20, this);
                                break;
                            case 18:
                                graficos.drawImage(null, x, y, 27, 20, this);
                                break;
                            case 20:
                                graficos.drawImage(player.getR2(), x, y, 27, 20, this);
                                break;
                            case 30:
                                graficos.drawImage(player.getR3(), x, y, 27, 20, this);
                                break;
                            default:
                                break;
                        }
                    }
                }

                graficos.drawImage(player.getPersonagem(), player.getPx(), player.getPy(), 30, 30, this);  // "desenhando" o personagem na tela;
                graficos.drawImage(inimigo.getSujV(), inimigo.getSx(), inimigo.getSy(), 30, 30, this);  
                graficos.drawImage(inimigo.getSujM(), inimigo.getSx2(), inimigo.getSy2(), 30, 30, this);  
                graficos.drawImage(inimigo.getSujR(), inimigo.getSx3(), inimigo.getSy3(), 30, 30, this); 
                graficos.drawImage(inimigo.getSujA(), inimigo.getSx4(), inimigo.getSy4(), 30, 30, this); // "desenhando" o inimigo na tela;


                // mesma funcionalida do metodo interação da classe Player;
                if(player.getStart()) {
                    switch(mp[player.getMpy()][player.getMpx()]) {
                        case 0: // papel 2 * pontos
                            this.score++;
                            mp[player.getMpy()][player.getMpx()] = 0;
                        break;
                        case 5: // saco de lixo + 5 pontos
                            this.score = score + 5;
                            mp[player.getMpy()][player.getMpx()] = 80;
                        break;
                        case 6: // garrafa pet + 2 pontos
                            this.score=score + 2;
                            mp[player.getMpy()][player.getMpx()] = 81;
                        break;
                        case 7: // casca de banana + 1
                            this.score++;
                            mp[player.getMpy()][player.getMpx()] = 82;
                        break;
                        case 10: //r1
                            mp[player.getMpy()][player.getMpx()] = 83;
                            mp[6][1]=20;
                        break;
                        case 20: //r2
                            mp[player.getMpy()][player.getMpx()] = 84;
                            mp[28][26]=30;
                        break;
                        case 30: //r3
                            mp[player.getMpy()][player.getMpx()] = 85;
                            player.setG_win(true); // usuário ganhando o jogo, ao pegar o ultimo R;
                    default:
                        break;
                    }

                }else{

                    pause.drawImage(player.getPause(), 300,250,this);

                }

            // g.dispose(); // método responsavel por liberar os recursos do sistema relacionados a janela (liberar espaço na memória;

            } else if(vitoria){ // caso o usuário finalize o jogo
            
                vitoria();
                graficos.drawImage(player.getVitoria(),0,0,this);
            // g.dispose(); // método responsavel por liberar os recursos do sistema relacionados a janela (liberar espaço na memória;
        

            } else if (gameOver) {

                reiniciarFase();
                graficos.drawImage(player.getGameOver(),0,0,this);
            // g.dispose(); // método responsavel por liberar os recursos do sistema relacionados a janela (liberar espaço na memória;


            }
        g.dispose(); // método responsavel por liberar os recursos do sistema relacionados a janela (liberar espaço na memória;

    }

    // método responsável por atribuir os valores iniciais da matriz e chamar os metodos de "reiniciar" as outras classes;
    public void reiniciarFase() {

        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 31; j++) {
                switch(mp[j][i]) {
                    case 8:
                        mp[j][i]=0;
                        break;
                    case 80:
                        mp[j][i]=5;
                        break;
                    case 81:
                        mp[j][i]=6;
                        break;
                    case 82:
                        mp[j][i]=7;
                        break;
                    case 83:
                        mp[j][i]=10;
                        break;
                    default:
                        break;
                }
            }
        }

        this.vida = 3;
        player.reiniciarFase();
        inimigo.posicaoInimigo();

    }

    // reescrevendo o metodo actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) { // método obrigatório do 'ActionListiner', responsável pro atualizar a tela , (este método é responsável por realizar uma determinada ação quando for disparado este evento.)

        // atualiza as informações das variáveis do tipo jogo, vítoria, game over e score;
        this.jogo=player.getJogo();
        this.vitoria=player.getG_win();
        this.gameOver=player.getG_over();
        this.score = player.getScore();

        // movimenta o inimigo apenas se o jogo estiver "rodando";
        if (player.getStart()) {
            inimigo.update();
        }


        colisao(); // chama o metodo que verifica colisão com inimigo;

        repaint(); // metodo para "re-pintar", utilizado para melhorar a visualização dos objetos na tela;

    }

    public void colisao() { // metodo responsavel pro verificar a colisão entre o personagem e os inimigos;
        
        // "adicionando" um objeto do tipo Rectangle, para o personagem e para cada inimigo e atribuindo os eixos e o tamanho de cada objeto; 
        Rectangle personagem = player.getBounds();
        Rectangle ini_sujV = inimigo.getBoundsSujV();
        Rectangle ini_sujM = inimigo.getBoundsSujM();
        Rectangle ini_sujR = inimigo.getBoundsSujR();
        Rectangle ini_sujA = inimigo.getBoundsSujA();

        if(vida>0 && (personagem.intersects(ini_sujV) || personagem.intersects(ini_sujM) || personagem.intersects(ini_sujR) || personagem.intersects(ini_sujA))) {

            this.vida = vida-1;
            player.posicaoPlayer();

            if(vida==0) {

                player.setStart(false);
                player.setJogo(false);
                player.setG_over(true);
                repaint(); // metodo para "re-pintar", utilizado para melhorar a visualização dos objetos na tela;

            }


        }

    }


    public void vitoria() { // metodo utilizado para quando o personagem termina o objetivo do jogo;

        reiniciarFase();
        player.setStart(false);
        player.setJogo(false);
        repaint(); // metodo para "re-pintar", utilizado paramelhorar a visualização dos objetos na tela;
        
    }

    // criando uma classe do Teclado que herda os atributos e metodos da classe abstrata KeyAdapter, utlizada para processar eventos do Teclado;
    private class Teclado extends KeyAdapter{ // essa classe é responsavel pro receber os eventos e sobreescrever os metodos;

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e); // chamando o metodo de pressionar tecla da classe Player passando a tecla pressionada através de um evento "e";
            player.update(); // objeto player, chamando o metodo responsável por atualizar o movimento do personagem na tela somente quando acontece um "Evento" no metodo de pressionar tecla;
            player.interacao(); // chamando o metodo que modifica a matriz de acordo com o local que o personagem passa;
        }


        @Override
        public void keyReleased(KeyEvent e) {


            player.keyReleased(e);  // chamando o metodo de soltar a tecla da classe Player passando a tecla através de um evento "e";


        }
    
    
    
    }

}



