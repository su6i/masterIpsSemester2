#!/usr/bin/env python
# # -*- coding: utf8 -*-

# Import
# --------------------------------------------------------------------------------------------
import os
import sys
import cv2
import numpy as np
import matplotlib.pyplot as plt
# --------------------------------------------------------------------------------------------
os.system("clear")

if len(sys.argv) != 4:
    print("Usage: ImageIn.pgm ImageOut.pgm Seuil \n")
else:
    inputImage = int(sys.argv[1])
    outputImage = int(sys.argv[2])
    threshold = int(sys.argv[3])

averageOfColorValueInBlock = input(
    "Enter an average for color value in the block: ")
varianceOfColorValueInBlock = input(
    "Enter a variance for color value in the block: ")

print("img.shape: ", img.shape, "\nimg.size:",
      img.size, "img.dtype: ", img.dtype)


def averageOfBlock(inputImage):
    sum = 0.0

    # for i in range
