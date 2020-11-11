from PIL import Image
from PIL import ImageFilter     # To blur an image
import os
from shutil import move
# from shutil import copy2
import sys

# os.system("clear")


# The createExtensions() function get a list of files as argument and will
# convert it into all extensions that are in the knownExtensions list. At
# the end by calling clearRoot() function, it will pull all created files
# into its proper folder in the images folder.


def createExtensions(files):
    print("files:", files)
    for file in files:
        knownExtensions = ['jpg', 'png', 'pgm', 'ppm']
        fileName, fileExtension = os.path.splitext(file)
        fileExtension = fileExtension[1:]
        knownExtensions.remove(fileExtension)
        if file.endswith('.'+fileExtension):
            i = Image.open(file)
            for extension in knownExtensions:
                if fileExtension not in os.listdir('images') and fileExtension:
                    os.mkdir('images/'+fileExtension)
                    i.save('images/' + extension + '/' +
                           fileName + '.' + extension)
                    print(file, "converted and copied to images/" +
                          extension+'/'+fileName + '.' + extension)
                else:
                    i.save('images/' + extension + '/' +
                           fileName + '.' + extension)
                    print(file, "converted and copied to images/" +
                          extension+'/'+fileName + '.' + extension)
    clearRoot()

# This function will move all files with the extensions {'jpg', 'pgm', 'png', 'ppm'}
# into a folder with the same name in the images folder and if this file
# already exist in the mentioned folder, it will move that file into the
# AlreadyExisted folder.


def clearRoot():
    files = os.listdir('.')
    for file in files:
        fileName, fileExtension = os.path.splitext(file)
        fileExtension = fileExtension[1:]
        if fileName and fileExtension in {'jpg', 'pgm', 'png', 'ppm'}:
            if fileExtension not in os.listdir('images') and fileExtension:
                os.mkdir('images/'+fileExtension)
                move(file, 'images/' + fileExtension + '/' + file)
                print(file, "moved to images/", fileExtension+'/'+file)

            if file not in os.listdir('images/' + fileExtension):
                move(file, 'images/' + fileExtension + '/' + file)
                print(file, "moved to images/" + fileExtension+'/'+file)
            else:
                print("There is a copy of", file, "in the images/" + fileExtension,
                      "folder. I'll put this second copy into\n'AlreadyExisted folder.")
                if not os.path.exists('images/AlreadyExisted'):
                    os.makedirs('images/AlreadyExisted')
                move(file, 'images/AlreadyExisted/' + file)

# resize() function, get the name of a file and a number as a size of a photo
# and as a result it'll save that file in the new given size.


def resize(file, size):
    img = Image.open(file)
    size = size, size
    img.thumbnail(size)
    width, height = size
    fileName, fileExtension = os.path.splitext(file)
    img.save('{}_{}_{}{}'.format(fileName, width, height, fileExtension))


# Example of resize() function, that will create a file with the name
# girl_56_56.jpg and with the size of 56*56 pixel
# resize('girl.jpg', 56)

# Exaple of createExtensions() function that will create all other format that
# exist in the list of knownExtensions exept one that user will give as an argument.
# createExtensions(sys.argv[1:])

# Example of using multiple PILLOW commands in a single command.
# image1 = Image.open('images/lena.ppm').show()
# image1.rotate(-90).save('lena4.jpg')


# Other built-in funcions:
# image1.convert(mode='L)   # Convert to black and white
# image1.filter(ImageFilter.GaussianBlur(15)).save('anything.jpg')      # To blur an image

# You can execute myPIL.py by parameters, the first parameter is the name of
# function and the other parameters are the arguments of each function with a
# space between each ot them
# Example: python3 myPIL.py resize girl.jpg 100

if len(sys.argv) > 1:
    function = sys.argv[1]
    print("function=", function)
    if function == 'createExtensions':
        if len(sys.argv) > 2:
            files = sys.argv[2:]
            print("files=", files)
            createExtensions(files)
    elif function == 'clearRoot':
        clearRoot()
    elif function == 'resize':
        if len(sys.argv) > 2:
            file = sys.argv[2]
            print("file=", file)
            if len(sys.argv) > 3:
                size = int(sys.argv[3])
                print("size=", size, ",", size)
                resize(file, size)
            else:
                print("You have to enter a correct file size!")
        else:
            print("You didn't enter a filename to resize!")
else:
    print("You have just 3 choice, createExtensions(files), clearRoot() and resize(file, size)")
