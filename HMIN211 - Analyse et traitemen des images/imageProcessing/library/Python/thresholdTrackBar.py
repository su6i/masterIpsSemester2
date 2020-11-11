#!/usr/bin/env python
# # -*- coding: utf8 -*-

import cv2
import numpy as np
import matplotlib.pyplot as plt

# --------------------------------------------------------------------------------------------

# plt.imshow(img, cmap='gray', interpolation='bicubic')
#_, binary = cv2.threshold(OriginalBlackGrayscale, 40, 255, cv2.THRESH_BINARY)
# plt.plot([100, 0], [200, 300], 'r', linewidth=5)
# plt.show()
# cv2.imwrite('imageout.jpg', img)
# print(img.shape, img.size, img.dtype)
# img3 = cv2.merge((b,g,r))
# b = cv2.getTrackbarPos('B','image')
# g = cv2.getTrackbarPos('G','image')
# r = cv2.getTrackbarPos('R','image')
# img2[:] = [b, g, r]
# cv2.waitKey(0)
# cv2.destroyAllWindows()
# B, G, R = cv2.split(OriginalLenaColor)
# cv2.imshow('B', B)
# cv2.imshow('G', G)
# cv2.imshow('R', R)
# plt.hist(B.ravel(), 256, [0, 256])
# plt.hist(G.ravel(), 256, [0, 256])
# plt.hist(R.ravel(), 256, [0, 256])
# plt.show()

# --------------------------------------------------------------------------------------------

ROOT = '/Users/su6i/Amir/gitProjects/myGitProjects/S2/imageProcessing'
img = cv2.imread(ROOT + '/images/ppm/lena.ppm', cv2.IMREAD_GRAYSCALE)


def callBack(x):
    print(x)


cv2.namedWindow("BinaryThresholded")
cv2.createTrackbar("ThresholdValue", "BinaryThresholded", 0, 255, callBack)
while True:
    Threshold = cv2.getTrackbarPos("ThresholdValue", "BinaryThresholded")
    _, thresholdBinary = cv2.threshold(img, Threshold, 255, cv2.THRESH_BINARY)
    key = cv2.waitKey(100)
    if key == 27:
        break

    cv2.imshow("image", img)
    cv2.imshow("BinaryThresholded", thresholdBinary)

cv2.destroyAllWindows()
