# -*- coding: utf-8 -*-
"""
Created on Fri Apr 17 03:46:00 2020

@author: STG
"""

from urllib import request
import json
import time
url = "http://192.168.43.31/garbageboat/api/v1/latency_test/gettime.php"
data = request.urlopen(url)
responsestring = data.read().decode('utf-8')
response = json.loads(responsestring)
print(response["data"])
millis = lambda: int(round(time.time() * 1000))
lastsendtime = 0
requestscount = 0
while True:
    data = request.urlopen(url)
    responsestring = data.read().decode('utf-8')
    requestscount += 1
    try:
        response = json.loads(responsestring)
        sendtime = response["data"]
        if sendtime != lastsendtime:
            currenttime = millis()
            print("\r" + str(currenttime - sendtime) + "  " + str(requestscount))
            lastsendtime = sendtime
    except:
        print("I was unable to decode JSON. so I slept")
        time.sleep(1)