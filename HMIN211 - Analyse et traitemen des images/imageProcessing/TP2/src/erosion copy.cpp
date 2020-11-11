// test_couleur.cpp : Seuille une image en niveau de gris

#include <stdio.h>
#include "image_ppm.h"

// int max(int i, int j) {
//   int m, n, matrix[3][3], maximum = 0;
//   m = 3;
//   n = 3;

//     for (; i < m+i; i++){
//       for (; j < n+i; j++){
//         maximum = matrix[i][j];
//           if ((i-1)*(j-1) > 0 && matrix[i][j] > maximum)
//                   maximum = matrix[i][j];
          
//       }
//     }
//     return maximum;
// }


// int min(int i, int j) {
//     int m, n, matrix[3][3], minumum = 0;
//     minumum = matrix[i][j];
//     m = 3;
//     n = 3;


//       for (; i < m+i; i++){
//           for (; j < n+j; j++){
//         minumum = matrix[i][j];
//           if ((i-1)*(j-1) > 0 && matrix[i][j] < minumum)
//                   minumum = matrix[i][j];
          
//       }
//     }
//     return minumum;
// }


int main(int argc, char* argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nH, nW, nTaille;
  // S = Seuil
  
  if (argc != 3) 
     {
       printf("Usage: ImageIn.pgm ImageOut.pgm Seuil \n"); 
       exit (1) ;
     }
   
   sscanf (argv[1],"%s",cNomImgLue) ;
   sscanf (argv[2],"%s",cNomImgEcrite);

   OCTET *ImgIn, *ImgOut;
   
   lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
   nTaille = nH * nW;
  
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(cNomImgLue, ImgIn, nH * nW);
   allocation_tableau(ImgOut, OCTET, nTaille);
	

 for (int i=0; i < nH; i++)
 {
   for (int j=0; j < nW; j++)
     {
       int maximum = max(i,j);
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
       if ( ImgIn[i*nW+j] < maximum) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
     }
 }
   ecrire_image_pgm(cNomImgEcrite, ImgOut,  nH, nW);
   free(ImgIn);
   return 1;
}


