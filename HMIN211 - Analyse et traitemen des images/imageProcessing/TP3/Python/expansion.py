#!/usr/bin/python3

import cv2
import numpy as np
import matplotlib.pyplot as plt
import sys
from PIL import Image


# a = np.shape(img)
# b = img.reshape(img.shape[0]*img.shape[1], img.shape[2])
# c = np.reshape(img, (270000, 1))
# np.argmin(a)

inp = sys.argv
if len(inp) != 3:
    print("Usage: ImageIn.pgm ImageOut.pgm \n")
else:
    imgName = inp[1]
    imgOut = inp[2]

    imgIn = cv2.imread(imgName, cv2.IMREAD_GRAYSCALE)
    widths, heights = np.shape(imgIn)
    imgSize = widths * heights

    imgInArray = np.array(imgIn, np.uint8)

    a0 = np.amin(imgIn)
    a1 = np.amax(imgIn)
    print("a0:", a0, "a1:", a1)

    alpha = -255.0 * float(a0) / float(a1 - a0)
    beta = 255.0 / float(a1 - a0)
    print("alpha:", alpha, "beta:", beta)

    for width in range(widths):
        for height in range(heights):
            imgOut[width, height] = alpha + beta * \
                float(imgInArray[width, height])
    cv2.imwrite('blackOut.pgm', imgOut)

    cv2.imshow("imgIn", imgIn)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
