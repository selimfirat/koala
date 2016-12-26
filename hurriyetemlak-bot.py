#!/usr/bin/env python
# -*- coding: utf-8 -*-
from bs4 import BeautifulSoup
import urllib2
import re
import json


class PageParser:
    def __init__(self, url):
        pageFile = urllib2.urlopen(url)
        pageHtml = pageFile.read()
        pageFile.close()
        self.soup = BeautifulSoup(pageHtml, "html.parser")

    def findTitle(self):
        soupObj = self.soup.find("h1", {"class": "details-header"})
        return soupObj.text

    def findDescription(self):
        soupObj = self.soup.find("div", {"class": "left-side description-middle-left"}).find("div", {"itemprop": "description"})
        return soupObj.text

    def findCoordinates(self):
        soupObj = self.soup.find("input", {"id": "hdnPoiCoordinates"})['value']

        values = soupObj.split(",", 1)

        latitude = float(values[0])
        longtude = float(values[1])

        return [latitude, longtude]

    def findTotalValue(self):
        soupObj = self.soup.find("input", {"id": "TotalValue"})['value']

        price = int(soupObj)

        return price

    def findBuildingProperties(self):
        result = {}
        soupLiObj = self.soup.find("li", {"class": "dimension-line clearfix"})
        for span in soupLiObj.find_all("span", recursive=False):
            result[span.contents[0].text] = span.contents[1]
        soupLiObj = self.soup.find("li", {"class": "info-line"})
        soupUlObj = soupLiObj.find("ul", {"class": "clearfix"})
        for li in soupUlObj.find_all("li", recursive=False):
            content = li.find_all("span")
            if len(content) > 1:
                result[content[0].text] = content[1].text

    #    result.append(re.sub("\D", "", children[3].contents[1].text).encode("ascii"))
        # @return List of size, section, age of building, floor, total floor
        return result

    def getJSONData(self):
        coor = self.findCoordinates()
        houseFeatures = self.findBuildingProperties()
        value = self.findTotalValue()
        title = self.findTitle()
        description = self.findDescription()
        d = {
            "houseType": "FOR_SALE",
            "location": {
                "longitude": coor[1],
                "latitude": coor[0]
                },
            "houseFeatures": {
                "currentFloor": int(houseFeatures[u'Bulunduğu Kat']) if u'Bulunduğu Kat' in houseFeatures and not re.search('[a-zA-Z]', houseFeatures[u'Bulunduğu Kat']) else '',
                "totalFloor": int(houseFeatures[u'Kat Sayısı']) if u'Kat Sayısı' in houseFeatures else '',
                "bathroomNumber": int(houseFeatures[u'Banyo Sayısı']) if u'Banyo Sayısı' in houseFeatures else '',
                "furnished": True,
                "price": value,
                "size": int(re.sub("\D", "", houseFeatures[u'Metrekare'])) if 'Metrekare' in houseFeatures else '',
                "ageOfBuilding": int(houseFeatures[u'Bina Yaşı']) if u'Bina Yaşı' in houseFeatures else '',
                "roomNumber": houseFeatures[u'Oda + Salon'][0] if u'Oda + Salon' in houseFeatures else '',
                "title": title
                }
        }
        return d


pageNumber = 2
output = []
fp = open('result.json', 'a')
for pg in range(1, pageNumber):
    current_url = "http://www.hurriyetemlak.com/satilik-daire?page=" + str(pg)
    pageFile = urllib2.urlopen(current_url)
    pageHtml = pageFile.read()
    pageFile.close()
    soup = BeautifulSoup(pageHtml, "html.parser")
    for div in soup.find_all("div", {"class": "list-item timeshare clearfix"}):
        link = div.find_all("a")
        print link[0]
        pageParser = PageParser("http://www.hurriyetemlak.com"+link[0]['href'])
        json.dump(pageParser.getJSONData(), fp)
