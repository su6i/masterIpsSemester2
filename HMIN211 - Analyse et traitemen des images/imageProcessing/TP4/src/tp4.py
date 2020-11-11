#!/usr/bin/env python
# -*- coding:utf-8 -*-

import cv2
import numpy as np
import matplotlib.pyplot as plt
import os

ROOT = '/home/e20190009681/myGitProjects/S2/imageProcessing/Python'

imgColor = cv2.imread(ROOT + '/TP4/images/tp4_2_128.ppm', cv2.IMREAD_COLOR)
imgGrayscale = cv2.imread(
    ROOT + '/TP4/images/tp4_2_128.ppm', cv2.IMREAD_GRAYSCALE)
# _, thresholdBinary100 = cv2.threshold(imgGrayscale, 25, 255, cv2.THRESH_BINARY)
# _, thresholdBinary105 = cv2.threshold(imgGrayscale, 30, 255, cv2.THRESH_BINARY)
masked050 = cv2.inRange(imgGrayscale, 0, 50)
masked50100 = cv2.inRange(imgGrayscale, 50, 100)
masked100150 = cv2.inRange(imgGrayscale, 100, 150)
masked150200 = cv2.inRange(imgGrayscale, 150, 200)
masked200255 = cv2.inRange(imgGrayscale, 200, 255)

# # histogram = cv2.calcHist([img], [0], None, [256], [0, 256])


plt.hist(imgGrayscale.ravel(), 256, [0, 256])

# B, G, R = cv2.split(imgColor)

# cv2.imshow('B', B)
# cv2.imshow('G', G)
# cv2.imshow('R', R)
# plt.hist(B.ravel(), 256, [0, 256])
# plt.hist(G.ravel(), 256, [0, 256])
# plt.hist(R.ravel(), 256, [0, 256])
# plt.show()


# titles = ['thresholdBinary100','thresholdBinary105','thresholdBinary110','thresholdBinary115',
#         'thresholdBinary120','thresholdBinary125','thresholdBinary130','thresholdBinary135','thresholdBinary140',
#         'thresholdBinary145','thresholdBinary150','thresholdBinary155','thresholdBinary160','thresholdBinary165']

# images = [thresholdBinary100,thresholdBinary105,thresholdBinary110,thresholdBinary115,
#         thresholdBinary120,thresholdBinary125,thresholdBinary130,thresholdBinary135,thresholdBinary140,
#         thresholdBinary145,thresholdBinary150,thresholdBinary155,thresholdBinary160,thresholdBinary165]

# for i in range(14):
#     plt.subplot(3, 5, i+1), plt.imshow(images[i], 'gray')
#     plt.title(titles[i])
#     plt.xticks([]), plt.yticks([])

# plt.show()

titles = ['masked 0-50', 'masked 50-100',
          'masked 100-150', 'masked 150-200', 'masked 200-255']

images = [masked050, masked50100,
          masked100150, masked150200, masked200255]

for i in range(5):
    plt.subplot(1, 5, i+1), plt.imshow(images[i], 'gray')
    plt.title(titles[i])
    plt.xticks([]), plt.yticks([])

plt.show()


# masked = cv2.inRange(imgGrayscale, 160, 255)
# cv2.imshow('masked', masked)

# plt.hist(imgGrayscale.ravel(), 256, [0, 256])
# cv2.imshow('imgGrayscale', imgGrayscale)
# plt.show()

# cv2.imwrite('/TP4/results/thresholdBinary_120.jpg', thresholdBinary)
# cv2.imwrite('imgGrayscale_girl.jpg', imgGrayscale)
# cv2.imshow('thBinary', thresholdBinary)


cv2.waitKey(0)
cv2.destroyAllWindows()
