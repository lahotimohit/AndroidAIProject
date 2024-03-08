# This file not link with main app...
# this file published in docker Azure VM through which this app works...

from flask import Flask, jsonify
import google.generativeai as genai

app = Flask(__name__)

GOOGLE_API_KEY = "********************"
genai.configure(api_key=GOOGLE_API_KEY)

#this function is to test our api work successfully or not...
@app.route('/')
def index():
    return jsonify({'msg': 'This is the restful api created in flask server...'})

# In this function the question refers to the input coming from end user
@app.route('/api/hello/<question>')
def home(question):
    response = apiResponse(question)
    return jsonify({'msg': response})

#this function returns what gemini found the answer of input question
def apiResponse(question):
    model_name = "models/text-bison-001"
    response = genai.generate_text(model=model_name, prompt=question)
    print(response)
    return response.result

app.run()