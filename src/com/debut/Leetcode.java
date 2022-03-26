package com.debut;
//l'ensemble de mes solution leetcode
public class Leetcode {


    public static boolean ispowerOf(int n, int powerof) {
        //le meme principe que quand j'essayait de connaitre les puissance étant petit
        //on divise par le nombre jusqu'a ce qu'on arrive a 1 ou a une division avec reste
        while (true){
            if (n==1) return true;//des que n est egal a un on sait que c'est une puissance du nombre
            if (n==0) return false;// si le nombre est egal a 0 on sait automatiquement que c'est pas une puissance
            if (n%powerof!=0) return false;//si la division a un reste ce n'est pas une puissance
            n/=powerof;//on divise le nombre par trois pour pouvoir refaire l'operation
        }
    }

    /*l'algorithme sert a connaitre le a quelle puissance est deux nombre
    exemple: si n est egal a 16 et powerof est egal a 4 la reponse est 2 car 4 puissance 2 egal 16
    exemple: si n est egal a 128 et powerof est egal a 2 la reponse est 7 car 2 puissance 7 egal 128
    exemple: si n est egal a 33 et powerof est egal a 2 la reponse est -1 car 33 n'est pas une puissance de 2*/
    public static int whatisthepower(int n, int powerof) {
        int compte=0;
        while (true){
            if (n==1) return compte;
            if (n==0) return -1;
            if (n%powerof!=0) return -1;
            compte++;
            n/=powerof;
        }
    }

    public static boolean isPowerOfThree(int n) {
        //il y'a une boucle infini
        while (true){
            //le meme principe que quand j'essayait de connaitre les puissance étant petit
            //on divise par le nombre jusqu'a ce qu'on arrive a 1 ou a une division avec reste
            if (n==1) return true;//des que n est egal a un on sait que c'est une puissance du nombre
            if (n==0) return false;// si le nombre est egal a 0 on sait automatiquement que c'est pas une puissance
            if (n%3!=0) return false;//si la division a un reste ce n'est pas une puissance
            n/=3; //on divise le nombre par trois pour pouvoir refaire l'operation
        }


    }

    public boolean isPowerOfFour(int n) {
        while (true){
            if (n==1) return true;
            if (n==0) return false;
            if (n%4!=0) return false;
            n/=4;
        }
    }

    public boolean isPowerOfThree2(int n) {
        if (n <= 0)
            return false;
        /* le nombre est la puissance de 3 maximale qu'un integer peut suporter (3^19)
        les puissances divisé par des puissances plus petites ne laissent pas de reste.*/
        return 1162261467 % n == 0;
    }





}
