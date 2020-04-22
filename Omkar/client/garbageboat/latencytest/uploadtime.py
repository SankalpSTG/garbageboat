# -*- coding: utf-8 -*-
"""
Created on Fri Apr 17 00:10:35 2020

@author: STG
"""

import requests as req
import time

millis = lambda: int(round(time.time() * 1000))
currenttime = millis()
timedata = {'time': currenttime}
url = "http://192.168.43.31/garbageboat/api/v1/latency_test/uploadtime.php"
response = req.post(url, data=timedata)
print(response.text)