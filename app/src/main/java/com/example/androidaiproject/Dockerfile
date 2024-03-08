# The file present in this app has not link with the app...
# This docker file published in Azure Vm to run the app, this is the copy of that file.....
FROM python:3.8

WORKDIR /app

COPY server.py /app/server.py

RUN pip3 install flask
RUN pip3 install google.generativeai

EXPOSE 5001

CMD ["python3", "server.py"]