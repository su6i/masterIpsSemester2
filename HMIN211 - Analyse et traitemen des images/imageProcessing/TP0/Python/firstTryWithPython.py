#!/usr/bin/python3

import cv2
import numpy as np
import matplotlib.pyplot as plt

ROOT = '/Users/su6i/Amir/gitProjects/myGitProjects/S2/imageProcessing'
# img = cv2.imread(ROOT + '/images/lena.ppm', cv2.IMREAD_GRAYSCALE)
# img1 = cv2.imread(ROOT + '/images/lena.ppm', cv2.IMREAD_GRAYSCALE)
# cv2.IMREAD_GRAYSCALE  equivalent to 0
# cv2.IMREAD_COLOR  equivalent to 1
# cv2.IMREAD_UNCHANGED  equivalent to -1

# -------------------------------------------------------------------------------------------------------
# Read and write by matplotlib
# plt.imshow(img, cmap='gray', interpolation='bicubic')
# plt.plot([100, 0], [200, 300], 'r', linewidth=5)
# plt.show()
# cv2.imwrite('imageout.jpg', img)


# print(img.shape, img.size, img.dtype)
# img3 = cv2.merge((b,g,r))
# ROI = Region of interest
# -------------------------------------------------------------------------------------------------------
# Read a webcam
# cap = cv2.VideoCapture(0)

# while(True):
# while(cap.isOpened()):

#     ret, frame = cap.read()
#     # gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
#     color = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

#     # cv2.imshow('WebCam', gray)
#     cv2.imshow('WebCam', color)

#     if cv2.waitKey(1) & 0XFF == ord('q'):
#         break

# cap.release()
# cv2.destroyAllWindows()


#key = cv2.waitKey(0) & 0XFF
# if key == 27:
#    cv2.destroyAllWindows()
# elif key == ord('s'):
#    cv2.imwrite('lena.jpg',img)
#    cv2.destroyAllWindows()
# -------------------------------------------------------------------------------------------------------
# Write a video
# cap = cv2.VideoCapture(0)
# fourcc = cv2.VideoWriter_fourcc(*'XVID')
# out = cv2.VideoWriter('output.avi', fourcc, 20.0, (640, 480))

# while(True):
#     ret, frame = cap.read()
#     gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
#     # color = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
#     out.write(frame)

#     cv2.imshow('WebCam', gray)
#     # cv2.imshow('WebCam', color)

#     if cv2.waitKey(1) & 0XFF == ord('q'):
#         break

# cap.release()
# out.release()
# cv2.destroyAllWindows()

# -------------------------------------------------------------------------------------------------------
# Create a black image

# img2 = np.zeros ([512, 512, 3], np.uint8)
# font = cv2.FONT_HERSHEY_SIMPLEX
# text = img1.shape
# cv2.putText(img1, 'Amir', (100, 100), font, 3, (0, 255, 255), 5, cv2.LINE_AA)
# cv2.imshow('blak by numpy', img1)

# -------------------------------------------------------------------------------------------------------
# # Write something on the video
# cap = cv2.VideoCapture(0)

# while(True):
#     ret, frame = cap.read()
#     # color = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
#     # cv2.rectangle(frame, (0, 0), (200, 300), (255, 0, 0), -1)
#     # cv2.rectangle(frame, (0, 0), (1276, 716), (255, 0, 0), 5)
#     # cv2.arrowedLine(frame, (0, 0), (1280, 716), (255, 0, 0), 10)
#     font = cv2.FONT_HERSHEY_SIMPLEX
#     text = 'Width: ' + str(cap.get(3)) + ' Height: ' + str(cap.get(4))
#     cv2.putText(frame, text, (50, 100), font, 2, (0, 255, 255), 2, cv2.LINE_AA)
#     cv2.imshow('WebCam', frame)
#     # print('size: ', frame.shape)
#     # if cv2.waitKey(1) & 0XFF == ord('q'):
#     if cv2.waitKey(1) & 0XFF == 27:
#         break
# cap.release()


# -------------------------------------------------------------------------------------------------------
# Thresholding

# Read colorful image
# OriginalColor = cv2.imread(ROOT + '/images/black.ppm', cv2.IMREAD_COLOR)

