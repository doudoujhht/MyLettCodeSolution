package com.debut;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static boolean isPowerOfFour(int n) {
        while (true){
            if (n==1) return true;
            if (n==0) return false;
            if (n%4!=0) return false;
            n/=4;
        }
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0)
            return false;
        /* le nombre est la puissance de 3 maximale qu'un integer peut suporter (3^19)
        les puissances divisé par des puissances plus petites ne laissent pas de reste.*/
        return 1162261467 % n == 0;
    }


    /*
     Input: nums = [0,2,1,5,3,4]
    Output: [0,1,2,4,5,3]
    Explanation: The array ans is built as follows:
    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
        = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
        = [0,1,2,4,5,3]
    */
    public static int[] buildArray(int[] nums) {
        int[] s=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i]=nums[nums[i]];
        }
        return s;
    }

    // ca retrouve le nombre de paires qu'il y'a dans un array
    // on prend le premier nombre et on le compare avec tous les autres qui si c'est une paire on rajoute un au compte
    public static int numIdenticalPairs(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;

    }



    //ca permet de classé un array apres avoir mis tous les nombre du arrai au carré
    public static int[] sortedSquares(int[] nums) {
        //ca met les nombres au carré
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nums[i]*nums[i];
        }

        //ca ordonne les nombres du array du plus petit au plus grand arrays.sort fait la meme chose
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                if (nums[i]<nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]= temp;
                }
            }
        }
        return nums;
    }

    //j'ai pas ecris moi meme cet algorithme mais il a l,air interessant so je vais voir comment il marche un jour
    public static int[] sortedSquares2(int[] nums) {
        //two pointers
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0, j = n - 1, index = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                i++;
            } else {
                ans[index] = nums[j] * nums[j];
                j--;
            }
            //put from end to start
            index--;
        }
        return ans;
    }

    //dans un array classé et ou tous les nombres sont distincts ça permet de savoir ou le nombre serais mis si il devait etre inserer
    public static int searchInsert(int[] nums, int target) {

        int first=0;
        int last= nums.length-1;
        int midpoint=0;

        // tant que first sera plus petit ou egal a last
        while (first<=last){
            midpoint=(first+last)/2;//on trouve le millueu
            if (nums[midpoint]==target) return midpoint;//si le nombre est egal au nombre au millueu du array on renvoie ca sinon
            else if (nums[midpoint]<target) first=midpoint+1;//si le nombre du millueu est plus petit le debut devient le millueu +1
            else last=midpoint-1;//si le nombre du milieu est plus grand la fin devien le nombre du millueu moins 1
        }
        if (target>nums[midpoint]) midpoint++;//si la target est plus grand que le millueu c'est que c'est le prochain la bonne réponse
        return midpoint;//retourne le nombre du millueu final
    }

    //dans un array classé on doit trouver la position d'un nombre ou retourner -1
    public static int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    //deplacer tous les zeros d'un array a la fin
    public void moveZeroes(int[] nums) {
        ArrayList<String> s=new ArrayList<>() ;
        for (int num : nums) {
            if (num != 0) s.add(String.valueOf(num));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i< s.size()){
                nums[i]=Integer.parseInt(s.get(i));
            }
            else {
                nums[i]=0;
            }
        }

    }

    //pas ma solution mais c'est une solution interessante
    public void moveZeroes2(int[] nums) {
        int cur = 0;
        int i = 0;

        while ( cur < nums.length){
            if (nums[cur] != 0) {
                nums[i] = nums[cur];
                i++;
            }
            cur++;
        }

        while ( i < nums.length){
            nums[i] = 0;
            i++;

        }
    }

    public void moveZeroes3(int[] nums) {
        ArrayList<String> s=new ArrayList<>() ;
        for (int num : nums) {
            if (num != 0) s.add(String.valueOf(num));
        }
        for (int i = 0; i < s.size(); i++) {
            nums[i]=Integer.parseInt(s.get(i));
        }
        for (int i = s.size(); i < nums.length; i++) {
            nums[i]=0;
        }

    }

    /*
    Input: mat = [[1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1]]
    Output: 8
    ca fait la somme des diagonales de la matrice

            int[][] mat = {
                          {1,2,3},
                          {4,5,6},
                          {7,8,9},
                          };
    ca fait 25 parce que le 5 du milieu ne compte pas
    */

    public static int diagonalSum(int[][] mat) {
        int sum=0;//la somme
        for (int i = 0; i < mat.length; i++) {
            sum+=mat[i][i];//À chaque tour les deux i augmente du coup on descend et on avance dans le ArrayList
            sum+=mat[mat.length-i-1][i];//la meme chose qu'en haut, mais on part du côté inversé pour prendre la deuxième diagonale
        }
        if (mat.length%2==1) sum=sum- mat[mat.length/2][mat.length/2];//si jamais la matrice a une longueur impaire on doit retirer le milieu

        return sum;// retourner la somme
    }

    /*creer un array qui est egale a l'array d'origine mais doublé
    exemple:Input: nums = [1,2,1]
            Output: [1,2,1,1,2,1]
     je pourrais aussi duplicate le Array et le concatener
    */

    public static int[] getConcatenation(int[] nums) {
        int[] nums1=new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            nums1[i]=nums1[i+ nums.length]=nums[i];
        }
        return nums1;
    }


    //ca compte les nombres negatif dans un array
    public static int countNegatives(int[][] grid) {
        int compte=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]<0){
                    compte += grid[i].length-j;
                    break;
                }
            }
        }
        return compte;
    }





}
