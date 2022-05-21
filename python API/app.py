from flask import Flask, render_template, jsonify
from random import randint
import json

app = Flask(__name__)

@app.route("/<number>")
def repo_list(number):
    lista = []
    for i in range(int(number)):
        lista.append(randint(300,600))
    return jsonify(lista)


if __name__ == '__main__':
    app.run()