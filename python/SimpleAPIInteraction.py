import requests

def getFact():
    apiURL = "https://uselessfacts.jsph.pl/api/v2/facts/today"
    
    try:
        response = requests.get(apiURL)
        if (response.status_code) == 200:
            print(response.json()["text"])
        elif (response.status_code) == 404:
            print("404 Not Found")
    except:
        print("An error occurred.")
    
getFact()
