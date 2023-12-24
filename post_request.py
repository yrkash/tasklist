import requests

URL = f"http://localhost:8080/api/v1/tasks/4/image"

jwt_token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lQGdtYWlsLmNvbSIsImlkIjoxLCJyb2xlcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImV4cCI6MTcwMzQxOTA1NX0.pqs7EanPqEz6t5zZTRylWRdwD0LSzG0xBXTf2w4htB9mL683P2mtnj5Kn7v3brQpph8-inrSqv8NiVCtwk9DUw'
headers = {'Authorization': 'Bearer ' + jwt_token}

files = {'file': open('c:/Users/Laptop/IdeaProjects/tasklist/12345.png', 'rb')}  


response = requests.post(url = URL, files=files, headers=headers)

print(response.text)
