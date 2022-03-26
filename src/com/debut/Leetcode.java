package com.debut;
//l'ensemble de mes solution leetcode
public class Leetcode {

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

    public boolean isPowerOfThree2(int n) {
        if (n <= 0)
            return false;
        /* le nombre est la puissance de 3 maximale qu'un integer peut suporter (3^19)
        les puissances divisé par des puissances plus petites ne laissent pas de reste.*/
        return 1162261467 % n == 0;
    }



}
