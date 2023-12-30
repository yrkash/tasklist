import requests

id = int(input("Введи id человека\n"))
URL = f"http://localhost:8080/api/v1/users/{id}"

jwt_token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGdtYWlsLmNvbSIsImlkIjoxLCJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl0sImV4cCI6MTcwMzQxMzYyMn0.Teg5rsWW0yGx568w-XaPnzvsp2XdBV0NA5GXPif1-DXS1ma0BPbp6ZOxQjKFHDuKySO964I0yYdmR971VrBX9Q'
headers = {'Authorization': 'Bearer ' + jwt_token}

r = requests.get(url=URL, headers=headers)

if r.status_code == 404:
    print(f"Ошибка от сервера: {r.json()['message']}")
    print(f"Ошибка от сервера: {r.json()['timestamp']}")
else:
    person = r.json()
    print(f"Имя человека: {person['name']}")
