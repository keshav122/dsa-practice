package com.dsa.arrays_3_2_medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ZeroMatrix {

     public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
  
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i< n;i++){
            for(int j = 0; j < m ; j++){
                if(matrix.get(i).get(j)  == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        //Setting rows to 0
        for(int i = 0; i< rows.size() ;i++){
            int index = rows.get(i);
            for(int j =  0;j < m; j++){
                matrix.get(index).set(j, 0);
            }
        }
        
        //Setting cols to 0
        for(int i = 0; i< cols.size() ;i++){
            int index = cols.get(i);
            for(int j =  0;j < n; j++){
                matrix.get(j).set(index, 0);
            }
        }
        return matrix;
    }
    

    public static ArrayList<ArrayList<Integer>> zeroMatrix_Way1(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
    	 Set<Integer> rows = new HashSet<>();
         Set <Integer> cols = new HashSet<>();
         for(int i = 0; i< n;i++){
             for(int j = 0; j < m ; j++){
                 if(matrix.get(i).get(j)  == 0){
                     rows.add(i);
                     cols.add(j);
                 }
             }
         }

         //Setting rows to 0
         for(Integer index : rows){
             for(int j =  0;j < m; j++){
                 matrix.get(index).set(j, 0);
             }
         }
         
         //Setting cols to 0
         for(Integer index : cols) {
             for(int j =  0;j < n; j++){
                 matrix.get(j).set(index, 0);
             }
         }
         return matrix;
    }

}
