
import json
import bs4
import requests
import lxml


urls = []
query_url = "https://www.newtral.es/wp-json/wp/v2/posts?per_page=100&offset={offset}&categories=1&exclude=80729%2C79970%2C78262%2C78455%2C77275%2C77315%2C77161%2C76907%2C76298%2C75434%2C74706%2C74103%2C74062&_locale=user"

file = "allArticles.json"
json_output = requests.get(query_url.format(offset=0))
print("size:", json_output.json())
offset = 0

# print(json_output.json())
while len(json_output.json()) > 1:
    pages = json_output.json()
    for index, page in enumerate(pages):
        print("*"*100)
        print("Page number:", index)
        print("*"*100)
        links = page['link']
        print("Link:", links)
        urls.append(links)

    offset += 100
    json_output = requests.get(query_url.format(offset=offset))
print("urls size:", len(urls))
with open(file, 'w') as outJson:
    json.dump(urls, outJson, indent=2)
    print("Writing finished.")
