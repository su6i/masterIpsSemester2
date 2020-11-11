#include "image_ppm.h"
#include <stdio.h>
#include <stdlib.h>     /* atoi */

int main(int argc, char* argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nHeight, nWidth, nTaille, NbSeuils;
  if (argc <4) 
     {
       printf("Usage: ImageIn.pgm ImageOut.pgm NbSeuils Seuil1 Seuil2 ... \n"); 
       exit (1) ;
     }
   sscanf (argv[1],"%s",cNomImgLue) ;
   sscanf (argv[2],"%s",cNomImgEcrite);
   sscanf (argv[3],"%d",&NbSeuils);
   int Seuil[NbSeuils];
   for (int i=0; i<NbSeuils; i++){
     sscanf (argv[4+i],"%d",&Seuil[i]);
   }


   OCTET *ImgIn, *ImgOut;
  //  for (int i=0; i < nHeight; i++){
  //  for (int j=0; j < nWidth; j++)
  //    {
  //      for(int k=0;k<NbSeuils; NbSeuils++){
  //        if ( ImgIn[i*nWidth+j] < Seuil[k]) {
  //          ImgOut[i*nWidth+j]=0; 
  //         break;
  //          } 
  //        else {
  //          ImgOut[i*nWidth+j]=255;
  //         } 
  //       }
  //   }
  lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nHeight, &nWidth);
   nTaille = nHeight * nWidth;
  
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(cNomImgLue, ImgIn, nHeight * nWidth);
   allocation_tableau(ImgOut, OCTET, nTaille);
	
   //   for (int i=0; i < nTaille; i++)
   // {
   //  if ( ImgIn[i] < S) ImgOut[i]=0; else ImgOut[i]=255;
   //  }


 for (int i=0; i < nHeight; i++)
 {
   for (int j=0; j < nWidth; j++)
     {
       for(int k=0;k<NbSeuils; k++){
         if ( ImgIn[i*nWidth+j] < Seuil[k]) {
           ImgOut[i*nWidth+j]=k * (255/NbSeuils); 
          break;
           } 
         else {
           ImgOut[i*nWidth+j]=255;
          } 

        }
     }
}
       

   ecrire_image_pgm(cNomImgEcrite, ImgOut,  nHeight, nWidth);
   free(ImgIn);
   return 1;
}
