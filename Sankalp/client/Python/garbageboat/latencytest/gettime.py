# -*- coding: utf-8 -*-
"""
Created on Fri Apr 17 00:21:00 2020

@author: STG
"""

import requests as req
import time
from time import sleep
import json

millis = lambda: int(round(time.time() * 1000))
lastsendtime = 0
url = "http://192.168.43.88/garbageboat/api/v1/latency_test/gettime.php"
while True:
    try:
        json_response = req.get(url)
        response = json.loads(json_response.text)
        sendtime = response["data"]
        if sendtime != lastsendtime:
            currenttime = millis()
            print("\r" + str(currenttime - sendtime))
            lastsendtime = sendtime
    except req.exceptions.ConnectionError:
        print("waiting for a second")
        sleep(1)
        