// test_couleur.cpp : Seuille une image en niveau de gris

#include <stdio.h>
#include "image_ppm.h"

int main(int argc, char *argv[])
{
  char cNomImgLue[250], cNomImgEcrite[250];
  int nH, nW, nTaille, a0, a1;
  float alpha, beta;
  // S = Seuil

  if (argc != 3)
  {
    printf("Usage: ImageIn.pgm ImageOut.pgm Seuil \n");
    exit(1);
  }

  sscanf(argv[1], "%s", cNomImgLue);
  sscanf(argv[2], "%s", cNomImgEcrite);

  OCTET *ImgIn, *ImgOut;

  lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
  nTaille = nH * nW;

  allocation_tableau(ImgIn, OCTET, nTaille);
  lire_image_pgm(cNomImgLue, ImgIn, nH * nW);
  allocation_tableau(ImgOut, OCTET, nTaille);

  //   for (int i=0; i < nTaille; i++)
  // {
  //  if ( ImgIn[i] < S) ImgOut[i]=0; else ImgOut[i]=255;
  //  }

  a0 = 255;
  a1 = 0;

  for (int i = 0; i < nH; i++)
  {
    for (int j = 0; j < nW; j++)
    {
      if (ImgIn[i * nW + j] < a0)
        a0 = ImgIn[i * nW + j];
      if (ImgIn[i * nW + j] > a1)
        a1 = ImgIn[i * nW + j];
    }
  }

  alpha = -255.0 * float(a0) / float(a1 - a0);
  beta = 255.0 / float(a1 - a0);
  printf("alpha = %f", alpha);
  printf("beta = %f", beta);
  printf("a0 = %d", a0);
  printf("a1 = %d", a1);

  for (int i = 0; i < nH; i++)
  {
    for (int j = 0; j < nW; j++)
    {
      ImgOut[i * nW + j] = alpha + beta * float(ImgIn[i * nW + j]);
    }
  }

  // S) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
  ecrire_image_pgm(cNomImgEcrite, ImgOut, nH, nW);
  free(ImgIn);
  return 1;
}
