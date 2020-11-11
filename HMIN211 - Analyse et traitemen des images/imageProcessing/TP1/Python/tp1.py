#!/usr/bin/env python
# # -*- coding: utf8 -*-

import os
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
os.system("clear")
ROOT = '/Users/su6i/Amir/gitProjects/myGitProjects/S2/imageProcessing/imageProcessing'
file = '/images/pgm/08.pgm'
imageFile = ROOT+file
thresh1 = 100
thresh2 = 200
color = cv2.imread(imageFile, cv2.IMREAD_COLOR)
gray = cv2.imread(imageFile, cv2.IMREAD_GRAYSCALE)
ret, binary = cv2.threshold(gray, 127, 255, cv2.THRESH_BINARY)

height, width = gray.shape

binary100 = np.zeros([height, width, 1], 'uint8')
binary200 = np.zeros([height, width, 1], 'uint8')

white = np.ones([height, width, 1], 'uint8')*255
hist = cv2.calcHist(gray, [0], None, [256], [0, 256])
print(hist)
cv2.imshow("Finale", hist)
# plt.hist(gray.ravel(), 256, [0, 256])
# plt.show()


minThreshold = np.amin(gray)
print("minThreshold:", minThreshold)
maxThreshold = np.amax(gray)
print("maxThreshold:", maxThreshold)

for row in range(height):
    for colomn in range(width):
        if gray[row][colomn] < thresh1:
            binary100[row][colomn] = 0
        elif gray[row][colomn] < thresh2:
            binary100[row][colomn] = 127

        else:
            binary100[row][colomn] = 255


# Concatenate two images horizontally
final_horizontal_1 = cv2.hconcat((color, gray))
final_horizontal_2 = cv2.hconcat((binary, binary100))

# Concatenate two images vertically
# final_vertical = cv2.vconcat((gray, binary100))


final_double_horizontal = cv2.vconcat((final_horizontal_1, final_horizontal_2))

cv2.imshow("Final", final_double_horizontal)


print("gray.dtype:", gray.dtype)
print("gray.size:", gray.size)
print("gray.shape:", gray.shape)
print("height: ", height, "width: ", width)
cv2.waitKey(0)
cv2.destroyAllWindows()
