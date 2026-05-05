from typing import List


class RotateImage_48:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(0, n-1):
            for j in range(i + 1, n):
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp

        for i in range(0, n-1):
            k = n-1-j
            matrix[i][j] , matrix[i][k] = 
           
       
		   
		  