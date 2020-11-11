#!/usr/bin/python3
# coding: utf-8

from requests import get
from bs4 import BeautifulSoup
from time import sleep
from time import time
import pandas as pd
import re
from random import randint


links = []
titles = []
claims = []
auteurs = []
author_pub = []
date_pub = []
tags = []
bodys = []
al_link =[]

headers = {
    'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36'}

"""pages = [str(i) for i in range(1,500)]

for  p in pages :

    #Faire une requete GET pour recuperer les elements
    response = get ('https://www.newtral.es/zona-verificacion/fact-check/?página='+p, headers, timeout = 5)
    if response.status_code == 200:
        h = response.text
        soup = BeautifulSoup(h, "html.parser")
        # print (soup)"""


url = "https://www.newtral.es/zona-verificacion/fact-check/"
#url ="https://www.newtral.es/las-imagenes-de-rajoy-haciendo-ejercicio-son-actuales-no-de-diciembre/20200417/"
response = get(url,  headers=headers)
#r = requests.get(url, headers=headers, timeout=5)
soup = BeautifulSoup (response.text, "html.parser")
head = soup.findAll ('div', class_= 'c-card__inner')


for container in head :

    #Recuperation des liens
    link = container.h3.a['href']
    links.append(link)
    resp = get(link)
    lin = BeautifulSoup(resp.text, "html.parser")
    hd = lin.find('header', class_='entry-header')   
    #print(link)
        #Recuperation des claims
    elm = container.h3.text
    dospunto = re.search(r'(: «)', elm)
    dospunt = re.search(r'(: “)', elm)
    if dospunto :
        claim_a = container.h3.text.split(":")
        auteur = claim_a[0].strip()
        auteurs.append(auteur)
        #print ("auteur:" , auteur)
        claim = claim_a[1].strip("« »")
        claims.append(claim)
        #print ("claim :", claim)
        
        #Recuperation des titres
    elif dospunt:
            claim_b = container.h3.text.split(":")
            auteur = claim_b[0].strip()
            #print ("auteur:" , auteur)
            auteurs.append(auteur)
            claim = claim_b[1].strip(": “ ”")
            #print ("claim :", claim)
            claims.append(claim)
    else :
            title = container.h3.text
            titles.append(title)
            #print("title", title)
            claim_c = hd.h1.text.split(":")
            claim_d = hd.h1.text.strip()
            
    """if claim_c :
        auteur = claim_c[0].strip()
        auteurs.append(auteur)
        print ("auteur:" , auteur)
        claim = claim_c[1].strip("« »")
        claims.append(claim)
        #print ("claim :", claim)
            #else  :
            #print (claim_d)"""
                



        #Recuperation de l'auteur de l'article
    el = lin.find('div', class_='entry-content')
    autor_ = el.span.a.text
    autor = re.sub('Por', '', autor_).strip()
    author_pub.append(autor)
    #print ('auteur_article:', autor)
        #Date de publication de l'article
    date_p = el.time['datetime']
    date_pub.append(date_p)
    #print ('date_pub :', date_p)
        #Tags de l'article
    tag = el.find('ul', class_='tags-links').text.strip()
    tags.append(tag)
    #print('tags:' ,tag)
    #Recuperation du texte de l'article

    body_t =el.findAll('p')
    body =[text.text.strip() for text in body_t]
    bodys.append(body)
    #print (body)

    #Recuperation des liens dans le texte de l'article
    link_a = [link['href'] for link in el.findAll('a', href=True)]
    al_link.append(link_a)
    #print (link_a)
   
    #Source de l'article
        


    #print("j:"*40)
    # link = "https://www.newtral.es/no-el-914-de-la-ciudadania-no-apoya-al-gobierno-y-alcanzar-un-gran-acuerdo-ante-la-crisis-como-dice-el-psoe-en-un-tuit/20200417/"
    #link = "https://www.newtral.es/pedro-sanchez-la-universidad-de-oxford-otorga-a-espana-la-puntuacion-mas-alta-de-los-paises-occidentales-90-sobre-100-en-cuanto-al-rigor-en-la-respuesta-a-la-pandemia/20200410/"



def common(a, b):
    c = [value for value in a if value in b]
    return c

def common2(a, b):
    return set(a).intersection(b)


def removePunctuation(string):
    result = re.sub('[«»!"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~]', '', string)
    return result


link = "https://www.newtral.es/espinosa-de-los-monteros-sobre-galicia-uno-no-se-puede-dirigir-a-la-administracion-en-ningun-otro-idioma-que-no-sea-el-gallego/20200225/"
veracities = ["ENGAÑOSA","ENGAÑOSO","FALSO","FALSA","FALSOS","VERDADERO","VERDAD A MEDIAS"]


resp = get(link).text
lin = BeautifulSoup(resp, "html.parser")
hd = lin.find('header', class_='entry-header')   

intro = hd.find("div", attrs={'class': 'c-article__intro'})


mainText = [text.text.strip() for text in intro]
mainArticle = ' '.join(mainText)

mainArticle = removePunctuation(mainArticle)

# print(intro)

print("*"*100)

print((mainArticle))
rating_text_list = mainArticle.upper().split()
res = common(veracities,rating_text_list)
print(res)

 


        
    