# Read grayscale image
# OriginalGrayscale = cv2.imread(ROOT + '/images/black.pgm', cv2.IMREAD_GRAYSCALE)

# Read gradient
# gradient = cv2.imread(ROOT + '/images/gradient.jpg', cv2.IMREAD_GRAYSCALE)

# Thresholding colorful image to binary
# thBinaryColor = cv2.adaptiveThreshold(
# OriginalColor, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 11, 2)

# Thresholding grayscale image to binary
# thBinaryGray = cv2.adaptiveThreshold(OriginalGrayscale, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY, 11, 2)

# Thresholding colorful image to binary inverse
# _, thBinaryColorInverse = cv2.threshold(OriginalColor, 127, 255, cv2.THRESH_BINARY_INV)

# Thresholding grayscale image to binary
# _, thBinaryInvers = cv2.threshold(OriginalGrayscale, 127, 255, cv2.THRESH_BINARY_INV)

# Show original colorful image
# cv2.imshow('OriginalColor', OriginalColor)

# Show thresholded binary colorful
# cv2.imshow('thBinaryColor', thBinaryColor)

# Show original grayscale image
# cv2.imshow('OriginalGrayscale', OriginalGrayscale)

# Show binary thresholded grayscale image
# cv2.imshow('thBinaryGray', thBinaryGray)

# Show binary thresholded gradient image
# cv2.imshow('gradient', gradient)

# Show binary thresholded gradient image
# cv2.imshow('THRESH_TOZERO', thBinarygradient)


# Show threshold binary inverse color image
# cv2.imshow('thBinaryColorInverse', thBinaryColorInverse)

# Show threshold binary inverse grayscale image
# cv2.imshow('thBinaryInvers', thBinaryInvers)

# Histogram
# histogram = cv2.calcHist([OriginalGrayscale], [0], None, [256], [0, 256])

# -------------------------------------------------------------------------------------------------------
# Morphological transformation

# OriginalColor = cv2.imread(ROOT + '/images/08.ppm', cv2.IMREAD_COLOR)
# OriginalGrayscale = cv2.imread(ROOT + '/images/08.pgm', cv2.IMREAD_GRAYSCALE)

# _, binary = cv2.threshold(OriginalGrayscale, 150, 255, cv2.THRESH_BINARY)

# _, binaryInverse = cv2.threshold(
#     OriginalGrayscale, 150, 255, cv2.THRESH_BINARY_INV)

# _, trunc = cv2.threshold(
#     OriginalGrayscale, 150, 255, cv2.THRESH_TRUNC)

# _, zero = cv2.threshold(
#     OriginalGrayscale, 150, 255, cv2.THRESH_TOZERO)

# _, zeroInverse = cv2.threshold(
#     OriginalGrayscale, 150, 255, cv2.THRESH_TOZERO_INV)

# kernel = np.ones((2, 2), np.uint8)
# dilationBinary = cv2.dilate(binary, kernel, iterations=1)
# dilationBinaryInverse = cv2.dilate(binaryInverse, kernel, iterations=1)
# dilationTrunc = cv2.dilate(trunc, kernel, iterations=1)
# erosionBinary = cv2.erode(binary, kernel, iterations=1)
# erosionBinaryInverse = cv2.erode(binaryInverse, kernel, iterations=1)
# erosionTrunc = cv2.erode(trunc, kernel, iterations=1)
# openingBinary = cv2.morphologyEx(binary, cv2.MORPH_OPEN, kernel)
# openingBinaryInverse = cv2.morphologyEx(binaryInverse, cv2.MORPH_OPEN, kernel)
# openingTrunc = cv2.morphologyEx(trunc, cv2.MORPH_OPEN, kernel)
# closingBinary = cv2.morphologyEx(binary, cv2.MORPH_CLOSE, kernel)
# closingBinaryInverse = cv2.morphologyEx(binaryInverse, cv2.MORPH_CLOSE, kernel)
# closingTrunc = cv2.morphologyEx(trunc, cv2.MORPH_CLOSE, kernel)

