// test_couleur.cpp : Seuille une image en niveau de gris

#include <stdio.h>
#include <iostream>
#include <math.h>
#include "library/image_ppm.h"

using namespace std;
double ImageMean(char *NomImage);
double ImageVariance(char *NomImage);
int main(int argc, char* argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nH, nW, nTaille, S;

  if (argc != 4)
     {
       printf("Usage: ImageIn.pgm ImageOut.pgm Seuil \n");
       exit (1) ;
     }

   sscanf (argv[1],"%s",cNomImgLue) ;
   sscanf (argv[2],"%s",cNomImgEcrite);
   sscanf (argv[3],"%d",&S);


double moyenne=ImageMean(cNomImgLue);
double variance=ImageVariance(cNomImgLue);
  cout<<"moyenne = "<<moyenne<<endl;
  cout<<"variance = "<<variance<<endl;


/* for (int i=0; i < nH; i++)
   for (int j=0; j < nW; j++)
     {
       if ( ImgIn[i*nW+j] < S) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
     }*/



   return 1;
}

double ImageMean(char *NomImage){
    int nH,nW,nTaille;
    OCTET *ImgIn;
    lire_nb_lignes_colonnes_image_pgm(NomImage, &nH, &nW);
   nTaille = nH * nW;
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(NomImage, ImgIn, nH * nW);
   double sum=0;
   for (int i=0; i < nTaille; i++)
    {
     sum+=(int)ImgIn[i];
     }
     free(ImgIn);
     return sum/nTaille;

}


double ImageVariance(char *NomImage){
    int nH,nW,nTaille;
    OCTET *ImgIn;
    lire_nb_lignes_colonnes_image_pgm(NomImage, &nH, &nW);
   nTaille = nH * nW;
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(NomImage, ImgIn, nH * nW);
   double sumVariance=0;
   double moyenne=ImageMean(NomImage);
   for (int i=0; i < nTaille; i++)
    {
     sumVariance+=((int)ImgIn[i] - moyenne)*((int)ImgIn[i] - moyenne);
     }
     free(ImgIn);
     return sumVariance/nTaille;

}
