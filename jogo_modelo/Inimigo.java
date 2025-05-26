package jogo_modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



public class Inimigo {

    private int msx,msy,msx2,msy2; // coordenadas do inimigo na matriz;
    private int msx3,msy3,msx4,msy4; // coordenadas do inimigo na matriz;
    private int sx,sy; // eixo x e y do Sujão Verde;
    private int sx2,sy2; // eixo x e y do Sujão Marron;
    private int sx3,sy3; // eixo x e y do Sujão Roxo;
    private int sx4,sy4; // eixo x e y do Sujão Azul;
    private int veloSx,veloSy; // varialvel que incrementa no eixo x e y do Sujão;
    private boolean subir=false,descer=true,esquerda=false,direita=true,subir2=false,descer2=true,esquerda2=false,direita2=true;
    private int contS,contS2,contS3,contS4; // varialvel que incrementa no eixo x e y do Sujão;
    private Image ini_sujV;
    private Image ini_sujM;
    private Image ini_sujR;
    private Image ini_sujA;
    private int width, height;

    int mp[][]={
            //0,  1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  4, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//0
            {18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18},//1
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//2
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//3
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//4
            {18,  0,  0,  0, 18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18, 18, 18,  6,  0,  0, 10, 18},//5
            {18,  0,  0,  0, 18, 18, 18,  0,  8,  8,  8,  8,  8,  8,  8,  8,  0, 18, 18, 18, 18, 18, 18,  0,  0,  7, 77, 18},//6
            {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//7
            {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  5, 18, 18, 18, 18},//8
            {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//9
            {18, 18, 18,  0, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//10
            {18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//11
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//12
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//13
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//14
            {18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18},//15
            { 1,  0,  0,  0, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  2},//16
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//17
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//18
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//19
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18},//20
            {18,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//21
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//22
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//23
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//24
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  6, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//25
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//26
            {18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//27
            {18,  8,  8,  8,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  0, 18, 18, 18, 18, 18, 18,  0,  0,  0,  0, 18},//28
            {18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18,  8, 18, 18, 18, 18, 18, 18,  0, 18, 18, 18, 18},//29
            {18, 18, 18, 18,  9,  9,  9,  9,  9,  9,  9, 18,  9,  9,  9,  9, 18,  9,  9,  9,  9,  9,  9, 18,  9, 18, 18, 18}};//30


    public int getSx() {
        return sx;
    }
    public int getSy() {
        return sy;
    }
    public int getSx2() {
        return sx2;
    }
    public int getSy2() {
        return sy2;
    }
    public int getMsx() {
        return msx;
    }
    public int getmsy() {
        return msy;
    }
    public int getMsx2() {
        return msx2;
    }
    public int getMsy2() {
        return msy2;
    }
    public Image getSujV() {
        return ini_sujV;
    }

    public Image getSujM() {
        return ini_sujM;
    }
    public int getSx3() {
        return sx3;
    }
    public int getSy3() {
        return sy3;
    }
    public int getSx4() {
        return sx4;
    }
    public int getSy4() {
        return sy4;
    }
    public int getMsx3() {
        return msx3;
    }
    public int getMsy3() {
        return msy3;
    }
    public int getMsx4() {
        return msx4;
    }
    public int getMsy4() {
        return msy4;
    }
    public Image getSujR() {
        return ini_sujR;
    }

    public Image getSujA() {
        return ini_sujA;
    }


    // metodo construtor;

    public Inimigo() {

        posicaoInimigo();

    }


    public void posicaoInimigo() {

        this.sx = 3 * 27 + 9;
        this.sy = 1 * 20 + 9;

        this.sx2 = 16 * 27 + 9;
        this.sy2 = 29 * 20 + 9;

        this.msx = (sx - 9) / 27; // coluna
        this.msy = (sy - 9) / 20; // linha

        this.msx2 = (sx2 - 9) / 27; // coluna
        this.msy2 = (sy2 - 9) / 20; // linha

        // posição dos outros inimigos;
        this.sx3 = 11 * 27 + 9;
        this.sy3 = 29 * 20 + 9;

        this.sx4 = 23 * 27 + 9;
        this.sy4 = 1 * 20 + 9;

        this.msx3 = (sx3 - 9) / 27; // coluna
        this.msy3 = (sy3 - 9) / 20; // linha

        this.msx4 = (sx4 - 9) / 27; // coluna
        this.msy4 = (sy4 - 9) / 20; // linha

    }


    public void load() {

    ImageIcon sujV = new ImageIcon("src/Imagens/sujaoV.png");
    ImageIcon sujM = new ImageIcon("src/Imagens/sujaoM.png");
    ImageIcon sujR = new ImageIcon("src/Imagens/sujaoR.png");
    ImageIcon sujA = new ImageIcon("src/Imagens/sujaoA.png");

    ini_sujV    = sujV.getImage();
    height      = ini_sujV.getHeight(null);
    width       = ini_sujV.getWidth(null);

    ini_sujM    = sujM.getImage();
    height      = ini_sujM.getHeight(null);
    width       = ini_sujM.getWidth(null);

    ini_sujR    = sujR.getImage();
    height      = ini_sujR.getHeight(null);
    width       = ini_sujR.getWidth(null);

    ini_sujA    = sujA.getImage();
    height      = ini_sujA.getHeight(null);
    width       = ini_sujA.getWidth(null);


    }

    // criando metodos que retornam um retnagulo com as posições x e y e altura/largura de cada inimigo;
    public Rectangle getBoundsSujV() {

        return new Rectangle(sx, sy, width, height);
    }

    public Rectangle getBoundsSujM() {

        return new Rectangle(sx2, sy2, width, height);
    }

    public Rectangle getBoundsSujR() {

        return new Rectangle(sx3, sy3, width, height);
    }

    public Rectangle getBoundsSujA() {

        return new Rectangle(sx4, sy4, width, height);
    }

    public void update() { // classe responsável por chamar todos os metodos de movimentação dos iniigos
        
        descerInimigo();
        subirInimigo();
        esquerdaInimigo();
        direitaInimigo();
        descerInimigo2();
        subirInimigo2();
        esquerdaInimigo2();
        direitaInimigo2();

    }

    public void descerInimigo() {

        if(mp[msy + 1][msx] != 18 && descer == true) {
                
            veloSy=2; //"velocidade" do inimigo em pixels;
            veloSx=0;

            //this.sx=sx+ix;
            this.sx=sx+veloSx;

            //this.sy=sy+iy;
            this.sy=sy+veloSy;

            contS=contS+veloSy;

            if(contS==20) {
                msy+=1;
                contS=0;
            }
        }else {

            descer = false;
            subir  = true;
        }



    }

    public void descerInimigo2() {

        if(mp[msy2 + 1][msx2] != 18 && descer2 == true) {
                
            veloSy=2; //"velocidade" do inimigo em pixels;
            veloSx=0;

            //this.sx=sx+ix;
            this.sx2=sx2+veloSx;
            //this.sy=sy+iy;
            this.sy2=sy2+veloSy;
        
            contS2=contS2+veloSy;

            if(contS2==20) {
                msy2+=1;
                contS2=0;
            }
        }else {

            descer2 = false;
            subir2  = true;
        }



    }


    public void subirInimigo() {

        if(mp[msy - 1][msx] != 18 && subir == true) {
                
            veloSy=2; //"velocidade" do inimigo em pixels;
            veloSx=0;

            //this.sx=sx+ix;
            this.sx=sx+veloSx;
            //this.sy=sy+iy;
            this.sy=sy-veloSy;

            contS=contS+veloSy; // cont recebe o valor da velocidade do personagem até chegar em "20", que corresponde a +1 da posição na matriz;

            if(contS==20) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;
               
                msy-=1;
                contS=0;
            }

        }else {
            descer = true;
            subir = false;
        }

    }

    public void subirInimigo2() {

        if(mp[msy2 - 1][msx2] != 18 && subir2 == true) {
                
            veloSy=2; //"velocidade" do inimigo em pixels;
            veloSx=0;

            //this.sx=sx+ix;
            this.sx2=sx2+veloSx;
            //this.sy=sy+iy;
            this.sy2=sy2-veloSy;

            contS2=contS2+veloSy; // cont recebe o valor da velocidade do personagem até chegar em "20", que corresponde a +1 da posição na matriz;

            if(contS2==20) { // quando cont for igual a 20, quer dizer que ele andou uma casa na matriz;

                msy2-=1;
                contS2=0;
            }

        }else {
            descer2 = true;
            subir2 = false;
        }

    }

    public void direitaInimigo() {

        if(mp[msy][msx + 1] != 18 && direita == true) {
                
            veloSy=0; 
            veloSx=1; //"velocidade" do inimigo em pixels;

            this.sx3=sx3+veloSx;
            //this.sx=sx+ix;

            this.sy3=sy3+veloSy;
            //this.sy=sy+iy;

            contS3=contS3+veloSx;

            if(contS3==27) {
                msx3+=1;
                contS3=0;
            }
        }else {

            direita = false;
            esquerda = true;
        }

    }

    public void direitaInimigo2() {

        if(mp[msy2][msx2 + 1] != 18 && direita2 == true) {
                
            veloSy=0; 
            veloSx=1; //"velocidade" do inimigo em pixels;

            this.sx4=sx4+veloSx;
            //this.sx=sx+ix;

            this.sy4=sy4+veloSy;
            //this.sy=sy+iy;

            contS4=contS4+veloSx;

            if(contS4==27) {
                msx4+=1;
                contS4=0;
            }
        }else {

            direita2 = false;
            esquerda2 = true;
        }

    }

    public void esquerdaInimigo() {

        if(mp[msy][msx - 1] != 18 && esquerda == true) {
                
            veloSy=0; 
            veloSx=-1; //"velocidade" do inimigo em pixels;

            this.sx3=sx3+veloSx;
            //this.sx=sx+ix;

            this.sy3=sy3+veloSy;
            //this.sy=sy+iy;

            contS3=contS3+veloSx;

            if(contS3==27) {
                msx3-=1;
                contS3=0;
            }
        }else {
            esquerda = false;
            direita = true;
        }

    }

    public void esquerdaInimigo2() {

        if(mp[msy2][msx2 - 1] != 18 && esquerda2 == true) {
                
            veloSy=0; 
            veloSx=-1; //"velocidade" do inimigo em pixels;

            this.sx4=sx4+veloSx;
            //this.sx=sx+ix;

            this.sy4=sy4+veloSy;
            //this.sy=sy+iy;

            contS4=contS4+veloSx;

            if(contS4==27) {
                msx4-=1;
                contS4=0;
            }
        }else {
            esquerda2 = false;
            direita2 = true;
        }

    }



}