# titles = ['grayscale', 'binary', 'binaryInverse',
#           'trunc', 'zero', 'zeroInverse']
# titles2 = ['dilationBinary', 'dilationBinaryInverse', 'dilationTrunc',
#            'erosionBinary', 'erosionBinaryInverse', 'erosionTrunc']
# images = [OriginalGrayscale, binary, binaryInverse,
#           trunc, zero, zeroInverse]
# images2 = [dilationBinary, dilationBinaryInverse,
#            dilationTrunc, erosionBinary, erosionBinaryInverse, erosionTrunc]
# titles3 = ['openingBinary', 'openingBinaryInverse', 'openingTrunc',
#            'closingBinary', 'closingBinaryInverse', 'closingTrunc']
# images3 = [openingBinary, openingBinaryInverse, openingTrunc,
#            closingBinary, closingBinaryInverse, closingTrunc]
# for i in range(6):
#     plt.subplot(2, 3, i+1), plt.imshow(images[i], 'gray')
#     plt.title(titles[i])
#     # plt.xticks([]), plt.yticks([])

# plt.show()

# for j in range(6):
#     plt.subplot(2, 3, j+1), plt.imshow(images2[j], 'gray')
#     plt.title(titles2[j])
#     plt.xticks([]), plt.yticks([])


# plt.show()

# for k in range(6):
#     plt.subplot(2, 3, k+1), plt.imshow(images3[k], 'gray')
#     plt.title(titles3[k])
#     plt.xticks([]), plt.yticks([])

# plt.show()

# -------------------------------------------------------------------------------------------------------
# Histogram by numpy
# img = np.zeros((200, 200), np.uint8)
# cv2.rectangle(img, (0, 100), (200, 200), (255), -1)

# OriginalGrayscale = cv2.imread(ROOT + '/images/08.pgm', cv2.IMREAD_GRAYSCALE)
# OriginalLenaColor = cv2.imread(ROOT + '/images/lena.ppm', cv2.IMREAD_COLOR)

# _, binary = cv2.threshold(OriginalGrayscale, 150, 255, cv2.THRESH_BINARY)

# cv2.imshow('Black image', OriginalGrayscale)
# B, G, R = cv2.split(OriginalLenaColor)
# cv2.imshow('B', B)
# cv2.imshow('G', G)
# cv2.imshow('R', R)
# plt.hist(B.ravel(), 256, [0, 256])
# plt.hist(G.ravel(), 256, [0, 256])
# plt.hist(R.ravel(), 256, [0, 256])
# plt.show()

# -------------------------------------------------------------------------------------------------------
# Histogram by numpy
# OriginalBlackColor = cv2.imread(ROOT + '/images/black.ppm', cv2.IMREAD_COLOR)
# OriginalBlackGrayscale = cv2.imread(
#    ROOT + '/images/black.pgm', cv2.IMREAD_GRAYSCALE)
#
#_, binary = cv2.threshold(OriginalBlackGrayscale, 40, 255, cv2.THRESH_BINARY)
# binaryAuto = cv2.adaptiveThreshold(
##     OriginalBlackGrayscale, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY,
# 11, 2)
#
# norm_image = cv2.normalize(
#    binary, None, alpha=0, beta=1, norm_type=cv2.NORM_MINMAX, dtype=cv2.CV_32F)
#
#
# histogramByOpenCV = cv2.calcHist(
#    [binary], [0], None, [256], [0, 256])
#
# plt.plot(histogramByOpenCV)
#cv2.imshow('norm_image', norm_image)
# plt.show()

# cv2.waitKey(0)
# cv2.destroyAllWindows()
# --------------------------------------------------------------------------
# Add trackbar
#img = cv2.imread('/Users/su6i/Temp/Schahin/Image processing/TP3/lena.jpg')
#color = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
#imgNOT = cv2.bitwise_not(img)
#img2 = np.zeros((512,512,3), np.uint8)
# cv2.namedWindow('image')
#
# def myPrint(x):
#    print(x)
#
#cv2.createTrackbar('B', 'image',  0,  255, myPrint)
#cv2.createTrackbar('G', 'image',  0,  255, myPrint)
#cv2.createTrackbar('R', 'image',  0,  255, myPrint)
#
# while (1):
#    cv2.imshow('image',img2)
#    key = cv2.waitKey(1) & 0XFF
#    if key == 27:
#        break
#    b = cv2.getTrackbarPos('B','image')
#    g = cv2.getTrackbarPos('G','image')
#    r = cv2.getTrackbarPos('R','image')
#
#    img2[:] = [b, g, r]


