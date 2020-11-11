
veracities = ["ENGAÑOSA","ENGAÑOSO","FALSO","FALSA","FALSOS","VERDADERO","VERDAD A MEDIAS"]

rating_text = "Es ENGAÑOSO que 90 sea la cifra más ENGAÑOSO. Los últimos días que España registra un 90 sobre 100, el estudio de Oxford da una puntuación mayor a países como Austria, Francia, Croacia, Italia, entre otros. (*) Se ha hecho una actualización de los datos a día 11/04/2020"
rating_text_list = rating_text.upper().split()


# return a list
def common(a, b):
    c = [value for value in a if value in b]
    return c

# return a dictionary
def common2(a, b):
    return set(a).intersection(b)

# def myFunction():
#     res = [x for x in veracities]
#     print(x)
#     return res

res = common(veracities,rating_text_list)


# result = filter(myFunction(), rating_text) 

print(res)


# matches = filter(x for x in veracities, rating_text)

# print(rating_text_list)