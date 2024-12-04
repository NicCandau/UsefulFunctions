from flask import Flask, jsonify
from markupsafe import escape

# For this simple REST API we can use Flask - see FlaskIntro.py for more info on Flask.
app = Flask(__name__)

# Declare a dictionary -> this is the data that the API will provide
# This data could also be loaded from a file instead.
employees = [{ 'id': '1', 'name': 'Alice'},
             { 'id': '2', 'name': 'Bob'},
             { 'id': '3', 'name': 'Charlie'}
]

# Returns a JSON document of every employee
@app.route("/employees")
def getemployees():
    return jsonify(employees)

# Return a JSON document of a specifc employee by name.
@app.route("/employees/<string:name>")
def getCountryByName(name: str):
    for element in employees:
        if element['name'] == name.capitalize():
            return jsonify(element)
    return jsonify({'error': 'Employee could not be found.'}), 404

# Run the program, then in a browser load: 
# http://127.0.0.1:5000
# and then the path as shown above.
if __name__ == '__main__':
   app.run(port=5000)