#cv2.imshow('image', img)

#titles = ['color', 'imgNOT']
#images = [color, imgNOT]
# for i in range(2):
# plt.subplot(1, 2, i+1), plt.imshow(images[i], 'gray')
# plt.title(titles[i])
# # plt.xticks([]), plt.yticks([])
#
# plt.show()

# --------------------------------------------------------------------------
# Add Gray/Color Switch

# cv2.namedWindow('image')
#
# def myPrint(x):
#    print(x)
#
#cv2.createTrackbar('CurrentPosition', 'image',  0,  255, myPrint)
#switch = 'color/gray'
#cv2.createTrackbar(switch, 'image',  0,  1, myPrint)
#
#
#
# while (1):
#    img = cv2.imread('/Users/su6i/Temp/Schahin/Image processing/TP3/lena.jpg')
#    pos = cv2.getTrackbarPos('CurrentPosition', 'image')
#    font = cv2.FONT_HERSHEY_SIMPLEX
#    cv2.putText(img, str(pos), (50,150), font, 4, (255,255,255), 4)
#    key = cv2.waitKey(1) & 0XFF
#    if key == 27:
#        break
#    s = cv2.getTrackbarPos(switch,'image')
#    if s == 0:
#        pass
#    else:
#          img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
#
#    img = cv2.imshow('image', img)

# --------------------------------------------------------------------------
# Object detection

def callBackFunction(x):
    print(x)


cap = cv2.VideoCapture(0)         # To capture the video
cv2.namedWindow('TrackingColors')
cv2.createTrackbar('LowerHue', 'TrackingColors',  0,  255, callBackFunction)
cv2.createTrackbar('LowerSaturation', 'TrackingColors',
                   0,  255, callBackFunction)
cv2.createTrackbar('LowerValue', 'TrackingColors',  0,  255, callBackFunction)
cv2.createTrackbar('UpperHue', 'TrackingColors',  255,  255, callBackFunction)
cv2.createTrackbar('UpperSaturation', 'TrackingColors',
                   255,  255, callBackFunction)
cv2.createTrackbar('UpperValue', 'TrackingColors',
                   255,  255, callBackFunction)


while (1):
    #img = cv2.imread('images/png/smarties.png')
    _, img = cap.read()             # To read the video
    hsvPhoto = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

    LowerHueTrackbar = cv2.getTrackbarPos('LowerHue', 'TrackingColors')
    LowerSaturationTrackbar = cv2.getTrackbarPos(
        'LowerSaturation', 'TrackingColors')
    LowerValueTrackbar = cv2.getTrackbarPos('LowerValue', 'TrackingColors')

    UpperHueTrackbar = cv2.getTrackbarPos('UpperHue', 'TrackingColors')
    UpperSaturationTrackbar = cv2.getTrackbarPos(
        'UpperSaturation', 'TrackingColors')
    UpperValueTrackbar = cv2.getTrackbarPos('UpperValue', 'TrackingColors')

    lowerBandFilter = np.array(
        [LowerHueTrackbar, LowerSaturationTrackbar, LowerValueTrackbar])
    upperBandFilter = np.array(
        [UpperHueTrackbar, UpperSaturationTrackbar, UpperValueTrackbar])
    mask = cv2.inRange(hsvPhoto, lowerBandFilter, upperBandFilter)
    result = cv2.bitwise_and(img, img, mask=mask)
    cv2.imshow('image', img)
    cv2.imshow('mask', mask)
    cv2.imshow('result', result)

    key = cv2.waitKey(1) & 0XFF
    if key == 27:
        break


# titles = ['img', 'mask','result']
# images = [img, mask,result]
# for i in range(3):
# plt.subplot(1, 3, i+1), plt.imshow(images[i])
# plt.title(titles[i])
# # plt.xticks([]), plt.yticks([])

# plt.show()

cap.release()
cv2.destroyAllWindows()
